package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempleEncounter {

    JFrame window;
    Container con;
    Dimension conSize;
    String area;
    int encounterCounter = 0;

    Player player;

    int randomEnemy;
    int[] randomEnemyChecker = {0, 0};

    JLayeredPane screen;
    JPanel background;
    JLabel backImage;
    String backgroundFilePath;

    // Actions:
    JPanel attackPanel, defendPanel, potionPanel, retreatPanel;
    JButton attackButton, defendButton, potionButton, retreatButton;

    JPanel playerStats, enemyStats;

    JLabel playerName, playerHP, playerAttack, playerDefense, lolaRemedios;

    int playerMaxHPI, playerHPI, playerAttackI, playerDefenseI, lolaRemediosI;
    String playerNameI, playerHPS, playerAttackS, playerDefenseS, lolaRemediosS;

    JLabel enemyName, enemyMaxHP, enemyHP, enemyAttack, enemyDefense;

    int enemyMaxHPI, enemyHPI, enemyAttackI, enemyDefenseI;
    String enemyNameI, enemyHPS, enemyAttackS, enemyDefenseS;

    Font normalFont = new Font("Arial",Font.PLAIN, 30);

    BattleHandler battleHandler = new BattleHandler();

    public TempleEncounter(JFrame window, Container con, Player player, String area) {
        this.window = window;
        this.con = con;
        this.player = player;
        conSize = new Dimension(con.getWidth(), con.getHeight());
        this.area = area.toUpperCase();

        playerNameI = player.getPlayerName();
        playerMaxHPI = player.getPlayerMaxHealth();
        playerHPI = player.getPlayerHealth();
        playerAttackI = player.getPlayerAttack();
        playerDefenseI = player.getPlayerDefense();
        lolaRemediosI = player.getLolaRemedios();

        playerHPS = "HP: " + playerHPI + "/" + playerMaxHPI;
        playerAttackS = "ATK: " + playerAttackI;
        playerDefenseS = "DEF: " + playerDefenseI;
        lolaRemediosS = "LR: " + lolaRemediosI;

        enemyHPS = ":HP";

        // Sample Stats. Changes depending on enemy.
        /*
        ENEMY BASE STATS:
        MaxHP = 100
        Attack = 105
        Defense = 90
         */
        enemyNameI = "Babadook";
        enemyMaxHPI = 100;
        enemyHPI = enemyMaxHPI;
        enemyAttackI = 105;
        enemyDefenseI = 90;

        battleScreen();
    }

    public void battleScreen() {
        screen = new JLayeredPane();
        screen.setSize(conSize);

        if (encounterCounter != 3) {
            do {
                randomEnemy = (int)(Math.random() * (4 - 1 + 1)) + 1;
            } while (randomEnemy == randomEnemyChecker[0] || randomEnemy == randomEnemyChecker[1]);
            if (encounterCounter <= 1)
                randomEnemyChecker[encounterCounter] = randomEnemy;
        }
        else
            randomEnemy = 5;
        backgroundFilePath = ".//resources//images//Temples//" + area + randomEnemy + ".png";
        backImage = new JLabel(new ImageIcon(backgroundFilePath));

        background = new JPanel(new BorderLayout());
        background.setSize(conSize);
        background.add(backImage);
        screen.add(background, Integer.valueOf(0));


        attackButton = new JButton();
        attackButton.addActionListener(battleHandler);
        attackButton.setActionCommand("attack");
        attackButton.setOpaque(false);
        attackButton.setContentAreaFilled(false);
        attackButton.setBorderPainted(false);
        attackPanel = new JPanel(new BorderLayout());
        attackPanel.setBounds(0,536,406,75);
        attackPanel.setOpaque(false);
        attackPanel.add(attackButton);
        screen.add(attackPanel, Integer.valueOf(1));

        defendButton = new JButton();
        defendButton.addActionListener(battleHandler);
        defendButton.setActionCommand("defend");
        defendButton.setOpaque(false);
        defendButton.setContentAreaFilled(false);
        defendButton.setBorderPainted(false);
        defendPanel = new JPanel(new BorderLayout());
        defendPanel.setBounds(868, 536, 412, 75);
        defendPanel.setOpaque(false);
        defendPanel.add(defendButton);
        screen.add(defendPanel, Integer.valueOf(1));

        potionButton = new JButton();
        potionButton.addActionListener(battleHandler);
        potionButton.setActionCommand("potion");
        potionButton.setOpaque(false);
        potionButton.setContentAreaFilled(false);
        potionButton.setBorderPainted(false);
        potionPanel = new JPanel(new BorderLayout());
        potionPanel.setBounds(0, 627, 406, 75);
        potionPanel.setOpaque(false);
        potionPanel.add(potionButton);
        screen.add(potionPanel, Integer.valueOf(1));

        retreatButton = new JButton();
        retreatButton.addActionListener(battleHandler);
        retreatButton.setActionCommand("retreat");
        retreatButton.setOpaque(false);
        retreatButton.setContentAreaFilled(false);
        retreatButton.setBorderPainted(false);
        retreatPanel = new JPanel(new BorderLayout());
        retreatPanel.setBounds(868, 627, 412, 75);
        retreatPanel.setOpaque(false);
        retreatPanel.add(retreatButton);
        screen.add(retreatPanel, Integer.valueOf(1));

        playerName = new JLabel(playerNameI);
        playerName.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerName.setFont(normalFont);

        playerHP = new JLabel(playerHPS);
        playerHP.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerHP.setFont(normalFont);

        playerAttack = new JLabel(playerAttackS);
        playerAttack.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerAttack.setFont(normalFont);

        playerDefense = new JLabel(playerDefenseS);
        playerDefense.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerDefense.setFont(normalFont);

        lolaRemedios = new JLabel(lolaRemediosS);
        lolaRemedios.setAlignmentX(Component.LEFT_ALIGNMENT);
        lolaRemedios.setFont(normalFont);

        playerStats = new JPanel();
        playerStats.setLayout(new BoxLayout(playerStats, BoxLayout.Y_AXIS));
        playerStats.setBounds(40, 30, 200, 200);
        playerStats.setBackground(Color.pink);
        playerStats.setOpaque(true);

        playerStats.add(playerName);
        playerStats.add(playerHP);
        playerStats.add(playerAttack);
        playerStats.add(playerDefense);
        playerStats.add(lolaRemedios);

        screen.add(playerStats, Integer.valueOf(1));

        con.add(screen);
        screen.setVisible(true);
        encounterCounter++;
    }

    public void attack() {
        System.out.println("Attack");
    }

    public void defend() {
        System.out.println("Defend");
    }

    public void potion() {
        System.out.println("Potion");
    }

    public void retreat() {
        System.out.println("Retreat");
    }

    public class BattleHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            switch (action) {
                case "attack": {
                    attack();
                    break;
                }
                case "defend": {
                    defend();
                    break;
                }
                case "potion": {
                    potion();
                    break;
                }
                case "retreat": {
                    retreat();
                    break;
                }
            }
        }
    }
}
