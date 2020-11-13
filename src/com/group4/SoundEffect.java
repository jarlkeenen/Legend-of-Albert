package com.group4;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class SoundEffect {
Clip clip;
    public void setURL(String soundFilename){
        try{
            File file=new File(soundFilename);
            AudioInputStream sound= AudioSystem.getAudioInputStream(file);
            clip=AudioSystem.getClip();
            clip.open(sound);

        }
        catch(Exception e){

        }

    }

    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }
}
