package graphics.animation;

import game.gameObject.EGameObject;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.HashMap;

public class AnimationFactory {

    private static AnimationFactory instance = new AnimationFactory();
    private HashMap<EGameObject,ObjectAnimation> gameobject;

    private AnimationFactory() {
        this.gameobject = new HashMap<EGameObject, ObjectAnimation>();
    }

    public static AnimationFactory getInstance() {
        return instance;
    }


    public void init() throws SlickException {
        createPlayer();
        createBird();
        createRaccoon();
    }


    private void createPlayer() throws SlickException {
    ObjectAnimation objectAnimation = new ObjectAnimation();
    SpriteSheet spriteSheet = new SpriteSheet("sprites/player.png", 64, 64);

    objectAnimation.addAnimation(EAnimation.IDLE, loadAnimation(spriteSheet, 0, 31, 0));
    objectAnimation.addAnimation(EAnimation.MOVE_WALK, loadAnimation(spriteSheet, 0, 32, 2));
    gameobject.put(EGameObject.KEVIN, objectAnimation);
    }

    private void createBird() throws SlickException{
        ObjectAnimation birdAnimation = new ObjectAnimation();
        SpriteSheet spriteSheet = new SpriteSheet("sprites/birdAnimation.png", 64,64);

        birdAnimation.addAnimation(EAnimation.FLY, loadAnimation(spriteSheet,0,19,0));
        gameobject.put(EGameObject.BIRD,birdAnimation);
    }

    private void createRaccoon() throws SlickException{
        ObjectAnimation raccoonAnimation = new ObjectAnimation();
        SpriteSheet spriteSheet = new SpriteSheet("sprites/raccoon.png", 64,64);

        raccoonAnimation.addAnimation(EAnimation.MOVE_WALK, loadAnimation(spriteSheet,0,7,0));
        raccoonAnimation.addAnimation(EAnimation.ATTACK, loadAnimation(spriteSheet,0,9,1));
        gameobject.put(EGameObject.RACCOON,raccoonAnimation);
    }


    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    public ObjectAnimation getObjectAnimation(EGameObject eGameObject){
        return new ObjectAnimation(gameobject.get(eGameObject));
    }
}
