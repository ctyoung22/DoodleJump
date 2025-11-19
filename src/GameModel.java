import java.util.ArrayList;
import java.util.Iterator;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class GameModel {
    private double doodX = 200;
    private double doodY = 300;
    private double basePlatX = 200;
    private double basePlatY = 350;
    private double topPlatX = 200;
    private double topPlatY = 350;
    private double gravity = 100;
    private double duration = 0.015;
    private double velocity = 0;
    private double reboundVel = -200;
    private boolean endState = false;
    private Doodle dood;
    private Platform basePlat;
    private Platform topPlat;
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

    public void updatePosition(double viewWidth, double viewHeight, int direction){
        moveDoodle(viewWidth, viewHeight, direction);
        generatePlatforms();
        removePlatforms(viewHeight);
    }

    // For moving doodle with arrow keys
    // if statements are for wrap around
    private void moveDoodle(double viewWidth, double viewHeight, int direction) {

        for(Platform plat : platforms) {
            if(dood.getBoundsInParent().intersects(plat.getBoundsInParent()) && velocity > 0 && doodY + dood.getHeight() <= plat.getPlatY() + plat.getHeight()) {
                velocity = reboundVel * plat.getBounceMulti();
                if(plat instanceof DisappearingPlatform) {
                    ((DisappearingPlatform) plat).markForRemoval(); 
                }
            }
        }

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

    private void generatePlatforms() {
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

    private void removePlatforms(double viewHeight) {
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

    public boolean scrollCheck(double viewHeight) {
        if(doodY < viewHeight/2){
            return true;
        }
        return false;
    }

    public void scrollPlatforms(double viewHeight, double scrollAmount) {
        while(doodY < viewHeight/2) {
            for(Platform plat : platforms) {
                plat.setLayoutY(plat.getLayoutY() + scrollAmount);
                plat.setPlatY(plat.getPlatY() + scrollAmount);
            }
            doodY += scrollAmount;
        }
    }

    private Platform getRandoPlat(double platX, double platY){
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

    public IntegerProperty getScore(){
        return score;
    }

    public boolean checkEndState() {
        if(doodY > 600) {
            endState = true;
        }
        return endState;
    }

}
