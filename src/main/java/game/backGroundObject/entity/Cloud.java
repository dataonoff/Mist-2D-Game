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

public class Cloud extends BackgroundObject {

    private String cloudName;
    private Image img;
    private TiledMap Map1 = MapFactory.getMapFactory().getMaps(EMap.MAP1);
    boolean cloudToTheRight;
    boolean cloudToTheLeft;

    public Cloud(float x, float y, String cloudName) throws SlickException {
        super(x, y, EBackgroundObject.CLOUD);
        this.cloudName = cloudName;
        this.img = new Image(cloudName);
    }


    @Override
    public void draw(Graphics graphics){
        img.draw(getX(), getY());
    }

    @Override
    public void update(GameContainer container, int delta){
        int min = container.getWidth() / 2;
        int max = Map1.getWidth() * Map1.getTileWidth() -  container.getWidth() / 2;
        if (this.x < min) {
            cloudToTheRight = true;
            cloudToTheLeft = false;
        } else if (this.x > max) {
            cloudToTheRight = false;
            cloudToTheLeft = true;
        }

        if(cloudToTheRight){
            this.x += .03f * delta;
        }
        else if(cloudToTheLeft){
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
