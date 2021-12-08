import java.awt.*;

public class Star {
    double x, y, z;
    double dx, dy;
    int tx, ty;
    int px, py;
    int count = 0;
    double ratioX, ratioY;
    int size = StarField.SIZE;
    int centreX = StarField.SIZE / 2;
    int centreY = centreX;
    static boolean mod1 = true;


    Star() {
        this.x = Math.random() * size;
        this.y = Math.random() * size;
        this.z = Math.random() * size / 2;

    }

    void update() {
        if (tx > size || ty > size || tx < 0 || ty < 0) {
            this.x = Math.random() * size;
            this.y = Math.random() * size;
            this.z = size / 2;
            count = 0;
        }
        if (count % 6 == 0) {
            px = tx;
            py = ty;
        }
        count++;
        z--;

    }

    void show(Graphics g) {
        dx = Math.abs(x - centreX);
        dy = Math.abs(y - centreY);
        ratioX = dx / z;
        ratioY = dy / z;
        if (x < centreX) tx = centreX - (int) (centreX * ratioX);
        else tx = centreX + (int) (centreX * ratioX);
        if (y < centreY) ty = centreY - (int) (centreY * ratioY);
        else ty = centreY + (int) (centreY * ratioY);
        if (count < 7) return;
        if (mod1) g.drawLine(px, py, tx, ty);
        else g.fillOval(tx, ty, (int) (1 + Math.round(centreX / z)*2), (int) (1 + Math.round(centreX / z)*2));
    }

}
