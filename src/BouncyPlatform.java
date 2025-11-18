import javafx.scene.paint.Color;

public class BouncyPlatform extends Platform{
    private double platX;
    private double platY;

    public BouncyPlatform(double platX, double platY) {
        super(platX, platY, Color.GREEN, 1.5);
    }

}
