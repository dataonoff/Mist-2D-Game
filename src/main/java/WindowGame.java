import org.newdawn.slick.*;

public class WindowGame extends BasicGame{

    GameContainer container;

    public WindowGame(String title) {
        super("yo");
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        this.container = container;
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

    }

    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowGame("Lolo et charlie Game"), 640, 480, false).start();
    }

    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
    }
}
