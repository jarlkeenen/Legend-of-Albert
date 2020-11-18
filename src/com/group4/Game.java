package com.group4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Game extends Canvas{

    // Game resolution
    public static final int WIDTH = 1296, HEIGHT = 759;

    boolean existingSaveFile;

    Window myGame;

    // Runs once at the start of the application
    public Game() throws IOException {
        SaveFile SaveFilePath = new SaveFile();
        File savesFolder = new File(SaveFilePath.saveFilesPath);
        savesFolder.mkdirs();

        existingSaveFile = Objects.requireNonNull(savesFolder.list()).length != 0;

        myGame = new Window(WIDTH, HEIGHT, "Legend of Albert", existingSaveFile);
    }

    public static void main(String[] args) throws IOException {
        new Game();
    }

}
