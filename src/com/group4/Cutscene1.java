package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Cutscene1 {

    JFrame window;
    Container con;
    Dimension conSize;
    Cutscene CHpicker;

    JPanel cutscene,textPanel,nextButtonPanel;
    JLabel cutsceneImageLabel;
    JTextArea textArea;
    JButton nextButton;
    Font textFont = new Font("Times New Roman", Font.PLAIN, 18);
    String position;
    int i=0,soundCue=0;
    private String text;
    Player player;
    String imgPath;

    int cutsceneIden;
    cutsceneHandler CH = new cutsceneHandler();

    SoundEffect se= new SoundEffect();

    public Cutscene1(String text, String imgPath, Player player, JFrame window, Container con, int cutsceneIden) {

        /*
        this.window = window;
        this.con = con;
        this.text=text;

         */


        this.cutsceneIden = cutsceneIden;
        this.player = player;

        this.window= new JFrame();
        this.window.setSize(1296,759);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.getContentPane().setBackground(Color.BLACK);
        this.window.setLayout(null);
        this.window.setResizable(false);
        this.window.setLocationRelativeTo(null);
        this.con = this.window.getContentPane();
        this.text = text;
        this.imgPath = imgPath;

        CHpicker = new Cutscene(this.player, this.window, this.con);

        conSize = new Dimension(this.con.getWidth(), this.con.getHeight());

        drawCutscene();
    }

    public void drawCutscene() {

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
        //textArea.setOpaque(false);
        textPanel.add(textArea);

        nextButton=new JButton();
        nextButton.setForeground(new Color(0,0,0,0));
        nextButton.setBackground(new Color(0,0,0,0));
        nextButton.setPreferredSize(new Dimension(170,50));
        nextButton.setFocusPainted(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setOpaque(false);
        nextButton.addActionListener(CH);
        switch (cutsceneIden) {
            case 1: {
                nextButton.setActionCommand("1");
                break;
            }
            case 2: {
                nextButton.setActionCommand("2");
                break;
            }
            case 3: {
                nextButton.setActionCommand("3");
                break;
            }
            case 4: {
                nextButton.setActionCommand("4");
                break;
            }
            case 5: {
                nextButton.setActionCommand("5");
                break;
            }
            case 6: {
                nextButton.setActionCommand("6");
                break;
            }
            case 7: {
                nextButton.setActionCommand("7");
                break;
            }
            case 8: {
                nextButton.setActionCommand("8");
                break;
            }
        }

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

    public class cutsceneHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String c = event.getActionCommand();

            switch (c) {
                case "1": {
                    textTimer.stop();
                    se.stop();
                    new tutorialBattle(player, window, con);
                    break;
                }
                case "2": {
                    textTimer.stop();
                    se.stop();
                    CHpicker.cutscene3();
                    break;
                }
                case "3": {
                    textTimer.stop();
                    se.stop();
                    CHpicker.cutscene4();
                    break;
                }
                case "4": {
                    textTimer.stop();
                    se.stop();
                    int areaPicker = (int)(Math.random() * (3 - 1 + 1)) + 1;
                    String area;
                    switch (areaPicker) {
                        case 1: {
                            area = "ruins";
                            break;
                        }
                        case 2: {
                            area = "forest";
                            break;
                        }
                        case 3: {
                            area = "shore";
                            break;
                        }
                        default: {
                            area = "ruins";
                        }
                    }
                    try {
                        nextButton.setVisible(false);
                        textArea.setVisible(false);
                        cutsceneImageLabel.setVisible(false);
                        new TempleEncounter(window, con, player, area);
                    } catch (IOException | FontFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "5": {
                    textTimer.stop();
                    se.stop();
                    try {
                        nextButton.setVisible(false);
                        textArea.setVisible(false);
                        cutsceneImageLabel.setVisible(false);
                        new TempleEncounter(window, con, player, "boss");
                    } catch (IOException | FontFormatException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "6": {
                    textTimer.stop();
                    se.stop();
                    CHpicker.Ending2();
                    break;
                }
                case "7": {
                    textTimer.stop();
                    se.stop();
                    CHpicker.Ending3();
                    break;
                }
                case "8": {
                    textTimer.stop();
                    se.stop();
                    new Credits();
                    break;
                }
            }
        }
    }
}