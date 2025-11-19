// the game pane for adding and removing items in the pane

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Shape;

public class GamePane extends BorderPane{
    Doodle dood;

    // adds the doodle to the border pane
    public void addDoodle(Doodle dood) {
        this.dood = dood;
        getChildren().add(dood);
    }

    // updates the x and y position of the doodle
    public void updateDoodlePosition(double doodX, double doodY) {
        dood.setLayoutX(doodX);
        dood.setLayoutY(doodY);
    }

    // adds a platform to the border pane
    public void addPlatform(Platform plat) {
        getChildren().add(plat);
    }

    // removes the platform from the border pane
    public void removePlatform(Platform plat) {
        getChildren().remove(plat);
    }

    // ads the game over text when the fail state is reached
    public void addGameOverPane() {
        StackPane gameOverPane = new StackPane();
        gameOverPane.setPrefSize(100, 100);
        Label gameOverLabel = new Label("Game Over");
        gameOverLabel.setStyle("-fx-font-size: 48px; -fx-text-fill: red;");
        gameOverPane.getChildren().add(gameOverLabel);
        setCenter(gameOverPane);
    }
}
