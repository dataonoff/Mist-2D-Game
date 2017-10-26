package game.gameObject;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

public abstract class GameObject {

    protected float x;
    protected float y;

    protected Animation animation;

    protected GameObject(Animation animation, float x, float y) {
        this.animation = animation;
        this.x = x;
        this.y = y;
    }

    public void init() {

    }

    public void draw(Graphics graphics) {
        graphics.drawAnimation(animation, x, y);
    }
}
