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
        Label scoreLabel = new Label("Total Score: 0");
        jumpPane.setTop(scoreLabel);

        HBox menuPane = new HBox();
        quitBtn = new Button("Quit");
        menuPane.getChildren().add(quitBtn);
        menuPane.setAlignment(Pos.CENTER);
        menuPane.setPrefHeight(100);
        menuPane.setStyle("-fx-background-color: #c4c8cc");

        setCenter(jumpPane);
        setBottom(menuPane);
    }

    public Button getQuitBtn() {
        return this.quitBtn;
    }

    public void updateView(double doodX, double doodY) {
        jumpPane.updateDoodlePosition(doodX, doodY);
    }

}
