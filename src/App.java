import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application{

    public void start(Stage primaryStage) {
        

        BorderPane gamePane = new BorderPane();
        BorderPane jumpPane = new BorderPane();
        Label scoreLabel = new Label("Total Score: 0");
        jumpPane.setTop(scoreLabel);

        HBox menuPane = new HBox();
        Button quitBtn = new Button("Quit");
        quitBtn.setOnAction(e -> {
            System.exit(0);
        });
        menuPane.getChildren().add(quitBtn);
        menuPane.setAlignment(Pos.CENTER);
        menuPane.setPrefHeight(100);
        menuPane.setStyle("-fx-background-color: #c4c8cc");

        gamePane.setCenter(jumpPane);
        gamePane.setBottom(menuPane);

        Scene mainScene = new Scene(gamePane, 400, 600);
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}
