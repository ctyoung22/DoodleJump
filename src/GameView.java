import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class GameView extends BorderPane {
    GamePane jumpPane;
    Button quitBtn;

    public GameView() {
        jumpPane = new GamePane();

        HBox scorePane = new HBox();
        Label scoreLabel = new Label("Total Score: 0");
        scorePane.getChildren().add(scoreLabel);

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

    // adds 10 random platforms for testing
    public void addPlatform(){
        for(int i = 0; i < 10; i++){
            double platX = Math.random() * (400 + 1);
            double platY = Math.random() * (500 + 1);
            jumpPane.updatePlatformPostition(platX, platY);
        }
    }

    public boolean intersect(){
        return jumpPane.intersection();
    }

}
