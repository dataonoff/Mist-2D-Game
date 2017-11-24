import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class MasterGame {

    public void init(){

    }

    public void start() throws SlickException {
        AppGameContainer app = new AppGameContainer(new StateGame(), 800, 600, false);
        app.setTargetFrameRate(50);
        app.setShowFPS(false);
        app.start();


    }
}
