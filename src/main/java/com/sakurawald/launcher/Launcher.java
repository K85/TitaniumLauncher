package com.sakurawald.launcher;

import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.bot.setting.PlayerSettings;
import com.github.ocraft.s2client.bot.syntax.SettingsSyntax;
import com.github.ocraft.s2client.protocol.game.BattlenetMap;
import com.github.ocraft.s2client.protocol.game.LocalMap;
import com.sakurawald.bot.TitaniumBot;
import com.sakurawald.file.config.ConfigFile;
import com.sakurawald.file.config.FileManager;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Launcher {


    private static final ArrayList<S2Coordinator> launchedS2Coordinators = new ArrayList<>();


    public static ArrayList<S2Coordinator> getLaunchedS2Coordinators() {
        return launchedS2Coordinators;
    }

    public static void launch(String mapParam, SettingsSyntax settingsSyntax, PlayerSettings... entities) {

        S2Coordinator s2Coordinator = settingsSyntax.setParticipants(entities).launchStarcraft();

        Launcher.getLaunchedS2Coordinators().add(s2Coordinator);

        // Auto Choose Map.
        if (new File(mapParam).exists()) {
            s2Coordinator.startGame(LocalMap.of(Paths.get(mapParam)));
        } else {
            s2Coordinator.startGame(BattlenetMap.of(mapParam));
        }

        while (s2Coordinator.update()) {
            // Do nothing.
        }

        // Update TitaniumBots.
        TitaniumBot.clearInvalidTitaniumBots();

        s2Coordinator.quit();


    }

    public static SettingsSyntax getSettingsSyntaxAccordingToConfig() {

        SettingsSyntax settingsSyntax = S2Coordinator.setup()
                .setRealtime(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.realTime)
                .setTraced(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.trace)
                .setMultithreaded(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.multiThreads)
                .setNeedsSupportDir(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.needsSupportDir)
                .setRawAffectsSelection(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.rawAffectsSelection)
                .setRawCropToPlayableArea(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.rawCropToPlayableArea)
                .setShowBurrowed(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.showBurrowed)
                .setShowCloaked(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.showCloaked)
                .setUseGeneralizedAbilityId(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.useGeneralizedAbilityID)
                .setVerbose(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.verbose);


        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.dataVersion != null) {
            settingsSyntax.setDataVersion(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.dataVersion);
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.stepSize != ConfigFile.DefaultValue.INT_DEFAULT_VALUE) {
            settingsSyntax.setStepSize(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.stepSize);
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.dataDir != null) {
            settingsSyntax.setDataDir(Paths.get(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.dataDir));
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.processPath != null) {
            settingsSyntax.setProcessPath(Paths.get(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.processPath));
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.eglPath != null) {
            settingsSyntax.setEglPath(Paths.get(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.eglPath));
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.osMesaPath != null) {
            settingsSyntax.setOsMesaPath(Paths.get(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.osMesaPath));
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.tempDir != null) {
            settingsSyntax.setTmpDir(Paths.get(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.tempDir));
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.timeoutMS != ConfigFile.DefaultValue.INT_DEFAULT_VALUE) {
            settingsSyntax.setTimeoutMS(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.timeoutMS);
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowLocation.left != ConfigFile.DefaultValue.INT_DEFAULT_VALUE
                || FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowLocation.top != ConfigFile.DefaultValue.INT_DEFAULT_VALUE) {
            settingsSyntax.setWindowLocation(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowLocation.left, FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowLocation.top);
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowSize.width != ConfigFile.DefaultValue.INT_DEFAULT_VALUE
                || FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowSize.height != ConfigFile.DefaultValue.INT_DEFAULT_VALUE) {
            settingsSyntax.setWindowLocation(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowSize.width, FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowSize.height);
        }

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.loadSettings != null) {
            settingsSyntax.loadSettings(new String[]{FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.loadSettings});
        }

        return settingsSyntax;
    }

}
