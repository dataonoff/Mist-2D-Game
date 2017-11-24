package game.gameObject.entity;

import game.gameObject.GameObject;
import graphics.animation.ObjectAnimation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Gate extends GameObject{

    private float x = 0, y = 0;

    public Gate(ObjectAnimation animation, float x, float y) {
        super(animation, x, y);
        this.x = x;
        this.y = y;

    }

    @Override
    public void draw(Graphics graphics){
        this.objectAnimation.getCurrentAnimation().getCurrentFrame().getFlippedCopy(false,false).draw(x,y);
        //System.out.println(this.objectAnimation.getCurrentAnimation().getCurrentFrame().getColor(98,76).getAlpha());

    }

    @Override
    public void update(int delta){
        this.objectAnimation.getCurrentAnimation().update(delta);
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

    @Override
    public boolean GetCollision(float x, float y) {
        //1.récupérer les coordonnés de position du GameObject(x et y)
        //2.Une fois les coordonnés récupérés, dessiner un carré qui reprend le contour du gif
        //3. si le carré contient la position du player return boolean isInside true
        Rectangle rectangle = new Rectangle(this.getX()+75,this.getY()+55,this.getWidth()/4, this.getHeight()/4);
        if (rectangle.contains(x, y)) {
            isInside = true;
            return isInside;
        } else {
            isInside = false;
            return isInside;
        }
    }

}
