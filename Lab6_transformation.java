import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Lab6_transformation extends JPanel{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 6: Transformation matrix in Java 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.add(new Lab6_transformation());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // เปิด Anti-aliasing เพื่อให้เส้นคม
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // rect
        int rectX = 200;
        int rectY = 200;
        int rectWidth = 200;
        int rectHeight = 200;

        // Transform the square above to rotate 30 degrees counterclockwise around its centre.
        // its centre
        double centerX = rectX + rectWidth / 2.0;
        double centerY = rectY + rectHeight / 2.0;

        // AffineTransform
        AffineTransform rotate30 = AffineTransform.getRotateInstance(
                Math.toRadians(30), centerX, centerY);
        g2.setTransform(rotate30);
        g2.setColor(Color.BLUE);
        g2.drawRect(rectX, rectY, rectWidth, rectHeight);

        // reset
        g2.setTransform(new AffineTransform());

        // Transform the square above to scale x2 around its top-left corner
        AffineTransform scaleAndTranslate = new AffineTransform(2, 0, 0, 2, -50, 50);
        g2.setTransform(scaleAndTranslate);
        g2.setColor(Color.RED);
        g2.drawRect(rectX, rectY, rectWidth, rectHeight);
    }

}
