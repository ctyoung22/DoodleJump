// GameController object for controlling and keeping track of things changed in game
// and updated with every game frame
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class GameController {
    GameModel model;
    GameView view;
    Timeline doodLoc;
    Platform topPlatform;
    ArrayList<Platform> platforms = new ArrayList<>();

    // sets up what needs to tracked by the game controller
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        setQuitAction();
        view.getGamePane().addDoodle(model.getDoodle());
        doodLoc = new Timeline(new KeyFrame(Duration.millis(20), e -> setupDoodleMovement())); // the gametimeline for the game cycles
        doodLoc.setCycleCount(Timeline.INDEFINITE);
        doodLoc.play();
        setupKeyControls();
        trackScore();
    }

    // method for seting the doodles movements with updating the model and view
    // also updates the platforms and checks for the scrolling effect
    public void setupDoodleMovement() {
        model.updatePosition(view.getWidth(), view.getGamePane().getHeight(),0);
        view.updateView(model.getDoodX(), model.getDoodY());
        updatePlatforms();
        if(model.scrollCheck(view.getGamePane().getHeight())) {
            model.scrollPlatforms(view.getGamePane().getHeight(), 0.5);
            updatePlatforms();
        }
        // checks if the doodle falls above a pixel count ending the game
        if(model.checkEndState()) {
            endGame();
        }
    }

    // sets up the arrow keys for left and right movements, also updated with the timeline
    // to allow for holding down the button for faster movement
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

    // sets up the quit button at the bottom of the window
    public void setQuitAction() {
        view.getQuitBtn().setOnAction(e -> {
            System.exit(0);
        });
    }

    // updates the platforms while also checking for their special atributes
    // like scrolling platforms and disappearing platforms
    public void updatePlatforms() {
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

    // method for keeping track of the score at the top of the window, updated
    // when a platform reaches the bottom of the window and is removed
    public void trackScore(){
        IntegerProperty score = model.getScore();
        score.addListener(ov -> view.updateScore(score.getValue()));
    }

    // method called when the game fail state occures
    public void endGame() {
        doodLoc.stop();
        view.showGameOver();
    }
}
