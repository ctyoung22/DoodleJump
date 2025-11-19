import javafx.scene.paint.Color;

public class DisappearingPlatform extends Platform{
    boolean bounceRemove = false;

    public DisappearingPlatform(double platX, double platY) {
        super(platX, platY, Color.RED, 1);
    }

    public boolean getRemove(){
        return bounceRemove;
    }

    public void markForRemoval() {
        bounceRemove = true;
    }

}
