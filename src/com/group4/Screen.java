package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Screen extends  Canvas{
    public static final int WIDTH = 1296, HEIGHT = 759;
    JFrame window;
    Container con;
    JPanel startbuttonpanel,iconpanel,textpanel,exchangebuttonpanel,gotoplacepanel;
    JTextArea textArea;
    JLabel icon;
    JButton startbutton,exhangebutton,exchangebutton2,homebutton,shopbutton,tavernbutton;
    Font font=new Font("Times New Roman",Font.CENTER_BASELINE,30);
    Font nfont=new Font("Times New Roman",Font.PLAIN,25);
    String text;
    SoundEffect se=new SoundEffect();
    MouseHandler mouse=new MouseHandler();
    int i=0;
    int soundcue=0;


    public void StartScreen(CombatTutorial.ActionHandler action){
        //initializes game screen panel
        window= new JFrame();
        window.setSize(WIDTH,HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);
        window.addMouseListener(mouse);
        con=window.getContentPane();

        //sets the start button
        startbutton=new JButton();
        startbutton.setPreferredSize(new Dimension(125,43));
        startbutton.setOpaque(false);
        startbutton.setFocusPainted(false);
        startbutton.setContentAreaFilled(false);
        startbutton.addActionListener(action);
        startbutton.setActionCommand("start");

        startbuttonpanel=new JPanel();
        startbuttonpanel.setBounds(470,640,400,200);
        startbuttonpanel.setBackground(Color.blue);
        startbuttonpanel.setOpaque(false);
        startbuttonpanel.add(startbutton);

        //set background
        iconpanel=new JPanel();
        iconpanel.setBounds(1,1,1280,720);
        iconpanel.setBackground(new Color(0,0,0,0));

        icon=new JLabel();
        icon.setIcon(new ImageIcon("resources/images/Title.png"));
        iconpanel.add(icon);

        //implements to the window
        con.add(startbuttonpanel);
        con.add(iconpanel);

        window.setVisible(true);
    }

    public void Shop (CombatTutorial.ActionHandler action){
        startbuttonpanel.setVisible(false);
        exchangebuttonpanel=new JPanel();
        exchangebuttonpanel.setBounds(500,640,250,50);
        exchangebuttonpanel.setBackground(Color.BLACK);
        exchangebuttonpanel.setLayout(new FlowLayout(1));

        exhangebutton=new JButton("Yes");
        exhangebutton.setFont(font);
        exhangebutton.setPreferredSize(new Dimension(100,43));
        exhangebutton.setBackground(new Color(0,0,0,0));
        exhangebutton.setForeground(Color.WHITE);
        exhangebutton.setFocusPainted(false);
        exhangebutton.setContentAreaFilled(false);
        exhangebutton.addActionListener(action);
        exhangebutton.setActionCommand("yesShop");

        exchangebutton2=new JButton("No");
        exchangebutton2.setFont(font);
        exchangebutton2.setPreferredSize(new Dimension(100,43));
        exchangebutton2.setBackground(new Color(0,0,0,0));
        exchangebutton2.setForeground(Color.WHITE);
        exchangebutton2.setFocusPainted(false);
        exchangebutton2.setContentAreaFilled(false);
        exchangebutton2.addActionListener(action);
        exchangebutton2.setActionCommand("no");

        exchangebuttonpanel.add(exhangebutton);
        exchangebuttonpanel.add(exchangebutton2);

        con.add(exchangebuttonpanel);
        icon.setIcon(new ImageIcon("resources/images/Shop.png"));

        textpanel=new JPanel();
        textpanel.setBounds(100,580,1200,200);
        textpanel.setBackground(new Color(0,0,0,0));
        textpanel.setOpaque(false);
        con.add(textpanel);

        textArea=new JTextArea();
        textArea.setBounds(0,0,1000,200);
        textArea.setBackground(new Color(0,0,0,0));
        textArea.setForeground(Color.WHITE);
        textArea.setFont(nfont);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textpanel.add(textArea);

        text="Do you want to exchange a bit of your power fo a [Lola Remedios]?";
        prepareText();
        exchangebuttonpanel.setVisible(true);
        window.setVisible(true);

    }

    public void town(){
        startbuttonpanel.setVisible(false);
        icon.setIcon(new ImageIcon(".//resources//images//Town.png"));
    }

    public void tavern(){
        icon.setIcon(new ImageIcon(".//resources//images//Tavern.png"));
    }
        Timer textTimer=new Timer(80, new ActionListener() {
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
                if(soundcue==2){
                String soundeffect=".//resources//audio//type.wav";
                se.setURL(soundeffect);
                se.play();
                soundcue=0;}
                if(i==arrnum){
                    i=0;
                    textTimer.stop();
                }
            }
        });
    public void prepareText(){
        i=0;
        textArea.setText("");
        textTimer.start();
    }
    public class MouseHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }


        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
