package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;


public class Screen  {
    JFrame window;
    Container con;
    JPanel startbuttonpanel,iconpanel,textpanel,exchangebuttonpanel;
    JTextArea textArea;
    JLabel icon;
    JButton startbutton,exhangebutton;
    Font font=new Font("Times New Roman",Font.CENTER_BASELINE,30);
    Font nfont=new Font("Times New Roman",Font.PLAIN,25);
    String text;
    SoundEffect se=new SoundEffect();
    MouseHandler mouse=new MouseHandler();
    int i=0;
    int soundcue=0;


    public void StartScreen(TestRun.ActionHandler action){
        //initializes game screen panel
        window= new JFrame();
        window.setSize(1280,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.addMouseListener(mouse);
        con=window.getContentPane();

        //sets the start button
        startbuttonpanel=new JPanel();
        startbuttonpanel.setBounds(470,640,400,200);
        startbuttonpanel.setBackground(new Color(0,0,0,0));
        startbuttonpanel.setOpaque(false);

        startbutton=new JButton();
        startbutton.setPreferredSize(new Dimension(125,43));
        startbutton.setBackground(new Color(0,0,0,0));
        startbutton.setOpaque(false);
        startbutton.setFocusPainted(false);
        startbutton.setContentAreaFilled(false);
        startbutton.addActionListener(action);
        startbutton.setActionCommand("start");
        startbuttonpanel.add(startbutton);

        //set background
        iconpanel=new JPanel();
        iconpanel.setBounds(1,1,1280,720);
        iconpanel.setBackground(new Color(0,0,0,0));

        //exchange button
        exchangebuttonpanel=new JPanel();
        exchangebuttonpanel.setBounds(470,640,400,200);
        exchangebuttonpanel.setBackground(Color.BLACK);

        exhangebutton=new JButton("Exchange");
        exhangebutton.setFont(font);
        exhangebutton.setPreferredSize(new Dimension(200,43));
        exhangebutton.setBackground(new Color(0,0,0,0));
        exhangebutton.setForeground(Color.WHITE);
        exhangebutton.setFocusPainted(false);
        exhangebutton.setContentAreaFilled(false);
        exchangebuttonpanel.add(exhangebutton);

        icon=new JLabel();
        icon.setIcon(new ImageIcon("resources/Background.png"));
        iconpanel.add(icon);

        //implements to the window
        con.add(startbuttonpanel);
        con.add(iconpanel);
        con.add(exchangebuttonpanel);

        exchangebuttonpanel.setVisible(false);
        window.setVisible(true);
    }

    public void Shop (){
        startbuttonpanel.setVisible(false);
        icon.setIcon(new ImageIcon("resources/Shop.png"));

        textpanel=new JPanel();
        textpanel.setBounds(100,600,1200,200);
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


        text="Hello pushov-I mean customer, Do you want to exhange a bit of your power for a [Panacea]?";
        timer.start();
        exchangebuttonpanel.setVisible(true);
        window.setVisible(true);

    }
        Timer timer=new Timer(80, new ActionListener() {
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
                String soundeffect=".//resources//type.wav";
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
    public class MouseHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
                timer.stop();
                textArea.setText(text);
                i=0;
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
