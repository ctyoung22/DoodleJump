import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Platform extends Rectangle {
    double platX;
    double platY;
    double bouceMulti;
    boolean bounceRemove = false;

    public Platform(double platX, double platY, Color color, double bounceMulti) {
        super(platX, platY, 40, 10);
        setFill(color);
        this.platX = platX;
        this.platY = platY;
        this.bouceMulti = bounceMulti;
    }

    public double getPlatX() {
        return platX;
    }

    public double getPlatY() {
        return platY;
    }

    public double getBounceMulti(){
        return bouceMulti;
    }

    public void setForRemoval(){
        bounceRemove = false;
    }

    public boolean getRemoval(){
        return bounceRemove;
    }

}
