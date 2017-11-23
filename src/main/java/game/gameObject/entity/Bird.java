package game.gameObject.entity;

import game.gameObject.GameObject;
import graphics.animation.ObjectAnimation;
import org.newdawn.slick.Graphics;

public class Bird extends GameObject{

    private float x = 0, y = 0;
    private boolean flyOnRight = true;
    private boolean flyOnLeft = false;

    public Bird(ObjectAnimation animation, float x, float y) {
        super(animation,x,y);
        this.x = x;
        this.y = y;
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

    @Override
    public void draw(Graphics graphics) {
        this.objectAnimation.getCurrentAnimation().getCurrentFrame().getFlippedCopy(flyOnRight, false).draw(x - 32, y - 64);
    }

    @Override
    public void update(int delta){
        this.objectAnimation.getCurrentAnimation().update(delta);

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

