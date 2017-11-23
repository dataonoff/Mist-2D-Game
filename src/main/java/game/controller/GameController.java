package game.controller;

import game.backGroundObject.backgroundObjectManager.BackgroundObjectManager;
import game.gameObject.GameObjectManager;
import game.gameObject.EGameObject;
import graphics.animation.AnimationFactory;
import game.gameObject.player.Player;
import org.newdawn.slick.*;

public class GameController extends WindowController {
    private Player player;
    private Camera camera;
    private BackgroundObjectManager backgroundObjectManager;
    private GameObjectManager gameObjects;

    @Override
    public void init() {

    }

    @Override
    public void enter() {
        try {
            this.player = new Player(AnimationFactory.getInstance().getObjectAnimation(EGameObject.KEVIN), 300-32, 1300-64);
            this.camera = new Camera();
            this.gameObjects = new GameObjectManager();
            this.gameObjects.init();
            this.backgroundObjectManager = new BackgroundObjectManager();
            this.backgroundObjectManager.init();
            Music background = null;
            try {
                background = new Music("music/Dew.wav");
            } catch (SlickException e) {
                e.printStackTrace();
            }
            background.loop();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        player.draw(graphics);
        this.gameObjects.draw(graphics);
        backgroundObjectManager.draw(graphics);
    }

    @Override
    public void update(GameContainer container, int delta) {
            player.update(delta);
            camera.update(container, this.player);
            this.gameObjects.update(delta);
            backgroundObjectManager.update(container,delta);
    }

    @Override
    public void keyReleased(int key, char c) {
        switch (key){
            case Input.KEY_RIGHT:
                this.player.setGoingRight(false);
                break;
            case Input.KEY_LEFT:
                this.player.setGoingLeft(false);
                break;
        }
        this.player.idle();
    }

    @Override
    public float CameraFocusX() {
        return this.camera.getX();
    }

    @Override
    public float CameraFocusY() {
        return this.camera.getY();
    }

    @Override
    public void keyPressed(int key, char c) {
        switch (key) {
            case Input.KEY_RIGHT:
                this.player.walkRight();
                break;
            case Input.KEY_LEFT:
                this.player.walkLeft();
                break;
            case Input.KEY_UP:
                this.player.liftUp();
                break;
            case Input.KEY_DOWN:
                this.player.liftDown();
                break;
            case Input.KEY_SPACE:
                this.player.jump();
        }
    }
}
