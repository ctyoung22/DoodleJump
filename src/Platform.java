import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Platform extends Rectangle {

    public Platform(double platX, double platY, Color color) {
        super(platX, platY, 40, 10);
        setFill(color);
    }
}
