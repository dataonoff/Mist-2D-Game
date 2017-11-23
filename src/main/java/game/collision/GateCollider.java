package game.collision;

import game.gameObject.EGameObject;
import game.gameObject.GameObject;
import game.gameObject.GameObjectManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class GateCollider extends Collision {

    private GameObject gate;
    private Rectangle collider;

    public GateCollider() {
        this.gate = GameObjectManager.getInstance().getGameObjectsHashMap().get(EGameObject.GATE);
        //System.out.println(gate);
        this.collider = new Rectangle(this.gate.getX(),this.gate.getY(),50, 68);
        System.out.println(this.gate.getX());

    }

    public boolean GateCollision(float x, float y) {
        if(this.collider.contains(x, y)){
            return true;
        }
        else return false;
    }

    public void draw(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.fill(collider);
    }

}
