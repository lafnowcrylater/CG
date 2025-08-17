import java.awt.Color;
import java.awt.Graphics;

public class Creeper {
    // size of each pixel
    private static final int BLOCK_SIZE = 12;

    // make it center
    private static final int HEAD_START_X = (600 - (8 * BLOCK_SIZE)) / 2;
    private static final int HEAD_START_Y = (600 - (8 * BLOCK_SIZE)) / 2;

    // color pallete -- normal
    private static final Color DARK_GREEN = new Color(0, 102, 0);
    private static final Color MEDIUM_GREEN = new Color(0, 153, 0);
    private static final Color LIGHT_GREEN = new Color(153, 204, 0);
    private static final Color GREY = new Color(44, 88, 43);
    private static final Color BLACK = Color.BLACK;

    // color for exploding part
    private static final Color DARK_GREEN_FADE = new Color(102, 153, 102);
    private static final Color MEDIUM_GREEN_FADE = new Color(128, 179, 128);
    private static final Color LIGHT_GREEN_FADE = new Color(204, 229, 153);
    private static final Color GREY_FADE = new Color(153, 179, 153);
    private static final Color BLACK_FADE = new Color(77, 77, 77);

    public static void drawCreeperBlock(Graphics g, int i, int j, Color color) {
        g.setColor(color);

        // where creeper is -> i = col, j = row
        int x = HEAD_START_X + (i * BLOCK_SIZE);
        int y = HEAD_START_Y + (j * BLOCK_SIZE);

        g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
    }


    public static void drawCreeperGreen(Graphics g) {
        //-------------HEAD------------
        //1
        drawCreeperBlock(g, 0, 0, DARK_GREEN);
        drawCreeperBlock(g, 1, 0, DARK_GREEN);
        drawCreeperBlock(g, 2, 0, MEDIUM_GREEN);
        drawCreeperBlock(g, 3, 0, LIGHT_GREEN);
        drawCreeperBlock(g, 4, 0, DARK_GREEN);
        drawCreeperBlock(g, 5, 0, DARK_GREEN);
        drawCreeperBlock(g, 6, 0, DARK_GREEN);
        drawCreeperBlock(g, 7, 0, MEDIUM_GREEN);

        //2
        drawCreeperBlock(g, 0, 1, DARK_GREEN);
        drawCreeperBlock(g, 1, 1, DARK_GREEN);
        drawCreeperBlock(g, 2, 1, MEDIUM_GREEN);
        drawCreeperBlock(g, 3, 1, DARK_GREEN);
        drawCreeperBlock(g, 4, 1, MEDIUM_GREEN);
        drawCreeperBlock(g, 5, 1, MEDIUM_GREEN);
        drawCreeperBlock(g, 6, 1, DARK_GREEN);
        drawCreeperBlock(g, 7, 1, DARK_GREEN);

        //3
        drawCreeperBlock(g, 0, 2, LIGHT_GREEN);
        drawCreeperBlock(g, 1, 2, BLACK);
        drawCreeperBlock(g, 2, 2, BLACK);
        drawCreeperBlock(g, 3, 2, DARK_GREEN);
        drawCreeperBlock(g, 4, 2, DARK_GREEN);
        drawCreeperBlock(g, 5, 2, BLACK);
        drawCreeperBlock(g, 6, 2, BLACK);
        drawCreeperBlock(g, 7, 2, MEDIUM_GREEN);

        //4
        drawCreeperBlock(g, 0, 3, MEDIUM_GREEN);
        drawCreeperBlock(g, 1, 3, BLACK);
        drawCreeperBlock(g, 2, 3, BLACK);
        drawCreeperBlock(g, 3, 3, LIGHT_GREEN);
        drawCreeperBlock(g, 4, 3, MEDIUM_GREEN);
        drawCreeperBlock(g, 5, 3, BLACK);
        drawCreeperBlock(g, 6, 3, BLACK);
        drawCreeperBlock(g, 7, 3, DARK_GREEN);

        //5
        drawCreeperBlock(g, 0, 4, MEDIUM_GREEN);
        drawCreeperBlock(g, 1, 4, DARK_GREEN);
        drawCreeperBlock(g, 2, 4, DARK_GREEN);
        drawCreeperBlock(g, 3, 4, BLACK);
        drawCreeperBlock(g, 4, 4, BLACK);
        drawCreeperBlock(g, 5, 4, MEDIUM_GREEN);
        drawCreeperBlock(g, 6, 4, MEDIUM_GREEN);
        drawCreeperBlock(g, 7, 4, DARK_GREEN);

        //6
        drawCreeperBlock(g, 0, 5, DARK_GREEN);
        drawCreeperBlock(g, 1, 5, DARK_GREEN);
        drawCreeperBlock(g, 2, 5, BLACK);
        drawCreeperBlock(g, 3, 5, BLACK);
        drawCreeperBlock(g, 4, 5, BLACK);
        drawCreeperBlock(g, 5, 5, BLACK);
        drawCreeperBlock(g, 6, 5, DARK_GREEN);
        drawCreeperBlock(g, 7, 5, DARK_GREEN);

        //7
        drawCreeperBlock(g, 0, 6, LIGHT_GREEN);
        drawCreeperBlock(g, 1, 6, MEDIUM_GREEN);
        drawCreeperBlock(g, 2, 6, BLACK);
        drawCreeperBlock(g, 3, 6, BLACK);
        drawCreeperBlock(g, 4, 6, BLACK);
        drawCreeperBlock(g, 5, 6, BLACK);
        drawCreeperBlock(g, 6, 6, LIGHT_GREEN);
        drawCreeperBlock(g, 7, 6, MEDIUM_GREEN);

        //8
        drawCreeperBlock(g, 0, 7, MEDIUM_GREEN);
        drawCreeperBlock(g, 1, 7, LIGHT_GREEN);
        drawCreeperBlock(g, 2, 7, BLACK);
        drawCreeperBlock(g, 3, 7, LIGHT_GREEN);
        drawCreeperBlock(g, 4, 7, MEDIUM_GREEN);
        drawCreeperBlock(g, 5, 7, BLACK);
        drawCreeperBlock(g, 6, 7, LIGHT_GREEN);
        drawCreeperBlock(g, 7, 7, DARK_GREEN);

        //-------------BODY------------
        //9
        drawCreeperBlock(g, 1, 8, MEDIUM_GREEN);
        drawCreeperBlock(g, 2, 8, DARK_GREEN);
        drawCreeperBlock(g, 3, 8, DARK_GREEN);
        drawCreeperBlock(g, 4, 8, MEDIUM_GREEN);
        drawCreeperBlock(g, 5, 8, DARK_GREEN);
        drawCreeperBlock(g, 6, 8, MEDIUM_GREEN);
        //10
        drawCreeperBlock(g, 1, 9, DARK_GREEN);
        drawCreeperBlock(g, 2, 9, LIGHT_GREEN);
        drawCreeperBlock(g, 3, 9, MEDIUM_GREEN);
        drawCreeperBlock(g, 4, 9, MEDIUM_GREEN);
        drawCreeperBlock(g, 5, 9, LIGHT_GREEN);
        drawCreeperBlock(g, 6, 9, DARK_GREEN);
        //11
        drawCreeperBlock(g, 1, 10, LIGHT_GREEN);
        drawCreeperBlock(g, 2, 10, MEDIUM_GREEN);
        drawCreeperBlock(g, 3, 10, DARK_GREEN);
        drawCreeperBlock(g, 4, 10, MEDIUM_GREEN);
        drawCreeperBlock(g, 5, 10, DARK_GREEN);
        drawCreeperBlock(g, 6, 10, DARK_GREEN);
        //12
        drawCreeperBlock(g, 1, 11, MEDIUM_GREEN);
        drawCreeperBlock(g, 2, 11, DARK_GREEN);
        drawCreeperBlock(g, 3, 11, LIGHT_GREEN);
        drawCreeperBlock(g, 4, 11, LIGHT_GREEN);
        drawCreeperBlock(g, 5, 11, DARK_GREEN);
        drawCreeperBlock(g, 6, 11, MEDIUM_GREEN);
        //13
        drawCreeperBlock(g, 1, 12, DARK_GREEN);
        drawCreeperBlock(g, 2, 12, DARK_GREEN);
        drawCreeperBlock(g, 3, 12, MEDIUM_GREEN);
        drawCreeperBlock(g, 4, 12, LIGHT_GREEN);
        drawCreeperBlock(g, 5, 12, MEDIUM_GREEN);
        drawCreeperBlock(g, 6, 12, DARK_GREEN);
        //14
        drawCreeperBlock(g, 1, 13, MEDIUM_GREEN);
        drawCreeperBlock(g, 2, 13, DARK_GREEN);
        drawCreeperBlock(g, 3, 13, DARK_GREEN);
        drawCreeperBlock(g, 4, 13, DARK_GREEN);
        drawCreeperBlock(g, 5, 13, MEDIUM_GREEN);
        drawCreeperBlock(g, 6, 13, LIGHT_GREEN);
        //15
        drawCreeperBlock(g, 1, 14, LIGHT_GREEN);
        drawCreeperBlock(g, 2, 14, DARK_GREEN);
        drawCreeperBlock(g, 3, 14, DARK_GREEN);
        drawCreeperBlock(g, 4, 14, MEDIUM_GREEN);
        drawCreeperBlock(g, 5, 14, LIGHT_GREEN);
        drawCreeperBlock(g, 6, 14, DARK_GREEN);
        //16
        drawCreeperBlock(g, 1, 15, MEDIUM_GREEN);
        drawCreeperBlock(g, 2, 15, DARK_GREEN);
        drawCreeperBlock(g, 3, 15, MEDIUM_GREEN);
        drawCreeperBlock(g, 4, 15, LIGHT_GREEN);
        drawCreeperBlock(g, 5, 15, DARK_GREEN);
        drawCreeperBlock(g, 6, 15, DARK_GREEN);
        //17
        drawCreeperBlock(g, 1, 16, DARK_GREEN);
        drawCreeperBlock(g, 2, 16, MEDIUM_GREEN);
        drawCreeperBlock(g, 3, 16, DARK_GREEN);
        drawCreeperBlock(g, 4, 16, LIGHT_GREEN);
        drawCreeperBlock(g, 5, 16, DARK_GREEN);
        drawCreeperBlock(g, 6, 16, MEDIUM_GREEN);
        //18
        drawCreeperBlock(g, 1, 17, MEDIUM_GREEN);
        drawCreeperBlock(g, 2, 17, DARK_GREEN);
        drawCreeperBlock(g, 3, 17, DARK_GREEN);
        drawCreeperBlock(g, 4, 17, DARK_GREEN);
        drawCreeperBlock(g, 5, 17, MEDIUM_GREEN);
        drawCreeperBlock(g, 6, 17, MEDIUM_GREEN);
        //19
        drawCreeperBlock(g, 1, 18, LIGHT_GREEN);
        drawCreeperBlock(g, 2, 18, MEDIUM_GREEN);
        drawCreeperBlock(g, 3, 18, DARK_GREEN);
        drawCreeperBlock(g, 4, 18, MEDIUM_GREEN);
        drawCreeperBlock(g, 5, 18, DARK_GREEN);
        drawCreeperBlock(g, 6, 18, DARK_GREEN);
        //20
        drawCreeperBlock(g, 1, 19, MEDIUM_GREEN);
        drawCreeperBlock(g, 2, 19, LIGHT_GREEN);
        drawCreeperBlock(g, 3, 19, DARK_GREEN);
        drawCreeperBlock(g, 4, 19, DARK_GREEN);
        drawCreeperBlock(g, 5, 19, DARK_GREEN);
        drawCreeperBlock(g, 6, 19, MEDIUM_GREEN);
        //21
        drawCreeperBlock(g, 1, 20, MEDIUM_GREEN);
        drawCreeperBlock(g, 2, 20, DARK_GREEN);
        drawCreeperBlock(g, 3, 20, DARK_GREEN);
        drawCreeperBlock(g, 4, 20, MEDIUM_GREEN);
        drawCreeperBlock(g, 5, 20, DARK_GREEN);
        drawCreeperBlock(g, 6, 20, LIGHT_GREEN);

        // ---------------leg---------------
        //22
        drawCreeperBlock(g, 0, 21, MEDIUM_GREEN);
        drawCreeperBlock(g, 1, 21, DARK_GREEN);
        drawCreeperBlock(g, 2, 21, MEDIUM_GREEN);
        drawCreeperBlock(g, 3, 21, LIGHT_GREEN);
        drawCreeperBlock(g, 4, 21, DARK_GREEN);
        drawCreeperBlock(g, 5, 21, DARK_GREEN);
        drawCreeperBlock(g, 6, 21, DARK_GREEN);
        drawCreeperBlock(g, 7, 21, MEDIUM_GREEN);

        //23
        drawCreeperBlock(g, 0, 22, DARK_GREEN);
        drawCreeperBlock(g, 1, 22, DARK_GREEN);
        drawCreeperBlock(g, 2, 22, MEDIUM_GREEN);
        drawCreeperBlock(g, 3, 22, DARK_GREEN);
        drawCreeperBlock(g, 4, 22, MEDIUM_GREEN);
        drawCreeperBlock(g, 5, 22, MEDIUM_GREEN);
        drawCreeperBlock(g, 6, 22, DARK_GREEN);
        drawCreeperBlock(g, 7, 22, DARK_GREEN);

        //24
        drawCreeperBlock(g, 0, 23, GREY);
        drawCreeperBlock(g, 1, 23, BLACK);
        drawCreeperBlock(g, 2, 23, GREY);
        drawCreeperBlock(g, 3, 23, BLACK);
        drawCreeperBlock(g, 4, 23, GREY);
        drawCreeperBlock(g, 5, 23, BLACK);
        drawCreeperBlock(g, 6, 23, GREY);
        drawCreeperBlock(g, 7, 23, BLACK);

        //25
        drawCreeperBlock(g, 0, 24, BLACK);
        drawCreeperBlock(g, 1, 24, GREY);
        drawCreeperBlock(g, 2, 24, BLACK);
        drawCreeperBlock(g, 3, 24, GREY);
        drawCreeperBlock(g, 4, 24, BLACK);
        drawCreeperBlock(g, 5, 24, GREY);
        drawCreeperBlock(g, 6, 24, BLACK);
        drawCreeperBlock(g, 7, 24, GREY);
    }

    public static void drawCreeperFlashing(Graphics g) {
        //-------------HEAD------------
        //1
        drawCreeperBlock(g, 0, 0, DARK_GREEN_FADE);
        drawCreeperBlock(g, 1, 0, DARK_GREEN_FADE);
        drawCreeperBlock(g, 2, 0, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 3, 0, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 4, 0, DARK_GREEN_FADE);
        drawCreeperBlock(g, 5, 0, DARK_GREEN_FADE);
        drawCreeperBlock(g, 6, 0, DARK_GREEN_FADE);
        drawCreeperBlock(g, 7, 0, MEDIUM_GREEN_FADE);

        //2
        drawCreeperBlock(g, 0, 1, DARK_GREEN_FADE);
        drawCreeperBlock(g, 1, 1, DARK_GREEN_FADE);
        drawCreeperBlock(g, 2, 1, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 3, 1, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 1, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 5, 1, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 6, 1, DARK_GREEN_FADE);
        drawCreeperBlock(g, 7, 1, DARK_GREEN_FADE);

        //3
        drawCreeperBlock(g, 0, 2, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 1, 2, BLACK_FADE);
        drawCreeperBlock(g, 2, 2, BLACK_FADE);
        drawCreeperBlock(g, 3, 2, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 2, DARK_GREEN_FADE);
        drawCreeperBlock(g, 5, 2, BLACK_FADE);
        drawCreeperBlock(g, 6, 2, BLACK_FADE);
        drawCreeperBlock(g, 7, 2, MEDIUM_GREEN_FADE);

        //4
        drawCreeperBlock(g, 0, 3, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 1, 3, BLACK_FADE);
        drawCreeperBlock(g, 2, 3, BLACK_FADE);
        drawCreeperBlock(g, 3, 3, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 4, 3, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 5, 3, BLACK_FADE);
        drawCreeperBlock(g, 6, 3, BLACK_FADE);
        drawCreeperBlock(g, 7, 3, DARK_GREEN_FADE);

        //5
        drawCreeperBlock(g, 0, 4, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 1, 4, DARK_GREEN_FADE);
        drawCreeperBlock(g, 2, 4, DARK_GREEN_FADE);
        drawCreeperBlock(g, 3, 4, BLACK_FADE);
        drawCreeperBlock(g, 4, 4, BLACK_FADE);
        drawCreeperBlock(g, 5, 4, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 6, 4, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 7, 4, DARK_GREEN_FADE);

        //6
        drawCreeperBlock(g, 0, 5, DARK_GREEN_FADE);
        drawCreeperBlock(g, 1, 5, DARK_GREEN_FADE);
        drawCreeperBlock(g, 2, 5, BLACK_FADE);
        drawCreeperBlock(g, 3, 5, BLACK_FADE);
        drawCreeperBlock(g, 4, 5, BLACK_FADE);
        drawCreeperBlock(g, 5, 5, BLACK_FADE);
        drawCreeperBlock(g, 6, 5, DARK_GREEN_FADE);
        drawCreeperBlock(g, 7, 5, DARK_GREEN_FADE);

        //7
        drawCreeperBlock(g, 0, 6, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 1, 6, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 2, 6, BLACK_FADE);
        drawCreeperBlock(g, 3, 6, BLACK_FADE);
        drawCreeperBlock(g, 4, 6, BLACK_FADE);
        drawCreeperBlock(g, 5, 6, BLACK_FADE);
        drawCreeperBlock(g, 6, 6, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 7, 6, MEDIUM_GREEN_FADE);

        //8
        drawCreeperBlock(g, 0, 7, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 1, 7, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 2, 7, BLACK_FADE);
        drawCreeperBlock(g, 3, 7, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 4, 7, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 5, 7, BLACK_FADE);
        drawCreeperBlock(g, 6, 7, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 7, 7, DARK_GREEN_FADE);

        //-------------BODY------------
        //9
        drawCreeperBlock(g, 1, 8, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 2, 8, DARK_GREEN_FADE);
        drawCreeperBlock(g, 3, 8, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 8, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 5, 8, DARK_GREEN_FADE);
        drawCreeperBlock(g, 6, 8, MEDIUM_GREEN_FADE);
        //10
        drawCreeperBlock(g, 1, 9, DARK_GREEN_FADE);
        drawCreeperBlock(g, 2, 9, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 3, 9, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 4, 9, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 5, 9, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 6, 9, DARK_GREEN_FADE);
        //11
        drawCreeperBlock(g, 1, 10, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 2, 10, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 3, 10, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 10, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 5, 10, DARK_GREEN_FADE);
        drawCreeperBlock(g, 6, 10, DARK_GREEN_FADE);
        //12
        drawCreeperBlock(g, 1, 11, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 2, 11, DARK_GREEN_FADE);
        drawCreeperBlock(g, 3, 11, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 4, 11, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 5, 11, DARK_GREEN_FADE);
        drawCreeperBlock(g, 6, 11, MEDIUM_GREEN_FADE);
        //13
        drawCreeperBlock(g, 1, 12, DARK_GREEN_FADE);
        drawCreeperBlock(g, 2, 12, DARK_GREEN_FADE);
        drawCreeperBlock(g, 3, 12, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 4, 12, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 5, 12, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 6, 12, DARK_GREEN_FADE);
        //14
        drawCreeperBlock(g, 1, 13, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 2, 13, DARK_GREEN_FADE);
        drawCreeperBlock(g, 3, 13, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 13, DARK_GREEN_FADE);
        drawCreeperBlock(g, 5, 13, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 6, 13, LIGHT_GREEN_FADE);
        //15
        drawCreeperBlock(g, 1, 14, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 2, 14, DARK_GREEN_FADE);
        drawCreeperBlock(g, 3, 14, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 14, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 5, 14, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 6, 14, DARK_GREEN_FADE);
        //16
        drawCreeperBlock(g, 1, 15, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 2, 15, DARK_GREEN_FADE);
        drawCreeperBlock(g, 3, 15, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 4, 15, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 5, 15, DARK_GREEN_FADE);
        drawCreeperBlock(g, 6, 15, DARK_GREEN_FADE);
        //17
        drawCreeperBlock(g, 1, 16, DARK_GREEN_FADE);
        drawCreeperBlock(g, 2, 16, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 3, 16, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 16, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 5, 16, DARK_GREEN_FADE);
        drawCreeperBlock(g, 6, 16, MEDIUM_GREEN_FADE);
        //18
        drawCreeperBlock(g, 1, 17, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 2, 17, DARK_GREEN_FADE);
        drawCreeperBlock(g, 3, 17, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 17, DARK_GREEN_FADE);
        drawCreeperBlock(g, 5, 17, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 6, 17, MEDIUM_GREEN_FADE);
        //19
        drawCreeperBlock(g, 1, 18, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 2, 18, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 3, 18, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 18, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 5, 18, DARK_GREEN_FADE);
        drawCreeperBlock(g, 6, 18, DARK_GREEN_FADE);
        //20
        drawCreeperBlock(g, 1, 19, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 2, 19, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 3, 19, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 19, DARK_GREEN_FADE);
        drawCreeperBlock(g, 5, 19, DARK_GREEN_FADE);
        drawCreeperBlock(g, 6, 19, MEDIUM_GREEN_FADE);
        //21
        drawCreeperBlock(g, 1, 20, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 2, 20, DARK_GREEN_FADE);
        drawCreeperBlock(g, 3, 20, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 20, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 5, 20, DARK_GREEN_FADE);
        drawCreeperBlock(g, 6, 20, LIGHT_GREEN_FADE);

        // ---------------leg---------------
        //22
        drawCreeperBlock(g, 0, 21, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 1, 21, DARK_GREEN_FADE);
        drawCreeperBlock(g, 2, 21, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 3, 21, LIGHT_GREEN_FADE);
        drawCreeperBlock(g, 4, 21, DARK_GREEN_FADE);
        drawCreeperBlock(g, 5, 21, DARK_GREEN_FADE);
        drawCreeperBlock(g, 6, 21, DARK_GREEN_FADE);
        drawCreeperBlock(g, 7, 21, MEDIUM_GREEN_FADE);

        //23
        drawCreeperBlock(g, 0, 22, DARK_GREEN_FADE);
        drawCreeperBlock(g, 1, 22, DARK_GREEN_FADE);
        drawCreeperBlock(g, 2, 22, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 3, 22, DARK_GREEN_FADE);
        drawCreeperBlock(g, 4, 22, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 5, 22, MEDIUM_GREEN_FADE);
        drawCreeperBlock(g, 6, 22, DARK_GREEN_FADE);
        drawCreeperBlock(g, 7, 22, DARK_GREEN_FADE);

        //24
        drawCreeperBlock(g, 0, 23, GREY_FADE);
        drawCreeperBlock(g, 1, 23, BLACK_FADE);
        drawCreeperBlock(g, 2, 23, GREY_FADE);
        drawCreeperBlock(g, 3, 23, BLACK_FADE);
        drawCreeperBlock(g, 4, 23, GREY_FADE);
        drawCreeperBlock(g, 5, 23, BLACK_FADE);
        drawCreeperBlock(g, 6, 23, GREY_FADE);
        drawCreeperBlock(g, 7, 23, BLACK_FADE);

        //25
        drawCreeperBlock(g, 0, 24, BLACK_FADE);
        drawCreeperBlock(g, 1, 24, GREY_FADE);
        drawCreeperBlock(g, 2, 24, BLACK_FADE);
        drawCreeperBlock(g, 3, 24, GREY_FADE);
        drawCreeperBlock(g, 4, 24, BLACK_FADE);
        drawCreeperBlock(g, 5, 24, GREY_FADE);
        drawCreeperBlock(g, 6, 24, BLACK_FADE);
        drawCreeperBlock(g, 7, 24, GREY_FADE);
    }
}