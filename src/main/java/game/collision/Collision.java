package game.collision;

import game.gameObject.GameObject;
import graphics.map.EMap;
import graphics.map.MapFactory;
import org.lwjgl.Sys;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

public abstract class Collision {

    protected GameObject gameObject;
    protected int layer;
    protected TiledMap map;

    public Collision() {
        this.map = MapFactory.getMapFactory().getCurrentMap();
        System.out.println("locol map: "+ MapFactory.getMapFactory().getCurrent());
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}
