import javafx.scene.paint.Color;

public class DisappearingPlatform extends Platform{
    private double platX;
    private double platY;
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
