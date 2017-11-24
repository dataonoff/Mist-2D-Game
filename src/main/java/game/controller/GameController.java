package game.controller;

import game.backGroundObject.backgroundObjectManager.BackgroundObjectManager;
import game.gameObject.GameObjectManager;
import game.gameObject.EGameObject;
import graphics.animation.AnimationFactory;
import game.gameObject.player.Player;
import graphics.map.EMap;
import graphics.map.MapFactory;
import music.SoundManager;
import org.lwjgl.Sys;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class GameController extends WindowController {
    private Player player;
    private Camera camera;
    private BackgroundObjectManager backgroundObjectManager;
    private EMap eMap = EMap.MAP1;

    @Override
    public void init() {

    }

    @Override
    public void enter() {
        try {

            this.player = new Player(AnimationFactory.getInstance().getObjectAnimation(EGameObject.KEVIN), 300-32, 1300-64);
            this.camera = new Camera();
            GameObjectManager.getInstance().init();
            SoundManager.getInstance().init();
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
        changeMap(eMap).render(0,0);
        player.draw(graphics);
        GameObjectManager.getInstance().draw(graphics);
        backgroundObjectManager.draw(graphics);
    }

    private TiledMap changeMap(EMap eMap){
        return MapFactory.getMapFactory().getMaps(eMap);

    }

    @Override
    public void update(GameContainer container, int delta) {
            player.update(delta);
            this.eMap = player.getNewMap();
            camera.update(container, this.player);
            GameObjectManager.getInstance().update(delta);
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
