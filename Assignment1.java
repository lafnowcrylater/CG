import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Assignment1 extends JPanel implements Runnable{

    static final int FPS = 30;
    double currentTime, elapsedTime, totalTime = 0;

    private static class Scene1State {
        int ax = 100, ay = 0;
        int bx = 120, by = 100;
        int cx = 70, cy = 600;
        double coffinOffset = 0;

        final double initialSpeed = 450.0; //px/sec
        final double slowdownFactor = 0.4;
        final double duration = 1.5;
    }
    private final Scene1State scene1 = new Scene1State();

    public static void main(String[] args){
        Assignment1 m = new Assignment1();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Graphics");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        new Thread(m).start();
    }
    
    
    public void run() {
        double lastTime = System.nanoTime() / 1_000_000_000.0; // in seconds

        while (true){
            currentTime = System.nanoTime() / 1_000_000_000.0;
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            totalTime += elapsedTime;
            double speed = scene1.initialSpeed / (1 + scene1.slowdownFactor * totalTime);
            //System.out.printf("Sum: %.3f s\n", totalTime);

            if(totalTime <= scene1.duration){
                scene1.coffinOffset += speed * elapsedTime;
                scene1.bx += speed/240.0;
                System.out.println(totalTime + " : "+ speed);
            }
            //System.out.printf("Frame time: %.3f s\n", elapsedTime);

            repaint();

            try {
                Thread.sleep(1000/FPS); // ~60 FPS
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        if(totalTime<=scene1.duration) scene1(g);
    }

    private void scene1(Graphics g){
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);

        g2.setColor(Color.BLACK);
        g2.translate(scene1.coffinOffset, 0);
        g2.drawLine(scene1.ax, scene1.ay, scene1.bx, scene1.by);
        g2.drawLine(scene1.bx, scene1.by, scene1.cx, scene1.cy);
        g2.translate(-scene1.coffinOffset, 0);

        buffer = floodFill(buffer, 0, 0, Color.WHITE, Color.BLACK);
        g.drawImage(buffer, 0, 0, null);
    }

    private void scene2(Graphics g){
        
    }

    BufferedImage floodFill(BufferedImage m, int x, int y, Color targetColor, Color replacementColor){
        int targetColorRGB = targetColor.getRGB();
        int replacementColorRGB = replacementColor.getRGB();

        Queue<int[]> q = new LinkedList<>();
        m.setRGB(x, y, replacementColorRGB);
        int[] arr = {x,y};
        q.offer(arr);

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            if(y1<m.getHeight() && m.getRGB(x1, y1+1) == targetColorRGB){
                m.setRGB(x1, y1+1, replacementColorRGB);
                int[] a = {x1, y1+1};
                q.offer(a);
            }
            if(y1>0 && m.getRGB(x1, y1-1) == targetColorRGB){
                m.setRGB(x1, y1-1, replacementColorRGB);
                int[] a = {x1, y1-1};
                q.offer(a);
            }
            if(x1<m.getWidth() && m.getRGB(x1+1, y1) == targetColorRGB){
                m.setRGB(x1+1, y1, replacementColorRGB);
                int[] a = {x1+1, y1};
                q.offer(a);
            }
            if(x1>0 && m.getRGB(x1-1, y1) == targetColorRGB){
                m.setRGB(x1-1, y1, replacementColorRGB);
                int[] a = {x1-1, y1};
                q.offer(a);
            }
        }

        return m;
    }
}
