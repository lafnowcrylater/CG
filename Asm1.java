import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Asm1 extends JPanel implements Runnable{

    static final int FPS = 24;
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
        Asm1 m = new Asm1();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Graphics");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
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

        //Backgroud
        Color sky = new Color(135, 206, 235);
        g2.setColor(sky); // light sky blue
        g2.fillRect(0, 0, 600, 600);

        //Clouds
        g2.setColor(Color.WHITE);
        CGTools.midpointEllipse(g2, 90,80,70,50);
        CGTools.floodFill(buffer, 90, 80, sky, Color.WHITE);
        CGTools.midpointEllipse(g2, 140,60,90,60);
        CGTools.floodFill(buffer, 160, 60, sky, Color.WHITE);
        
        CGTools.midpointEllipse(g2, 400,100,140,70);
        CGTools.floodFill(buffer, 400, 100, sky, Color.WHITE);
        CGTools.midpointEllipse(g2, 450,80,120,60);
        CGTools.floodFill(buffer, 540, 80, sky, Color.WHITE);
        // g2.fillOval(80, 80, 100, 60);
        // g2.fillOval(130, 60, 120, 80);
        // g2.fillOval(400, 100, 140, 70);
        // g2.fillOval(450, 80, 120, 60);

        //Coffin
        g2.setColor(Color.BLACK);
        g2.translate(scene1.coffinOffset, 0);
        g2.drawLine(scene1.ax, scene1.ay, scene1.bx, scene1.by);
        g2.drawLine(scene1.bx, scene1.by, scene1.cx, scene1.cy);
        g2.translate(-scene1.coffinOffset, 0);

        buffer = CGTools.floodFillWithBoundary(buffer, 0, 0, Color.BLACK, Color.BLACK);
        g.drawImage(buffer, 0, 0, null);
    }

}