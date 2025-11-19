// A game model class file for keeping track of different vaiables and properties
// of different items

import java.util.ArrayList;
import java.util.Iterator;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class GameModel {
    double doodX = 200;
    double doodY = 300;
    double basePlatX = 200;
    double basePlatY = 350;
    double topPlatX = 200;
    double topPlatY = 350;
    int doodDX = 1;
    int doodDY = 1;
    double gravity = 100;
    double duration = 0.015;
    double velocity = 0;
    double reboundVel = -200;
    boolean endState = false;
    Doodle dood;
    Platform basePlat;
    Platform topPlat;
    private ArrayList<Platform> platforms = new ArrayList<>();
    private IntegerProperty score = new SimpleIntegerProperty(0);

    public GameModel() {
        dood = new Doodle(doodX, doodY);
        basePlat = new RegularPlatform(basePlatX, basePlatY);
        platforms.add(basePlat);
    }

    public double getDoodX() {
        return doodX;
    }

    public double getDoodY() {
        return doodY;
    }

    public Doodle getDoodle() {
        return dood;
    }
    
    public double getTopPlatX() {
        return topPlatX;
    }

    public double getTopPlatY() {
        return topPlatY;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    // updates the position position of the doodle while also generating new platforms
    // when the doodle continues to climb higher, also remove platforms that drop too low
    public void updatePosition(double viewWidth, double viewHeight, int direction){
        moveDoodle(viewWidth, viewHeight, direction);
        generatePlatforms();
        removePlatforms(viewHeight);
    }

    // For moving doodle with arrow keys
    // if statements are for wrap around
    public void moveDoodle(double viewWidth, double viewHeight, int direction) {

        for(Platform plat : platforms) {
            if(dood.getBoundsInParent().intersects(plat.getBoundsInParent()) && velocity > 0) {
                velocity = reboundVel * plat.getBounceMulti();
                if(plat instanceof DisappearingPlatform) {
                    ((DisappearingPlatform) plat).markForRemoval(); 
                }
            }
        }

        // the calculation for the doodle gravity
        velocity = velocity + gravity * duration;
        doodY = doodY + velocity * duration;

        doodX = doodX + direction;
        if(doodX < -5){
            doodX = viewWidth - 15;
        }
        if(doodX > viewWidth - 15){
            doodX = 0;
        }
    }

    // generates platforms based on random x and y positions and also 
    // generates random platforms
    public void generatePlatforms() {
        topPlat = platforms.get(platforms.size() - 1);
        while(getTopPlatY() < 500 && getTopPlatY() > - 100) {
            double lowX = Math.max(0, getTopPlatX() - 100);
            double highX = Math.min(360, getTopPlatX() + 100);
            double newPlatX = Math.random() * (highX - lowX) + lowX;

            double lowY = getTopPlatY() - 20;
            double highY = getTopPlatY() - 100;
            double newPlatY = Math.random() * (highY - lowY) + lowY;

            topPlat = getRandoPlat(newPlatX, newPlatY);
            topPlatX = newPlatX;
            topPlatY = newPlatY;
            platforms.add(topPlat);
        }
    }

    // removes platforms that fall below the window, and sets the
    // random platform y generation so that new platforms can be created
    // as they get removed
    public void removePlatforms(double viewHeight) {
        Iterator<Platform> iter = platforms.iterator();
        while(iter.hasNext()) {
            Platform plat = iter.next();
            if(plat.getPlatY() > viewHeight) {
                iter.remove();
                score.setValue(score.getValue() + 1);
                if(platforms.size() < 10){
                    topPlatY = 0;
                }
            }
        }
    }

    // checks if the doodle is at half of the window height
    // allowing for scrolling
    public boolean scrollCheck(double viewHeight) {
        if(doodY < viewHeight/2){
            return true;
        }
        return false;
    }

    // scrolls the platforms when the doodle is at the halfway point of the window
    public void scrollPlatforms(double viewHeight, double scrollAmount) {
        while(doodY < viewHeight/2) {
            for(Platform plat : platforms) {
                plat.setLayoutY(plat.getLayoutY() + scrollAmount);
                plat.platY += scrollAmount;
            }
            doodY += scrollAmount;
        }
    }

    // randomly generates a number and then generates a platform with
    // an atribute based on the random number
    public Platform getRandoPlat(double platX, double platY){
        int randoNum = (int)(Math.random()*(6)+1);
        Platform randoPlat;
        if(randoNum > 3){
            randoPlat = new RegularPlatform(platX, platY);
        }
        else if(randoNum == 2){
            randoPlat = new ScrollingPlatform(platX, platY);
        }
        else if(randoNum == 3){
            randoPlat = new DisappearingPlatform(platX, platY);
        }
        else{
            randoPlat = new BouncyPlatform(platX, platY);
        }
        return randoPlat;
    }

    // returns the score counter
    public IntegerProperty getScore(){
        return score;
    }

    // checks if the doodle falls beyond the fail state threshold
    public boolean checkEndState() {
        if(doodY > 600) {
            endState = true;
        }
        return endState;
    }

}
