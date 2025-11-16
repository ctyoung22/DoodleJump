import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RegularPlatform extends Rectangle implements Platform{
    private double platX;
    private double platY;

    public RegularPlatform(){
        super(40, 10, Color.RED);
    }

    public boolean intersection(){
        return true;
    }

    public void setPlatX(double x){
        platX = x;
    }

    public void setPlatY(double y){
        platY = y;
    }

    public void removePlat(){
        
    }

}
