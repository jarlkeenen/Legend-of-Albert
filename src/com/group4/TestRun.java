package com.group4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestRun {
    Screen ss = new Screen();
    tutorialBattle tb = new tutorialBattle();
    ActionHandler action = new ActionHandler();

    TestRun(){
        tb.tutorial(action);
    }

    public static void main(String[] args) {
        new TestRun();
    }


    class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            switch (choice) {
                case "start": ss.Shop();
                case "attack": tb.attackInstructions(); break;
                case "defend": tb.defendInstructions(); break;
                case "potion": tb.potionInstructions(); break;
                case "retreat": System.out.println("Success"); break;
            }
        }
    }
}