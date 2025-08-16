import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

// Class for the Minecraft-style panel
public class MinecraftBackgroundPanel extends JPanel {

    // Set the dimensions for the panel
    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    public MinecraftBackgroundPanel() {
        // Set preferred size to match the assignment requirement
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // Set the background color (not strictly needed as we'll draw over it)
        setBackground(Color.WHITE);
    }

    // This method is called by the Swing system to draw the components
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Cast Graphics object to Graphics2D for more advanced drawing features
        Graphics2D g2d = (Graphics2D) g;

        // --- Draw the Sky (ท้องฟ้า) ---
        // Use a light blue color
        g2d.setColor(new Color(135, 206, 235)); // Sky Blue
        // Fill the top half of the panel
        g2d.fill(new Rectangle2D.Double(0, 0, WIDTH, HEIGHT / 2));

        // --- Draw the Ground (พื้นดิน) ---
        // Use a bright green color
        g2d.setColor(new Color(85, 107, 47)); // Dark Olive Green
        // Fill the bottom half of the panel
        g2d.fill(new Rectangle2D.Double(0, HEIGHT / 2, WIDTH, HEIGHT / 2));

        // --- Draw a simple block-like tree (ต้นไม้) ---
        // You can use a loop or call a method to draw multiple trees
        drawTree(g2d, 150, 250);
        drawTree(g2d, 400, 280);
    }

    // Method to draw a single tree
    private void drawTree(Graphics2D g2d, int x, int y) {
        // --- Draw the trunk (ลำต้น) ---
        g2d.setColor(new Color(102, 51, 0)); // Brown
        g2d.fill(new Rectangle2D.Double(x, y, 40, 100));

        // --- Draw the leaves (ใบไม้) ---
        g2d.setColor(new Color(34, 139, 34)); // Forest Green
        // Top block of leaves
        g2d.fill(new Rectangle2D.Double(x - 20, y - 40, 80, 40));
        // Middle blocks of leaves
        g2d.fill(new Rectangle2D.Double(x - 40, y, 120, 40));
        g2d.fill(new Rectangle2D.Double(x - 60, y + 40, 160, 40));
        // You can add more blocks to make it look fuller
    }

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Minecraft Reborn Animation Background");
        // Create the panel and add it to the frame
        frame.add(new MinecraftBackgroundPanel());
        // Set frame size based on the panel's preferred size
        frame.pack();
        // Make the frame visible
        frame.setVisible(true);
        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
    }
}