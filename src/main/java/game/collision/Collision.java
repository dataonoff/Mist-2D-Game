package game.collision;

import game.gameObject.GameObject;
import graphics.map.EMap;
import graphics.map.MapFactory;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

public abstract class Collision {

    protected GameObject gameObject;
    protected int layer;
    TiledMap map = MapFactory.getMapFactory().getMaps(EMap.MAP1);

    public Collision() {
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}
