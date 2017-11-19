package graphics.map;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.util.HashMap;

public class MapFactory{

    private static MapFactory mapFactory = new MapFactory();
    private HashMap<EMap,TiledMap> maps;
    private TiledMap level1;

    public MapFactory() {
        this.maps = new HashMap<EMap, TiledMap>();
    }

    public static MapFactory getMapFactory() {
        return mapFactory;
    }

    public void init() throws SlickException {
        addMaps();
    }

    private void addMaps() throws SlickException {
        TiledMap map1 = new TiledMap("map/walk.tmx");
        this.maps.put(EMap.MAP1,map1);
    }

    public TiledMap getMaps(EMap eMap){
        return this.maps.get(eMap);
    }

}
