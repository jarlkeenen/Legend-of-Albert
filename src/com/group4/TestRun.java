package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestRun {
    Screen ss = new Screen();
    ActionHandler action = new ActionHandler();

    TestRun() {
        ss.StartScreen(action);
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
            }
        }
    }
}