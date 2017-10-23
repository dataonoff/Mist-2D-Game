import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class WindowGame extends BasicGame{

    private GameContainer container;
    private TiledMap map;

    public WindowGame(String title) {
        super("yo");
    }

    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new WindowGame("Lolo et charlie Game"), 640, 480, false).start();
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        this.container = container;
        this.map = new TiledMap("map/tecar.tmx");

    }

    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        this.map.render(0,0);
    }


    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
    }
}
