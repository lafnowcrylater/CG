import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

public class PolygonFloodFill {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 3: Polygon Flood Fill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(620, 640);
        frame.add(new PolygonPanel());
        frame.setVisible(true);
    }

    static class PolygonPanel extends JPanel {
        @SuppressWarnings("override")
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = buffer.createGraphics();

            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, 600, 600);

            int[] xPoly = {150, 250, 325, 375, 400, 275, 100};
            int[] yPoly = {150, 100, 125, 225, 325, 375, 300};
            Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
            g2.setColor(Color.BLACK);
            g2.drawPolygon(poly);

            buffer = floodFill(buffer, 200, 150, Color.WHITE, Color.GREEN); // Exercise 3.2
            g.drawImage(buffer, 0, 0, null);
        }
    }

    // Excersise 3.1
    public static BufferedImage floodFill(BufferedImage m, int x, int y, Color targetColor, Color replacementColor) {
        int width = m.getWidth();
        int height = m.getHeight();
        int targetRGB = targetColor.getRGB();
        int replacementRGB = replacementColor.getRGB();

        if (targetRGB == replacementRGB) 
            return m;
        if (m.getRGB(x, y) != targetRGB) 
            return m;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        m.setRGB(x, y, replacementRGB);

        while (!q.isEmpty()) {
            Point p = q.remove();
            int px = p.x;
            int py = p.y;

            int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // N{0,1} up, E{1,0} right, S{0,-1} down, W{-1,0} left
            for (int[] d : directions) {
                int nx = px + d[0];
                int ny = py + d[1];

                if (nx >= 0 && ny >= 0 && nx < width && ny < height && m.getRGB(nx, ny) == targetRGB) {
                    m.setRGB(nx, ny, replacementRGB);
                    q.add(new Point(nx, ny));
                }
            }
        }
        return m;
    }
}
