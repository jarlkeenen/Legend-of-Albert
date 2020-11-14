package com.group4;

/*
ALL SCENES WILL BE CODED HERE. CREATE NECESSARY FILES FOR OTHER STUFF LIKE AUDIO, LISTENERS, IMAGES IF POSSIBLE. TENKYU
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class Window extends Canvas {

    JFrame window;
    Container con;
    Dimension conSize;
    JPanel background;
    JLabel backImage;
    ImageIcon title;
    String position, music = "yes";

    //Button:
    JButton startButton, Cbutton, NGbutton, Qbutton;
    JPanel startButtonPanel, Cpanel, NGpanel, Qpanel;

    //may font kay gina size nila ang buttons for some reason lol
    Font normalFont = new Font("Arial",Font.PLAIN, 25);
    Font NGFont = new Font("Arial",Font.PLAIN, 15);
    Font QFont = new Font("Arial",Font.PLAIN, 20);
    ButtonHandler bHandler = new ButtonHandler();

    //Music:
    String TM,sfx;
    Music mu = new Music();

    public Window(int width, int height, String title) {
        window = new JFrame(title);
        window.pack();
        window.setSize(width,height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.blue);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);
        con = window.getContentPane();
        conSize = new Dimension(con.getWidth(), con.getHeight());
        titleScreen();
    }

    // Title Screen is created when starting the application
    public void titleScreen() {
        position = "no";
        TM = ".//resources//audio//opening music.wav";
        
            mu.setFile(TM);
            mu.play();
            mu.loop();

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
        startButton.addActionListener(evt -> createGameScreen());
        startButton.setOpaque(false);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(520,635,300,150);
        startButtonPanel.setBackground(Color.blue);
        startButtonPanel.setOpaque(false);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen() {
        System.out.println("button test worked");
        Menu1();
    }

    public void Menu1(){
        position = "m1";
        startButton.setVisible(false);
        backImage.setIcon(new ImageIcon(".//resources//images//CMenu.png"));

        Cbutton = new JButton("CONTINUESSSSSSS");
        Cbutton.setForeground(Color.white);
        Cbutton.setFont(normalFont);
        Cbutton.addActionListener(bHandler);
        Cbutton.setActionCommand("cb");
        Cbutton.setOpaque(false);
        Cpanel = new JPanel();
        Cpanel.setBounds(-18,435,600,150);
        Cpanel.setBackground(Color.blue);
        Cpanel.setOpaque(false);
        Cpanel.add(Cbutton);
        con.add(Cpanel);

        NGbutton = new JButton("NEWGAMESSSSSSSSSSSSS");
        NGbutton.setForeground(Color.white);
        NGbutton.setFont(NGFont);
        NGbutton.addActionListener(bHandler);
        NGbutton.setActionCommand("ngb");
        NGbutton.setOpaque(false);
        NGpanel = new JPanel();
        NGpanel.setBounds(5,485,500,150);
        NGpanel.setBackground(Color.blue);
        NGpanel.setOpaque(false);
        NGpanel.add(NGbutton);
        con.add(NGpanel);

        Qbutton = new JButton("QUITS");
        Qbutton.setForeground(Color.white);
        Qbutton.setFont(QFont);
        Qbutton.addActionListener(bHandler);
        Qbutton.setActionCommand("qb");
        Qbutton.setOpaque(false);
        Qpanel = new JPanel();
        Qpanel.setBounds(34,517,300,150);
        Qpanel.setBackground(Color.blue);
        Qpanel.setOpaque(false);
        Qpanel.add(Qbutton);
        con.add(Qpanel);
    }

    public void ConMenu () {
        position = "CM";
        Cbutton.setVisible(false);
        NGbutton.setVisible(false);
        Qbutton.setVisible(false);
        backImage.setIcon(new ImageIcon(".//resources//images//MenuC.png"));
    }

    public void NwgMenu () {
        position = "NGM";
        Cbutton.setVisible(false);
        NGbutton.setVisible(false);
        Qbutton.setVisible(false);
        backImage.setIcon(new ImageIcon(".//resources//images//MenuNG.png"));
    }

    public void QuitMenu () {
        mu.stop();
        position = "QM";
        Cbutton.setVisible(false);
        NGbutton.setVisible(false);
        Qbutton.setVisible(false);
        backImage.setIcon(new ImageIcon(".//resources//images//Title.png"));
        titleScreen();
    }

    public class Music{
        Clip clip;

        public void setFile(String soundFileName){

            try{
                File file = new File(soundFileName);
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
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

        public void loop(){

            clip.loop(Clip.LOOP_CONTINUOUSLY);

        }

        public void stop(){
            clip.stop();
            clip.close();
        }
    }

    public class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            sfx = ".//resources//audio//click sound2 (1).wav";
            mu.setFile(sfx);
            mu.play();

            String yourChoice = event.getActionCommand();

            if (!position.equals("no")) {
                switch (position) {
                    case "m1":
                        switch (yourChoice) {
                            case "cb":
                                ConMenu();
                                break;
                            case "ngb":
                                NwgMenu();
                                break;
                            case "qb":
                                QuitMenu();
                                break;
                        }
                }
            }
        }
    }
}
