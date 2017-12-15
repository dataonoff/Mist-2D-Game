package game.universe;


import game.controller.GameController;
import graphics.map.EMap;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;

public abstract class World {

    private EMap map;
    private Music music;

    public World(EMap map) {
        this.map = map;
    }

    public abstract void enter();
    public abstract void init(GameController gameController);
    public abstract void render(GameContainer gameContainer, Graphics graphics);
    public abstract void update(GameContainer container, int delta);
    public abstract void keyReleased(int key, char c);
    public abstract float CameraFocusX();
    public abstract float CameraFocusY();
    public abstract void keyPressed(int key, char c);

    public EMap getMap() {
        return map;
    }

    public void setMap(EMap map) {
        this.map = map;
    }
}
