package game.controller;

import game.gameObject.player.Player;
import graphics.map.EMap;
import graphics.map.MapFactory;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.tiled.TiledMap;

public class Camera {

    private float xCamera;
    private float yCamera;
    private TiledMap Map1 = MapFactory.getMapFactory().getMaps(EMap.MAP1);

    public Camera() {
        this.xCamera = 0;
        this.yCamera = 0;
    }

    public void update(GameContainer container, Player player){
        int w = container.getWidth() / 4;
        float x = player.getX();
        float y = player.getY();
        if (x > this.xCamera + w) {
            this.xCamera = (x - w);
        } else if (x < this.xCamera - w) {
            this.xCamera = (x + w);
        }
        int h = container.getHeight() / 4;
        if (y > this.yCamera + h) {
            this.yCamera = (y - h);
        } else if (y < this.yCamera - h) {
            this.yCamera = (y + h);
        }

        //camera Map Limit
        int min = container.getWidth() / 2;
        int max = Map1.getWidth() * Map1.getTileWidth() -  container.getWidth() / 2;
        if (this.xCamera < min) {
            this.xCamera = min;
        } else if (this.xCamera > max) {
            this.xCamera = max;
        }
        min = container.getHeight() / 2;
        max = this.Map1.getHeight() * this.Map1.getTileHeight() - container.getHeight() / 2;
        if (this.yCamera < min) {
            this.yCamera = min;
        } else if (this.yCamera > max) {
            this.yCamera = max;
        }
    }

    public float getX() {
        return xCamera;
    }

    public void setX(float x) {
        this.xCamera = x;
    }

    public float getY() {
        return yCamera;
    }

    public void setY(float y) {
        this.yCamera = y;
    }
}
