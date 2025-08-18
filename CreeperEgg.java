import java.awt.*;

public class CreeperEgg{
    private static final int GRID_W = 12;
    //private static final int GRID_H = 14;
    private static final int BLOCK_SIZE = 12;

    // center the 16x16 block in a 600x600 canvas
    private static final int START_X = (600 - (GRID_W * BLOCK_SIZE)) / 2;
    private static final int START_Y = (600 - (18 * BLOCK_SIZE));

    // color pallete
    private static final Color VERY_DARK_GREEN = new Color(29, 77, 23);
    private static final Color DARK_GREEN = new Color(42, 97, 36);
    private static final Color MEDIUM_GREEN = new Color(17, 158, 37);
    private static final Color MEDIUM_GREEN_FADE = new Color(58, 180, 60);
    private static final Color LIGHT_GREEN = new Color(96, 201, 83);
    private static final Color LIGHT_GREEN_FADE = new Color(165, 218, 155);
    private static final Color FERN = new Color(60, 125, 58);
    private static final Color GREY = new Color(65, 78, 63);
    private static final Color LIGHT_GREY = new Color(122, 162, 124);

    private static void drawEggBlock(Graphics g, int i, int j, Color c) {
        g.setColor(c);
        int x = START_X + i * BLOCK_SIZE;
        int y = START_Y + j * BLOCK_SIZE;
        g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
    }

    public static void drawEgg(Graphics g) {
        // Row 0
        //drawEggBlock(g, 0, 0, new Color(0, 0, 0));
        //drawEggBlock(g, 1, 0, new Color(0, 0, 0));
        //drawEggBlock(g, 2, 0, new Color(0, 0, 0));
        //drawEggBlock(g, 3, 0, new Color(0, 0, 0));
        drawEggBlock(g, 4, 0, DARK_GREEN);
        drawEggBlock(g, 5, 0, DARK_GREEN);
        drawEggBlock(g, 6, 0, DARK_GREEN);
        drawEggBlock(g, 7, 0, DARK_GREEN);
        //drawEggBlock(g, 8, 0, new Color(0, 0, 0));
        //drawEggBlock(g, 9, 0, new Color(0, 0, 0));
        //drawEggBlock(g, 10, 0, new Color(0, 0, 0));
        //drawEggBlock(g, 11, 0, new Color(0, 0, 0));

        // Row 1
        //drawEggBlock(g, 0, 1, new Color(0, 0, 0));
        //drawEggBlock(g, 1, 1, new Color(0, 0, 0));
        //drawEggBlock(g, 2, 1, new Color(0, 0, 0));
        drawEggBlock(g, 3, 1, DARK_GREEN);
        drawEggBlock(g, 4, 1, MEDIUM_GREEN);
        drawEggBlock(g, 5, 1, LIGHT_GREEN);
        drawEggBlock(g, 6, 1, LIGHT_GREEN);
        drawEggBlock(g, 7, 1, MEDIUM_GREEN);
        drawEggBlock(g, 8, 1, DARK_GREEN);
        // drawEggBlock(g, 9, 1, new Color(42, 97, 36));
        // drawEggBlock(g, 10, 1, new Color(0, 0, 0));
        // drawEggBlock(g, 11, 1, new Color(0, 0, 0));

        // Row 2
        // drawEggBlock(g, 0, 2, new Color(0, 0, 0));
        // drawEggBlock(g, 1, 2, new Color(0, 0, 0));
        drawEggBlock(g, 2, 2, DARK_GREEN);
        drawEggBlock(g, 3, 2, MEDIUM_GREEN);
        drawEggBlock(g, 4, 2, LIGHT_GREEN);
        drawEggBlock(g, 5, 2, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 6, 2, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 7, 2, LIGHT_GREEN);
        drawEggBlock(g, 8, 2, MEDIUM_GREEN);
        drawEggBlock(g, 9, 2, DARK_GREEN);
        // drawEggBlock(g, 10, 2, new Color(0, 0, 0));
        // drawEggBlock(g, 11, 2, new Color(0, 0, 0));

        // Row 3
        //drawEggBlock(g, 0, 3, new Color(0, 0, 0));
        drawEggBlock(g, 1, 3, DARK_GREEN);
        drawEggBlock(g, 2, 3, MEDIUM_GREEN);
        drawEggBlock(g, 3, 3, LIGHT_GREEN);
        drawEggBlock(g, 4, 3, LIGHT_GREEN_FADE);
        drawEggBlock(g, 5, 3, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 6, 3, LIGHT_GREEN);
        drawEggBlock(g, 7, 3, MEDIUM_GREEN);
        drawEggBlock(g, 8, 3, new Color(165, 218, 155));
        drawEggBlock(g, 9, 3, FERN);
        drawEggBlock(g, 10, 3, DARK_GREEN);
        // drawEggBlock(g, 11, 3, new Color(0, 0, 0));

        // Row 4
        //drawEggBlock(g, 0, 4, new Color(0, 0, 0));
        drawEggBlock(g, 1, 4, DARK_GREEN);
        drawEggBlock(g, 2, 4, LIGHT_GREEN);
        drawEggBlock(g, 3, 4, Color.WHITE);
        drawEggBlock(g, 4, 4, Color.WHITE);
        drawEggBlock(g, 5, 4, LIGHT_GREEN);
        drawEggBlock(g, 6, 4, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 7, 4, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 8, 4, new Color(165, 218, 155));
        drawEggBlock(g, 9, 4, MEDIUM_GREEN);
        drawEggBlock(g, 10, 4, VERY_DARK_GREEN);
        // drawEggBlock(g, 11, 4, new Color(0, 0, 0));

        // Row 5 - start of eye
        drawEggBlock(g, 0, 5, DARK_GREEN);
        drawEggBlock(g, 1, 5, MEDIUM_GREEN);
        drawEggBlock(g, 2, 5, LIGHT_GREEN_FADE);
        drawEggBlock(g, 3, 5, new Color(38, 142, 47));
        drawEggBlock(g, 4, 5, new Color(50, 110, 45));
        drawEggBlock(g, 5, 5, LIGHT_GREEN_FADE);
        drawEggBlock(g, 6, 5, LIGHT_GREEN);
        drawEggBlock(g, 7, 5, new Color(29, 77, 23));
        drawEggBlock(g, 8, 5, new Color(21, 56, 15));
        drawEggBlock(g, 9, 5, new Color(38, 142, 47));
        drawEggBlock(g, 10, 5, FERN);
        drawEggBlock(g, 11, 5, GREY);

        // Row 6 - end of eye
        drawEggBlock(g, 0, 6, DARK_GREEN);
        drawEggBlock(g, 1, 6, LIGHT_GREEN);
        drawEggBlock(g, 2, 6, LIGHT_GREEN_FADE);
        drawEggBlock(g, 3, 6, new Color(50, 110, 45));
        drawEggBlock(g, 4, 6, new Color(29, 77, 23));
        drawEggBlock(g, 5, 6, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 6, 6, LIGHT_GREEN);
        drawEggBlock(g, 7, 6, new Color(29, 77, 23));
        drawEggBlock(g, 8, 6, new Color(12, 38, 9));
        drawEggBlock(g, 9, 6, MEDIUM_GREEN);
        drawEggBlock(g, 10, 6, LIGHT_GREY);
        drawEggBlock(g, 11, 6, VERY_DARK_GREEN);

        // Row 7 - start of mouth
        drawEggBlock(g, 0, 7, DARK_GREEN);
        drawEggBlock(g, 1, 7, LIGHT_GREEN_FADE);
        drawEggBlock(g, 2, 7, LIGHT_GREEN);
        drawEggBlock(g, 3, 7, LIGHT_GREEN_FADE);
        drawEggBlock(g, 4, 7, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 5, 7, DARK_GREEN);
        drawEggBlock(g, 6, 7, new Color(21, 56, 15));
        drawEggBlock(g, 7, 7, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 8, 7, LIGHT_GREEN);
        drawEggBlock(g, 9, 7, new Color(38, 142, 47));
        drawEggBlock(g, 10, 7, MEDIUM_GREEN);
        drawEggBlock(g, 11, 7, VERY_DARK_GREEN);

        // Row 8 - 2nd row of mouth
        drawEggBlock(g, 0, 8, DARK_GREEN);
        drawEggBlock(g, 1, 8, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 2, 8, FERN);
        drawEggBlock(g, 3, 8, LIGHT_GREEN);
        drawEggBlock(g, 4, 8, new Color(29, 77, 23));
        drawEggBlock(g, 5, 8, new Color(29, 77, 23));
        drawEggBlock(g, 6, 8, new Color(12, 38, 9));
        drawEggBlock(g, 7, 8, new Color(12, 38, 9));
        drawEggBlock(g, 8, 8, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 9, 8, new Color(38, 142, 47));
        drawEggBlock(g, 10, 8, LIGHT_GREY);
        drawEggBlock(g, 11, 8, GREY);

        // Row 9 - 3rd row of mouth
        drawEggBlock(g, 0, 9, DARK_GREEN);
        drawEggBlock(g, 1, 9, new Color(38, 142, 47));
        drawEggBlock(g, 2, 9, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 3, 9, LIGHT_GREEN);
        drawEggBlock(g, 4, 9, new Color(21, 56, 15));
        drawEggBlock(g, 5, 9, new Color(0, 0, 0));
        drawEggBlock(g, 6, 9, new Color(0, 0, 0));
        drawEggBlock(g, 7, 9, new Color(0, 0, 0));
        drawEggBlock(g, 8, 9, MEDIUM_GREEN);
        drawEggBlock(g, 9, 9, LIGHT_GREY);
        drawEggBlock(g, 10, 9, LIGHT_GREY);
        drawEggBlock(g, 11, 9, GREY);

        // Row 10 - end of mouth
        drawEggBlock(g, 0, 10, DARK_GREEN);
        drawEggBlock(g, 1, 10, MEDIUM_GREEN);
        drawEggBlock(g, 2, 10, MEDIUM_GREEN);
        drawEggBlock(g, 3, 10, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 4, 10, new Color(12, 38, 9));//
        drawEggBlock(g, 5, 10, LIGHT_GREEN);
        drawEggBlock(g, 6, 10, MEDIUM_GREEN_FADE);
        drawEggBlock(g, 7, 10, new Color(0, 0, 0));
        drawEggBlock(g, 8, 10, new Color(38, 142, 47));
        drawEggBlock(g, 9, 10, MEDIUM_GREEN);
        drawEggBlock(g, 10, 10, FERN);
        drawEggBlock(g, 11, 10, VERY_DARK_GREEN);

        // Row 11
        //drawEggBlock(g, 0, 11, new Color(0, 0, 0));
        drawEggBlock(g, 1, 11, DARK_GREEN);
        drawEggBlock(g, 2, 11, FERN);
        drawEggBlock(g, 3, 11, MEDIUM_GREEN);
        drawEggBlock(g, 4, 11, new Color(38, 142, 47));
        drawEggBlock(g, 5, 11, LIGHT_GREY);
        drawEggBlock(g, 6, 11, new Color(38, 142, 47));
        drawEggBlock(g, 7, 11, new Color(38, 142, 47));
        drawEggBlock(g, 8, 11, MEDIUM_GREEN);
        drawEggBlock(g, 9, 11, FERN);
        drawEggBlock(g, 10, 11, VERY_DARK_GREEN);
        // drawEggBlock(g, 11, 11, new Color(0, 0, 0));

        // Row 12
        // drawEggBlock(g, 0, 12, new Color(0, 0, 0));
        // drawEggBlock(g, 1, 12, new Color(0, 0, 0));
        drawEggBlock(g, 2, 12, VERY_DARK_GREEN);
        drawEggBlock(g, 3, 12, FERN);
        drawEggBlock(g, 4, 12, FERN);
        drawEggBlock(g, 5, 12, FERN);
        drawEggBlock(g, 6, 12, LIGHT_GREY);
        drawEggBlock(g, 7, 12, FERN);
        drawEggBlock(g, 8, 12, FERN);
        drawEggBlock(g, 9, 12, VERY_DARK_GREEN);
        // drawEggBlock(g, 10, 12, new Color(60, 125, 58));
        // drawEggBlock(g, 11, 12, new Color(42, 97, 36));

        // Row 13 - last
        // drawEggBlock(g, 0, 13, new Color(0, 0, 0));
        // drawEggBlock(g, 1, 13, new Color(0, 0, 0));
        // drawEggBlock(g, 2, 13, new Color(0, 0, 0));
        drawEggBlock(g, 3, 13, VERY_DARK_GREEN);
        drawEggBlock(g, 4, 13, VERY_DARK_GREEN);
        drawEggBlock(g, 5, 13, GREY);
        drawEggBlock(g, 6, 13, GREY);
        drawEggBlock(g, 7, 13, GREY);
        drawEggBlock(g, 8, 13, VERY_DARK_GREEN);
        // drawEggBlock(g, 9, 13, new Color(58, 180, 60));
        // drawEggBlock(g, 10, 13, new Color(0, 0, 0));
        // drawEggBlock(g, 11, 13, new Color(0, 0, 0));
    }
}
