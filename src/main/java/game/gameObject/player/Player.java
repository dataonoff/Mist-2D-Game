package game.gameObject.player;

import game.gameObject.GameObject;
import graphics.animation.EAnimation;
import graphics.animation.ObjectAnimation;
import org.newdawn.slick.*;

public class Player extends GameObject {

    private int direction = 1;
    private float x = 300, y = 520;
    private boolean moving = false;


    public Player(ObjectAnimation animation, float x, float y) throws SlickException {
        super(animation, x, y);
        this.x= x;
        this.y=y;
    }

    public void init() {

    }

    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0, .5f));
        graphics.fillOval(x - 16, y - 8, 32, 16);
        this.objectAnimation.getCurrentAnimation().getCurrentFrame().getFlippedCopy(!this.objectAnimation.isLookRight(), false).draw(x-32, y-60);
    }

    public void update(int delta){
        this.objectAnimation.getCurrentAnimation().update(delta);
        if (this.moving) {
            switch (this.direction) {
                //case 0:
                //    this.y -= .1f;
                //    break;
                //case 1:
                //    this.x -= .1f;
                //    break;
                case 0:
                    this.x += .8f;
                    //this.camera.setX(x);
                    break;
                case 1:
                    this.x -= .8f;
                    //this.camera.setX(x);
                    break;
            }
        }
    }

    public void walkRight(){
        this.objectAnimation.setCurrent(EAnimation.MOVE_WALK);
        this.setDirection(0);
        this.moving = true;
    }

    public void walkLeft(){
        this.objectAnimation.setCurrent(EAnimation.MOVE_WALK);
        this.setDirection(1);
        this.moving = true;
    }

    public void idle(){
        this.objectAnimation.setCurrent(EAnimation.IDLE);
        this.moving = false;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int z) {
        this.direction = z;
        this.objectAnimation.setLookRight(this.direction == 0);
    }
}
