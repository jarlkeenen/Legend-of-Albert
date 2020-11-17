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

    JLabel backImage;

    // Actions:
    JPanel attackPanel, defendPanel, potionPanel, retreatPanel;
    JButton attackButton, defendButton, potionButton, retreatButton;

    Font normalFont = new Font("Arial",Font.PLAIN, 25);

    BattleHandler battleHandler = new BattleHandler();

    public TempleEncounter(JFrame window, Container con, JLabel backImage, Player player, String area) {
        this.window = window;
        this.con = con;
        this.player = player;
        conSize = new Dimension(con.getWidth(), con.getHeight());
        this.backImage = backImage;
        this.area = area.toUpperCase();
        battleScreen();
    }

    public void battleScreen() {
        if (encounterCounter != 3) {
            do {
                randomEnemy = (int)(Math.random() * (4 - 1 + 1)) + 1;
            } while (randomEnemy == randomEnemyChecker[0] || randomEnemy == randomEnemyChecker[1]);
            if (encounterCounter <= 1)
                randomEnemyChecker[encounterCounter] = randomEnemy;
        }
        else
            randomEnemy = 5;
        System.out.println(randomEnemy);
        String backgroundFilePath = ".//resources//images//Temples//" + area + randomEnemy + ".png";
        backImage.setIcon(new ImageIcon(backgroundFilePath));

        // JEZZ PUCHA WAAY GID NI GA BUTWA ANG LINTE NI NGA BUTTON HALP
        /*
        attackButton = new JButton("ATTACK");
        attackButton.setForeground(Color.white);
        attackButton.setFont(normalFont);
        attackButton.addActionListener(battleHandler);
        attackButton.setActionCommand("attack");
        attackButton.setOpaque(true);
        attackPanel = new JPanel();
        attackPanel.setBounds(-18,435,600,150);
        attackPanel.setBackground(Color.blue);
        attackPanel.setOpaque(true);
        attackPanel.add(attackButton);
        con.add(attackPanel);
        attackButton.setVisible(true);
        */

        System.out.println(con.getWidth() + "  " + con.getHeight());

        con.setVisible(true);
        encounterCounter++;
    }

    public void firstEncounter() {

    }

    public class BattleHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();

            switch (action) {
                case "attack": {
                    System.out.println("Attack pressed.");
                    break;
                }
                case "defend": {
                    System.out.println("Defend pressed.");
                    break;
                }
                case "potion": {
                    System.out.println("Potion pressed.");
                    break;
                }
                case "retreat": {
                    System.out.println("Retreat pressed.");
                    break;
                }
            }
        }
    }

}
