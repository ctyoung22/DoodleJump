// a pane for keeping track of the game score
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ScorePane extends HBox{
    Label scoreLabel;

    // sets the initial game score
    public ScorePane() {
        scoreLabel = new Label("Total Score: 0");
        getChildren().add(scoreLabel);
    }

    // gets the score label
    public Label getScore(){
        return scoreLabel;
    }

    // updates the score label
    public void updateLabel(int score){
        scoreLabel.setText("Total Score: " + score);
    }
}
