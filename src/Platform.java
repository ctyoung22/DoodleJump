import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Platform extends Rectangle {
    double platX;
    double platY;

    public Platform(double platX, double platY, Color color) {
        super(platX, platY, 40, 10);
        setFill(color);
        this.platX = platX;
        this.platY = platY;
    }

    public double getPlatX() {
        return platX;
    }

    public double getPlatY() {
        return platY;
    }
}
