// A platform class extending platform for platforms that increase bounce height
import javafx.scene.paint.Color;

public class BouncyPlatform extends Platform{

    public BouncyPlatform(double platX, double platY) {
        super(platX, platY, Color.GREEN, 1.5);
    }

}
