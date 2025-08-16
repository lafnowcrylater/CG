import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GraphicsSwing extends JPanel
{
    public static void main(String[] args){
        GraphicsSwing m = new GraphicsSwing();
        JFrame f=new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);  
    }

    @Override
    public void paintComponent(Graphics g){
        // g.drawString("Hello", 40, 40);
        // g.setColor(Color.BLUE);
        // g.fillRect(130, 30, 100, 80);
        // g.drawOval(30, 130, 50, 60);
        // g.setColor(Color.RED);
        // g.drawLine(0, 0, 200, 30);
        // g.fillOval(130, 130, 50, 60);
        // g.drawArc(30, 200, 40, 50, 90, 60);
        // g.fillArc(30, 130, 40, 50, 180, 40);
    
        // g.setColor(Color.MAGENTA);
        // plot(g, 300, 100);

        // g.setColor(Color.CYAN);
        // plot(g, 350, 100);

        // g.setColor(Color.BLUE);
        // plot(g, 400, 100);

        // g.setColor(Color.GREEN);
        // plot(g, 450, 100);

        // g.setColor(Color.YELLOW);
        // plot(g, 500, 100);

        // g.setColor(Color.ORANGE);
        // plot(g, 300, 200);

        // g.setColor(Color.RED);
        // plot(g, 350, 200);

        // g.setColor(Color.PINK);
        // plot(g, 400, 200);

        // g.setColor(new Color(1, 128, 128)); 
        // plot(g, 450, 200);

        // g.setColor(new Color(255, 119, 180)); 
        // plot(g, 500, 200);
    }

    private void plot(Graphics g, int x, int y){
        g.fillRect(x, y, 4, 4);
    }
}
