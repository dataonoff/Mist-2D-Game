package game.collision;

import game.gameObject.GameObject;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class FloorCollision extends Collision{

    public FloorCollision() {
        super();
        this.layer = this.map.getLayerIndex("plateforme");
    }

    public boolean getCollision(float futurX, float futurY) {
        int tileW = this.map.getTileWidth();
        int tileH = this.map.getTileHeight();
        Image tile = this.map.getTileImage((int) futurX / tileW, (int) futurY / tileH, this.layer);
        boolean collisionfloor = tile != null;
        if (collisionfloor) {
            Color color = tile.getColor((int) futurX % tileW, (int) futurY % tileH);
            collisionfloor = color.getAlpha() > 0;
        }
        return collisionfloor;
    }

}
