package game.gameObject;

import game.gameObject.player.Actions;
import graphics.animation.ObjectAnimation;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected ObjectAnimation objectAnimation;
    private boolean moving = false;
    private Actions actions;

    protected GameObject(ObjectAnimation animation, float x, float y) {
        this.objectAnimation = animation;
        this.x = x;
        this.y = y;
    }

    public void init() {

    }

    public void draw(Graphics graphics) {
    }

    public void update(int delta){

    }

    public float nextX(int delta){
        return x;
    }

    public float nextY(int delta){
        return y;
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

}
