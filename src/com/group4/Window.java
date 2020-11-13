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
    JPanel background;
    JLabel backimage;
    Container con;
    ImageIcon image;

    // Main menu screen is created when starting the application
    public void mainMenu(int width, int height, String title, Game game) {
        window = new JFrame(title);
        window.setTitle(title);
        window.setSize(width,height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.blue);
        window.setLayout(null);
        window.add(game);
        con = window.getContentPane();

        background = new JPanel();
        background.setBounds(0, 0, width, height);
        con.add(background);

        image = new ImageIcon(".//src//images//TitleScreenImage.png");
        Image backimg = image.getImage();
        Image modifiedbackimg = backimg.getScaledInstance(width,height, Image.SCALE_SMOOTH);
        image = new ImageIcon(modifiedbackimg);

        backimage = new JLabel();
        backimage.setIcon(image);
        background.add(backimage);

        window.setVisible(true);
    }

    public void createGameScreen() {
        System.out.println("button test worked");
    }

}
