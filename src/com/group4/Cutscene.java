package com.group4;

import javax.swing.*;
import java.awt.*;

public class Cutscene {
    String text;
    JFrame window;
    Container con;
    String imgPath;
    public void cutscene1(){
        this.text = "For centuries, the city of Victorias has been protected by the soul of Albert, "
                +"an ancient soul passed down by its user which has now become a title for those deemed worthy to inherit it,"
                +" beset by dark forces unleashed long ago by the banished Dark Lord. "
                +"Where this story starts, the city is protected by Albert the protector, "+"" +
                "a brave and selfless hero embued by the soul that puts the lives and protection of the people first but "
                +"though this is your story, you are not Albert the Protector, you are just an ordinary citizen, "
                +"and this is your legend.";
        imgPath=".//resources//images//Cutscene.png";
        new Cutscene1(text,imgPath,window,con);
    }

    public void cutscene2(){
        this.text="As you are wandering around the outskirts of Victorias, the City is suddenly attacked by monsters. "+
                "You rush back to find the people being taken away and in a moment of clarity, you see your mentor, "
               +"Master Jim disappear with the rest.";
        //Due to wrong naming cutscene 3 image is swapped with cutscene 2
        imgPath=".//resources//images//Cutscene (3).png";
        new Cutscene1(text,imgPath,window,con);
    }
    public void cutscene3(){
        text="You sprint towards him but is stopped by a monster. Before he kills you, he speaks of your futility."
                +" \'Foolish Victorian, you cannot prevent the return of the Dark Lord!"
                +" \"He\" will be resurrected at Mt.Kanlaon and lead his dark legion once again! Die!\' " +
                " As the his weapon swings to finish you off, Albert the Protector arrives and pushes you away, " +
                "receiving the blow instead. ";
        imgPath=".//resources//images//Cutscene (2).png";
        new Cutscene1(text,imgPath,window,con);
    }

    public void cutscene4(){
        text="Albert the Protector lays dying on your hands after selflessly sacrificing himself for you, "
                +"with his last words he tells you. "
                +"\'I have cleansed the city of the rest, inherit my soul, kill their warchief here and the "
                +"rest will scatter and finally rescue the captives from Mt. Kanlaon. Save Victorias.\' " +
                "His body vanishes and you are imbued with the soul of Albert, you have become Albert." +
                " You again face the Monster now as Albert the Savior.";
        imgPath=".//resources//images//Cutscene (4).png";
        new Cutscene1(text,imgPath,window,con);
    }
    public void beforeFinalBattle(){
        text="You have come in vain, Victorian. The Dark Lord has"
            + "  already been unleashed."
            + "\'-You will now face DEATH!-\'";
        imgPath=".//resources//images//BeforeBossFightCutscene.jpg";
        new Cutscene1(text,imgPath,window,con);
    }
    public void Ending1(){
        text="With the defeat of the Dark Lord by the hands of the new Albert, "
                +"Master Jim was again released from his own darkness and returned to Victorias with the Hero to bid "
                +"farewell and forgiveness to the people as evident that darkness will forever follow him for power. "
                +"He set off to the Barren waste of the West, never to be heard from again.";
        imgPath=".//resources//images//Ending (1).jpg";
        new Cutscene1(text,imgPath,window,con);
    }
    public void Ending2(){
        text="Before leaving, Master Jim and the people of Victorias name the new Albert as "
                +"\"Albert the Savior\". The new generation of Victorians prospered as decades pass, "
                +"the city expanded and cleansed the nearby territories monsters. "
                +"All had become well under Albert The Savior but what what the Hero did not know was the secret of the "
                +"foundation of Victorias.";
        imgPath=".//resources//images//Ending (2).jpg";
        new Cutscene1(text,imgPath,window,con);
    }
    public void Ending3(){
        text= "A secret that lies dormant and forgotten underneath the surface and murky depths of Victorias "
                +"that will once again shake the stability of the world. ";
        imgPath=".//resources//images//Ending (3).jpg";
        new Cutscene1(text,imgPath,window,con);
    }

}
