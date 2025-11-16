import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class GameController {
    GameModel model;
    GameView view;
    Timeline doodLoc;

    
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        setQuitAction();
        setupPlatform();
        doodLoc = new Timeline(new KeyFrame(Duration.millis(20), e -> setupDoodleMovement()));
        doodLoc.setCycleCount(Timeline.INDEFINITE);
        doodLoc.play();
        setupKeyControls();
        
    }

    public void setupDoodleMovement() {
        model.updatePosition(view.getWidth(), view.getHeight(),0);
        view.updateView(model.getDoodX(), model.getDoodY());
    }

    public void setupKeyControls() {
        view.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.LEFT){
                model.updatePosition(view.getWidth(), view.getHeight(), -5);
            }
            else if(e.getCode() == KeyCode.RIGHT){
                model.updatePosition(view.getWidth(), view.getHeight(), 5);
            }
        });
    }

    public void setQuitAction() {
        view.getQuitBtn().setOnAction(e -> {
            System.exit(0);
        });
    }

    public void setupPlatform() {
        model.addBasePlatform();
        view.updatePlatform(model.getTopPlatX(), model.getTopPlatY());
        while(model.getTopPlatY() < 500 && model.getTopPlatY() > 0) {
            model.updateTopPlatform();
            view.updatePlatform(model.getTopPlatX(), model.getTopPlatY());
        }
    }
}
