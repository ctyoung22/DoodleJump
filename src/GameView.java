// a view class for showing items to the game window
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class GameView extends BorderPane {
    GamePane jumpPane;
    Button quitBtn;
    Platform topPlatform;
    ArrayList<Platform> platforms = new ArrayList<>();
    ScorePane scorePane;
    
    // creates a game pane, hbox, and score pane adding them to the gameView
    public GameView() {
        jumpPane = new GamePane();
        jumpPane.setMinHeight(500);

        scorePane = new ScorePane();

        HBox menuPane = new HBox();
        quitBtn = new Button("Quit");
        menuPane.getChildren().add(quitBtn);
        menuPane.setAlignment(Pos.CENTER);
        menuPane.setPrefHeight(100);
        menuPane.setStyle("-fx-background-color: #c4c8cc");

        setTop(scorePane);
        setCenter(jumpPane);
        setBottom(menuPane);
    }

    // gets the quit button
    public Button getQuitBtn() {
        return this.quitBtn;
    }

    // updates the view with the doodles postition in the window
    public void updateView(double doodX, double doodY) {
        jumpPane.updateDoodlePosition(doodX, doodY);
    }

    // adds the platform for the view
    public void renderPlatform(Platform plat) {
        jumpPane.addPlatform(plat);
    }

    // removes the platfrom from the view
    public void erasePlatform(Platform plat) {
        jumpPane.removePlatform(plat);
    }

    // returns the game pane
    public GamePane getGamePane() {
        return this.jumpPane;
    }

    // updates the score label with the current score
    public void updateScore(int score){
        scorePane.updateLabel(score);
    }

    // shows the game over text when the fail state is achieved
    public void showGameOver() {
        jumpPane.addGameOverPane();
    }

}
