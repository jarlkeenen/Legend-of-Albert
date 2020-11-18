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
import javax.swing.Timer;

public class Window extends Canvas {

    SaveFile SaveFilePath = new SaveFile();
    File savesFolder = new File(SaveFilePath.saveFilesPath);

    JFrame window;
    Container con;
    Dimension conSize;
    JPanel background, inputPanel;
    JLabel backImage;
    ImageIcon title;
    String position, music = "yes";
    JTextField inputF;

    //Button:
    JButton startButton, Cbutton, NGbutton, Qbutton, backB, slot1b, slot2b, slot3b, OWyesB, OWnoB, Pescb, Omecb, Somb, Createb;
    JPanel startButtonPanel, Cpanel, NGpanel, Qpanel, backP, slot1p, slot2p, slot3p, OWyesP, OWnoP, Pescp, Omecp, Somp, Createp;

    //may font kay gina size nila ang buttons for some reason lol
    Font normalFont = new Font("Arial",Font.PLAIN, 25);
    Font NGFont = new Font("Arial",Font.PLAIN, 15);
    Font QFont = new Font("Arial",Font.PLAIN, 20);
    Font slotFont = new Font("Arial",Font.PLAIN, 77);
    Font raceFont = new Font("Arial",Font.PLAIN, 18);
    ButtonHandler bHandler = new ButtonHandler();
    TestRun TR;

    //for player
    String pname = null, prace;
    int playnum, phealth, pattack, pdefense;

    //Music:
    String TM,sfx;
    Music mu = new Music();
    SoundEffect se = new SoundEffect();

    int overwrite;
    boolean racechange = false;
    boolean isTMPlaying = false;
    boolean ExistingPlayer;

    //possibly unnecessary variable but needed to fix glitch lol
    int glitch = 0;

    public Window(int width, int height, String title, boolean existingSaveFile) {

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

        ExistingPlayer = existingSaveFile;

        titleScreen();
    }

    // Main menu screen is created when starting the application
    public void titleScreen() {
        position = "ts";
        TM = ".//resources//audio//opening music.wav";
        String titleImagePath = ".//resources//images//Title.png";

        /* DELETE COMMENT TO TEST. IMAGE SIZE SHOULD BE EQUAL TO CON SIZE
        System.out.println(image.getIconWidth() + "  " + image.getIconHeight());
        System.out.println(con.getWidth() + "  " + con.getHeight());
        */
        if (glitch == 0) {
            timer.start();

            startButton = new JButton("PLAYS");
            startButton.setEnabled(false);
            title = new ImageIcon(".//resources//images//Normal_loading3F.gif");
            backImage = new JLabel(title);

            background = new JPanel(new BorderLayout());
            background.setSize(conSize);
            background.add(backImage);
            con.add(background);
        }
        else {
            startButton = new JButton("PLAYS");
            backImage.setIcon(new ImageIcon(titleImagePath));
        }

        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
		
        startButton.addActionListener(evt -> mainMenu()); // CHANGE BACK TO MAINMENU AFTER FINISHING RANDOM ENCOUNTER CODE
        startButton.addActionListener(bHandler);
        startButton.setOpaque(false);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(520,635,300,150);
        startButtonPanel.setBackground(Color.blue);
        startButtonPanel.setOpaque(false);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);
        startButton.setVisible(true);
        if (backImage.getIcon().toString().equals(titleImagePath)) {
            startButton.setEnabled(true);
        }

        window.setVisible(true);
    }

    // DELETE AFTER FINISHING RANDOM ENCOUNTER CODE
    public void templeTest() {
        background.setVisible(false);
        startButton.setVisible(false);
        startButton.setEnabled(false);
        Player player = new Player(1);
        new TempleEncounter(window, con, player, "forest");
    }

    public void mainMenu() {
        glitch++;
        System.out.println("button test worked");
        if (ExistingPlayer) {
            Menu1();
        }
        else {
            Menu0();
        }
    }

    public void Menu0 () {
        position = "m0";

        startButton.setVisible(false);
        backImage.setIcon(new ImageIcon(".//resources//images//NGMenu.png"));

        NGbutton = new JButton("NEWGAMESSSSSSSSSSSSS");
        NGbutton.setForeground(Color.white);
        NGbutton.setFont(NGFont);
        NGbutton.addActionListener(bHandler);
        NGbutton.setActionCommand("ngb");
        NGbutton.setOpaque(false);
        NGpanel = new JPanel();
        NGpanel.setBounds(0,455,500,150);
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
        Qpanel.setBounds(25,487,300,150);
        Qpanel.setBackground(Color.blue);
        Qpanel.setOpaque(false);
        Qpanel.add(Qbutton);
        con.add(Qpanel);
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
        Cpanel.setBounds(-69,450,700,150);
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
        NGpanel.setBounds(5,495,500,150);
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
        Qpanel.setBounds(34,530,300,150);
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

        backB = new JButton("BACK");
        backB.setForeground(Color.white);
        backB.setFont(slotFont);
        backB.addActionListener(bHandler);
        backB.setActionCommand("back");
        backB.setOpaque(false);
        backP = new JPanel();
        backP.setBounds(20, 10, 150, 40);
        backP.setBackground(Color.blue);
        backP.setOpaque(false);
        backP.add(backB);
        con.add(backP);

        slot1b = new JButton("            s            ");
        slot1b.setForeground(Color.white);
        slot1b.setFont(slotFont);
        slot1b.addActionListener(bHandler);
        slot1b.setOpaque(false);
        slot1p = new JPanel();
        slot1p.setBounds(242,210,800,770);
        slot1p.setBackground(Color.blue);
        slot1p.setOpaque(false);
        slot1p.add(slot1b);
        con.add(slot1p);

        slot2b = new JButton("            s            ");
        slot2b.setForeground(Color.white);
        slot2b.setFont(slotFont);
        slot2b.addActionListener(bHandler);
        slot2b.setOpaque(false);
        slot2p = new JPanel();
        slot2p.setBounds(242,330,800,770);
        slot2p.setBackground(Color.blue);
        slot2p.setOpaque(false);
        slot2p.add(slot2b);
        con.add(slot2p);

        slot3b = new JButton("            s            ");
        slot3b.setForeground(Color.white);
        slot3b.setFont(slotFont);
        slot3b.addActionListener(bHandler);
        slot3b.setOpaque(false);
        slot3p = new JPanel();
        slot3p.setBounds(242,460,800,770);
        slot3p.setBackground(Color.blue);
        slot3p.setOpaque(false);
        slot3p.add(slot3b);
        con.add(slot3p);
    }

    public void NwgMenu () {
        if (position.equals("m1")) {
            Cbutton.setVisible(false);
        }
        NGbutton.setVisible(false);
        Qbutton.setVisible(false);
        backImage.setIcon(new ImageIcon(".//resources//images//MenuNG.png"));

        position = "NGM";

        backB = new JButton("BACK");
        backB.setForeground(Color.white);
        backB.setFont(slotFont);
        backB.addActionListener(bHandler);
        backB.setActionCommand("back");
        backB.setOpaque(false);
        backP = new JPanel();
        backP.setBounds(20, 10, 150, 40);
        backP.setBackground(Color.blue);
        backP.setOpaque(false);
        backP.add(backB);
        con.add(backP);

        slot1b = new JButton("            s            ");
        slot1b.setForeground(Color.white);
        slot1b.setFont(slotFont);
        slot1b.addActionListener(bHandler);
        slot1b.setActionCommand("Player1");
        slot1b.setOpaque(false);
        slot1p = new JPanel();
        slot1p.setBounds(242,210,800,770);
        slot1p.setBackground(Color.blue);
        slot1p.setOpaque(false);
        slot1p.add(slot1b);
        con.add(slot1p);

        slot2b = new JButton("            s            ");
        slot2b.setForeground(Color.white);
        slot2b.setFont(slotFont);
        slot2b.addActionListener(bHandler);
        slot2b.setActionCommand("Player2");
        slot2b.setOpaque(false);
        slot2p = new JPanel();
        slot2p.setBounds(242,330,800,770);
        slot2p.setBackground(Color.blue);
        slot2p.setOpaque(false);
        slot2p.add(slot2b);
        con.add(slot2p);

        slot3b = new JButton("            s            ");
        slot3b.setForeground(Color.white);
        slot3b.setFont(slotFont);
        slot3b.addActionListener(bHandler);
        slot3b.setActionCommand("Player3");
        slot3b.setOpaque(false);
        slot3p = new JPanel();
        slot3p.setBounds(242,460,800,770);
        slot3p.setBackground(Color.blue);
        slot3p.setOpaque(false);
        slot3p.add(slot3b);
        con.add(slot3p);
    }

    // DIRI I BUTANG ANG YES AND NO BUTTONS JEZZ
    public void overwrite() {
        position = "OW";
        backB.setVisible(false);
        slot1b.setVisible(false);
        slot2b.setVisible(false);
        slot3b.setVisible(false);
        backImage.setIcon(new ImageIcon(".//resources//images//Overwrite.png"));

    }

    public void back() {
        backB.setVisible(false);
        slot1b.setVisible(false);
        slot2b.setVisible(false);
        slot3b.setVisible(false);
        if (ExistingPlayer) {
            Menu1();
        }
        else {
            Menu0();
        }
    }

    public void QuitMenu () {
        if (position.equals("m1")) {
            Cbutton.setVisible(false);
        }
        NGbutton.setVisible(false);
        Qbutton.setVisible(false);
        titleScreen();
    }

    public void CreateChar () {
        slot1b.setVisible(false);
        slot2b.setVisible(false);
        slot3b.setVisible(false);
        if (!racechange) {
            backImage.setIcon(new ImageIcon(".//resources//images//CreatePlayer.png"));
        }
        position = "CC";

        inputPanel = new JPanel();
        inputPanel.setBounds(250,625,200,50);
        inputPanel.setBackground(Color.white);
        inputPanel.setLayout(new GridLayout(1,1));
        inputF = new JTextField(15);
        inputF.setFont(new Font("Tahoma",Font.PLAIN, 50));
        inputPanel.add(inputF);
        con.add(inputPanel);

        Pescb = new JButton("Pescadorianssssssssssssss");
        Pescb.setForeground(Color.white);
        Pescb.setFont(raceFont);
        Pescb.addActionListener(bHandler);
        Pescb.setActionCommand("Pes");
        Pescb.setOpaque(false);
        Pescp = new JPanel();
        Pescp.setBounds(-375,95,1250,150);
        Pescp.setBackground(Color.blue);
        Pescp.setOpaque(false);
        Pescp.add(Pescb);
        con.add(Pescp);

        Somb = new JButton("Pescadorianssssssssss");
        Somb.setForeground(Color.white);
        Somb.setFont(raceFont);
        Somb.addActionListener(bHandler);
        Somb.setActionCommand("Som");
        Somb.setOpaque(false);
        Somp = new JPanel();
        Somp.setBounds(-245,135,950,150);
        Somp.setBackground(Color.blue);
        Somp.setOpaque(false);
        Somp.add(Somb);
        con.add(Somp);

        Omecb = new JButton("Pescadorianssssssssssss");
        Omecb.setForeground(Color.white);
        Omecb.setFont(raceFont);
        Omecb.addActionListener(bHandler);
        Omecb.setActionCommand("Ome");
        Omecb.setOpaque(false);
        Omecp = new JPanel();
        Omecp.setBounds(-264,173,1000,150);
        Omecp.setBackground(Color.blue);
        Omecp.setOpaque(false);
        Omecp.add(Omecb);
        con.add(Omecp);

        Createb = new JButton("PLAYSSSSSS");
        Createb.setForeground(Color.white);
        Createb.setFont(raceFont);
        Createb.addActionListener(bHandler);
        Createb.setActionCommand("Create");
        Createb.setOpaque(false);
        Createp = new JPanel();
        Createp.setBounds(859,636,600,150);
        Createp.setBackground(Color.blue);
        Createp.setOpaque(false);
        Createp.add(Createb);
        con.add(Createp);
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
                System.out.println("An error occurred.");
                e.printStackTrace();
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

    public class SoundEffect{
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
                System.out.println("An error occurred.");
                e.printStackTrace();
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

    //change to 15000 as delay, gin 1k ko lng para dasig check sng gui
    Timer timer = new Timer(1000,new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            backImage.setIcon(new ImageIcon(".//resources//images//Title.png"));
            startButton.setEnabled(true);
            if (!isTMPlaying) {
                mu.setFile(TM);
                mu.play();
                mu.loop();
                isTMPlaying = true;
            }
            timer.stop();
        }
    });

    public class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            sfx = ".//resources//audio//click sound2 (1).wav";
            se.setFile(sfx);
            se.play();

            String yourChoice = event.getActionCommand();

            if (!position.equals("ts")) {
                switch (position) {
                    case "m1":
                    case "m0":
                        switch (yourChoice) {
                            case "ngb":
                                NwgMenu();
                                break;
                            case "qb":
                                QuitMenu();
                                break;
                            case "cb":
                                ConMenu();
                                break;
                        }
                        break;
                    case "CM":
                        switch (yourChoice) {
                            case "back":
                                back();
                                break;
                            case "slot1":
                                break;
                        }
                        break;
                    case "NGM":
                        switch (yourChoice) {
                            case "back":
                                back();
                                break;
                            case "Player1":
                                playnum = 1;
                                File saveFile1 = new File(SaveFilePath.saveFilesPath + "\\Slot " + playnum + ".txt");
                                if (saveFile1.exists()) {
                                    overwrite();
                                }
                                else {
                                    CreateChar();
                                }
                                break;
                            case "Player2":
                                playnum = 2;
                                File saveFile2 = new File(SaveFilePath.saveFilesPath + "\\Slot " + playnum + ".txt");
                                if (saveFile2.exists()) {
                                    overwrite();
                                }
                                else {
                                    CreateChar();
                                }
                                break;
                            case "Player3":
                                playnum = 3;
                                File saveFile3 = new File(SaveFilePath.saveFilesPath + "\\Slot " + playnum + ".txt");
                                if (saveFile3.exists()) {
                                    overwrite();
                                }
                                else {
                                    CreateChar();
                                }
                                break;
                        }
                        break;
                    case "OW":
                        switch (yourChoice) {
                            case "OWyes":
                                OWyesB.setVisible(false);
                                OWnoB.setVisible(false);
                                CreateChar();
                                break;
                            case "OWno":
                                OWyesB.setVisible(false);
                                OWnoB.setVisible(false);
                                NwgMenu();
                                break;
                        }
                    case "CC":
                        switch (yourChoice) {
                            case "Pes":
                                backImage.setIcon(new ImageIcon(".//resources//images//Pescadorian.png"));
                                racechange = true;
                                prace = "Pescadorian";
                                phealth = 60;
                                pattack = 10;
                                pdefense = 10;
                                break;
                            case "Som":
                                backImage.setIcon(new ImageIcon(".//resources//images//Somanian.png"));
                                racechange = true;
                                prace = "Somanian";
                                phealth = 50;
                                pattack = 20;
                                pdefense = 10;
                                break;
                            case "Ome":
                                backImage.setIcon(new ImageIcon(".//resources//images//Omecillian.png"));
                                racechange = true;
                                prace = "Omecillian";
                                phealth = 50;
                                pattack = 10;
                                pdefense = 20;
                                break;
                            case "Create":
                                pname = inputF.getText();
                                if (!racechange || pname == null){
                                    System.out.println("no");
                                }
                                else{
                                    mu.stop();
                                    new NewPlayer(playnum, inputF.getText(), prace, phealth, pattack, pdefense);
                                    backImage.setVisible(false);
                                    //TR = new TestRun();
                                    System.out.println("yes");
                                }
                                break;
                        }
                        break;
                }
            }
        }
    }
}
