import javafx.scene.layout.BorderPane;

public class GamePane extends BorderPane{
    Doodle dood;

    public GamePane() {
        dood = new Doodle();
    }

    public void updateDoodlePosition(double doodX, double doodY) {
        dood.setLayoutX(doodX);
        dood.setLayoutY(doodY);
    }
    
}
