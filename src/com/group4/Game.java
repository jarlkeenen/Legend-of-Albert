package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas{

    // Game resolution
    public static final int WIDTH = 1286, HEIGHT = 749;

    Window myGame;

    // Runs once at the start of the application
    public Game() {

<<<<<<< Updated upstream
        myGame = new Window();
        myGame.mainMenu(WIDTH, HEIGHT, "Legend of Albert", this);

=======
        myGame = new Window(WIDTH, HEIGHT, "Legend of Albert");
>>>>>>> Stashed changes
    }

    /* ignore
    public void startGame() {

    }
    */

    public static void main(String[] args) {
        new Game();
    }

}
