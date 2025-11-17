import java.util.ArrayList;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Shape;

public class GamePane extends BorderPane{
    Doodle dood;

    public void addDoodle(Doodle dood) {
        this.dood = dood;
        getChildren().add(dood);
    }

    public void updateDoodlePosition(double doodX, double doodY) {
        dood.setLayoutX(doodX);
        dood.setLayoutY(doodY);
    }

    public void addPlatform(Platform plat) {
        getChildren().add(plat);
    }

    public void removePlatform(Platform plat) {
        getChildren().remove(plat);
    }
}
