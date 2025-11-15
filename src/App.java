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
        GameModel model = new GameModel();
        GameView view = new GameView();
        GameController controller = new GameController(model, view);

        Scene mainScene = new Scene(view, 400, 600);
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}
