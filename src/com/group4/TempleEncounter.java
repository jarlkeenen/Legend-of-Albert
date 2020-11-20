package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TempleEncounter {
    private final static String nl = "\n";

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

    String healthCaption = "HP", attackCaption = "ATK", defenseCaption = "DEF", lolaRemediosCaption = "LR";

    JLabel playerName, playerHPL, playerHP, playerAttackL, playerAttack, playerDefenseL, playerDefense, lolaRemediosL, lolaRemedios;

    int playerMaxHPI, playerHPI, playerAttackI, playerDefenseI, lolaRemediosI;
    String playerNameI, playerHPS, playerAttackS, playerDefenseS, lolaRemediosS;

    JLabel enemyName, enemyHPL, enemyHP, enemyAttackL, enemyAttack, enemyDefenseL, enemyDefense;

    int enemyMaxHPI, enemyHPI, enemyAttackI, enemyDefenseI;
    String enemyNameI, enemyHPS, enemyAttackS, enemyDefenseS;

    JTextArea combatLog;

    Font nameFont;
    Font statFont;
    Font labelFont;
    Font combFont;

    BattleHandler battleHandler = new BattleHandler();

    public TempleEncounter(JFrame window, Container con, Player player, String area) throws IOException, FontFormatException {

        try {
            nameFont = Font.createFont(Font.TRUETYPE_FONT, new File(".//resources//fonts/Quest.ttf")).deriveFont(30f);
            statFont = Font.createFont(Font.TRUETYPE_FONT, new File(".//resources//fonts/Quest.ttf")).deriveFont(23f);
            labelFont = Font.createFont(Font.TRUETYPE_FONT, new File(".//resources//fonts/Quest.ttf")).deriveFont(15f);
            combFont = Font.createFont(Font.TRUETYPE_FONT, new File(".//resources//fonts/Quest.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(".//resources//fonts//Quest.ttf")));
        } catch (IOException | FontFormatException ignored) {
        }

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

        // Sample Stats. Changes depending on enemy.
        /*
        ENEMY BASE STATS:
        MaxHP = 100
        Attack = 105
        Defense = 90
         */
        enemyNameI = "Babadook";
        enemyMaxHPI = 200;
        enemyHPI = enemyMaxHPI;
        enemyAttackI = 105;
        enemyDefenseI = 90;

        playerHPS = String.valueOf(playerHPI);
        playerAttackS = String.valueOf(playerAttackI);
        playerDefenseS = String.valueOf(playerDefenseI);
        lolaRemediosS = String.valueOf(lolaRemediosI);

        enemyHPS = String.valueOf(enemyHPI);
        enemyAttackS = String.valueOf(enemyAttackI);
        enemyDefenseS = String.valueOf(enemyDefenseI);

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
        screen.add(attackPanel, Integer.valueOf(2));

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
        screen.add(defendPanel, Integer.valueOf(2));

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
        screen.add(potionPanel, Integer.valueOf(2));

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
        screen.add(retreatPanel, Integer.valueOf(2));

        playerName = new JLabel(playerNameI);
        playerName.setForeground(Color.white);
        playerName.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerName.setFont(nameFont);

        playerHPL = new JLabel(healthCaption);
        playerHPL.setForeground(Color.white);
        playerHPL.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerHPL.setFont(labelFont);

        playerHP = new JLabel(playerHPS);
        playerHP.setForeground(Color.white);
        playerHP.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerHP.setFont(statFont);

        playerAttackL = new JLabel(attackCaption);
        playerAttackL.setForeground(Color.white);
        playerAttackL.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerAttackL.setFont(labelFont);

        playerAttack = new JLabel(playerAttackS);
        playerAttack.setForeground(Color.white);
        playerAttack.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerAttack.setFont(statFont);

        playerDefenseL = new JLabel(defenseCaption);
        playerDefenseL.setForeground(Color.white);
        playerDefenseL.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerDefenseL.setFont(labelFont);

        playerDefense = new JLabel(playerDefenseS);
        playerDefense.setForeground(Color.white);
        playerDefense.setAlignmentX(Component.LEFT_ALIGNMENT);
        playerDefense.setFont(statFont);

        lolaRemediosL = new JLabel(lolaRemediosCaption);
        lolaRemediosL.setForeground(Color.white);
        lolaRemediosL.setAlignmentX(Component.LEFT_ALIGNMENT);
        lolaRemediosL.setFont(labelFont);

        lolaRemedios = new JLabel(lolaRemediosS);
        lolaRemedios.setForeground(Color.white);
        lolaRemedios.setAlignmentX(Component.LEFT_ALIGNMENT);
        lolaRemedios.setFont(statFont);

        playerStats = new JPanel();
        playerStats.setLayout(new BoxLayout(playerStats, BoxLayout.Y_AXIS));
        playerStats.setBounds(40, 100, 200, 260);
        playerStats.setOpaque(false);

        playerStats.add(playerName);
        playerStats.add(Box.createRigidArea(new Dimension(0, 10)));
        playerStats.add(playerHPL);
        playerStats.add(playerHP);
        playerStats.add(Box.createRigidArea(new Dimension(0, 6)));
        playerStats.add(playerAttackL);
        playerStats.add(playerAttack);
        playerStats.add(Box.createRigidArea(new Dimension(0, 6)));
        playerStats.add(playerDefenseL);
        playerStats.add(playerDefense);
        playerStats.add(Box.createRigidArea(new Dimension(0, 6)));
        playerStats.add(lolaRemediosL);
        playerStats.add(lolaRemedios);

        screen.add(playerStats, Integer.valueOf(1));

        enemyName = new JLabel(enemyNameI);
        enemyName.setForeground(Color.white);
        enemyName.setAlignmentX(Component.RIGHT_ALIGNMENT);
        enemyName.setFont(nameFont);

        enemyHPL = new JLabel(healthCaption);
        enemyHPL.setForeground(Color.white);
        enemyHPL.setAlignmentX(Component.RIGHT_ALIGNMENT);
        enemyHPL.setFont(labelFont);

        enemyHP = new JLabel(enemyHPS);
        enemyHP.setForeground(Color.white);
        enemyHP.setAlignmentX(Component.RIGHT_ALIGNMENT);
        enemyHP.setFont(statFont);

        enemyAttackL = new JLabel(attackCaption);
        enemyAttackL.setForeground(Color.white);
        enemyAttackL.setAlignmentX(Component.RIGHT_ALIGNMENT);
        enemyAttackL.setFont(labelFont);

        enemyAttack = new JLabel(enemyAttackS);
        enemyAttack.setForeground(Color.white);
        enemyAttack.setAlignmentX(Component.RIGHT_ALIGNMENT);
        enemyAttack.setFont(statFont);

        enemyDefenseL = new JLabel(defenseCaption);
        enemyDefenseL.setForeground(Color.white);
        enemyDefenseL.setAlignmentX(Component.RIGHT_ALIGNMENT);
        enemyDefenseL.setFont(labelFont);

        enemyDefense = new JLabel(enemyDefenseS);
        enemyDefense.setForeground(Color.white);
        enemyDefense.setAlignmentX(Component.RIGHT_ALIGNMENT);
        enemyDefense.setFont(statFont);

        enemyStats = new JPanel();
        enemyStats.setLayout(new BoxLayout(enemyStats, BoxLayout.Y_AXIS));
        enemyStats.setBounds(1040, 100, 200, 260);
        enemyStats.setOpaque(false);

        enemyStats.add(enemyName);
        enemyStats.add(Box.createRigidArea(new Dimension(0, 10)));
        enemyStats.add(enemyHPL);
        enemyStats.add(enemyHP);
        enemyStats.add(Box.createRigidArea(new Dimension(0, 6)));
        enemyStats.add(enemyAttackL);
        enemyStats.add(enemyAttack);
        enemyStats.add(Box.createRigidArea(new Dimension(0, 6)));
        enemyStats.add(enemyDefenseL);
        enemyStats.add(enemyDefense);

        screen.add(enemyStats, Integer.valueOf(1));

        combatLog = new JTextArea();
        combatLog.setEditable(false);
        combatLog.setHighlighter(null);
        combatLog.setForeground(Color.white);
        combatLog.setFont(combFont);
        combatLog.setOpaque(false);

        JScrollPane combatLogPane = new JScrollPane(combatLog);
        combatLogPane.setBounds(500, 540, 290, 160);
        combatLogPane.setBackground(Color.green);
        combatLogPane.setBorder(BorderFactory.createEmptyBorder());
        combatLogPane.setOpaque(false);
        combatLogPane.getViewport().setOpaque(false);

        screen.add(combatLogPane, Integer.valueOf(2));

        screen.setVisible(true);
        con.add(screen);
    }

    public void nextEncounters() {
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
        backImage.setIcon(new ImageIcon(backgroundFilePath));

        enemyNameI = "Pennywise";
        enemyMaxHPI = 200;
        enemyHPI = enemyMaxHPI;
        enemyAttackI = 105;
        enemyDefenseI = 90;

        updateStats();
    }

    public void attack() throws IOException, FontFormatException {
        int playerDamage = playerAttackI - enemyDefenseI;
        enemyHPI -= playerDamage;
        if (enemyHPI <= 0) {
            enemyHPI = 0;
            combatLog.append(playerNameI + " has killed " + enemyNameI + "." + nl);
            updateStats();
            encounterCounter++;
            nextEncounters();

            return;
        }
        combatLog.append(playerNameI + " dealt " + playerDamage + " damage to " + enemyNameI + "." + nl);

        enemyAttack();

        updateStats();
    }

    public void defend() {
        int defenseIncrease = 10;
        playerDefenseI += defenseIncrease;
        combatLog.append(playerNameI + " increased his defense by " + defenseIncrease + " for one turn." + nl);

        enemyAttack();

        playerDefenseI -= defenseIncrease;

        updateStats();
    }

    public void potion() {
        if (lolaRemediosI > 0) {
            if (playerHPI == playerMaxHPI) {
                combatLog.append(playerNameI + " tried to drink a sachet of Lola Remedios but he was already at full HP." + nl);
                return;
            }
            else {
                int healthHealed = playerMaxHPI / 4;
                playerHPI += healthHealed;

                if (playerHPI > playerMaxHPI) {
                    healthHealed -= (playerHPI - playerMaxHPI);
                    playerHPI = playerMaxHPI;
                }

                lolaRemediosI--;
                combatLog.append(playerNameI + " drank a sachet of Lola Remedios and regained " + healthHealed + " HP." + nl);
            }
        }
        else {
            combatLog.append(playerNameI + " tried to drink a sachet of Lola Remedios but he had none left." + nl);
        }

        updateStats();
    }

    public void retreat() {
        int retreat = (int)(Math.random() * (100 - 1 + 1)) + 1;

        if (retreat <= 10) {
            combatLog.append(playerNameI + " tried to run but has failed." + nl);
            enemyAttack();
            updateStats();
        }
        else {
            combatLog.append(playerNameI + " has successfully fled." + nl);
            attackButton.setEnabled(false);
            defendButton.setEnabled(false);
            potionButton.setEnabled(false);
            retreatButton.setEnabled(false);
        }
    }

    public void enemyAttack() {
        int enemyDamage = enemyAttackI - playerDefenseI;
        playerHPI -= enemyDamage;
        if (playerHPI <= 0) {
            playerHPI = 0;
            combatLog.append(playerNameI + " has died." + nl);
            updateStats();
            attackButton.setEnabled(false);
            defendButton.setEnabled(false);
            potionButton.setEnabled(false);
            retreatButton.setEnabled(false);
            return;
        }
        combatLog.append(enemyNameI + " dealt " + enemyDamage + " damage to " + playerNameI + "." + nl);
    }

    private void updateStats() {
        playerHPS = String.valueOf(playerHPI);
        playerAttackS = String.valueOf(playerAttackI);
        playerDefenseS = String.valueOf(playerDefenseI);
        lolaRemediosS = String.valueOf(lolaRemediosI);

        enemyHPS = String.valueOf(enemyHPI);
        enemyAttackS = String.valueOf(enemyAttackI);
        enemyDefenseS = String.valueOf(enemyDefenseI);

        playerHP.setText(playerHPS);
        playerAttack.setText(playerAttackS);
        playerDefense.setText(playerDefenseS);
        lolaRemedios.setText(lolaRemediosS);

        enemyHP.setText(enemyHPS);
        enemyAttack.setText(enemyAttackS);
        enemyDefense.setText(enemyDefenseS);
    }

    public class BattleHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            switch (action) {
                case "attack": {
                    try {
                        attack();
                    } catch (IOException | FontFormatException exception) {
                        exception.printStackTrace();
                    }
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
