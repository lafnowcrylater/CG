import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test1 extends JPanel implements Runnable{

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

    // +Scene2State
    private static class Scene2State {
        int cloudX1 = -200, cloudY1 = 150;
        int cloudX2 = -300, cloudY2 = 100;
        int cloudSpeed = 2; // px per frame
    }
    private final Scene2State scene2 = new Scene2State();

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
            } else{ // +cloud scene2
                scene2.cloudX1 += scene2.cloudSpeed;
                scene2.cloudX2 += scene2.cloudSpeed;
                // cloud loop
                if (scene2.cloudX1 > 650) 
                    scene2.cloudX1 = -200;
                if (scene2.cloudX2 > 650) 
                    scene2.cloudX2 = -200;
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

        
        if(totalTime<=scene1.duration) {
            scene1(g);
        } else {
            scene2(g); // +scene2
        }
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
        int width = 600;
        int height = 600;

        // Sky
        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, width, height);

        // Grass
        g.setColor(new Color(76, 153, 0));
        for (int i = 0; i < width; i += 40) {
            for (int j = 400; j < height; j += 40) {
                Polygon block = new Polygon();
                block.addPoint(i, j);
                block.addPoint(i + 40, j);
                block.addPoint(i + 40, j + 40);
                block.addPoint(i, j + 40);
                g.fillPolygon(block);
            }
        }

        // Grass line
        g.setColor(new Color(0, 102, 51));
        drawLine(g, 0, 400, 600, 400);

        // Trees
        drawTree(g, 100, 410);
        drawTree(g, 500, 410);

        // Clouds
        drawCloud(g, scene2.cloudX1, scene2.cloudY1, 40);
        drawCloud(g, scene2.cloudX2, scene2.cloudY2, 30);

        // Creeper 
        drawCreeper1(g, width/2 - 40, 400 - 120, 20); 


    }

    private void drawCreeper1(Graphics g, int x, int y, int blockSize) {
        g.setColor(new Color(0, 153, 0));

        // Head 4x4
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g.fillRect(x + i * blockSize, y + j * blockSize, blockSize, blockSize);
            }
        }

        // body
        for (int i = 1; i <= 2; i++) {
            for (int j = 4; j < 8; j++) {
                g.fillRect(x + i * blockSize, y + j * blockSize, blockSize, blockSize);
            }
        }

        // Legs?
        for (int i = 0; i < 4; i++) {
            g.fillRect(x + i * blockSize, y + 8 * blockSize, blockSize, blockSize);
            g.fillRect(x + i * blockSize, y + 9 * blockSize, blockSize, blockSize);
        }
    }
        

    private void drawLine(Graphics g, int x0, int y0, int x1, int y1) {
        // Bresenham Line
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = (x0 < x1) ? 1 : -1;
        int sy = (y0 < y1) ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.fillRect(x0, y0, 1, 1);

            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) { err -= dy; x0 += sx; }
            if (e2 < dx) { err += dx; y0 += sy; }
        }
    }

    private void drawTree(Graphics g, int x, int y) {
        g.setColor(new Color(102, 51, 0));
        for (int j = 0; j < 3; j++) {
            Polygon trunk = new Polygon();
            trunk.addPoint(x, y - j * 20);
            trunk.addPoint(x + 20, y - j * 20);
            trunk.addPoint(x + 20, y - j * 20 - 20);
            trunk.addPoint(x, y - j * 20 - 20);
            g.fillPolygon(trunk);
        }

        g.setColor(new Color(34, 139, 34));
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Polygon leaf = new Polygon();
                leaf.addPoint(x + i * 20, y - 60 + j * 20);
                leaf.addPoint(x + i * 20 + 20, y - 60 + j * 20);
                leaf.addPoint(x + i * 20 + 20, y - 60 + j * 20 - 20);
                leaf.addPoint(x + i * 20, y - 60 + j * 20 - 20);
                g.fillPolygon(leaf);
            }
        }
    }

    private void drawCloud(Graphics g, int x, int y, int blockSize) {
        g.setColor(new Color(240, 240, 240));

        // Top row (2 blocks)
        g.fillRect(x + blockSize, y - blockSize, blockSize, blockSize);
        g.fillRect(x + 2 * blockSize, y - blockSize, blockSize, blockSize);

        // Bottom row (4 blocks)
        for (int i = 0; i < 4; i++) {
            g.fillRect(x + i * blockSize, y, blockSize, blockSize);
        }
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