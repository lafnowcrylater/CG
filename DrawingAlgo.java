import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingAlgo extends JPanel {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new DrawingAlgo());
        f.setTitle("Lab2: Drawing Algorithm");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private void naiveLine(Graphics g, int x1, int y1, int x2, int y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;

        float m = dy / dx;
        float b = y1 - (m * x1);

        for (int x = x1; x <= x2; x++) {
            int y = Math.round(m * x + b);
            plot(g, x, y);
        }
    }

    private void DDALine(Graphics g, int x1, int y1, int x2, int y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float m = dy / dx;

        float x = x1;
        float y = y1;

        if (m >= 0 && m <= 1) {
            y = y1;
            for (int xi = x1; xi <= x2; xi++) {
                plot(g, xi, Math.round(y));
                y += m;
            }
        } else if (m <= -1) {
            y = y1;
            for (int xi = x2; xi >= x1; xi--) {
                plot(g, xi, Math.round(y));
                y += m;
            }
        } else if (m > 1) {
            x = x1;
            for (int yi = y1; yi <= y2; yi++) {
                plot(g, Math.round(x), yi);
                x += 1 / m;
            }
        } else { 
            //m < 0 && m > -1
            x = x1;
            for (int yi = y2; yi >= y1; yi--) {
                plot(g, Math.round(x), yi);
                x += 1 / m;
            }
        }
    }

    private void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;

        if (dy > dx) {
            int temp = dx;
            dx = dy;
            dy = temp;
            isSwap = true;
        }

        int D = 2 * dy - dx;
        int x = x1;
        int y = y1;

        for (int i = 0; i <= dx; i++) {
            plot(g, x, y);

            if (D >= 0) {
                if (isSwap) x += sx;
                else y += sy;
                D -= 2 * dx;
            }

            if (isSwap) y += sy;
            else x += sx;

            D += 2 * dy;
        }
    }


    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 2, 2);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // //Naïve line drawing algorithm
        // g.setColor(Color.BLUE);
        // naiveLine(g, 100, 100, 400, 200);

        // g.setColor(Color.PINK);
        // naiveLine(g, 400, 300, 100, 200);

        // g.setColor(Color.ORANGE);
        // naiveLine(g, 100, 100, 200, 400);

        // //DDA line drawing algorithm
        // g.setColor(Color.BLUE);
        // DDALine(g, 100, 100, 400, 200);

        // g.setColor(Color.PINK);
        // DDALine(g, 400, 300, 100, 200);

        // g.setColor(Color.ORANGE);
        // DDALine(g, 100, 100, 200, 400);

        //Bresenham’s line drawing algorithm
        g.setColor(Color.BLUE);
        bresenhamLine(g, 100, 100, 400, 200);

        g.setColor(Color.PINK);
        bresenhamLine(g, 400, 300, 100, 200);

        g.setColor(Color.ORANGE);
        bresenhamLine(g, 100, 100, 200, 400);

    }
}
