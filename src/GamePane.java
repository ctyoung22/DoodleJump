import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Shape;

public class GamePane extends BorderPane{
    Doodle dood;
    RegularPlatform regPlat;

    public GamePane() {
        dood = new Doodle();
        getChildren().add(dood);
    }

    public void updateDoodlePosition(double doodX, double doodY) {
        dood.setLayoutX(doodX);
        dood.setLayoutY(doodY);
    }

    // adds the random platforms to the random points
    public void updatePlatformPostition(double x, double y){
        regPlat = new RegularPlatform();
        regPlat.setLayoutX(x);
        regPlat.setLayoutY(y);
        getChildren().add(regPlat);
    }

    public boolean intersection(){
        Shape intersection = Shape.intersect(dood, regPlat);
        return intersection.getBoundsInLocal().getWidth() >= 0 &&
            intersection.getBoundsInLocal().getHeight() >= 0;
    }
    
}
