package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
COMMENTED OUT MOST CODE HERE AND TRANSFERRED THE class ActionHandler TO tutorialBattle.java
-JARL
*/

public class CombatTutorial {
    Screen ss = new Screen();
    ActionHandler action = new ActionHandler();
    //tutorialBattle tb = new tutorialBattle(n);

    CombatTutorial(Player player, JFrame window, Container con, JLabel backImage){
        //tb.tutorial(action, player, window, con);
    }

    class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String choice = e.getActionCommand();
            switch (choice) {
                case "start":
                    //ss.Shop(this);
                    break;
                case "attack":
                    //tb.attackInstructions();
                    break;
                case "defend":
                    //tb.defendInstructions();
                    break;
                case "potion":
                    //tb.potionInstructions();
                    break;
                case "retreat":
                    System.out.println("Success");
                    break;
            }
        }
    }
}