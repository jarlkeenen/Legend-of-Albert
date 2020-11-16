package com.group4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestRun {
    Screen ss = new Screen();
    Cutscene cs = new Cutscene();
    ActionHandler action= new ActionHandler();
    String text = "For centuries, the city of Victorias has been protected by the soul of Albert, " +
            "an ancient soul passed down by its user which has now become a title for those deemed worthy to inherit it, " +
            "beset by dark forces unleashed long ago by the banished Dark Lord. Where this story starts, the city is " +
            "protected by Albert the protector, a brave and selfless hero embued by the soul that puts the lives and " +
            "protection of the people first but though this is your story, you are not Albert the Protector, " +
            "you are just an ordinary citizen, and this is your legend. ";

    TestRun() {
        //ss.StartScreen(action);\\
        cs.cutscene1(text, ".//resources//images//Cutscene (1).png",action);
    }

    public static void main(String[] args) {
        new TestRun();
    }


    class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ActionHandler action = new ActionHandler();
            String choice = e.getActionCommand();
            switch (choice) {
                case "start":
                    ss.Shop(action);
                case "next1": cs.skipText();
            }
        }
    }
}