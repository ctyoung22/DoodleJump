import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Doodle extends Rectangle {
    double doodX;
    double doodY;

    public Doodle(double doodX, double doodY) {
        super(20, 30, Color.LIME);
        this.doodX = doodX;
        this.doodY = doodY;
    }

    public double getDoodX() {
        return doodX;
    }

    public double getDoodY() {
        return doodY;
    }
}
