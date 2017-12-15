package game.controller;

import game.backGroundObject.backgroundObjectManager.BackgroundObjectManager;
import game.gameObject.GameObjectManager;
import game.gameObject.EGameObject;
import game.universe.FirstWorld;
import game.universe.World;
import game.universe.worldmanager.EWorld;
import game.universe.worldmanager.WorldManager;
import graphics.animation.AnimationFactory;
import game.gameObject.player.Player;
import graphics.map.EMap;
import graphics.map.MapFactory;
import javafx.util.Pair;
import music.SoundManager;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class GameController extends WindowController implements Observer {

    private WorldManager worldManager;

    @Override
    public void init() {
        this.worldManager = new WorldManager();
        this.worldManager.init(this);
    }

    @Override
    public void enter() {
        this.worldManager.getCurrentWorld().enter();
        MapFactory.getMapFactory().setCurrent(EMap.MAP1);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {
        this.worldManager.getCurrentWorld().render(gameContainer, graphics);
    }

    @Override
    public void update(GameContainer container, int delta) {
            this.worldManager.getCurrentWorld().update(container,delta);

    }

    @Override
    public void keyReleased(int key, char c) {
        this.worldManager.getCurrentWorld().keyReleased(key, c);
    }

    @Override
    public float CameraFocusX() {
        return this.worldManager.getCurrentWorld().CameraFocusX();
    }

    @Override
    public float CameraFocusY() {
        return this.worldManager.getCurrentWorld().CameraFocusY();
    }

    @Override
    public void keyPressed(int key, char c) {
        this.worldManager.getCurrentWorld().keyPressed(key, c);
    }

    public void update(Observable o, Object arg) {
        System.out.println("oberver receive message");
        if (arg instanceof Pair) {
            Pair<String, EWorld> task = (Pair<String, EWorld>) arg;
            if (task.getKey().equals("redirect")) {
                System.out.println("oberver receive message: " + task.getValue());
                this.worldManager.setCurrent(task.getValue());
            }
        }
    }
}
