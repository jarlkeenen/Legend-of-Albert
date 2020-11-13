package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas{

    // Game resolution
    public static final int WIDTH = 1296, HEIGHT = 759;

    Window myGame;

    // Runs once at the start of the application
    public Game() {

        myGame = new Window(WIDTH, HEIGHT, "Legend of Albert");

    }

    /* ignore
    public void startGame() {

    }
    */

    public static void main(String[] args) {
        new Game();
    }
}
