import org.newdawn.slick.SlickException;

public class Main {

    public static void main(String[] args){
        MasterGame masterGame = new MasterGame();
        masterGame.init();

        try {
            masterGame.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }
}
