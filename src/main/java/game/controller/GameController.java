package game.controller;

import game.gameObject.EGameObject;
import graphics.animation.AnimationFactory;
import graphics.animation.ObjectAnimation;
import game.gameObject.player.Player;
import org.newdawn.slick.*;

public class GameController extends WindowController {
    private Camera camera = new Camera();
    private Player player;

    @Override
    public void init() {
    }

    @Override
    public void enter() {
        try {

            System.out.println("enter GameController : " + AnimationFactory.getInstance().getObjectAnimation(EGameObject.KEVIN).getAnimations().size());
            this.player = new Player(AnimationFactory.getInstance().getObjectAnimation(EGameObject.KEVIN), 300-32, 520-90);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        player.draw(graphics);
        //graphics.drawAnimation(playerAnimation.getAnimations()[direction + (moving ? 2 : 0)], x-32, y-60);
    }

    @Override
    public void update(GameContainer container, int delta) {
        //updateCamera(container);
        player.update(delta);
        camera.update(container, player);
    }

    @Override
    public void keyReleased(int key, char c) {
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
            //case Input.KEY_UP:
            //    this.direction = 0;
            //    this.moving = true;
            //    break;
            case Input.KEY_RIGHT:
                this.player.walkRight();
                break;
            case Input.KEY_LEFT:
                this.player.walkLeft();
                break;

            //case Input.KEY_DOWN:
            //  this.direction = 2;
            //  this.moving = true;
            //  break;
        }
    }


}
