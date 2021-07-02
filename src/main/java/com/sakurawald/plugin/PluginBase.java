package com.sakurawald.plugin;

import com.github.ocraft.s2client.bot.S2Agent;
import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.bot.syntax.SettingsSyntax;
import com.github.ocraft.s2client.protocol.game.Race;
import com.sakurawald.ui.App;

public abstract class PluginBase {

    @Override
    public String toString() {
        return this.getPluginName();
    }

    public abstract String getPluginName();

    public SettingsSyntax generateSettingsSyntax() {
        return S2Coordinator.setup().setRealtime(true);
    }

    public abstract S2Agent generateS2Agent();

    /**
     * Do some init if needed.
     **/
    public abstract void beforeLaunch();

    public Race getChooseBotRace() {
        return App.appInstance.getController().combobox_choose_opponent_ai_race.getSelectionModel().getSelectedItem();
    }

}
