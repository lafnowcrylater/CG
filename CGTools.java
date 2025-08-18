import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class CGTools {
    static void midpointEllipse(Graphics g, int xc, int yc, int a, int b){
        int a2 = a*a;
        int b2 = b*b;
        int twoA2 = 2*a2;
        int twoB2 = 2*b2;

        //region1
        int x = 0;
        int y = b;
        int D = Math.round(b2-a2*b + a2/4);
        int Dx = 0;
        int Dy = twoA2*y;
        while(Dx<=Dy){
            plot4Q(g, xc, yc, x, y);
            x++;
            Dx += twoB2;
            D += Dx+b2;

            if(D>=0){
                y--;
                Dy -= twoA2;
                D -= Dy;
            }
        }

        //region2
        x = a;
        y = 0;
        D = Math.round(a2-b2*a+b2/4);
        Dx = twoB2*x;
        Dy = 0;
        while(Dx>=Dy){
            plot4Q(g, xc, yc, x, y);
            y++;
            Dy += twoA2;
            D += Dy+a2;
            if(D>=0){
                x--;
                Dx -= twoB2;
                D -= Dx;
            }
        }
    }

    static void plot4Q(Graphics g, int xc, int yc, int x, int y) {
        g.fillRect(xc + x, yc + y, 1, 1);
        g.fillRect(xc - x, yc + y, 1, 1);
        g.fillRect(xc + x, yc - y, 1, 1);
        g.fillRect(xc - x, yc - y, 1, 1);
    }

    static BufferedImage floodFill(BufferedImage m, int x, int y, Color targetColor, Color replacementColor){
        int targetColorRGB = targetColor.getRGB();
        int replacementColorRGB = replacementColor.getRGB();

        Queue<int[]> q = new LinkedList<>();
        m.setRGB(x, y, replacementColorRGB);
        int[] arr = {x,y};
        q.offer(arr);

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            if(y1<m.getHeight() && m.getRGB(x1, y1+1) == targetColorRGB){
                m.setRGB(x1, y1+1, replacementColorRGB);
                int[] a = {x1, y1+1};
                q.offer(a);
            }
            if(y1>0 && m.getRGB(x1, y1-1) == targetColorRGB){
                m.setRGB(x1, y1-1, replacementColorRGB);
                int[] a = {x1, y1-1};
                q.offer(a);
            }
            if(x1<m.getWidth() && m.getRGB(x1+1, y1) == targetColorRGB){
                m.setRGB(x1+1, y1, replacementColorRGB);
                int[] a = {x1+1, y1};
                q.offer(a);
            }
            if(x1>0 && m.getRGB(x1-1, y1) == targetColorRGB){
                m.setRGB(x1-1, y1, replacementColorRGB);
                int[] a = {x1-1, y1};
                q.offer(a);
            }
        }

        return m;
    }

    static BufferedImage floodFillWithBoundary(BufferedImage m, int x, int y, Color boundaryColor, Color replacementColor) {
        int boundaryRGB = boundaryColor.getRGB();
        int replacementRGB = replacementColor.getRGB();

        Queue<int[]> q = new LinkedList<>();
        if (m.getRGB(x, y) == boundaryRGB || m.getRGB(x, y) == replacementRGB) {
            return m; // starting point is boundary or already filled
        }

        m.setRGB(x, y, replacementRGB);
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x1 = cur[0];
            int y1 = cur[1];

            // 4-connected neighbors
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            for (int[] d : dirs) {
                int nx = x1 + d[0];
                int ny = y1 + d[1];

                if (nx >= 0 && ny >= 0 && nx < m.getWidth() && ny < m.getHeight()) {
                    int color = m.getRGB(nx, ny);

                    // fill only if it's not boundary and not yet filled
                    if (color != boundaryRGB && color != replacementRGB) {
                        m.setRGB(nx, ny, replacementRGB);
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return m;
    }
    
    static void drawLineBresenham(Graphics g, int x0, int y0, int x1, int y1) {
        // Bresenham Line
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        int sx = (x0 < x1) ? 1 : -1;
        int sy = (y0 < y1) ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g.fillRect(x0, y0, 1, 1);

            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) { err -= dy; x0 += sx; }
            if (e2 < dx) { err += dx; y0 += sy; }
        }
    }
}
