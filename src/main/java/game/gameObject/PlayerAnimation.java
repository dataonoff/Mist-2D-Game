package game.gameObject;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class PlayerAnimation {

    private Animation[] animations = new Animation[4];
    private SpriteSheet spriteSheet = new SpriteSheet("sprites/player.png", 64, 64);

    public PlayerAnimation() throws SlickException {

        this.animations[0] = loadAnimation(spriteSheet, 0, 31, 0);
        this.animations[1] = loadAnimation(spriteSheet, 0, 31, 1);
        this.animations[2] = loadAnimation(spriteSheet, 0, 32, 2);
        this.animations[3] = loadAnimation(spriteSheet, 0, 32, 3);

    }

    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    public Animation[] getAnimations() {
        return animations;
    }

    public void setAnimations(Animation[] animations) {
        this.animations = animations;
    }
}
