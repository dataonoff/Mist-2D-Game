package game.gameObject.monster;

import game.collision.FloorCollision;
import game.gameObject.GameObject;
import game.gameObject.player.Actions;
import game.gravity.Gravity;
import graphics.animation.EAnimation;
import graphics.animation.ObjectAnimation;
import org.newdawn.slick.Graphics;

public class Raccoon extends GameObject {

    private float x = 0, y = 0;
    private Actions actions;
    private boolean moving = true;
    private boolean goingRight = true;
    private boolean goingLeft = false;
    private Gravity gravity = new Gravity();
    private FloorCollision floorCollision = new FloorCollision();

    public Raccoon(ObjectAnimation animation, float x, float y) {
        super(animation, x, y);
        this.x = x;
        this.y = y;
    }


    @Override
    public void draw(Graphics graphics) {
        this.objectAnimation.getCurrentAnimation().getCurrentFrame().getFlippedCopy(goingLeft,false).draw(x-32,y-64);
    }

    @Override
    public void update(int delta) {
        this.objectAnimation.setCurrent(EAnimation.MOVE_WALK);
        this.objectAnimation.getCurrentAnimation().update(delta);

        //manage Y
        gravity.setGravityOn(true);
        boolean useGravity = gravity.increment();
        if(useGravity){
            this.actions = Actions.FALLING;
        }

        float futurY = this.nextY(delta) + gravity.getGravity() * delta;
        boolean floorDetected = floorCollision.getCollision(nextX(delta),futurY);
        if (!floorDetected)
            this.y = futurY;
        else {
            this.gravity.setGravityOn(false);
            this.gravity.init();
        }

        int min = 300;
        int max = 1400;

        if (this.x < min){
            goingRight = true;
            goingLeft = false;
        }
        else if(this.x > max){
            goingLeft = true;
            goingRight = false;
        }
        if (goingRight){
            this.x +=.2f * delta;
        }
        else if(goingLeft){
            this.x -=.2f * delta;
        }
    }

    @Override
    public float nextX(int delta) {
        float x = this.x;
        if(this.moving){
            switch (this.actions){
                case WALK_RIGHT:
                    x += .2f * delta;
                    break;
                case WALK_LEFT:
                    x -=.2f * delta;
                    /*
                case ATTACK:
                    x = x * delta;
                    */
            }
        }
        return x;
    }

    @Override
    public float nextY(int delta) {
        float y = this.y;
        if (this.moving) {
            switch (this.actions) {
                case FALLING:
                    y +=.2f * delta;
                    break;
            }
        }
        return y;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }
}
