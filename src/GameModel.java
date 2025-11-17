import java.util.ArrayList;

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
    Doodle dood;
    Platform basePlat;
    Platform topPlat;
    ArrayList<Platform> platforms = new ArrayList<>();

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
    }

    // For moving doodle with arrow keys
    // if statements are for wrap around
    public void moveDoodle(double viewWidth, double viewHeight, int direction) {

        for(Platform plat : platforms) {
            if(dood.getBoundsInParent().intersects(plat.getBoundsInParent()) && velocity > 0) {
                velocity = reboundVel;
            }
            /* if(doodY + 30 >= plat.getPlatY() && (doodX + 20 >= plat.getPlatX() && doodX <= plat.getPlatX() + 40)) {
                
            } */
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

    public void generatePlatforms() {
        topPlat = platforms.get(platforms.size() - 1);
        while(getTopPlatY() < 500 && getTopPlatY() > 0) {
            double lowX = Math.max(0, getTopPlatX() - 100);
            double highX = Math.min(400, getTopPlatX() + 100);
            double newPlatX = Math.random() * (highX - lowX) + lowX;

            double lowY = getTopPlatY() - 20;
            double highY = getTopPlatY() - 100;
            double newPlatY = Math.random() * (highY - lowY) + lowY;

            topPlat = new RegularPlatform(newPlatX, newPlatY);
            topPlatX = newPlatX;
            topPlatY = newPlatY;
            platforms.add(topPlat);
        }
    }
}
