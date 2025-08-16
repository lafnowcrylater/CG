import java.awt.*;
import javax.swing.*;

public class Lab4_Ellipse extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 4: Ellipse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new Lab4_Ellipse());
        frame.setVisible(true);
    }

    private int xc = 300;
    private int yc = 300;
    private int a = 150;
    private int b = 100;

    public void midpointEllipse(Graphics g, int xc, int yc, int a, int b) {
        int a2 = a * a;
        int b2 = b * b;
        int twoA2 = 2 * a2;
        int twoB2 = 2 * b2;

        // REGION 1
        int x = 0;
        int y = b;
        int Dx = 0;
        int Dy = twoA2 * y;

        int D = (int)(b2 - a2 * b + 0.25 * a2);

        while (Dx <= Dy) {
            // plot 4 quadrants of (x, y)
            plot(g, xc + x, yc - y);
            plot(g, xc - x, yc - y);
            plot(g, xc + x, yc + y);
            plot(g, xc - x, yc + y);
            x++;
            Dx += twoB2;
            D += Dx + b2;

            if (D >= 0) {
                y--;
                Dy -= twoA2;
                D -= Dy;
            }
        }

        // REGION 2
        x = a;
        y = 0;
        Dx = twoB2 * x;
        Dy = 0;
        D = (int)(a2 - b2 * a + 0.25 * b2);

        while (Dx >= Dy) {
            // plot 4 quadrants of (x, y)
            plot(g, xc + x, yc - y);
            plot(g, xc - x, yc - y);
            plot(g, xc + x, yc + y);
            plot(g, xc - x, yc + y);

            y++;
            Dy += twoA2;
            D += Dy + a2;

            if (D >= 0) {
                x--;
                Dx -= twoB2;
                D -= Dx;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        midpointEllipse(g, xc, yc, a, b);
    }

    private void plot(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }
}
