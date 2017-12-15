package game.universe.worldmanager;

import game.controller.GameController;
import game.universe.BlackWorld;
import game.universe.FirstWorld;
import game.universe.World;
import graphics.map.MapFactory;

import java.util.HashMap;

public class WorldManager {

    private HashMap<EWorld,World> worldHashMap;
    private EWorld current;

    public WorldManager() {
        this.current = EWorld.FIRST;
        this.worldHashMap = new HashMap<EWorld, World>();
    }

    public void init(GameController gameController){
        FirstWorld firstWorld = new FirstWorld();
        BlackWorld blackWorld = new BlackWorld();
        firstWorld.init(gameController);
        blackWorld.init(gameController);
        worldHashMap.put(EWorld.FIRST, firstWorld);
        worldHashMap.put(EWorld.BLACK_WORLD, blackWorld);
    }

    public World getWorld(EWorld current){
        return worldHashMap.get(current);
    }

    public World getCurrentWorld(){
        return this.getWorld(this.current);
    }

    public EWorld getCurrent() {
        return current;
    }

    public void setCurrent(EWorld current) {
        this.current = current;
        MapFactory.getMapFactory().setCurrent(this.getCurrentWorld().getMap());
        this.getCurrentWorld().enter();
    }
}
