package com.group4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Player extends SaveFile implements Save {

    Player(int saveNum) {
        String saveFile = saveFilesPath + "\\Slot " + saveNum + ".txt";
        File save = new File(saveFile);

        try {
            Scanner saveReader = new Scanner(save);

            setSaveNum(Integer.parseInt(saveReader.nextLine()));
            isCombatTutorialCompleted = Boolean.parseBoolean(saveReader.nextLine());
            isTownHubTutorialCompleted = Boolean.parseBoolean(saveReader.nextLine());
            isCutscene2TutorialCompleted = Boolean.parseBoolean(saveReader.nextLine());
            isTheRuinsCompleted = Boolean.parseBoolean(saveReader.nextLine());
            isDSBForestCompleted = Boolean.parseBoolean(saveReader.nextLine());
            isCadizShoreCompleted = Boolean.parseBoolean(saveReader.nextLine());
            setPlayerName(saveReader.nextLine());
            setPlayerRace(saveReader.nextLine());
            setPlayerMaxHealth(Integer.parseInt(saveReader.nextLine()));
            setPlayerHealth(Integer.parseInt(saveReader.nextLine()));
            setPlayerAttack(Integer.parseInt(saveReader.nextLine()));
            setPlayerDefense(Integer.parseInt(saveReader.nextLine()));
            setLegSword(Boolean.parseBoolean(saveReader.nextLine()));
            setLegArmor(Boolean.parseBoolean(saveReader.nextLine()));
            setLegPants(Boolean.parseBoolean(saveReader.nextLine()));
            setLolaRemedios(Integer.parseInt(saveReader.nextLine()));
            setTempleKey(Integer.parseInt(saveReader.nextLine()));

            saveReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void save(boolean isCombatTutorialCompleted, boolean isTownHubTutorialCompleted, boolean isCutscene2TutorialCompleted,
                     boolean isTheRuinsCompleted, boolean isDSBForestCompleted, boolean isCadizShoreCompleted,
                     int playerMaxHealth, int playerHealth, int playerAttack, int playerDefense,
                     boolean legSword, boolean legArmor, boolean legPants, int lolaRemedios, int templeKey,
                     int playerLevel, int playerMaxXP, int playerXP) {
        this.isCombatTutorialCompleted = isCombatTutorialCompleted;
        this.isTownHubTutorialCompleted = isTownHubTutorialCompleted;
        this.isCutscene2TutorialCompleted = isCutscene2TutorialCompleted;
        this.isTheRuinsCompleted = isTheRuinsCompleted;
        this.isDSBForestCompleted = isDSBForestCompleted;
        this.isCadizShoreCompleted = isCadizShoreCompleted;
        setPlayerMaxHealth(playerMaxHealth);
        setPlayerHealth(playerHealth);
        setPlayerAttack(playerAttack);
        setPlayerDefense(playerDefense);
        setLegSword(legSword);
        setLegArmor(legArmor);
        setLegPants(legPants);
        setLolaRemedios(lolaRemedios);
        setTempleKey(templeKey);
    }

    @Override
    public void writeToPlayerFile(int saveNum) {
        String saveFile = saveFilesPath + "\\Slot " + saveNum + ".txt";
        File save = new File(saveFile);

        try {
            if (save.exists()) {
                FileWriter saveWriter = new FileWriter(save, false);

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

                saveWriter.close();
            } else {
                System.out.println("ERROR: NO SAVE FILE FOUND.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
