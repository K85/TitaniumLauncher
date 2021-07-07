package com.sakurawald.launcher;

import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.bot.setting.PlayerSettings;
import com.github.ocraft.s2client.bot.syntax.SettingsSyntax;
import com.github.ocraft.s2client.protocol.game.BattlenetMap;
import com.github.ocraft.s2client.protocol.game.LocalMap;
import com.sakurawald.ui.controller.AppController;
import com.sakurawald.util.JavaFxUtil;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Launcher {

    private static ArrayList<S2Coordinator> launchedS2Coordinators = new ArrayList<>();


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
        s2Coordinator.quit();


    }


}
