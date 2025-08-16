import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab4_Circle extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 4: Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new Lab4_Circle());
        frame.setVisible(true);
    }

    private int xc = 300;
    private int yc = 300;
    private int r = 100;

    public void midpointCircle(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int d = 1 - r;
        int dx = 2 * x;
        int dy = 2 * y;

        //plot 8 octants of (x, y)
        while (x <= y) {
            plot(g, xc + x, yc + y);
            plot(g, xc - x, yc + y);
            plot(g, xc + x, yc - y);
            plot(g, xc - x, yc - y);
            plot(g, xc + y, yc + x);
            plot(g, xc - y, yc + x);
            plot(g, xc + y, yc - x);
            plot(g, xc - y, yc - x);

            x += 1;
            dx += 2;
            d = d + dx + 1;

            if (d >= 0) {
                y--;
                dy -= 2;
                d -= dy;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        midpointCircle(g, xc, yc, r);  
    }

    private void plot(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }
}
