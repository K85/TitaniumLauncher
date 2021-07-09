package com.sakurawald.ui.bean;

import com.sakurawald.bot.TitaniumBot;
import com.sakurawald.file.config.FileManager;

public class CheatCommands {

    public static void showMap() {
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugShowMap().sendDebug());
    }

    public static void enemyControl() {
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugEnemyControl().sendDebug());
    }


    public static void giveAllTech() {
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugGiveAllTech().sendDebug());
    }

    public static void giveAllUpgrades() {
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugGiveAllUpgrades().sendDebug());
    }

    public static void ignoreFood() {
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugIgnoreFood().sendDebug());
    }

    public static void ignoreMineral() {
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugIgnoreMineral().sendDebug());
    }

    public static void ignoreResourceCost() {
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugIgnoreResourceCost().sendDebug());
    }

    public static void giveAllResources() {
        TitaniumBot.getTitaniumBots().forEach(bot -> {
            for (int i = 0; i < 20; i++) {
                bot.debug().debugGiveAllResources().sendDebug();
            }
        });
    }

    public static void fastBuild() {
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugFastBuild().sendDebug());
    }

    public static void godMode() {
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugGodMode().sendDebug());
    }

    public static void noCooldowns() {
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugNoCooldowns().sendDebug());
    }

    public static void quickCheatAccordingToConfig() {

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.giveAllResources) {
            CheatCommands.giveAllResources();
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.disableWarFog) {
            CheatCommands.showMap();
        }


        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.giveAllTech) {
            CheatCommands.giveAllTech();
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.giveAllUpgrades) {
            CheatCommands.giveAllUpgrades();
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.ignoreFood) {
            CheatCommands.ignoreFood();
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.ignoreMineral) {
            CheatCommands.ignoreMineral();
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.ignoreResourceCost) {
            CheatCommands.ignoreResourceCost();
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.fastBuild) {
            CheatCommands.fastBuild();
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.enemyControl) {
            CheatCommands.enemyControl();
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.godMode) {
            CheatCommands.godMode();
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.noCooldowns) {
            CheatCommands.noCooldowns();
        }

    }
}
