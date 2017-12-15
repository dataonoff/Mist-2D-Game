package game.collision;

import graphics.map.MapFactory;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

public class BorderCollision extends Collision {
    private int layer;

    public BorderCollision() {
        super();
        this.layer = MapFactory.getMapFactory().getCurrentMap().getLayerIndex("borders");
    }

    public boolean getCollision(float futurX, float futurY) {
        int tileW = this.map.getTileWidth();
        int tileH = this.map.getTileHeight();
        Image tile = this.map.getTileImage((int) futurX / tileW, (int) futurY / tileH, this.layer);
        boolean borderCollision = tile != null;
        if (borderCollision) {
            Color color = tile.getColor((int) futurX % tileW, (int) futurY % tileH);
            borderCollision = color.getAlpha() > 0;
        }
        return borderCollision;
    }

}
