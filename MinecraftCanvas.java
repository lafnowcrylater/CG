import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MinecraftCanvas extends JPanel {

    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 600;
    private final Color SKY_COLOR = new Color(135, 206, 235);
    private final Color GRASS_COLOR = new Color(76, 153, 0);
    private final Color CLOUD_COLOR = new Color(240, 240, 240);
    private final Color SUN_COLOR = new Color(255, 230, 0);
    private final Color BEZIER_COLOR = new Color(110, 80, 50);

    // This is the main drawing method for the canvas
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for smoother graphics, although the blocky style is intended
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        // Draw the background elements
        drawSky(g2d);
        drawGround(g2d);
        drawClouds(g2d);
        drawSun(g2d);
        drawBezierCurve(g2d);
    }

    // Method to draw the sky using a filled polygon
    private void drawSky(Graphics2D g2d) {
        g2d.setColor(SKY_COLOR);
        int[] xPoints = {0, WINDOW_WIDTH, WINDOW_WIDTH, 0};
        int[] yPoints = {0, 0, WINDOW_HEIGHT, WINDOW_HEIGHT};
        Polygon skyPolygon = new Polygon(xPoints, yPoints, 4);
        g2d.fill(skyPolygon);
    }

    // Method to draw the ground using a filled polygon
    private void drawGround(Graphics2D g2d) {
        g2d.setColor(GRASS_COLOR);
        int groundHeight = WINDOW_HEIGHT / 3;
        int[] xPoints = {0, WINDOW_WIDTH, WINDOW_WIDTH, 0};
        int[] yPoints = {WINDOW_HEIGHT - groundHeight, WINDOW_HEIGHT - groundHeight, WINDOW_HEIGHT, WINDOW_HEIGHT};
        Polygon groundPolygon = new Polygon(xPoints, yPoints, 4);
        g2d.fill(groundPolygon);
    }

    // This method uses the Midpoint Circle Algorithm to create "blocky" clouds
    private void drawClouds(Graphics2D g2d) {
        g2d.setColor(CLOUD_COLOR);

        // Cloud 1
        Polygon cloud1 = createBlockyCloud(100, 100, 40, 3, new int[]{1, 0, -1, -2, -1, 0});
        g2d.fill(cloud1);

        // Cloud 2
        Polygon cloud2 = createBlockyCloud(400, 80, 50, 4, new int[]{2, 1, 0, -1, -2, -1});
        g2d.fill(cloud2);

        // Cloud 3
        Polygon cloud3 = createBlockyCloud(250, 150, 35, 2, new int[]{1, 1, 0, -1, -1, 0});
        g2d.fill(cloud3);
    }

    // Helper method to create a blocky cloud shape by combining midpoint circles
    private Polygon createBlockyCloud(int x, int y, int r, int numClusters, int[] offsets) {
        Polygon cloudPolygon = new Polygon();
        for (int i = 0; i < numClusters; i++) {
            int offsetX = offsets[i] * r / 2;
            int offsetY = offsets[offsets.length - 1 - i] * r / 2;
            Polygon circlePart = midpointCircleAlgorithm(x + offsetX, y + offsetY, r);
            for (int j = 0; j < circlePart.npoints; j++) {
                cloudPolygon.addPoint(circlePart.xpoints[j], circlePart.ypoints[j]);
            }
        }
        return cloudPolygon;
    }

    // Midpoint Circle Algorithm implementation to generate points for a circle
    private Polygon midpointCircleAlgorithm(int x0, int y0, int r) {
        ArrayList<Point> points = new ArrayList<>();
        int x = r;
        int y = 0;
        int p = 1 - r;

        while (x >= y) {
            // Add points for all 8 octants
            addCirclePoints(x0, y0, x, y, points);
            y++;

            if (p < 0) {
                p = p + 2 * y + 1;
            } else {
                x--;
                p = p + 2 * y - 2 * x + 1;
            }
        }
        
        // Convert ArrayList of points to a Polygon
        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            xPoints[i] = points.get(i).x;
            yPoints[i] = points.get(i).y;
        }
        return new Polygon(xPoints, yPoints, points.size());
    }

    // Helper method to add points to the list for all 8 octants
    private void addCirclePoints(int x0, int y0, int x, int y, ArrayList<Point> points) {
        points.add(new Point(x0 + x, y0 + y));
        points.add(new Point(x0 - x, y0 + y));
        points.add(new Point(x0 + x, y0 - y));
        points.add(new Point(x0 - x, y0 - y));
        points.add(new Point(x0 + y, y0 + x));
        points.add(new Point(x0 - y, y0 + x));
        points.add(new Point(x0 + y, y0 - x));
        points.add(new Point(x0 - y, y0 - x));
    }

    // Method to draw the sun using the Midpoint Circle Algorithm
    private void drawSun(Graphics2D g2d) {
        g2d.setColor(SUN_COLOR);
        Polygon sun = midpointCircleAlgorithm(WINDOW_WIDTH - 100, 100, 40);
        g2d.fill(sun);
    }
    
    // Method to draw a Bezier curve using Polygon
    private void drawBezierCurve(Graphics2D g2d) {
        g2d.setColor(BEZIER_COLOR);
        
        // Control points for the quadratic Bezier curve
        Point p1 = new Point(0, WINDOW_HEIGHT / 2);
        Point p2 = new Point(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 4);
        Point p3 = new Point(WINDOW_WIDTH, WINDOW_HEIGHT / 2);
        
        Polygon bezierPolygon = new Polygon();
        for (double t = 0; t <= 1; t += 0.01) {
            double x = Math.pow(1 - t, 2) * p1.x + 2 * (1 - t) * t * p2.x + Math.pow(t, 2) * p3.x;
            double y = Math.pow(1 - t, 2) * p1.y + 2 * (1 - t) * t * p2.y + Math.pow(t, 2) * p3.y;
            bezierPolygon.addPoint((int) x, (int) y);
        }
        
        // To make it a solid line, we need to create a thicker polygon, but for a simple line, we can just use the points.
        // As the user requested "lines" and "curves" which can be represented by a series of connected points,
        // we'll just draw the points as a line.
        for (int i = 0; i < bezierPolygon.npoints - 1; i++) {
            g2d.drawLine(bezierPolygon.xpoints[i], bezierPolygon.ypoints[i], bezierPolygon.xpoints[i+1], bezierPolygon.ypoints[i+1]);
        }
    }

    public static void main(String[] args) {
        // This is the entry point for the application.
        JFrame frame = new JFrame("Minecraft Reborned Scene");
        MinecraftCanvas canvas = new MinecraftCanvas();
        frame.add(canvas);
        frame.setSize(canvas.WINDOW_WIDTH, canvas.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}