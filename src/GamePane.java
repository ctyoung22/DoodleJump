import java.util.ArrayList;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Shape;

public class GamePane extends BorderPane{
    Doodle dood;
    Platform topPlatform;


    public GamePane() {
        dood = new Doodle();
        getChildren().add(dood);
    }

    public void updateDoodlePosition(double doodX, double doodY) {
        dood.setLayoutX(doodX);
        dood.setLayoutY(doodY);
    }

    public void addPlatform(double platX, double platY) {
        Platform plat = new RegularPlatform(platX, platY);
        getChildren().add(plat);
    }

/*     public void generatePlatforms() {
        topPlatform = locateTopPlatform();
        while(topPlatform.getLayoutY() < 500 && topPlatform.getLayoutY() > 0) {
            double lowX = Math.max(0, topPlatform.getLayoutX() - 100);
            double highX = Math.min(400, topPlatform.getLayoutX() + 100);
            double newPlatX = Math.random() * (highX - lowX) + lowX;

            double lowY = topPlatform.getLayoutY() - 20;
            double highY = topPlatform.getLayoutY() - 100;
            double newPlatY = Math.random() * (highY - lowY) + lowY;

            addPlatform(newPlatX, newPlatY);
            topPlatform = locateTopPlatform();
        }
    }

    public Platform locateTopPlatform() {
        return platforms.get(platforms.size() - 1);
    } */
}
