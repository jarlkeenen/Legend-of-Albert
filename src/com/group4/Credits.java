package com.group4;
import javax.swing.*;
import java.awt.*;

public class Credits {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;

    public void SceneA() {
        test();
    }

    public void test(){
        frame = new JFrame("Test");
        frame.setVisible(true);
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);


        label = new JLabel("");

        panel.add(label);

        frame.add(panel);
    }
    public Credits() {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame();
                frame.add(new ImagePanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1296 ,759);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }

}

class ImagePanel extends JPanel {

    Image image;

    public ImagePanel() {
        image = Toolkit.getDefaultToolkit().createImage(".//resources//images//LOA Credits1.gif");

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

}