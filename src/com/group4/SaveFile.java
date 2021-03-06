package com.group4;

/*
PLEASE READ
FILE IS NOT YET FINISHED. DO NOT TOUCH.
COMMENTS ON PROGRESS TRACKERS ARE BASED ON THE LOA FINAL STORYBOARD:
https://jamboard.google.com/d/11rpBFbNEflwFLYJTfTqjNsvZLor4wbASEbyUtxpGnWU/edit?usp=sharing
 */

public class SaveFile {

    // Path of the directory containing all character save files
    public String saveFilesPath = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Legend of Albert\\Saves";

    /*
    Progress Trackers (NOT COMPLETE)
    Used for loading the player at the appropriate scene, level, progress, etc.
    Due to this system, if a player closes the game in the middle of a scene (e.g. a cutscene),
    they will be brought back to right after the previous tracker.
    */
    protected int saveNum;
    protected boolean isCombatTutorialCompleted; // true = page 9, false = page 7
    protected boolean isTownHubTutorialCompleted; // true = page 13, false = page 9
    protected boolean isCutscene2TutorialCompleted; // true = page 17, false = page 9 (but you can leave immediately)
    protected boolean isTheRuinsCompleted;
    protected boolean isDSBForestCompleted;
    protected boolean isCadizShoreCompleted;

    // Personal Info
    private String playerName;
    private String playerRace;

    // Combat Stats
    private int playerMaxHealth;
    private int playerHealth;
    private int playerAttack;
    private int playerDefense;

    // Equipment
    private boolean legSword;
    private boolean legArmor;
    private boolean legPants;
    private int lolaRemedios;
    private int templeKey;

    public int getSaveNum() {
        return saveNum;
    };

    public void setSaveNum(int saveNum) {
        this.saveNum = saveNum;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(String playerRace) {
        this.playerRace = playerRace;
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerAttack() {
        return playerAttack;
    }

    public void setPlayerAttack(int playerAttack) {
        this.playerAttack = playerAttack;
    }

    public int getPlayerDefense() {
        return playerDefense;
    }

    public void setPlayerDefense(int playerDefense) {
        this.playerDefense = playerDefense;
    }

    public boolean getLegSword() {
        return legSword;
    }

    public void setLegSword(boolean legSword) {
        this.legSword = legSword;
    }

    public boolean getLegArmor() {
        return legArmor;
    }

    public void setLegArmor(boolean legArmor) {
        this.legArmor = legArmor;
    }

    public boolean getLegPants() {
        return legPants;
    }

    public void setLegPants(boolean legPants) {
        this.legPants = legPants;
    }

    public int getLolaRemedios() {
        return lolaRemedios;
    }

    public void setLolaRemedios(int lolaRemedios) {
        this.lolaRemedios = lolaRemedios;
    }

    public int getTempleKey() {
        return templeKey;
    }

    public void setTempleKey(int templeKey) {
        this.templeKey = templeKey;
    }

}

interface Save {
    void writeToPlayerFile(int saveNum);
}