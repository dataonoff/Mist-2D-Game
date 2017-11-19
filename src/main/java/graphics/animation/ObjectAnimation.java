package graphics.animation;

import org.newdawn.slick.Animation;

import java.util.HashMap;
import java.util.Map;

public class ObjectAnimation {

    private HashMap<EAnimation, Animation> animations;
    private EAnimation current;
    private boolean lookRight;

    public ObjectAnimation() {
        this.current = EAnimation.IDLE;
        this.lookRight = true;
        this.animations = new HashMap<EAnimation, Animation>();
    }

    public ObjectAnimation(ObjectAnimation objectAnimation) {
        this.lookRight = objectAnimation.lookRight;
        this.current = objectAnimation.current;

        this.animations = new HashMap<EAnimation, Animation>();

        for (Map.Entry<EAnimation, Animation> item : objectAnimation.animations.entrySet()) {
            this.animations.put(item.getKey(), item.getValue().copy());
        }
    }



    public void addAnimation(EAnimation type, Animation animation){
        animations.put(type,animation);
    }

    public Animation getAnimation(EAnimation current) {
        return this.animations.get(current);
    }

    public EAnimation getCurrent() {
        return current;
    }

    public Animation getCurrentAnimation() {
        return this.getAnimation(this.current);
    }

    public boolean isLookRight() {
        return lookRight;
    }

    public void setCurrent(EAnimation current) {
        this.current = current;
    }

    public void setLookRight(boolean lookRight) {
        this.lookRight = lookRight;
    }

    public HashMap<EAnimation, Animation> getAnimations() {
        return animations;
    }
}
