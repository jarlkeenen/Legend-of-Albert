package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cutscene {
    //Jframe
    JFrame window;
    Container con;

    //
    JPanel cutscene,textPanel,nextButtonPanel;
    JLabel cutsceneImage;
    JTextArea textArea;
    JButton nextButton;
    Font textFont = new Font("Arial", Font.PLAIN, 16);
    String position;
    private String text;
    int i=0,soundCue=0;

    SoundEffect se= new SoundEffect();

    public void cutscene1(String text, String imgPath, TestRun.ActionHandler action) {
        //delete this if needed to copy paste code to inside of class with existing JFrame
        window = new JFrame();
        window.pack();
        window.setSize(new Dimension(1296, 759));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);
        con = window.getContentPane();
        //
        this.text=text;
        position = "cutscene1";
        ImageIcon cutscenceImage = new ImageIcon(imgPath);
        cutscene = new JPanel();
        cutscene.setBounds(0, 0, 1296, 759);
        cutscene.setBackground(Color.red);
        cutscene.setOpaque(false);

        cutsceneImage = new JLabel();
        cutsceneImage.setIcon(cutscenceImage);


        cutscene.add(cutsceneImage);

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
        nextButton.addActionListener(action);
        nextButton.setActionCommand("next1");

        nextButtonPanel= new JPanel();
        nextButtonPanel.setBounds(1100,650,170,50);
        nextButtonPanel.setBackground(Color.blue);
        nextButtonPanel.setOpaque(false);
        nextButtonPanel.add(nextButton);

        prepareText();

        con.add(cutscene);
        con.add(textPanel);
        con.add(nextButtonPanel);
        window.setVisible(true);

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
}