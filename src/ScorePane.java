import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ScorePane extends HBox{
    Label scoreLabel;

    public ScorePane() {
        scoreLabel = new Label("Total Score: 0");
        getChildren().add(scoreLabel);
    }

    public Label getScore(){
        return scoreLabel;
    }

    public void updateLabel(int score){
        scoreLabel.setText("Total Score: " + score);
    }
}
