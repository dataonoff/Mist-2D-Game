package music;

import java.util.HashMap;

public class SoundManager {

    private static SoundManager instance = new SoundManager();
    private HashMap<ESound,Sound> soundHashMap;

    public SoundManager() {
        this.soundHashMap = new HashMap<ESound, Sound>();
    }

    public static SoundManager getInstance() {
        return instance;
    }

    public void init(){
        Sound teleport = new Sound("music/Goutte.wav");
        this.soundHashMap.put(ESound.TELEPORT,teleport);
    }

    public HashMap<ESound, Sound> getSoundHashMap() {
        return soundHashMap;
    }

    public void setSoundHashMap(HashMap<ESound, Sound> soundHashMap) {
        this.soundHashMap = soundHashMap;
    }
}
