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
        setupDoodle();
        doodLoc = new Timeline(new KeyFrame(Duration.millis(20), e -> setupMovement()));
        doodLoc.setCycleCount(Timeline.INDEFINITE);
        doodLoc.play();
        setupKeyControls();
        setupPlatform();
    }

    public void setupMovement(){
        model.updatePosition(view.getWidth(), view.getHeight(),0);
        view.updateView(model.getDoodX(), model.getDoodY());
        handleIntersection();
    }

    public void setupKeyControls(){
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

    public void setupDoodle() {
        view.updateView(model.getDoodX(), model.getDoodY());
    }

    public void setupPlatform() {
        view.addPlatform();
    }

    public void handleIntersection() {
        boolean intersect = view.intersect();
        if(intersect){
            model.bounceDoodle();
            System.out.println("Bounce");
        }
    }
}
