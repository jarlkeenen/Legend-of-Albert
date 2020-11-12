package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas{

    // Game resolution
    public static final int WIDTH = 1280, HEIGHT = 720;

    Window myGame;

    // Runs once at the start of the application
    public Game() {

        myGame = new Window();
        myGame.mainMenu(WIDTH, HEIGHT, "Legend of Albert", this);

    }

    /* ignore
    public void startGame() {

    }
    */

    public static void main(String[] args) {
        new Game();
    }
}
