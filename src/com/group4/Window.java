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
    Container con;
    Dimension conSize;
    JPanel background,startButtonPanel;
    JLabel backImage;
    JButton startButton;
    ImageIcon title;
    Font normalFont = new Font("Arial",Font.PLAIN, 25);

    public Window(int width, int height, String title) {
        window = new JFrame(title);
        window.pack();
        window.setTitle(title);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);
        con = window.getContentPane();
        conSize = new Dimension(con.getWidth(), con.getHeight());
        titleScreen();
    }

    // Main menu screen is created when starting the application
    public void titleScreen() {
        title = new ImageIcon(".//resources//images//Title.png");
        /* DELETE COMMENT TO TEST. IMAGE SIZE SHOULD BE EQUAL TO CON SIZE
        System.out.println(image.getIconWidth() + "  " + image.getIconHeight());
        System.out.println(con.getWidth() + "  " + con.getHeight());
        */
        backImage = new JLabel(title);

        background = new JPanel(new BorderLayout());
        background.setSize(conSize);
        background.add(backImage);
        con.add(background);

        startButton = new JButton("PLAYS");
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(evt -> mainMenu());
        startButton.setOpaque(false);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(520,635,300,150);
        startButtonPanel.setBackground(Color.blue);
        startButtonPanel.setOpaque(false);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void mainMenu() {
        System.out.println("button test worked");
    }

}
