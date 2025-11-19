import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class GameController {
    private GameModel model;
    private GameView view;
    private Timeline doodLoc;
    private ArrayList<Platform> platforms = new ArrayList<>();
    
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        setQuitAction();
        view.getGamePane().addDoodle(model.getDoodle());
        doodLoc = new Timeline(new KeyFrame(Duration.millis(20), e -> setupDoodleMovement()));
        doodLoc.setCycleCount(Timeline.INDEFINITE);
        doodLoc.play();
        setupKeyControls();
        trackScore();
    }

    private void setupDoodleMovement() {
        model.updatePosition(view.getWidth(), view.getGamePane().getHeight(),0);
        view.updateView(model.getDoodX(), model.getDoodY());
        updatePlatforms();
        if(model.scrollCheck(view.getGamePane().getHeight())) {
            model.scrollPlatforms(view.getGamePane().getHeight(), 0.5);
            updatePlatforms();
        }
        if(model.checkEndState()) {
            endGame();
        }
    }

    private void setupKeyControls() {
        view.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.LEFT){
                model.updatePosition(view.getWidth(), view.getHeight(), -5);
            }
            else if(e.getCode() == KeyCode.RIGHT){
                model.updatePosition(view.getWidth(), view.getHeight(), 5);
            }
        });
    }

    private void setQuitAction() {
        view.getQuitBtn().setOnAction(e -> {
            System.exit(0);
        });
    }

    private void updatePlatforms() {
        platforms = model.getPlatforms();
        for(Platform plat : platforms) {
            if(!view.getGamePane().getChildren().contains(plat)) {
                view.renderPlatform(plat);
            }
            if(!model.getPlatforms().contains(plat)) {
                view.erasePlatform(plat);
            }
            if(plat instanceof IScrollable){
                ((IScrollable) plat).scrollPlat(0-plat.getPlatX(), 360-plat.getPlatX());
                plat.setLayoutX(((IScrollable) plat).getUpdatedX());
            }
            if(plat instanceof DisappearingPlatform){
                if(((DisappearingPlatform) plat).getRemove()){
                    view.erasePlatform(plat);
                }
            }
        }
    }

    private void trackScore(){
        IntegerProperty score = model.getScore();
        score.addListener(ov -> view.updateScore(score.getValue()));
    }

    private void endGame() {
        doodLoc.stop();
        view.showGameOver();
    }
}
