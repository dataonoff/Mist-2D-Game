package game.controller;

import game.gameObject.PlayerAnimation;
import org.newdawn.slick.*;

public class GameController extends WindowController {

    private float x = 300, y = 520;
    private float xCamera = x, yCamera = y;
    private int direction = 0;
    private Animation[] animations = new Animation[1];
    private boolean moving = false;
    private PlayerAnimation playerAnimation;

    @Override
    public void init() {
        try {
            this.playerAnimation = new PlayerAnimation();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        graphics.translate(gameContainer.getWidth() / 2 - (int) x, gameContainer.getHeight() / 2
                - (int) y);
        graphics.setColor(new Color(0, 0, 0, .5f));
        graphics.fillOval(x - 16, y - 8, 32, 16);
        graphics.drawAnimation(playerAnimation.getAnimations()[direction + (moving ? 2 : 0)], x-32, y-60);
    }

    @Override
    public void update(GameContainer container) {
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
                    break;
                case 1:
                    this.x -= .8f;
                    break;
            }
        }
    }
    @Override
    public void keyReleased(int key, char c) {
        this.moving = false;
        System.out.println("key release yes");
    }

    @Override
    public void keyPressed(int key, char c) {
        switch (key) {
            //case Input.KEY_UP:
            //    this.direction = 0;
            //    this.moving = true;
            //    break;
            case Input.KEY_RIGHT:
                this.direction = 0;
                this.moving = true;
                break;
            case Input.KEY_LEFT:
                this.direction = 1;
                this.moving = true;
                break;

            //case Input.KEY_DOWN:
            //  this.direction = 2;
            //  this.moving = true;
            //  break;
        }
    }


}
