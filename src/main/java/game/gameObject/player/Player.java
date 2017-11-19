package game.gameObject.player;

import game.collision.BorderCollision;
import game.collision.FloorCollision;
import game.collision.ScaleCollision;
import game.gameObject.GameObject;
import game.gravity.Gravity;
import graphics.animation.EAnimation;
import graphics.animation.ObjectAnimation;
import org.newdawn.slick.*;

public class Player extends GameObject {

    private float x = 0, y = 0;
    private boolean moving = false;
    private Actions actions;
    private BorderCollision borderCollision = new BorderCollision();
    private ScaleCollision scaleCollision = new ScaleCollision();
    private FloorCollision floorCollision = new FloorCollision();
    private Gravity gravity = new Gravity();
    private boolean goingRight = false;
    private boolean goingLeft = false;
    private boolean climbingUp = false;
    private boolean climbingDown = false;

    public Player(ObjectAnimation animation, float x, float y) throws SlickException {
        super(animation, x, y);
        this.x = x;
        this.y = y;
    }

    public void init() {
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

    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0, .5f));
        graphics.fillOval(x - 16, y - 8, 32, 16);
        this.objectAnimation.getCurrentAnimation().getCurrentFrame().getFlippedCopy(!this.objectAnimation.isLookRight(), false).draw(x - 32, y - 64);
    }


    public void update(int delta) {
        this.objectAnimation.getCurrentAnimation().update(delta);

        // manage X
        boolean borderCollisions = borderCollision.getCollision(this.nextX(delta), this.nextY(delta));
        if (borderCollisions) {
            this.moving = false;
        } else {
            this.x = nextX(delta);
        }

        // manage gravity
        boolean scaleDetected = scaleCollision.getCollision(this.x, this.y);
        if (!scaleDetected) {
            this.gravity.setGravityOn(true);
        } else if (scaleDetected && (climbingUp || climbingDown)) {
            this.gravity.setGravityOn(false);
        }

        // manage Y
        boolean useGravity = this.gravity.increment();
        float futurY = this.nextY(delta) + gravity.getGravity() * delta;
        boolean floorCollisions = floorCollision.getCollision(this.nextX(delta), futurY);
        if (!floorCollisions){
            this.y = futurY;
        }
        else {
            this.gravity.init();
        }

        // manage JUMP
        if (floorCollisions) {
            if (this.actions == Actions.LIFT_DOWN) {
                this.moving = false;
            }
            if (this.actions == Actions.SIMPLE_JUMP || this.actions == Actions.JUMP_RIGHT || this.actions == Actions.JUMP_LEFT) {
                this.actions = Actions.IDLE;
                if (!goingRight && !goingLeft) {
                    this.idle();
                }
                if (this.goingRight) {
                    this.walkRight();
                } else if (this.goingLeft) {
                    this.walkLeft();
                }
            }
        }

    }

    @Override
    public float nextX(int delta) {
        float x = this.x;
        if (this.moving) {
            switch (this.actions) {
                case WALK_RIGHT:
                    x += .2f * delta;
                    break;
                case WALK_LEFT:
                    x -= .2f * delta;
                    break;
                case JUMP_RIGHT:
                    x += .3f * delta;
                    break;
                case JUMP_LEFT:
                    x -= .3f * delta;
                    break;
            }
        }
        return x;
    }

    @Override
    public float nextY(int delta) {
        float y = this.y;
        if (this.moving) {
            switch (this.actions) {
                case SIMPLE_JUMP:
                    y -= .6f * delta;
                    break;
                case JUMP_RIGHT:
                    y -= .6f * delta;
                    break;
                case JUMP_LEFT:
                    y -= .6f * delta;
                    break;
                case LIFT_UP:
                    y -= .2f * delta;
                    break;
                case LIFT_DOWN:
                    y += .2f * delta;
                    break;
            }
        }
        return y;
    }

    public void walkRight() {
        this.objectAnimation.setCurrent(EAnimation.MOVE_WALK);
        this.setActions(Actions.WALK_RIGHT);
        this.moving = true;
        this.goingLeft = false;
        this.goingRight = true;

    }


    public void walkLeft() {
        this.objectAnimation.setCurrent(EAnimation.MOVE_WALK);
        this.setActions(Actions.WALK_LEFT);
        this.moving = true;
        this.goingRight = false;
        this.goingLeft = true;
    }

    public void climUp() {
        this.climbingUp = true;
        this.climbingDown = false;
        this.objectAnimation.setCurrent(EAnimation.MOVE_WALK);
        this.setActions(Actions.LIFT_UP);
        this.moving = true;
    }

    public void climDown() {
        this.climbingDown = true;
        this.climbingUp = false;
        this.objectAnimation.setCurrent(EAnimation.MOVE_WALK);
        this.setActions(Actions.LIFT_DOWN);
        this.moving = true;
    }

    public void jump() {
        if (!this.goingLeft && !this.goingRight) {
            this.objectAnimation.setCurrent(EAnimation.IDLE);
            this.setActions(Actions.SIMPLE_JUMP);
            this.moving = true;
        } else if (goingRight) {
            this.objectAnimation.setCurrent(EAnimation.IDLE);
            this.setActions(Actions.JUMP_RIGHT);
            this.moving = true;
        } else {
            this.objectAnimation.setCurrent(EAnimation.IDLE);
            this.setActions(Actions.JUMP_LEFT);
            this.moving = true;
        }
        this.gravity.init();

    }

    public void idle() {
        if (this.actions != Actions.SIMPLE_JUMP && this.actions != Actions.JUMP_RIGHT && this.actions != Actions.JUMP_LEFT) {
            //System.out.println("goingright: "+ goingRight);
            //System.out.println("goingleft: "+ goingLeft);
            if (goingRight && !goingLeft) {
                this.walkRight();
            } else if (goingLeft && !goingRight) {
                this.walkLeft();
            } else {
                this.objectAnimation.setCurrent(EAnimation.IDLE);
                this.actions = Actions.IDLE;
                this.moving = false;
            }
        }

    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
        this.objectAnimation.setLookRight(this.actions == Actions.WALK_RIGHT);
    }

    public void setGoingRight(boolean goingRight) {
        this.goingRight = goingRight;
    }

    public void setGoingLeft(boolean goingLeft) {
        this.goingLeft = goingLeft;
    }
}
