package game.gameObject;

import game.gameObject.entity.Bird;
import game.gameObject.entity.Gate;
import game.gameObject.monster.Raccoon;
import graphics.animation.AnimationFactory;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.HashMap;
import java.util.Map;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();
    private HashMap<EGameObject, GameObject> gameObjectsHashMap;

    public GameObjectManager() {
        this.gameObjectsHashMap = new HashMap<EGameObject,GameObject>();
    }

    public static GameObjectManager getInstance() {
        return instance;
    }

    public void init() throws SlickException {
        Bird bird = new Bird(AnimationFactory.getInstance().getObjectAnimation(EGameObject.BIRD),300,300);
        Gate gate = new Gate(AnimationFactory.getInstance().getObjectAnimation(EGameObject.GATE),1450, 800);
        Raccoon raccoon = new Raccoon(AnimationFactory.getInstance().getObjectAnimation(EGameObject.RACCOON),300,1300);
        this.gameObjectsHashMap.put(EGameObject.BIRD,bird);
        this.gameObjectsHashMap.put(EGameObject.GATE, gate);
        this.gameObjectsHashMap.put(EGameObject.RACCOON, raccoon);

    }

    public void draw(Graphics graphics){
        for(Map.Entry<EGameObject,GameObject> gameObjectEntry: gameObjectsHashMap.entrySet()){
            gameObjectEntry.getValue().draw(graphics);
        }
    }

    public void update(int delta){
        for(Map.Entry<EGameObject, GameObject> gameObjects : gameObjectsHashMap.entrySet()){
            gameObjects.getValue().update(delta);
        }
    }

    public HashMap<EGameObject, GameObject> getGameObjectsHashMap() {
        return gameObjectsHashMap;
    }

    public void setGameObjectsHashMap(HashMap<EGameObject, GameObject> gameObjectsHashMap) {
        this.gameObjectsHashMap = gameObjectsHashMap;
    }
}
