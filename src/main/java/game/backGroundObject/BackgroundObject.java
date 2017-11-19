package game.backGroundObject;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class BackgroundObject {

    protected float x;
    protected float y;
    protected Image image;
    protected EBackgroundObject type;

    protected BackgroundObject(float x, float y, EBackgroundObject type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics graphics) { }

    public void update(GameContainer gameContainer, int delta){ }

    public float nextX(int delta){
        return x;
    }

    public float nextY(int delta){ return y; }

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

