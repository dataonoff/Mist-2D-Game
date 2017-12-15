package graphics.windows;

import game.backGroundObject.entity.Mist;
import game.controller.HomeController;
import game.gameObject.GameObjectManager;
import graphics.animation.AnimationFactory;
import graphics.gui.GuiHomeManager;
import graphics.map.MapFactory;
import javafx.util.Pair;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.io.IOException;
import java.util.Observable;

public class WindowHome extends Window {

    private GameContainer container;
    private Image background;
    private Mist mist;
    private Music fleet;

    public WindowHome() {
        super(0);
        System.out.println("create windowHome");

        this.controller = new HomeController();
        this.guiManager = new GuiHomeManager();
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        System.out.println("enter home");
        this.controller.enter();
        this.fleet.play();
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        System.out.println("init home");
        super.init(gameContainer, stateBasedGame);
        this.container = gameContainer;
        try {
            this.fleet = new Music("music/Fleet.wav");
        } catch (SlickException e) {
            e.printStackTrace();
        }
        this.background = new Image("background/Mist_black.png");
        this.mist = new Mist(-500,0);
        try {
            AnimationFactory.getInstance().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MapFactory.getMapFactory().init();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());
        mist.draw(graphics);
        super.render(gameContainer, stateBasedGame, graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta){
        mist.update(gameContainer,delta);

    }

    public void update(Observable o, Object arg) {
        if (arg instanceof Pair) {
            Pair<String, Integer> task = (Pair<String, Integer>) arg;
            if (task.getKey().equals("redirect")) {
                this.stateBasedGame.enterState(task.getValue());
            }
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            this.container.exit();
        }
    }

    @Override
    public void keyPressed(int key, char c){
        if (Input.KEY_ENTER == key){
            this.stateBasedGame.enterState(1);
        }
    }
}