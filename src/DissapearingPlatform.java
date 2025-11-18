import javafx.scene.paint.Color;

public class DissapearingPlatform extends Platform{
    private double platX;
    private double platY;

    public DissapearingPlatform(double platX, double platY) {
        super(platX, platY, Color.RED, 1);
    }

    @Override
    public void setForRemoval(){
        bounceRemove = true;
    }

}
