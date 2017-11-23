package game.gravity;

import game.collision.FloorCollision;
import game.gameObject.GameObject;
import game.gameObject.player.Player;

public class Gravity {

    private float gravity = 0;
    private boolean gravityOn = true;

    public Gravity() {
    }

    public boolean increment() {

        if (!this.gravityOn) {
            init();
            return false;
        } else {
            gravity += .8f;
            return true;
        }
    }

    public void init(){
        this.gravity = 0;
    }

    public boolean isGravityOn() {
        return gravityOn;
    }

    public void setGravityOn(boolean gravityOn) {
        this.gravityOn = gravityOn;
    }

    public float getGravity() {
        return this.gravity;
    }
}
