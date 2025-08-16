import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class BezierCurve extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercise 1: Bezier Curve");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.add(new BezierCurve());
        frame.setVisible(true);
    }

    private final int[][] controlPoints = {
        {200, 100}, // x1 
        {100, 400}, // x2
        {400, 100}, // x3
        {500, 400}  // x4
        // if swap line formation will change
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawControlPoints(g);
        drawBezierCurve(g);
    }

    private void drawControlPoints(Graphics g) {
        g.setColor(Color.RED);
        for (int[] point : controlPoints) {
            g.fillOval(point[0]-4, point[1]-4, 8, 8);
        }
    }

    private void drawBezierCurve(Graphics g) {
        g.setColor(Color.BLUE);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        ArrayList<Point> curvePoints = new ArrayList<>();
        int steps = 1000;
        for (int i = 0; i <= steps; i++) {
            double t = i / (double) steps;
            Point p = calculateBezierPoint(t);
            curvePoints.add(p);
        }

        for (int i = 0; i < curvePoints.size() - 1; i++) {
            Point p1 = curvePoints.get(i);
            Point p2 = curvePoints.get(i + 1);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    private Point calculateBezierPoint(double t) {
        double x = (Math.pow(1 - t, 3) * controlPoints[0][0])
                 + (3 * t * Math.pow(1 - t, 2) * controlPoints[1][0])
                 + (3 * Math.pow(t, 2) * (1 - t) * controlPoints[2][0])
                 + (Math.pow(t, 3) * controlPoints[3][0]);

        double y = (Math.pow(1 - t, 3) * controlPoints[0][1])
                 + (3 * t * Math.pow(1 - t, 2) * controlPoints[1][1])
                 + (3 * Math.pow(t, 2) * (1 - t) * controlPoints[2][1])
                 + (Math.pow(t, 3) * controlPoints[3][1]);

        return new Point((int) x, (int) y);
    }
}
