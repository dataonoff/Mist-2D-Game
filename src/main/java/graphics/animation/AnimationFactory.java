package graphics.animation;

import game.gameObject.EGameObject;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.HashMap;

public class AnimationFactory {

    private static AnimationFactory instance = new AnimationFactory();

    private AnimationFactory() {
        this.gameobject = new HashMap<EGameObject, ObjectAnimation>();
    }

    public static AnimationFactory getInstance() {
        return instance;
    }

    private HashMap<EGameObject,ObjectAnimation> gameobject;

    public void init() throws SlickException {
        createPlayer();
    }


    private void createPlayer() throws SlickException {
    ObjectAnimation objectAnimation = new ObjectAnimation();
    SpriteSheet spriteSheet = new SpriteSheet("sprites/player.png", 64, 64);

    objectAnimation.addAnimation(EAnimation.IDLE, loadAnimation(spriteSheet, 0, 31, 0));
    objectAnimation.addAnimation(EAnimation.MOVE_WALK, loadAnimation(spriteSheet, 0, 32, 2));

    gameobject.put(EGameObject.KEVIN, objectAnimation);
    }

    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    public ObjectAnimation getObjectAnimation(EGameObject eGameObject){
        return gameobject.get(eGameObject);
    }
}
