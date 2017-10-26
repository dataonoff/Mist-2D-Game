package graphics.windows;

import game.controller.GameController;
import game.gameObject.PlayerAnimation;
import game.gameObject.player.Player;
import graphics.gui.GuiGameManager;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import java.util.Observable;

public class WindowGame extends Window {

    private TiledMap map;
    private GameContainer container;

    public WindowGame() {
        super(1);
        this.controller = new GameController();
        this.guiManager = new GuiGameManager();
    }
    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        System.out.println("enter game");

    }
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        super.init(gameContainer, stateBasedGame);
        this.container = gameContainer;
        this.map = new TiledMap("map/walk.tmx");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
    this.map.render(0, -950);
    super.render(gameContainer, stateBasedGame, graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        this.controller.update(gameContainer);
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
