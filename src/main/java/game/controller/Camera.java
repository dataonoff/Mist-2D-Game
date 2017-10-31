package game.controller;

import game.gameObject.player.Player;
import org.newdawn.slick.GameContainer;

public class Camera {

    private float x;
    private float y;

    public Camera() {
this.x = 0;
this.y = 0;
    }

    public void update(GameContainer container, Player player){
        int w = container.getWidth() / 4;
        float x = player.getX();
        float y = player.getY();
        //System.out.println("position player: " + this.x);
        //System.out.println("position camera: " + (this.camera.getX() + w));
        if (x > this.x + w) {
            this.x = (x - w);
        } else if (x < this.x - w) {
            this.x = (x + w);
        }
        int h = container.getHeight() / 4;
        if (y > this.y + h) {
            this.y = (y - h);
        } else if (y < this.y - h) {
            this.y = (y + h);
        }
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
