import java.awt.*;
import javax.swing.*;

public class MinecraftBackground extends JPanel {
    
    private int width = 600;
    private int height = 600;

    // ================== Bresenham Line ==================
    private void drawLine(Graphics g, int x0, int y0, int x1, int y1) {
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
        // หะำท
        g.setColor(new Color(102, 51, 0));
        for (int j = 0; j < 3; j++) {
            Polygon trunk = new Polygon();
            trunk.addPoint(x, y - j * 20);
            trunk.addPoint(x + 20, y - j * 20);
            trunk.addPoint(x + 20, y - j * 20 - 20);
            trunk.addPoint(x, y - j * 20 - 20);
            g.fillPolygon(trunk);
        }

        //leaves
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
        g.setColor(new Color(240, 240, 240)); // สีเมฆ (ขาวอมฟ้า)

        // แถวบน (2 blocks ตรงกลาง)
        g.fillRect(x + blockSize, y - blockSize, blockSize, blockSize);
        g.fillRect(x + 2 * blockSize, y - blockSize, blockSize, blockSize);

        // แถวล่าง (4 blocks)
        for (int i = 0; i < 4; i++) {
            g.fillRect(x + i * blockSize, y, blockSize, blockSize);
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Sky 
        g.setColor(new Color(135, 206, 235)); //bkue
        g.fillRect(0, 0, width, height);

        // Grass 
        g.setColor(new Color(76, 153, 0)); //green
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

        // grass line using Bresenham
        g.setColor(new Color(0, 102, 51));
        drawLine(g, 0, 400, 600, 400);
        
        // ton mai
        drawTree(g, 100, 410);  // left
        drawTree(g, 500, 410);  // right

        // cloud
        drawCloud(g, 100, 150, 40);
        drawCloud(g, 300, 100, 30);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Minecraft Background");
        MinecraftBackground panel = new MinecraftBackground();
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
