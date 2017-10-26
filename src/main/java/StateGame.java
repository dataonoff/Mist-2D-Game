import graphics.windows.WindowGame;
import graphics.windows.WindowHome;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StateGame extends StateBasedGame {

    public StateGame() {
        super("LOL");
    }


    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new WindowHome());
        addState(new WindowGame());
        this.enterState(0);
    }
}