package graphics.windows;

import game.controller.GameController;
import graphics.animation.MapTileAnimation;
import graphics.gui.GuiGameManager;
import graphics.map.EMap;
import graphics.map.MapFactory;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.Observable;

public class WindowGame extends Window {

    private TiledMap map;
    private GameContainer container;
    private GameController gameController = new GameController();
    private MapTileAnimation mapTileAnimation;
    private int deltaFreq = 0;


    public WindowGame() {
        super(1);
        this.controller = gameController;
        this.guiManager = new GuiGameManager();
    }
    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        System.out.println("enter game");
        this.controller.enter();

    }
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        System.out.println("init game");
        super.init(gameContainer, stateBasedGame);
        this.container = gameContainer;
        this.mapTileAnimation = new MapTileAnimation();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
    graphics.translate(gameContainer.getWidth() / 2 - (int) gameController.CameraFocusX(), gameContainer.getHeight() / 2
                - (int) gameController.CameraFocusY());
    super.render(gameContainer, stateBasedGame, graphics);
    }


    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        this.deltaFreq += delta;
        //System.out.println(deltaFreq + " !!!!!  " + delta);
        //if(deltaFreq >= 20) {
            this.controller.update(gameContainer, delta);
            deltaFreq = 0;
        //}
        this.mapTileAnimation.update(delta);

    }


    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            this.container.exit();
        }
        this.controller.keyReleased(key, c);
    }

    @Override
    public void keyPressed(int key, char c) {
        this.controller.keyPressed(key, c);
    }

    public void update(Observable o, Object arg) {

    }

}
