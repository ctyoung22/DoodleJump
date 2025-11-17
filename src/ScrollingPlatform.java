import javafx.scene.paint.Color;

public class ScrollingPlatform extends Platform{
    private double platX;
    private double platY;

    public ScrollingPlatform(double platX, double platY) {
        super(platX, platY, Color.BLUE);
    }

}
