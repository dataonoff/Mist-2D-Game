package graphics.windows;

import game.controller.GameController;
import game.gameObject.GameObject;
import graphics.gui.GuiManager;
import game.controller.WindowController;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Observer;

public abstract class Window extends BasicGameState implements Observer {

    protected StateBasedGame stateBasedGame;
    protected WindowController controller;
    protected GuiManager guiManager;
    private int id;

    protected Window(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return this.id;
    }

    public abstract void enter(GameContainer container, StateBasedGame game) throws SlickException;

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        System.out.println("init window");
        controller.init();
        guiManager.init(this);
        this.stateBasedGame = stateBasedGame;
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        controller.update(gameContainer);
        guiManager.update();
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        controller.render(gameContainer, graphics);
        guiManager.render(graphics);

    }

    @Override
    public void keyPressed(int key, char c) {
        controller.keyPressed(key,c);
    }
    @Override
    public void keyReleased(int key, char c){
        controller.keyReleased(key,c);
        System.out.println("keyreleasedwindow enter");
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        guiManager.mouseClicked(button, x, y);
    }

}
