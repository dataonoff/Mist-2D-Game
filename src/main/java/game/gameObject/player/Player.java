package game.gameObject.player;

import game.gameObject.GameObject;
import game.gameObject.PlayerAnimation;
import org.newdawn.slick.*;

public class Player extends GameObject {

    private PlayerAnimation playerAnimation;
    private int z;

    public Player(Animation animation, float x, float y) throws SlickException {
        super(animation, x, y);
        this.playerAnimation.getAnimations()[z] = animation;
    }

    public void init() {

    }

    public void draw(Graphics graphics) {
        graphics.drawAnimation(this.playerAnimation.getAnimations()[z], x, y);
    }


}
