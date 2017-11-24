package music;

import org.newdawn.slick.SlickException;

public class Sound {

org.newdawn.slick.Sound sound;
String soundName;

    public Sound(String soundName) {
        this.soundName = soundName;
        try {
            this.sound = new org.newdawn.slick.Sound(soundName);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void play(){
        this.sound.play();
    }
}
