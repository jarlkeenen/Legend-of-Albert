package com.group4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewPlayer extends SaveFile implements Save{

    NewPlayer(int saveNum, String playerName, String playerRace, int playerMaxHealth, int playerAttack, int playerDefense) {
        // Set Progress Trackers
        setSaveNum(saveNum);
        isCombatTutorialCompleted = false;
        isTownHubTutorialCompleted = false;
        isCutscene2TutorialCompleted = false;
        isTheRuinsCompleted = false;
        isDSBForestCompleted = false;
        isCadizShoreCompleted = false;

        // Set Personal Info
        setPlayerName(playerName);
        setPlayerRace(playerRace);

        // Set Combat Stats
        setPlayerMaxHealth(playerMaxHealth);
        setPlayerHealth(playerMaxHealth);
        setPlayerAttack(playerAttack);
        setPlayerDefense(playerDefense);

        // Set Equipment
        setLegSword(false);
        setLegArmor(false);
        setLegPants(false);
        setLolaRemedios(0);
        setTempleKey(0);

        // Set Experience
        setPlayerLevel(1);
        setPlayerMaxXP(100);
        setPlayerXP(0);

        writeToPlayerFile(1);
    }

    // Inputs data into the player's new save file
    @Override
    public void writeToPlayerFile(int saveNum) {
        String saveFile = saveFilesPath + "\\Slot " + saveNum + ".txt";
        File save = new File(saveFile);

        try {
            if (save.createNewFile()) {
                FileWriter saveWriter = new FileWriter(saveFile);

                saveWriter.append(String.valueOf(getSaveNum())).append("\n");
                saveWriter.append(String.valueOf(isCombatTutorialCompleted)).append("\n");
                saveWriter.append(String.valueOf(isTownHubTutorialCompleted)).append("\n");
                saveWriter.append(String.valueOf(isCutscene2TutorialCompleted)).append("\n");
                saveWriter.append(String.valueOf(isTheRuinsCompleted)).append("\n");
                saveWriter.append(String.valueOf(isDSBForestCompleted)).append("\n");
                saveWriter.append(String.valueOf(isCadizShoreCompleted)).append("\n");
                saveWriter.append(getPlayerName()).append("\n");
                saveWriter.append(getPlayerRace()).append("\n");
                saveWriter.append(String.valueOf(getPlayerMaxHealth())).append("\n");
                saveWriter.append(String.valueOf(getPlayerHealth())).append("\n");
                saveWriter.append(String.valueOf(getPlayerAttack())).append("\n");
                saveWriter.append(String.valueOf(getPlayerDefense())).append("\n");
                saveWriter.append(String.valueOf(getLegSword())).append("\n");
                saveWriter.append(String.valueOf(getLegArmor())).append("\n");
                saveWriter.append(String.valueOf(getLegPants())).append("\n");
                saveWriter.append(String.valueOf(getLolaRemedios())).append("\n");
                saveWriter.append(String.valueOf(getTempleKey())).append("\n");
                saveWriter.append(String.valueOf(getPlayerLevel())).append("\n");
                saveWriter.append(String.valueOf(getPlayerMaxXP())).append("\n");
                saveWriter.append(String.valueOf(getPlayerXP())).append("\n");

                saveWriter.close();
            } else {
                System.out.println("ERROR: SLOT IS NOT AVAILABLE.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
