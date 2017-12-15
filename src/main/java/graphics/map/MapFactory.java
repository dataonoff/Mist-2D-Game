package graphics.map;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.util.EmptyStackException;
import java.util.HashMap;

public class MapFactory{

    private static MapFactory mapFactory = new MapFactory();
    private HashMap<EMap,TiledMap> maps;
    private EMap current;

    public MapFactory() {
        this.current = EMap.MAP1;
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
        TiledMap map2 = new TiledMap("map/platform.tmx");
        this.maps.put(EMap.MAP1,map1);
        this.maps.put(EMap.MAP2, map2);
    }

    public TiledMap getMaps(EMap eMap){
        return this.maps.get(eMap);
    }

    public TiledMap getTiledMap(EMap current){
        return this.maps.get(current);
    }

    public TiledMap getCurrentMap(){
        return this.getTiledMap(this.current);
    }

    public EMap getCurrent() {
        return current;
    }

    public void setCurrent(EMap current) {
        this.current = current;
    }
}
