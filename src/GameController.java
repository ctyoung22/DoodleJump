import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class GameController {
    GameModel model;
    GameView view;
    Timeline doodLoc;
    Platform topPlatform;
    ArrayList<Platform> platforms = new ArrayList<>();

    
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        setQuitAction();
        view.getGamePane().addDoodle(model.getDoodle());
        doodLoc = new Timeline(new KeyFrame(Duration.millis(20), e -> setupDoodleMovement()));
        doodLoc.setCycleCount(Timeline.INDEFINITE);
        doodLoc.play();
        setupKeyControls();
    }

    public void setupDoodleMovement() {
        model.updatePosition(view.getWidth(), view.getGamePane().getHeight(),0);
        view.updateView(model.getDoodX(), model.getDoodY());
        updatePlatforms();
        if(model.scrollCheck(view.getGamePane().getHeight())) {
            model.scrollPlatforms(view.getGamePane().getHeight(), 0.5);
            updatePlatforms();
        }
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

    public void updatePlatforms() {
        platforms = model.getPlatforms();
        for(Platform plat : platforms) {
            if(!view.getGamePane().getChildren().contains(plat)) {
                view.renderPlatform(plat);
            }
            if(!model.getPlatforms().contains(plat)) {
                view.erasePlatform(plat);
            }
            if(plat.getRemoval()){
                view.erasePlatform(plat);
            }
        }
    }
}
