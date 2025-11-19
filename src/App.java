/* Name: Josh Weeks, Your Name
 * Class: CSCI-3331-002
 * 11/15/2025
 * Project: Doodle Jump Game
 * Discription: An app class for starting the doodle jump game
 */

import javafx.application.Application;
import javafx.scene.Scene;
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

        view.requestFocus();
    }

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}
