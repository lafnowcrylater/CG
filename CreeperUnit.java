import java.awt.Color;
import java.awt.Graphics;

public class CreeperUnit {
    // size of each pizxel
    private static final int BLOCK_SIZE = 12;
    
    // make it center
    private static final int HEAD_START_X = (600 - (8 * BLOCK_SIZE)) / 2;
    private static final int HEAD_START_Y = (600 - (8 * BLOCK_SIZE)) / 2;

    public static void drawCreeperBlock(Graphics g, int i, int j, Color color) {
        g.setColor(color);

        // where creeper is -> i = col, j = row
        int x = HEAD_START_X + (i * BLOCK_SIZE);
        int y = HEAD_START_Y + (j * BLOCK_SIZE);

        g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
    }
}