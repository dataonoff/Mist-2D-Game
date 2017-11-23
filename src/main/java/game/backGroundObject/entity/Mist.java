package game.backGroundObject.entity;

import game.backGroundObject.BackgroundObject;
import game.backGroundObject.EBackgroundObject;
import graphics.map.EMap;
import graphics.map.MapFactory;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Mist extends BackgroundObject {

    private Image img = new Image("sprites/Mist_min.png");
    private TiledMap Map1 = MapFactory.getMapFactory().getMaps(EMap.MAP1);
    private boolean mistToTheRight;
    private boolean mistToTheLeft;

    public Mist(float x, float y) throws SlickException {
        super(x, y, EBackgroundObject.MIST);
    }

    @Override
    public void draw(Graphics graphics){
        img.draw(getX(), getY());
    }

    @Override
    public void update(GameContainer container, int delta){
        int min = -400;
        int max = -30;
        if (this.x < min) {
            mistToTheRight = true;
            mistToTheLeft = false;
        } else if (this.x > max) {
            //System.out.println("x sup à " + min);
            mistToTheRight = false;
            mistToTheLeft = true;
        }

        if(mistToTheRight){
            this.x += .03f * delta;
        }
        else if(mistToTheLeft){
            this.x -= .03f * delta;
        }
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

}

