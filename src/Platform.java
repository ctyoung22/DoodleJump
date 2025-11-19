import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Platform extends Rectangle {
    private double platX;
    private double platY;
    private double bounceMulti;

    public Platform(double platX, double platY, Color color, double bounceMulti) {
        super(platX, platY, 40, 10);
        setFill(color);
        this.platX = platX;
        this.platY = platY;
        this.bounceMulti = bounceMulti;
    }

    // gets platform x position
    public double getPlatX() {
        return platX;
    }

    // gets platform y position
    public double getPlatY() {
        return platY;
    }

    // gets the platform jump multiplyer
    public double getBounceMulti(){
        return bounceMulti;
    }

    // sets platform y position
    public void setPlatY(double platY) {
        this.platY = platY;
    }
}
