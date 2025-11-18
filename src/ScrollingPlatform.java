import javafx.scene.paint.Color;

public class ScrollingPlatform extends Platform{
    private double platX;
    private double platY;
    private int dx = 1;

    public ScrollingPlatform(double platX, double platY) {
        super(platX, platY, Color.BLUE, 1);
    }

    @Override
    public boolean getScrollable(){
        return true;
    }

    @Override
    public void scrollPlat(double lowX, double highX){
        platX = platX + dx;
        if(platX < lowX || platX > highX){
            dx = dx * -1;
        }
    }
    @Override
    public double getUpdatedX(){
        return platX;
    }

}
