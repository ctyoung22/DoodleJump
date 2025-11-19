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

    public Button getQuitBtn() {
        return this.quitBtn;
    }

    public void updateView(double doodX, double doodY) {
        jumpPane.updateDoodlePosition(doodX, doodY);
    }

    public void renderPlatform(Platform plat) {
        jumpPane.addPlatform(plat);
    }

    public void erasePlatform(Platform plat) {
        jumpPane.removePlatform(plat);
    }

    public GamePane getGamePane() {
        return this.jumpPane;
    }

    public void updateScore(int score){
        scorePane.updateLabel(score);
    }

    public void showGameOver() {
        jumpPane.addGameOverPane();
    }

}
