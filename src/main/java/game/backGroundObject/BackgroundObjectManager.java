package game.backGroundObject;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BackgroundObjectManager {

    private HashMap<EBackgroundObject, BackgroundObject> backgroundObjectHashMap;
    private List<BackgroundObject> backgroundObjects;

    public void init() throws SlickException {
        Cloud cloud1 = new Cloud(300,200);
        Cloud cloud2 = new Cloud(1300, 500);
        Cloud cloud3 = new Cloud(2400, 800);
        Mist mist = new Mist(-500,0);
        backgroundObjects = new ArrayList<BackgroundObject>();
        backgroundObjects.add(cloud1);
        backgroundObjects.add(cloud2);
        backgroundObjects.add(cloud3);
        backgroundObjects.add(mist);

        /*
        backgroundObjectHashMap = new HashMap<EBackgroundObject, BackgroundObject>();
        backgroundObjectHashMap.put(EBackgroundObject.CLOUD, cloud1);
        backgroundObjectHashMap.put(EBackgroundObject.CLOUD, cloud2);
        */
    }


    public void draw(Graphics graphics) {
        for (BackgroundObject temp : backgroundObjects) {
            temp.draw(graphics);
        }
        /*
        for (Map.Entry<EBackgroundObject, BackgroundObject> item : backgroundObjectHashMap.entrySet()) {
            item.getValue().draw(graphics);
        }
        */
    }

    public void update(GameContainer container, int delta){
        /*
        for (Map.Entry<EBackgroundObject, BackgroundObject> item : backgroundObjectHashMap.entrySet()) {
            item.getValue().update(container,delta);
        }
        */

        for (BackgroundObject temp : backgroundObjects) {
            temp.update(container,delta);
        }
    }
}
