package game.backGroundObject;

import graphics.animation.EAnimation;
import graphics.animation.ObjectAnimation;
import org.newdawn.slick.Graphics;

public class Bird {

    private float x = 0, y = 0;
    private ObjectAnimation animation;
    private boolean flyOnRight = true;
    private boolean flyOnLeft = false;

    public Bird(ObjectAnimation animation, float x, float y) {
        this.animation = animation;
        this.x = x;
        this.y = y;
    }

    public Bird() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void draw(Graphics graphics) {
        this.animation.getCurrentAnimation().getCurrentFrame().getFlippedCopy(flyOnRight, false).draw(x - 32, y - 64);
    }

    public void update(int delta){
        this.animation.setCurrent(EAnimation.FLY);
        this.animation.getCurrentAnimation().update(delta);

        int min = -50;
        int max = 1700;

        if(this.x < min){

            this.flyOnRight = true;
            this.flyOnLeft = false;
        }
        else if(this.x > max){
            this.flyOnRight = false;
            this.flyOnLeft = true;
        }

        if(flyOnRight){
            this.x += .1f * delta;
        }
        else if(flyOnLeft){
            this.x -= .1f * delta;
        }
    }

}

