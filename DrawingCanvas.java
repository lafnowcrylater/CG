import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingCanvas extends JPanel {

    // Define the canvas size
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    int creeperX = 100;
    int creeperY = 200;

    int blockSize = 20; // for creeper

    // color pallete
    private static final Color DARK_GREEN = new Color(0, 102, 0);
    private static final Color MEDIUM_GREEN = new Color(0, 153, 0);
    private static final Color LIGHT_GREEN = new Color(153, 204, 0);
    private static final Color BLACK = Color.BLACK;

    /**
     * The main method to start the application.
     */
    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Empty Drawing Canvas");
        // Create an instance of our canvas panel
        DrawingCanvas canvas = new DrawingCanvas();

        // Add the canvas to the frame
        frame.add(canvas);
        // Set the frame's size
        frame.setSize(WIDTH, HEIGHT);
        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        // Make the frame visible
        frame.setVisible(true);
    }
    
    /**
     * This method is called by the Swing framework to draw the component.
     * You will put your drawing code inside this method.
     */
    @Override
    protected void paintComponent(Graphics g) {
        // Always call the superclass method first
        super.paintComponent(g);
        
        // Example: Fill the background with a white color
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //-------------HEAD------------
        //1
        CreeperUnit.drawCreeperBlock(g, 0, 0, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 1, 0, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 0, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 0, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 0, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 0, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 0, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 7, 0, MEDIUM_GREEN);

        //2
        CreeperUnit.drawCreeperBlock(g, 0, 1, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 1, 1, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 1, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 1, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 1, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 1, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 1, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 7, 1, DARK_GREEN);

        //3
        CreeperUnit.drawCreeperBlock(g, 0, 2, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 1, 2, BLACK);
        CreeperUnit.drawCreeperBlock(g, 2, 2, BLACK);
        CreeperUnit.drawCreeperBlock(g, 3, 2, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 2, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 2, BLACK);
        CreeperUnit.drawCreeperBlock(g, 6, 2, BLACK);
        CreeperUnit.drawCreeperBlock(g, 7, 2, MEDIUM_GREEN);

        //4
        CreeperUnit.drawCreeperBlock(g, 0, 3, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 1, 3, BLACK);
        CreeperUnit.drawCreeperBlock(g, 2, 3, BLACK);
        CreeperUnit.drawCreeperBlock(g, 3, 3, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 3, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 3, BLACK);
        CreeperUnit.drawCreeperBlock(g, 6, 3, BLACK);
        CreeperUnit.drawCreeperBlock(g, 7, 3, DARK_GREEN);

        //5
        CreeperUnit.drawCreeperBlock(g, 0, 4, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 1, 4, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 4, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 4, BLACK);
        CreeperUnit.drawCreeperBlock(g, 4, 4, BLACK);
        CreeperUnit.drawCreeperBlock(g, 5, 4, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 4, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 7, 4, DARK_GREEN);

        //6
        CreeperUnit.drawCreeperBlock(g, 0, 5, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 1, 5, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 5, BLACK);
        CreeperUnit.drawCreeperBlock(g, 3, 5, BLACK);
        CreeperUnit.drawCreeperBlock(g, 4, 5, BLACK);
        CreeperUnit.drawCreeperBlock(g, 5, 5, BLACK);
        CreeperUnit.drawCreeperBlock(g, 6, 5, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 7, 5, DARK_GREEN);

        //7
        CreeperUnit.drawCreeperBlock(g, 0, 6, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 1, 6, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 6, BLACK);
        CreeperUnit.drawCreeperBlock(g, 3, 6, BLACK);
        CreeperUnit.drawCreeperBlock(g, 4, 6, BLACK);
        CreeperUnit.drawCreeperBlock(g, 5, 6, BLACK);
        CreeperUnit.drawCreeperBlock(g, 6, 6, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 7, 6, MEDIUM_GREEN);

        //8
        CreeperUnit.drawCreeperBlock(g, 0, 7, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 1, 7, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 7, BLACK);
        CreeperUnit.drawCreeperBlock(g, 3, 7, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 7, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 7, BLACK);
        CreeperUnit.drawCreeperBlock(g, 6, 7, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 7, 7, DARK_GREEN);

        //-------------BODY------------
        //9
        CreeperUnit.drawCreeperBlock(g, 1, 8, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 8, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 8, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 8, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 8, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 8, MEDIUM_GREEN);
        //10
        CreeperUnit.drawCreeperBlock(g, 1, 9, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 9, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 9, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 9, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 9, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 9, DARK_GREEN);
        //11
        CreeperUnit.drawCreeperBlock(g, 1, 10, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 10, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 10, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 10, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 10, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 10, DARK_GREEN);
        //12
        CreeperUnit.drawCreeperBlock(g, 1, 11, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 11, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 11, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 11, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 11, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 11, MEDIUM_GREEN);
        //13
        CreeperUnit.drawCreeperBlock(g, 1, 12, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 12, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 12, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 12, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 12, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 12, DARK_GREEN);
        //14
        CreeperUnit.drawCreeperBlock(g, 1, 13, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 13, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 13, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 13, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 13, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 13, LIGHT_GREEN);
        //15
        CreeperUnit.drawCreeperBlock(g, 1, 14, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 14, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 14, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 14, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 14, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 14, DARK_GREEN);
        //16
        CreeperUnit.drawCreeperBlock(g, 1, 15, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 15, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 15, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 15, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 15, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 15, DARK_GREEN);
        //17
        CreeperUnit.drawCreeperBlock(g, 1, 16, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 16, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 16, LIGHT_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 16, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 16, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 16, DARK_GREEN);
        //18
        CreeperUnit.drawCreeperBlock(g, 1, 17, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 17, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 17, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 17, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 17, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 17, MEDIUM_GREEN);
        //19
        CreeperUnit.drawCreeperBlock(g, 1, 18, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 18, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 18, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 18, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 18, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 18, MEDIUM_GREEN);
        //20
        CreeperUnit.drawCreeperBlock(g, 1, 19, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 19, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 19, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 19, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 19, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 19, MEDIUM_GREEN);
        //21
        CreeperUnit.drawCreeperBlock(g, 1, 20, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 2, 20, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 3, 20, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 4, 20, MEDIUM_GREEN);
        CreeperUnit.drawCreeperBlock(g, 5, 20, DARK_GREEN);
        CreeperUnit.drawCreeperBlock(g, 6, 20, MEDIUM_GREEN);


    }
}