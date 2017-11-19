package game.controller;

import game.backGroundObject.BackgroundObjectManager;
import game.backGroundObject.Bird;
import game.backGroundObject.Cloud;
import game.gameObject.EGameObject;
import game.gameObject.GameObject;
import game.gameObject.monster.Raccoon;
import graphics.animation.AnimationFactory;
import game.gameObject.player.Player;
import org.newdawn.slick.*;

public class GameController extends WindowController {
    private Player player;
    private Camera camera;
    private Bird bird;
    private BackgroundObjectManager backgroundObjectManager;
    private Raccoon raccoon;
    @Override
    public void init() {
    }

    @Override
    public void enter() {
        try {
            this.player = new Player(AnimationFactory.getInstance().getObjectAnimation(EGameObject.KEVIN), 300-32, 1300-64);
            this.camera = new Camera();
            this.bird = new Bird(AnimationFactory.getInstance().getObjectAnimation(EGameObject.BIRD),300,300);
            this.backgroundObjectManager = new BackgroundObjectManager();
            this.backgroundObjectManager.init();
            this.raccoon = new Raccoon(AnimationFactory.getInstance().getObjectAnimation(EGameObject.RACCOON),300,1300);

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        player.draw(graphics);
        bird.draw(graphics);
        raccoon.draw(graphics);
        backgroundObjectManager.draw(graphics);
    }

    @Override
    public void update(GameContainer container, int delta) {
            player.update(delta);
            camera.update(container, this.player);
            bird.update(delta);
            raccoon.update(delta);
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
                this.player.climUp();
                break;
            case Input.KEY_DOWN:
                this.player.climDown();
                break;
            case Input.KEY_SPACE:
                this.player.jump();
        }
    }
}
