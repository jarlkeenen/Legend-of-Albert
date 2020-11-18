package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cutscene1 {

    JFrame window;
    Container con;

    JPanel cutscene,textPanel,nextButtonPanel;
    JLabel cutsceneImageLabel;
    JTextArea textArea;
    JButton nextButton;
    Font textFont = new Font("Arial", Font.PLAIN, 16);
    String position;
    private String text = "For centuries, the city of Victorias has been protected by the soul of Albert, an ancient soul passed down by its user which has now become a title for those deemed worthy to inherit it, beset by dark forces unleashed long ago by the banished Dark Lord. Where this story starts, the city is protected by Albert the protector, a brave and selfless hero embued by the soul that puts the lives and protection of the people first but though this is your story, you are not Albert the Protector, you are just an ordinary citizen, and this is your legend.";
    int i=0,soundCue=0;

    Player player;

    SoundEffect se= new SoundEffect();

    public Cutscene1(Player player, String text, String imgPath, JFrame w, Container c) {

        /*
        this.window = window;
        this.con = con;
        this.text=text;
         */

        window= new JFrame();
        window.setSize(1296,759);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        con=window.getContentPane();

        position = "cutscene1";
        ImageIcon cutsceneImage = new ImageIcon(imgPath);
        cutscene = new JPanel();
        cutscene.setBounds(0, 0, 1296, 759);
        cutscene.setBackground(Color.red);
        cutscene.setOpaque(false);

        cutsceneImageLabel = new JLabel(cutsceneImage);


        cutscene.add(cutsceneImageLabel);

        textPanel=new JPanel();
        textPanel.setBounds(100,550,1000,200);
        textPanel.setBackground(new Color(0,0,0,0));
        textPanel.setOpaque(false);

        textArea = new JTextArea();
        textArea.setBounds(0, 0, 1000, 200);
        textArea.setBackground(new Color(0, 0, 0, 0));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(textFont);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textPanel.add(textArea);

        nextButton=new JButton();
        nextButton.setForeground(new Color(0,0,0,0));
        nextButton.setBackground(new Color(0,0,0,0));
        nextButton.setPreferredSize(new Dimension(170,50));
        nextButton.setFocusPainted(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setOpaque(false);
        nextButton.addActionListener(evt -> skip());
        nextButton.setActionCommand("next1");

        nextButtonPanel= new JPanel();
        nextButtonPanel.setBounds(1100,650,170,50);
        nextButtonPanel.setBackground(Color.blue);
        nextButtonPanel.setOpaque(false);
        nextButtonPanel.add(nextButton);

        prepareText();

        this.con.add(cutscene);
        this.con.add(textPanel);
        this.con.add(nextButtonPanel);
        this.window.setVisible(true);

    }

    Timer textTimer = new Timer(80, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            char ch[] = text.toCharArray();
            int arrnum = ch.length;

            String addedCH = "";
            String blank = "";
            addedCH = blank + ch[i];
            textArea.append(addedCH);

            i++;
            soundCue++;
            if (soundCue == 2) {
                String soundeffect = ".//resources//audio//type.wav";
                se.setURL(soundeffect);
                se.play();
                soundCue = 0;
            }
            if (i == arrnum) {
                i = 0;
                textTimer.stop();
            }
        }
    });

    public void prepareText () {
        i = 0;
        textArea.setText("");
        textTimer.start();
    }

    public void skipText(){
        textTimer.stop();
        textArea.setText(text);
        i=0;
    }

    public void skip() {
        textTimer.stop();
        new tutorialBattle(player, window, con);
    }
}