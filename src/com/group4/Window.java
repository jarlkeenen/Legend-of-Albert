package com.group4;

/*
ALL SCENES WILL BE CODED HERE. CREATE NECESSARY FILES FOR OTHER STUFF LIKE AUDIO, LISTENERS, IMAGES IF POSSIBLE. TENKYU
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window extends Canvas {

    JFrame window;
    JPanel background,startButtonPanel;
    JLabel backimage;
    JButton startButton;
    Container con;
    ImageIcon image;
    Font normalFont = new Font("Arial",Font.PLAIN, 25);

    // Main menu screen is created when starting the application
    public void mainMenu(int width, int height, String title, Game game) {
        window = new JFrame(title);
        window.setTitle(title);
        window.setSize(width,height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.blue);
        window.setLayout(null);
        window.add(game);
        window.setResizable(false);
        con = window.getContentPane();

        background = new JPanel(new BorderLayout());
        background.setSize(1280,720);
        con.add(background);

        image = new ImageIcon(".//src//images//titleback.png");
        //Image backimg = image.getImage();
        //Image modifiedbackimg = backimg.getScaledInstance(width,height, Image.SCALE_SMOOTH);
        //image = new ImageIcon(modifiedbackimg);


        backimage = new JLabel();
        backimage.setIcon(image);
        background.add(backimage);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(520,635,300,150);
        startButtonPanel.setBackground(Color.blue);
        startButtonPanel.setOpaque(false);

        startButton = new JButton("PLAYS");
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(evt -> createGameScreen());
        startButton.setOpaque(false);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen() {
        System.out.println("button test worked");
    }

}
