// A platform class extending platform for platforms that disappear after 1 bounce
import javafx.scene.paint.Color;

public class DisappearingPlatform extends Platform{
    boolean bounceRemove = false;

    public DisappearingPlatform(double platX, double platY) {
        super(platX, platY, Color.RED, 1);
    }

    // gets if the platform should be removed from the game
    public boolean getRemove(){
        return bounceRemove;
    }

    // marks the platform to be removed in the next frame check
    public void markForRemoval() {
        bounceRemove = true;
    }

}
