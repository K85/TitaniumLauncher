package com.sakurawald.ui.controller;

import com.github.ocraft.s2client.bot.S2Coordinator;
import com.github.ocraft.s2client.bot.setting.PlayerSettings;
import com.github.ocraft.s2client.bot.syntax.SettingsSyntax;
import com.github.ocraft.s2client.protocol.Sc2ApiSerializable;
import com.github.ocraft.s2client.protocol.game.Difficulty;
import com.github.ocraft.s2client.protocol.game.Race;
import com.sakurawald.Titanium;
import com.sakurawald.bot.EmptyBot;
import com.sakurawald.debug.LoggerManager;
import com.sakurawald.launcher.Launcher;
import com.sakurawald.plugin.PluginBase;
import com.sakurawald.plugin.PluginManager;
import com.sakurawald.ui.App;
import com.sakurawald.util.JavaFxUtil;
import com.typesafe.config.ConfigFactory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class AppController extends Controller {

    @FXML
    public ComboBox<Race> combobox_choose_opponent_ai_race;
    @FXML
    public Button button_launch;
    @FXML
    public ComboBox<PluginBase> combobox_choose_opponent_ai_bot;
    @FXML
    private ComboBox<Race> combobox_choose_player_race;
    @FXML
    private ComboBox<Race> combobox_choose_opponent_computer_race;
    @FXML
    private ComboBox<Difficulty> combobox_choose_opponent_computer_difficulty;
    @FXML
    private TextField textfield_map;
    @FXML
    private Tab tab_opponent_computer;
    @FXML
    private Tab tab_opponent_ai;
    @FXML
    private Button button_browse;

    @FXML
    void button_browse_onAction(ActionEvent event) {
        // Select A Map.
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose A StarCraft II Map. (Or Input the BattleNet MapName)");
        fileChooser.setInitialDirectory(new File(Titanium.getLauncherMapsPath()));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("SC2Map", "*.SC2Map")
        );
        File chooseMap = fileChooser.showOpenDialog(App.appInstance.getStage());

        // Set ChooseMap.
        if (chooseMap != null) this.textfield_map.setText(chooseMap.getAbsolutePath());
    }

    private void disableControl() {
        this.button_launch.setDisable(true);
        this.combobox_choose_opponent_ai_bot.setDisable(true);
        this.combobox_choose_opponent_ai_race.setDisable(true);
        this.combobox_choose_opponent_computer_difficulty.setDisable(true);
        this.combobox_choose_opponent_computer_race.setDisable(true);
        this.combobox_choose_player_race.setDisable(true);
        this.textfield_map.setDisable(true);
        this.button_browse.setDisable(true);
        this.button_launch.setText("Playing...");
    }

    private void enableControl() {
        this.button_launch.setDisable(false);
        this.combobox_choose_opponent_ai_bot.setDisable(false);
        this.combobox_choose_opponent_ai_race.setDisable(false);
        this.combobox_choose_opponent_computer_difficulty.setDisable(false);
        this.combobox_choose_opponent_computer_race.setDisable(false);
        this.combobox_choose_player_race.setDisable(false);
        this.textfield_map.setDisable(false);
        this.button_browse.setDisable(false);
        App.appInstance.getController().button_launch.setText("Launch");
    }

    @FXML
    void button_launch_onAction(ActionEvent event) {

        // Check Map.
        if (this.textfield_map.getText().trim().isEmpty()) {
            JavaFxUtil.DialogTools.errorDialog("Map Can't Be Empty.");
            return;
        }

        disableControl();

        new Thread(() -> {

            String map = this.textfield_map.getText();
            SettingsSyntax settingsSyntax = null;
            PlayerSettings player = null;
            PlayerSettings opponent = null;

            try {
                // Vs Computer.
                if (tab_opponent_computer.isSelected()) {
                    settingsSyntax = S2Coordinator.setup().setRealtime(true);
                    player = S2Coordinator.createParticipant(this.combobox_choose_player_race.getSelectionModel().getSelectedItem(), new EmptyBot(), "Player");
                    opponent = S2Coordinator.createComputer(this.combobox_choose_opponent_computer_race.getSelectionModel().getSelectedItem(),
                            this.combobox_choose_opponent_computer_difficulty.getSelectionModel().getSelectedItem(), "Opponent");
                }


                if (tab_opponent_ai.isSelected()) {
                    PluginBase choosePlugin = combobox_choose_opponent_ai_bot.getSelectionModel().getSelectedItem();

                    if (choosePlugin == null) {
                        Platform.runLater(() -> {
                            JavaFxUtil.DialogTools.errorDialog("Bot Can't Be Empty.");
                        });
                        return;
                    }

                    // Call -> PluginBase.beforeLaunch()
                    choosePlugin.beforeLaunch();

                    settingsSyntax = choosePlugin.generateSettingsSyntax();
                    player = S2Coordinator.createParticipant(this.combobox_choose_player_race.getSelectionModel().getSelectedItem(), new EmptyBot(), "Player");
                    opponent = S2Coordinator.createParticipant(this.combobox_choose_opponent_ai_race.getSelectionModel().getSelectedItem(), choosePlugin.generateS2Agent(), "Opponent");
                }

                Launcher.launch(map, settingsSyntax, player, opponent);
            } catch (Exception e) {
                LoggerManager.reportException(e);
            } finally {
                Platform.runLater(() -> {
                    enableControl();
                });
            }

        }).start();

    }


    private void initRaceCombobox(ComboBox<Race> combobox_race) {
        combobox_race.getItems().clear();
        combobox_race.getItems().addAll(Race.TERRAN, Race.ZERG, Race.PROTOSS, Race.RANDOM);
        combobox_race.getSelectionModel().select(Race.TERRAN);
    }

    private void initDifficultyCombobox(ComboBox<Difficulty> combobox_difficulty) {
        combobox_difficulty.getItems().clear();
        combobox_difficulty.getItems().addAll(Difficulty.values());
        combobox_difficulty.getSelectionModel().select(Difficulty.MEDIUM);
    }

    private void initPluginsCombobox() {
        combobox_choose_opponent_ai_bot.getItems().clear();
        combobox_choose_opponent_ai_bot.getItems().addAll(PluginManager.getLoadedPlugins());
        if (!combobox_choose_opponent_ai_bot.getItems().isEmpty()) {
            combobox_choose_opponent_ai_bot.getSelectionModel().selectFirst();
        }
    }

    @FXML
    void initialize() {

        // Add Races to Race Combobox.
        initRaceCombobox(combobox_choose_player_race);
        initRaceCombobox(combobox_choose_opponent_ai_race);
        initRaceCombobox(combobox_choose_opponent_computer_race);

        // Add Difficulty to Difficulty Combobox.
        initDifficultyCombobox(combobox_choose_opponent_computer_difficulty);

        // Add Plugins.
        initPluginsCombobox();
    }

    @FXML
    void button_launch_onMouseClicked(MouseEvent event) {
        if (event.getButton() == MouseButton.MIDDLE && event.getClickCount() == 2)
            JavaFxUtil.DialogTools.informationDialog("Author: Teeth\nOpen Source: github.com/K85");
    }


}


