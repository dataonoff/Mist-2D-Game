package game.gameObject.player;

import game.collision.BorderCollision;
import game.collision.FloorCollision;
import game.collision.ScaleCollision;
import game.gameObject.EGameObject;
import game.gameObject.GameObject;
import game.gameObject.GameObjectManager;
import game.gravity.Gravity;
import game.universe.worldmanager.EWorld;
import graphics.animation.EAnimation;
import graphics.animation.ObjectAnimation;
import graphics.map.EMap;
import graphics.map.MapFactory;
import javafx.util.Pair;
import music.ESound;
import music.SoundManager;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;


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
    private boolean liftingUp = false;
    private boolean liftingDown = false;
    private int dobleJump = 0;
     private EMap newMap = EMap.MAP1;


    public Player(ObjectAnimation animation, float x, float y) throws SlickException {
        super(animation, x, y);
        this.x = x;
        this.y = y;
        this.actions = Actions.IDLE;
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

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(new Color(0, 0, 0, .5f));
        graphics.fillOval(x - 16, y - 8, 32, 16);
        this.objectAnimation.getCurrentAnimation().getCurrentFrame().getFlippedCopy(!this.objectAnimation.isLookRight(), false).draw(x - 32, y - 64);
    }

    @Override
    public void update(int delta) {
        this.objectAnimation.getCurrentAnimation().update(delta);


        //Gate
        boolean gate = GameObjectManager.getInstance().getGameObjectsHashMap().get(EGameObject.GATE).GetCollision(x,y);
        if(gate){
            SoundManager.getInstance().getSoundHashMap().get(ESound.TELEPORT).play();
            this.setChanged();
            this.notifyObservers(new Pair<String, EWorld>("redirect", EWorld.BLACK_WORLD));

            //x = 100;
            //y = 128;
            /*
            try {
                this.map = new TiledMap("map/desert.tmx");
            } catch (SlickException e) {
                e.printStackTrace();
            }
            */
        }

        // manage X
        boolean borderCollisions = borderCollision.getCollision(this.nextX(delta), this.nextY(delta));
        boolean floorDetected = floorCollision.getCollision(this.nextX(delta), this.nextY(delta));
        if (borderCollisions) {
            this.moving = false;
        } else {
            this.x = nextX(delta);
        }


        // manage gravity
        boolean scaleDetected = scaleCollision.getCollision(this.x, this.y);
        if (!scaleDetected || this.actions == Actions.SIMPLE_JUMP) {
            this.gravity.setGravityOn(true);
        } else if ((liftingUp || liftingDown)) {

            this.gravity.setGravityOn(false);
        }

        //Stop GravityOFF at the end of the scale
        if(liftingUp && !scaleDetected){
            this.actions = Actions.IDLE;
            this.idle();
        }

        // manage Y
        boolean useGravity = this.gravity.increment();
        float futurY = this.nextY(delta) + gravity.getGravity() * delta / 20;
        boolean floorCollisions = floorCollision.getCollision(this.nextX(delta), futurY);
        if (!floorCollisions) {
            this.y = futurY;
        }
        else {
            this.gravity.init();
        }

        //manage dobleJump
        if(floorCollisions && dobleJump == 2){
            dobleJump = 0;
        }

        // manage JUMP
        // avoid jump when falling
        if(!floorCollisions && dobleJump == 0){
            dobleJump = 2;
        }
        //avoid endless bouncing
        if (floorCollisions) {
        if (this.actions == Actions.SIMPLE_JUMP || this.actions == Actions.JUMP_RIGHT || this.actions == Actions.JUMP_LEFT || this.actions == Actions.LIFT_UP || this.actions == Actions.LIFT_DOWN) {
            this.actions = Actions.IDLE;
            this.idle();
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
                    y -= .6f * delta;
                    break;
                case LIFT_DOWN:
                    y += .6f * delta;
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
            this.liftingUp = false;
            this.liftingDown = true;
    }


    public void walkLeft() {
            this.objectAnimation.setCurrent(EAnimation.MOVE_WALK);
            this.setActions(Actions.WALK_LEFT);
            this.moving = true;
            this.goingRight = false;
            this.goingLeft = true;
            this.liftingUp = false;
            this.liftingDown = true;
    }

    public void liftUp() {
        boolean scaleDetector = scaleCollision.getCollision(this.x, this.y);
        if(!scaleDetector){
            this.moving = false;
            this.liftingUp = false;
        }
        else {
            this.objectAnimation.setCurrent(EAnimation.IDLE);
            this.liftingUp = true;
            this.liftingDown = false;
            this.setActions(Actions.LIFT_UP);
            this.moving = true;
        }
    }

    public void liftDown() {
        boolean scaleDetector = scaleCollision.getCollision(this.x, this.y);
        if(!scaleDetector){
            this.moving = false;
            this.liftingDown = false;
        }
        else{
            this.liftingDown = true;
            this.liftingUp = false;
            this.objectAnimation.setCurrent(EAnimation.IDLE);
            this.setActions(Actions.LIFT_DOWN);
            this.moving = true;
        }
    }

    public void jump() {

        if (dobleJump < 2){
            dobleJump++;
            if (!this.goingLeft && !this.goingRight) {
                this.objectAnimation.setCurrent(EAnimation.IDLE);
                this.setActions(Actions.SIMPLE_JUMP);
                this.moving = true;
            } else if (goingRight) {
                this.liftingDown = false;
                this.objectAnimation.setCurrent(EAnimation.IDLE);
                this.setActions(Actions.JUMP_RIGHT);
                this.moving = true;
            } else {
                this.liftingDown = false;
                this.objectAnimation.setCurrent(EAnimation.IDLE);
                this.setActions(Actions.JUMP_LEFT);
                this.moving = true;
            }
            this.gravity.init();
        }
    }

    public void idle() {
        if (this.actions != Actions.SIMPLE_JUMP && this.actions != Actions.JUMP_RIGHT && this.actions != Actions.JUMP_LEFT && this.actions !=Actions.LIFT_UP && this.actions != Actions.LIFT_DOWN) {
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
        if(actions == Actions.WALK_RIGHT || actions == Actions.JUMP_RIGHT){
            this.objectAnimation.setLookRight(true);
        }
        if(actions == Actions.WALK_LEFT || actions == Actions.JUMP_LEFT){
            this.objectAnimation.setLookRight(false);
        }
    }

    public void setGoingRight(boolean goingRight) {
        this.goingRight = goingRight;
    }

    public void setGoingLeft(boolean goingLeft) {
        this.goingLeft = goingLeft;
    }

    public EMap getNewMap() {
        return newMap;
    }
}
