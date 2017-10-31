package graphics.animation;

import org.newdawn.slick.Animation;

import java.util.HashMap;

public class ObjectAnimation {

    private HashMap<EAnimation, Animation> animations;
    private EAnimation current;
    private boolean lookRight;

    public ObjectAnimation() {
        this.current = EAnimation.IDLE;
        this.lookRight = true;
        this.animations = new HashMap<EAnimation, Animation>();
    }

    public void addAnimation(EAnimation type, Animation animation){
        System.out.println("add animation: " + type);
        animations.put(type,animation);
    }

    public Animation getAnimation(EAnimation current) {
        return this.animations.get(current);
    }

    public Animation getCurrentAnimation() {
        System.out.println("current : " + this.current + " size: " + this.animations.size());
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
