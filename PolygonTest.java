import java.awt.*;
import javax.swing.*;

public class PolygonTest extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Polygon poly = new Polygon();
        poly.addPoint(150, 150);
        poly.addPoint(250, 100);
        poly.addPoint(325, 125);
        poly.addPoint(375, 225);
        poly.addPoint(400, 325);
        poly.addPoint(275, 375);
        poly.addPoint(100, 300);
        g.drawPolygon(poly);

        /*  Exercise 2 : Draw triangles out of this polygon (triangulations). There should be 5 triangles in this 7-
gon shape. Draw at least 3 different ways of triangulating this polygon.*/
        g.drawLine(150, 150, 325, 125);
        g.drawLine(150, 150, 375, 225);
        g.drawLine(150, 150, 400, 325);
        g.drawLine(150, 150, 275, 375);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Polygon Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new PolygonTest());
        frame.setVisible(true);
    }
}
