package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.Random;

public class Game extends Canvas{

    // Game resolution
    public static final int WIDTH = 1296, HEIGHT = 759;

    Window myGame;

    // Runs once at the start of the application
    public Game() {
        SaveFile SaveFilePath = new SaveFile();
        File savesFolder = new File(SaveFilePath.saveFilesPath);
        savesFolder.mkdirs();

        myGame = new Window(WIDTH, HEIGHT, "Legend of Albert");

    }

    public static void main(String[] args) {
        new Game();
    }
}
