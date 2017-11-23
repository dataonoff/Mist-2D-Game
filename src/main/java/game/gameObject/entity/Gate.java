package game.gameObject.entity;

import game.gameObject.GameObject;
import graphics.animation.ObjectAnimation;
import org.newdawn.slick.Graphics;

public class Gate extends GameObject{

    private float x = 0, y = 0;

    public Gate(ObjectAnimation animation, float x, float y) {
        super(animation, x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics graphics){
        this.objectAnimation.getCurrentAnimation().getCurrentFrame().getFlippedCopy(false,false).draw(x,y);

    }

    @Override
    public void update(int delta){
        this.objectAnimation.getCurrentAnimation().update(delta);
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
