package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tutorialBattle {
    JFrame window;
    Container con;

    //Panel
    JPanel background,userPanel1,secondUserPanel,hpBar,enemyHpBar,textAreaPanel,healPanel,retreatPanel;
    //Label
    JLabel backgroundImage,playerName,enemyName;
    //Font
    Font nameFont=new Font("Times New Roman",Font.PLAIN,12);
    //Button
    JButton attack,defend,potion,retreat;
    //progress bar or hp bar
    JProgressBar healthBar,enemyHealthBar;

    //sample player attributes
    private int hp;
    private int playerDefense=15;
    private int playerAttack=15;
    private int playerMaxHp=100;
    private int healValue=playerMaxHp;
    private String namePlayer="Albert";

    //enemy attributes
    private int enemyHp;
    private int enemyMaxHp=100;
    private int enemyDefense=10;
    private int enemyAttack=35;
    private String nameEnemy="Master Jim";

    //text kaching2x
    int soundcue=0;
    int i=0;
    int delay=0;
    String text;
    JTextArea textArea;
    SoundEffect se = new SoundEffect();

    ActionHandler action = new ActionHandler();

    public tutorialBattle(Player player, JFrame w, Container c){

        /*
        window = w;
        con = c;
        */

        //Window frame...remove if needed to copy paste content to another class with existing JFrame
        window= new JFrame();
        window.setSize(1296,759);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        con=window.getContentPane();

        background = new JPanel();
        background.setBounds(0,0,1280,720);

        backgroundImage = new JLabel();
        backgroundImage.setIcon(new ImageIcon(".//resources//images//Tutorial.png"));
        background.add(backgroundImage);

        //Here you can set the max hp of player please set it to changeable
        playerHPBAR(playerMaxHp);
        enemyHPBAR(enemyMaxHp);
        instructions(action);

        con.add(background);
        window.setVisible(true);
    }
    public void playerHPBAR(int maxhp){

        hpBar = new JPanel();
        hpBar.setBounds(250, 80, 300, 50);
        hpBar.setBackground(Color.BLACK);
        hpBar.setLayout(new GridLayout(2,1));
        hpBar.setOpaque(false);

        playerName=new JLabel(namePlayer);
        playerName.setForeground(Color.WHITE);
        playerName.setFont(nameFont);
        hpBar.add(playerName);

        healthBar = new JProgressBar(0,maxhp);
        healthBar.setPreferredSize(new Dimension(300, 30));
        healthBar.setValue(maxhp);
        healthBar.setBackground(Color.RED);
        healthBar.setForeground(Color.GREEN);
        hpBar.add(healthBar);
        this.hp=maxhp;
        con.add(hpBar);
    }
    public void enemyHPBAR(int maxhp){

        enemyHpBar = new JPanel();
        enemyHpBar.setBounds(750, 50, 300, 50);
        enemyHpBar.setBackground(Color.BLACK);
        enemyHpBar.setLayout(new GridLayout(2,1));
        enemyHpBar.setOpaque(false);

        enemyName=new JLabel(nameEnemy);
        enemyName.setForeground(Color.WHITE);
        enemyName.setFont(nameFont);
        enemyHpBar.add(enemyName);

        enemyHealthBar = new JProgressBar(0,maxhp);
        enemyHealthBar.setPreferredSize(new Dimension(300, 30));
        enemyHealthBar.setValue(maxhp);
        enemyHealthBar.setBackground(Color.BLACK);
        enemyHealthBar.setForeground(Color.RED);
        enemyHpBar.add( enemyHealthBar);
        this.enemyHp=maxhp;
        con.add(enemyHpBar);

    }


    public void playerDamageReceived(int dmg) {
        String sound=".//resources//audio//sword 3.wav";
        se.setURL(sound);
        se.play();
        dmg=dmg-playerDefense;
        if(dmg<0){
            dmg=0;
        }
        hp = hp - dmg;
        healthBar.setValue(hp);
    }
    public void playerDefend(int dmg){
        String sound=".//resources//audio//sword1.wav";
        se.setURL(sound);
        se.play();
        dmg=dmg-(2*playerDefense);
        if(dmg<0){
            dmg=0;
        }
        hp=hp-dmg;
        healthBar.setValue(hp);
    }
    public void playerHealReceived(int heal){
        String sound=".//resources//audio//heal 1.wav";
        se.setURL(sound);
        se.play();
        hp=hp+heal;
        healthBar.setValue(hp);
    }
    public void enemyDamageReceived(int dmg2) {
        String sound=".//resources//audio//character attack music.wav";
        se.setURL(sound);
        se.play();
        dmg2=dmg2-enemyDefense;
        if(dmg2<0){
            dmg2=0;
        }
        enemyHp = enemyHp- dmg2;
        enemyHealthBar.setValue(enemyHp);
    }
    public void instructions(ActionHandler action){
        textAreaPanel =new JPanel();
        textAreaPanel.setBounds(930,110,300,70);
        textAreaPanel.setBackground(new Color(0,0,0,0));
        textAreaPanel.setOpaque(false);

        textArea=new JTextArea();
        textArea.setBounds(0,0,300,70);
        textArea.setBackground(new Color(0,0,0,0));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(nameFont);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textAreaPanel.add(textArea);

        secondUserPanel=new JPanel();
        secondUserPanel.setBounds(780,540,500,168);
        secondUserPanel.setBackground(Color.black);
        secondUserPanel.setOpaque(false);
        secondUserPanel.setLayout(new GridLayout(2,1));


        defend=new JButton();
        defend.setForeground(new Color(0,0,0,0));
        defend.setBackground(new Color(0,0,0,0));
        defend.setPreferredSize(new Dimension(500,82));
        defend.setFocusPainted(false);
        defend.setContentAreaFilled(false);
        defend.setOpaque(false);
        defend.addActionListener(action);
        defend.setActionCommand("defend");
        secondUserPanel.add(defend);

        healPanel=new JPanel();
        healPanel.setBounds(0,630,500,82);
        healPanel.setBackground(Color.blue);
        healPanel.setOpaque(false);
        healPanel.setLayout(new GridLayout(1,1));

        potion=new JButton();
        potion.setForeground(new Color(0,0,0,0));
        potion.setBackground(new Color(0,0,0,0));
        potion.setPreferredSize(new Dimension(500,82));
        potion.setFocusPainted(false);
        potion.setContentAreaFilled(false);
        potion.setOpaque(false);
        potion.addActionListener(action);
        potion.setActionCommand("potion");
        healPanel.add(potion);

        retreatPanel=new JPanel();
        retreatPanel.setBounds(780,630,500,82);
        retreatPanel.setBackground(Color.blue);
        retreatPanel.setOpaque(false);
        retreatPanel.setLayout(new GridLayout(1,1));

        retreat=new JButton();
        retreat.setForeground(new Color(0,0,0,0));
        retreat.setBackground(new Color(0,0,0,0));
        retreat.setPreferredSize(new Dimension(500,82));
        retreat.setFocusPainted(false);
        retreat.setContentAreaFilled(false);
        retreat.setOpaque(false);
        retreat.addActionListener(action);
        retreat.setActionCommand("retreat");
        retreatPanel.add(retreat);

        text="Master Jim: Okay you're finally here, "+namePlayer+" Let's now begin your lesson."
                +" First is attack, press the Attack button to attack, Now try it";
        prepareText();
        instruction2(action);
        con.add(textAreaPanel);
        con.add(secondUserPanel);
        con.add(healPanel);
        con.add(retreatPanel);
        healPanel.setVisible(false);
        secondUserPanel.setVisible(false);
        retreatPanel.setVisible(false);
    }
    public void instruction2(ActionHandler action){
        userPanel1=new JPanel();
        userPanel1.setBounds(0,540,500,164);
        userPanel1.setBackground(Color.blue);
        userPanel1.setOpaque(false);
        userPanel1.setLayout(new GridLayout(2,1));

        attack=new JButton();
        attack.setForeground(new Color(0,0,0,0));
        attack.setBackground(new Color(0,0,0,0));
        attack.setPreferredSize(new Dimension(500,164));
        attack.setFocusPainted(false);
        attack.setContentAreaFilled(false);
        attack.setOpaque(false);
        attack.addActionListener(action);
        attack.setActionCommand("attack");
        userPanel1.add(attack);

        con.add(userPanel1);
    }
    public void attackInstructions(){
        text="Master Jim: Each time you attack you must expect retaliation." +" Now try defending against me,"
                +"press Defend."
        ;
        prepareText();
        String soundeffect=".//";
        enemyDamageReceived(playerAttack);
        playerDamageReceived(enemyAttack);
        userPanel1.setVisible(false);
        secondUserPanel.setVisible(true);
    }
    public void defendInstructions(){
        text="Master Jim: When you defend your defense doubles for 1 turn, thus reducing the damage you received."
                +" Now try healing yourself by drinking a [Lola Remedios], click Potion.";
        prepareText();
        playerDefend(enemyAttack);
        secondUserPanel.setVisible(false);
        healPanel.setVisible(true);
    }
    public void potionInstructions(){
        text="Master Jim: When you drink a [Lola Remedios},made from all natural ingredients,"
                +" You can recover a portion of your health."+" That's all I can teach you, Let's now retreat"
                +" and go back to our Great City of [VICTORIAS]";
        prepareText();
        playerHealReceived(healValue);
        healPanel.setVisible(false);
        retreatPanel.setVisible(true);
    }

    Timer timer=new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            char ch[]=text.toCharArray();
            int arrnum=ch.length;

            String addedCH="";
            String blank="";
            addedCH=blank+ch[i];
            textArea.append(addedCH);

            i++;
            soundcue++;
            if(soundcue==3){
                String soundeffect=".//resources//audio//type.wav";
                se.setURL(soundeffect);
                se.play();
                soundcue=0;}
            if(i==ch.length){
                i=0;
                timer.stop();
            }
        }
    });
    public void prepareText(){
        i=0;
        textArea.setText("");
        timer.start();
    }

    class ActionHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String choice = e.getActionCommand();
            switch (choice) {
                case "start":
                    //ss.Shop(this);
                    break;
                case "attack":
                    attackInstructions();
                    break;
                case "defend":
                    defendInstructions();
                    break;
                case "potion":
                    potionInstructions();
                    break;
                case "retreat":
                    System.out.println("Success");
                    break;
            }
        }
    }
}
