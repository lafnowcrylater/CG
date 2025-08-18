import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Assignment1 extends JPanel implements Runnable{

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

    private static class Scene2State {
        // Cloud's part
        int cloudX1 = -100, cloudY1 = 150;
        int cloudX2 = -250, cloudY2 = 100;
        int cloudSpeed = 2; // px per frame

        double timeInScene = 0; 
        final double eggDuration = 2.0; // for creeper egg

        final double flashDelay = 1.0; // let creeper freeze for 1 sec.

        // Creeper flashing bf boom
        boolean isFlashing = false;
        double lastFlashTime = 0.0;
        final double flashInterval = 0.3; // Flash every 0.2 seconds

        double flashStartTime = -1;
        final double flashDuration = 2; // let it flash 2 sec

        // Explosion state
        boolean isExploding = false;
        int explosionRadius = 0;

        int creeperX = Creeper.HEAD_START_X + 4*Creeper.BLOCK_SIZE;
        int creeperY = Creeper.HEAD_START_Y + 4*Creeper.BLOCK_SIZE;

        // if explode = done
        boolean scene2Finished = false; 

    }
    private final Scene2State scene2 = new Scene2State();

    public static void main(String[] args){
        Assignment1 m = new Assignment1();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Graphics");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);

        new Thread(m).start();
    }
    
    @Override
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
            }else {
                scene2.timeInScene += elapsedTime;

                // Scene2 cloud
                scene2.cloudX1 += scene2.cloudSpeed;
                scene2.cloudX2 += scene2.cloudSpeed;

                if (scene2.cloudX1 > 650) scene2.cloudX1 = -200;
                if (scene2.cloudX2 > 650) scene2.cloudX2 = -200;

                // after egg n creeper are displayed then flash
                if (scene2.timeInScene >= scene2.eggDuration + scene2.flashDelay && scene2.flashStartTime < 0) {
                    scene2.flashStartTime = scene2.timeInScene;
                    scene2.lastFlashTime = scene2.timeInScene;
                    scene2.isFlashing = true;
                }

                if (scene2.flashStartTime >= 0 && scene2.timeInScene - scene2.flashStartTime <= scene2.flashDuration) {
                    if (scene2.timeInScene - scene2.lastFlashTime >= scene2.flashInterval) {
                        scene2.isFlashing = !scene2.isFlashing;
                        scene2.lastFlashTime = scene2.timeInScene;
                    }
                } else if (scene2.flashStartTime >= 0) {
                    // let it flash for 2 sec and stop
                    scene2.isFlashing = false;
                    scene2.isExploding = true; // then exploding
                }

                if (scene2.isExploding) {
                    scene2.explosionRadius += 30; // make rad bigger
                    if (scene2.explosionRadius > 600) { 
                        scene2.explosionRadius = 600;
                        scene2.scene2Finished = true;
                    }
                }
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
            scene2(g);
        }

        if (scene2.isExploding) {
            int bufSize = scene2.explosionRadius * 2 + 50;

            BufferedImage buffer = new BufferedImage(bufSize, bufSize, BufferedImage.TYPE_INT_ARGB);
            g2 = buffer.createGraphics();

            g2.setColor(Color.BLACK);
            CGTools.midpointEllipse(g2, bufSize/2, bufSize/2, scene2.explosionRadius, scene2.explosionRadius);

            buffer = CGTools.floodFill(buffer, bufSize/2, bufSize/2, new Color(0,0,0,0), Color.BLACK);

            g.drawImage(buffer, scene2.creeperX - bufSize/2, scene2.creeperY - bufSize/2, null);

            scene2.explosionRadius += 10;
            int maxRadius = Math.max(getWidth()*2, getHeight()*2);
            if (scene2.explosionRadius >= maxRadius) {
                scene2.scene2Finished = true;
                scene2.isExploding = false;
                return; 
            }
        }

        if (scene2.scene2Finished) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            return;
        }
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

    private void scene2(Graphics g){
        int width = 600;
        int height = 600;

        // Sky
        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, width, height);

        // Grass blocks
        g.setColor(new Color(76, 153, 0));
        for (int i = 0; i < width; i += 40) {
            for (int j = 400; j < height; j += 40) {
                g.fillRect(i, j, 40, 40);
            }
        }

        // Grass line
        g.setColor(new Color(0, 102, 51));
        CGTools.drawLine(g, 0, 400, 600, 400);

        // Clouds
        drawCloud(g, scene2.cloudX1, scene2.cloudY1, 40);
        drawCloud(g, scene2.cloudX2, scene2.cloudY2, 30);

        // Creeper's part
        if (scene2.timeInScene < scene2.eggDuration) {
            CreeperEgg.drawEgg(g); // for creeper egg
        } else {
            if (scene2.isFlashing) {
                Creeper.drawCreeperFlashing(g);
            } else {
                Creeper.drawCreeperGreen(g);
            }
        }

    }

    private void drawCloud(Graphics g, int x, int y, int blockSize) {
        g.setColor(new Color(240, 240, 240));

        // top
        g.fillRect(x + blockSize, y - blockSize, blockSize, blockSize);
        g.fillRect(x + 2*blockSize, y - blockSize, blockSize, blockSize);

        // bttm
        for (int i = 0; i < 4; i++) {
            g.fillRect(x + i*blockSize, y, blockSize, blockSize);
        }
    }


}
