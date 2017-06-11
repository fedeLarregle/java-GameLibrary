package com.puebla.TiledGame.manager;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author federico on 11/06/17.
 */
public class Sound {

    private final static Sound instance;
    private final HashMap<String, Clip> sounds;

    static {
        instance = new Sound();
    }

    private Sound(){
        sounds = new HashMap<>();
    }

    public static Sound getInstance() { return instance; }

    public void load(String soundName, String path) {
        Clip clip;
        if ( sounds.get(soundName) == null ) {
            AudioInputStream soundStream = null;
            try {
                soundStream = AudioSystem.getAudioInputStream(Sound.class.getClassLoader().getResourceAsStream(soundName));
                AudioFormat format = soundStream.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);
                clip = ((Clip)AudioSystem.getLine(info));
                clip.open(soundStream);

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    soundStream.close();
                } catch (IOException ioe) { ioe.printStackTrace(); }
            }
        }
    }

    public void play(String sound) {
        play(sound, 0);
    }

    public void play(String sound, int position) {
        if ( sounds.get(sound) != null ) {
            Clip clip = sounds.get(sound);
            if ( clip.isRunning() ) { clip.stop(); }
            clip.setFramePosition(position);
            clip.start();
        }
    }

    public void stop(String sound) {
        if ( sounds.get(sound) != null) { sounds.get(sound).stop(); }
    }

    public void loop(String sound) {
        if ( sounds.get(sound) != null ) { sounds.get(sound).loop(Clip.LOOP_CONTINUOUSLY);}
    }

    public void close(String sound) {
        if ( sounds.get(sound) != null ) {
            sounds.get(sound).stop();
            sounds.get(sound).close();
        }
    }
}
