package game.gameObject;

import game.gameObject.player.Actions;
import graphics.animation.ObjectAnimation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected ObjectAnimation objectAnimation;
    private boolean moving = false;
    protected boolean isInside = false;
    private Actions actions;

    protected GameObject(ObjectAnimation animation, float x, float y) {
        this.objectAnimation = animation;
        this.x = x;
        this.y = y;
    }

    public void init() {

    }

    public void draw(Graphics graphics) {
    }

    public void update(int delta){

    }

    public float nextX(int delta){
        return x;
    }

    public float nextY(int delta){
        return y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getHeight(){
        return this.objectAnimation.getCurrentAnimation().getHeight();
    }

    public int getWidth(){
        return this.objectAnimation.getCurrentAnimation().getWidth();
    }


    public boolean GetCollision(float x, float y){
        //1.récupérer les coordonnés de position du GameObject(x et y)
        //2.Une fois les coordonnés récupérés, dessiner un carré qui reprend le contour du gif
        //3. si le carré contient la position du player return boolean isInside true
        //4. Si IsInside est true, créer un compteur de int qui va correspondre à la position du player dans le frame:
        //A chaque +1 de playerx ou de playery : Augmenter xframe ou yframe
        //Si getAlpha > 0, return true, else return false,
        Rectangle rectangle = new Rectangle(getX(),getY(),getWidth(), getHeight());
        if(rectangle.contains(x, y)) {
            isInside = true;
            return isInside;
        }
        else {isInside = false;
        return isInside;
        }
    }

}
