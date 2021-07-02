package com.sakurawald.launcher;

import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.bot.setting.PlayerSettings;
import com.github.ocraft.s2client.bot.syntax.SettingsSyntax;
import com.github.ocraft.s2client.protocol.game.BattlenetMap;
import com.github.ocraft.s2client.protocol.game.LocalMap;
import com.sakurawald.debug.LoggerManager;
import com.sakurawald.ui.App;
import javafx.application.Platform;

import java.io.File;
import java.nio.file.Paths;

public class Launcher {

    public static void launch(String mapParam, SettingsSyntax settingsSyntax, PlayerSettings... entities) {
        S2Coordinator s2Coordinator = settingsSyntax.setParticipants(entities).launchStarcraft();

        try {
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

        } catch (Exception e) {
            LoggerManager.reportException(e);
        } finally {
            Platform.runLater(() -> {
                App.appInstance.getController().button_launch.setDisable(false);
                App.appInstance.getController().button_launch.setText("Launch");
            });
        }
    }


}
