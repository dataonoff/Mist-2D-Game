package game.universe;

import game.backGroundObject.backgroundObjectManager.BackgroundObjectManager;
import game.controller.Camera;
import game.controller.GameController;
import game.gameObject.EGameObject;
import game.gameObject.GameObjectManager;
import game.gameObject.player.Player;
import graphics.animation.AnimationFactory;
import graphics.map.EMap;
import graphics.map.MapFactory;
import music.SoundManager;
import org.newdawn.slick.*;

public class BlackWorld extends World {

    private Player player;
    private Camera camera;
    private BackgroundObjectManager backgroundObjectManager;

    public BlackWorld() {
        super(EMap.MAP2);

    }

    public void enter() {
        Music background = null;
        try {
            background = new Music("music/logue.wav");
        } catch (SlickException e) {
            e.printStackTrace();
        }
        background.loop();

    }

    @Override
    public void init(GameController gameController){
        try {
            MapFactory.getMapFactory().setCurrent(EMap.MAP2);
            this.player = new Player(AnimationFactory.getInstance().getObjectAnimation(EGameObject.KEVIN), 300, 352);
            this.camera = new Camera();
            //GameObjectManager.getInstance().init();
            //SoundManager.getInstance().init();
            this.backgroundObjectManager = new BackgroundObjectManager();
            this.backgroundObjectManager.init();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void render(GameContainer gameContainer, Graphics graphics){
        MapFactory.getMapFactory().getCurrentMap().render(0,0);
        player.draw(graphics);
        //GameObjectManager.getInstance().draw(graphics);
        backgroundObjectManager.draw(graphics);

    }
    @Override
    public void update(GameContainer container, int delta){
        player.update(delta);
        camera.update(container, this.player);
        //GameObjectManager.getInstance().update(delta);
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

    @Override
    public float CameraFocusX() {
        return this.camera.getX();
    }

    @Override
    public float CameraFocusY() {
        return this.camera.getY();
    }

}
