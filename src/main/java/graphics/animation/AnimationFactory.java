package graphics.animation;

import game.gameObject.EGameObject;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.BufferedImageUtil;

import java.io.IOException;
import java.io.InputStream;
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


    public void init() throws SlickException, IOException {
        createPlayer();
        createBird();
        createRaccoon();
        createGate();
    }


    private void createPlayer() throws SlickException {
    ObjectAnimation objectAnimation = new ObjectAnimation();
    SpriteSheet spriteSheet = new SpriteSheet("sprites/player.png", 64, 64);

    objectAnimation.addAnimation(EAnimation.IDLE, loadAnimation(spriteSheet, 0, 31, 0));
    objectAnimation.addAnimation(EAnimation.MOVE_WALK, loadAnimation(spriteSheet, 0, 32, 2));
    gameobject.put(EGameObject.KEVIN, objectAnimation);
    }


    private void createGate() throws SlickException, IOException {
        ObjectAnimation gate = new ObjectAnimation();
        gate.addAnimation(EAnimation.IDLE, loadAnimation(getClass().getClassLoader().getResourceAsStream("sprites/portail.gif"),true,true));
        gameobject.put(EGameObject.GATE,gate);
    }

    private void createBird() throws SlickException{
        ObjectAnimation birdAnimation = new ObjectAnimation();
        SpriteSheet spriteSheet = new SpriteSheet("sprites/birdAnimation.png", 64,64);

        birdAnimation.addAnimation(EAnimation.IDLE, loadAnimation(spriteSheet,0,19,0));
        gameobject.put(EGameObject.BIRD,birdAnimation);
    }

    private void createRaccoon() throws SlickException{
        ObjectAnimation raccoonAnimation = new ObjectAnimation();
        SpriteSheet spriteSheet = new SpriteSheet("sprites/raccoon.png", 64,64);

        raccoonAnimation.addAnimation(EAnimation.IDLE, loadAnimation(spriteSheet,0,7,0));
        raccoonAnimation.addAnimation(EAnimation.ATTACK, loadAnimation(spriteSheet,0,9,1));
        gameobject.put(EGameObject.RACCOON,raccoonAnimation);
    }


    public Animation loadAnimation(InputStream inputStream, boolean looping, boolean pingpong) {
        Animation animation = new Animation();
        GIFDecoder d = new GIFDecoder();

        d.read(inputStream);
        for (int i = 0; i < d.getFrameCount(); ++i) {
            try {
                animation.addFrame(new Image(BufferedImageUtil.getTexture("gif", d.getFrame(i))), d.getDelay(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        animation.setLooping(looping);
        animation.setPingPong(pingpong);
        return animation;
    }

    public Animation loadReverseAnimation(InputStream inputStream, boolean looping, boolean pingpong) {
        Animation animation = new Animation();
        GIFDecoder d = new GIFDecoder();

        d.read(inputStream);
        for (int i = d.getFrameCount()-1; i >= 0; --i) {
            try {
                animation.addFrame(new Image(BufferedImageUtil.getTexture("gif", d.getFrame(i))), d.getDelay(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        animation.setLooping(looping);
        animation.setPingPong(pingpong);
        return animation;
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
