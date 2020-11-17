package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthBar extends Screen{
    JPanel HPBar;
    JProgressBar HealthBar;
    JButton attack,heal;
    //current player hp
    private int hp;

    public void playerHPBAR(int maxhp){

        HPBar = new JPanel();
        HPBar.setBounds(250, 250, 300, 30);
        HPBar.setBackground(Color.BLACK);
        con.add(HPBar);

        HealthBar = new JProgressBar(0,maxhp);
        HealthBar.setPreferredSize(new Dimension(300, 30));
        HealthBar.setValue(100);
        HealthBar.setBackground(Color.RED);
        HealthBar.setForeground(Color.GREEN);
        HPBar.add(HealthBar);

        window.setVisible(true);

    }

    public void DamageReceived(int dmg) {
        hp = hp - dmg;
        HealthBar.setValue(hp);
    }
    public void HealReceived(int heal){
        hp=hp+heal;
        HealthBar.setValue(hp);

    }

}
