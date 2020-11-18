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

    JLayeredPane layers = new JLayeredPane();

    Player player;

    int randomEnemy;
    int[] randomEnemyChecker = {0, 0};

    JPanel background;
    JLabel backImage;

    // Actions:
    JPanel attackPanel, defendPanel, potionPanel, retreatPanel;
    JButton attackButton, defendButton, potionButton, retreatButton;

    Font normalFont = new Font("Arial",Font.PLAIN, 25);

    BattleHandler battleHandler = new BattleHandler();

    public TempleEncounter(JFrame window, Container con, Player player, String area) {
        this.window = window;
        this.con = con;
        this.player = player;
        conSize = new Dimension(con.getWidth(), con.getHeight());
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
        String backgroundFilePath = ".//resources//images//Temples//" + area + randomEnemy + ".png";
        backImage = new JLabel(new ImageIcon(backgroundFilePath));

        background = new JPanel(new BorderLayout());
        background.setSize(conSize);
        background.add(backImage);
        con.add(background);

        attackButton = new JButton("ATTACK");
        attackButton.setForeground(Color.white);
        attackButton.setFont(normalFont);
        attackButton.addActionListener(battleHandler);
        attackButton.setActionCommand("attack");
        attackButton.setOpaque(true);
        attackPanel = new JPanel();
        attackPanel.setBounds(0, 540, 500, 164);
        attackPanel.setBackground(Color.blue);
        attackPanel.setOpaque(true);
        attackPanel.add(attackButton);
        con.add(attackPanel);
        attackButton.setVisible(true);

        defendButton = new JButton("DEFEND");
        defendButton.setForeground(Color.white);
        defendButton.setFont(normalFont);
        defendButton.addActionListener(battleHandler);
        defendButton.setActionCommand("defend");
        defendButton.setOpaque(true);
        defendPanel = new JPanel();
        defendPanel.setBounds(780, 540, 500, 168);
        defendPanel.setBackground(Color.blue);
        defendPanel.setOpaque(true);
        defendPanel.add(defendButton);
        con.add(defendPanel);
        defendButton.setVisible(true);

        potionButton = new JButton("POTION");
        potionButton.setForeground(Color.white);
        potionButton.setFont(normalFont);
        potionButton.addActionListener(battleHandler);
        potionButton.setActionCommand("potion");
        potionButton.setOpaque(true);
        potionPanel = new JPanel();
        potionPanel.setBounds(0, 630, 500, 82);
        potionPanel.setBackground(Color.blue);
        potionPanel.setOpaque(true);
        potionPanel.add(potionButton);
        con.add(potionPanel);
        potionButton.setVisible(true);

        retreatButton = new JButton("RETREAT");
        retreatButton.setForeground(Color.white);
        retreatButton.setFont(normalFont);
        retreatButton.addActionListener(battleHandler);
        retreatButton.setActionCommand("retreat");
        retreatButton.setOpaque(true);
        retreatPanel = new JPanel();
        retreatPanel.setBounds(780, 630, 500, 168);
        retreatPanel.setBackground(Color.blue);
        retreatPanel.setOpaque(true);
        retreatPanel.add(retreatButton);
        con.add(retreatPanel);
        retreatButton.setVisible(true);

        encounterCounter++;
    }

    public void firstEncounter() {

    }

    public static class BattleHandler implements ActionListener {
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
