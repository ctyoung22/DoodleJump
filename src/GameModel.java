import java.util.ArrayList;

public class GameModel {
    double doodX = 200;
    double doodY = 300;
    double topPlatX = 200;
    double topPlatY = 350;
    int doodDX = 1;
    int doodDY = 1;
    double gravity = 100;
    double duration = 0.015;
    double velocity = 0;
    double reboundVel = -200;
    ArrayList<Platform> platforms = new ArrayList<>();


    public double getDoodX() {
        return doodX;
    }

    public double getDoodY() {
        return doodY;
    }
    
    public double getTopPlatX() {
        return topPlatX;
    }

    public double getTopPlatY() {
        return topPlatY;
    }

    public void updatePosition(double viewWidth, double viewHeight, int direction){
        moveDoodle(viewWidth, viewHeight, direction);
    }

    // For moving doodle with arrow keys
    // if statements are for wrap around
    public void moveDoodle(double viewWidth, double viewHeight, int direction) {

        for(Platform plat : platforms) {
            if(doodY + 30 >= plat.getLayoutY() && (doodX >= plat.getLayoutX() && doodX <= plat.getLayoutX() + 40)) {
                velocity = reboundVel;
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
    /*
    // this is for part 11, got a little ahead of myself
    public double doodleCheck(double velocity, double viewHeight){
        double doodleMidHight;
        if(doodY > viewHeight/2){
            doodleMidHight = viewHeight/2 - doodY;
            doodY = doodleMidHight;
        }
    }*/

    public void addBasePlatform() {
        Platform basePlat = new RegularPlatform(topPlatX, topPlatY);
        platforms.add(basePlat);
    }

    public void updateTopPlatform() {
        double lowX = Math.max(0, topPlatX - 100);
        double highX = Math.min(400, topPlatX + 100);
        topPlatX = Math.random() * (highX - lowX) + lowX;

        double lowY = topPlatY - 20;
        double highY = topPlatY - 100;
        topPlatY = Math.random() * (highY - lowY) + lowY;

        Platform plat = new RegularPlatform(topPlatX, topPlatY);
        platforms.add(plat);
    }

}
