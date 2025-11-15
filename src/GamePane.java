import javafx.scene.layout.BorderPane;

public class GamePane extends BorderPane{
    Doodle dood;

    public GamePane() {
        dood = new Doodle();
        getChildren().add(dood);
    }

    public void updateDoodlePosition(double doodX, double doodY) {
        dood.setLayoutX(doodX);
        dood.setLayoutY(doodY);
    }
    
}
