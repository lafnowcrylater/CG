import java.awt.*;
import javax.swing.*;

public class Lab5_animation extends JPanel implements Runnable {
    double circleMove = 0;
    double circleSpeed = 50.0;
    boolean movingRight = true;

    double squareRotate = 0;

    double square2Y = 600;  // from bottom
    boolean startSquare2 = false;

    public static void main(String[] args) {
        Lab5_animation m = new Lab5_animation();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Graphics");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();
    }

    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;
        double totalElapsedTime = 0;

        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;
            totalElapsedTime += elapsedTime / 1000.0;

            // Update circle movement
            if (movingRight) {
                circleMove += circleSpeed * elapsedTime / 1000.0;
                if (circleMove + 100 >= 600) {
                    movingRight = false;
                }
            } else {
                circleMove -= circleSpeed * elapsedTime / 1000.0;
                if (circleMove <= 0) {
                    movingRight = true;
                }
            }

            // Update square rotation
            squareRotate += 0.5 * elapsedTime / 1000.0;

            // Start moving the second square after 3 seconds
            if (totalElapsedTime >= 3.0) {
                startSquare2 = true;
            }

            if (startSquare2) {
                square2Y -= 100.0 * elapsedTime / 1000.0;
                if (square2Y < -200) {
                    square2Y = 600;
                }
            }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);

        g2.setColor(Color.BLACK);

        // Draw moving circle
        g2.translate(circleMove, 0);
        g2.drawOval(0, 0, 100, 100);
        g2.translate(-circleMove, 0);

        // Draw rotating square (center at 300,300)
        g2.rotate(squareRotate, 300, 300);
        g2.drawRect(200, 200, 200, 200);
        g2.rotate(-squareRotate, 300, 300); // reset

        // Draw second moving square
        if (startSquare2) {
            g2.drawRect(0, (int) square2Y, 100, 100);
        }
    }
}
