public class GameModel {
    double doodX = 200;
    double doodY = 30;
    int doodDX = 1;
    int doodDY = 1;
    double gravity = 100;
    double duration = 0.015;
    double velocity = 0;
    double reboundVel = -200;
    
    public double getDoodX() {
        return this.doodX;
    }

    public double getDoodY() {
        return this.doodY;
    }

    public void updatePosition(double viewWidth, double viewHeight, int direction){
        doodleGravity(viewWidth, viewHeight);
        moveDoodle(viewWidth, direction);
    }
    
    // gravity calculations
    public void doodleGravity(double viewWidth, double viewHeight){
        velocity = velocity + gravity * duration;
        doodY = doodY + velocity * duration;
    }

    // For moving doodle with arrow keys
    // if statements are for wrap around
    public void moveDoodle(double viewWidth, int direction){
        doodX = doodX + direction;
        if(doodX < -5){
            doodX = viewWidth - 15;
        }
        if(doodX > viewWidth - 15){
            doodX = 0;
        }
    }

    public void bounceDoodle(){
        velocity = reboundVel;
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

}
