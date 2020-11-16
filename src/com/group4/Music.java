package com.group4;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Music {
    Clip clip;
    public void setURL(String soundFilename){
        try{
            File file=new File(soundFilename);
            AudioInputStream sound= AudioSystem.getAudioInputStream(file);
            clip=AudioSystem.getClip();
            clip.open(sound);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
        }
        catch(Exception e){

        }

    }

    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop(){ clip.loop(Clip.LOOP_CONTINUOUSLY);}

    public void stop(){
        clip.stop();
        clip.close();
    }
}
