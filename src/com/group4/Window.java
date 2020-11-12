package com.group4;

/*
ALL SCENES WILL BE CODED HERE. CREATE NECESSARY FILES FOR OTHER STUFF LIKE AUDIO, LISTENERS, IMAGES IF POSSIBLE. TENKYU
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window extends Canvas {

    JFrame frame;
    Container con;

    // Main menu screen is created when starting the application
    public void mainMenu(int width, int height, String title, Game game) {
        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);

        // edit lang ang design please, gin butangan ko na bali contents (indi ko ni kabalo so kamo bahala sa akon hahahah)
        JLabel titleText = new JLabel("Legend of Albert");
        JPanel background = new JPanel();
        background.setBounds(WIDTH/2, 100, WIDTH, 100);
        background.add(titleText);
        frame.add(background);

        JButton startButton = new JButton("START");
        background.setLocation(WIDTH/2, 500);
        startButton.setFocusPainted(false);
        startButton.addActionListener(evt -> createGameScreen());
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.add(startButton);
        frame.add(startButtonPanel);

        frame.setVisible(true);
        // game.startGame();
    }

    public void createGameScreen() {
        System.out.println("button test worked");
    }

}
