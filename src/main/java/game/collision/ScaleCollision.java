package game.collision;

import graphics.map.MapFactory;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

public class ScaleCollision extends Collision{

    public ScaleCollision() {
        super();
        this.layer = MapFactory.getMapFactory().getCurrentMap().getLayerIndex("scale");
    }

    public boolean getCollision(float futurX, float futurY) {
        int tileW = this.map.getTileWidth();
        int tileH = this.map.getTileHeight();
        Image tile = this.map.getTileImage((int) futurX / tileW, (int) futurY / tileH, this.layer);
        boolean scaleDetector = tile != null;
        if (scaleDetector) {
            Color color = tile.getColor((int) futurX % tileW, (int) futurY % tileH);
            scaleDetector = color.getAlpha() > 0;
        }
        return scaleDetector;
    }
}
