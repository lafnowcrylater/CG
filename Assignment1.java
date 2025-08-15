import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Assignment1 extends JPanel implements Runnable{
    public static void main(String[] args) {
        Assignment1 m = new Assignment1();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Graphics");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        new Thread(m).start();
    }

    public void run(){

        while (true){


            //Display
            repaint();
        }
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        // g2.setColor(Color.WHITE);
        // g2.fillRect(0, 0, 600, 600);
        
    }

    public void scene1(Graphics g){
        
    }
}
