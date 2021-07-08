package com.sakurawald.ui.controller;

import com.github.ocraft.s2client.protocol.data.UnitType;
import com.github.ocraft.s2client.protocol.data.Units;
import com.github.ocraft.s2client.protocol.debug.Color;
import com.github.ocraft.s2client.protocol.spatial.Point;
import com.github.ocraft.s2client.protocol.spatial.Point2d;
import com.github.ocraft.s2client.protocol.unit.Unit;
import com.sakurawald.bot.TitaniumBot;
import com.sakurawald.file.config.FileManager;
import com.sakurawald.ui.bean.DrawGraphicsType;
import com.sakurawald.ui.bean.UnitWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class SettingsController extends Controller {

    @FXML
    private CheckBox checkbox_client_real_time;

    @FXML
    private CheckBox checkbox_client_multi_threads;

    @FXML
    private CheckBox checkbox_client_raw_affects_selection;

    @FXML
    private CheckBox checkbox_client_show_burrowed;

    @FXML
    private CheckBox checkbox_client_show_cloaked;

    @FXML
    private CheckBox checkbox_client_trace;

    @FXML
    private CheckBox checkbox_client_verbose;

    @FXML
    private CheckBox checkbox_client_needs_support_dir;

    @FXML
    private CheckBox checkbox_client_raw_crop_to_playable_area;

    @FXML
    private CheckBox checkbox_client_use_generalized_ability_id;

    @FXML
    private TextField textfield_client_load_settings;

    @FXML
    private TextField textfield_client_window_location_left;

    @FXML
    private TextField textfield_client_window_location_top;

    @FXML
    private TextField textfield_client_data_dir;

    @FXML
    private TextField textfield_client_data_version;

    @FXML
    private TextField textfield_client_egl_path;

    @FXML
    private TextField textfield_client_os_mesa_path;

    @FXML
    private TextField textfield_client_process_path;

    @FXML
    private TextField textfield_client_temp_dir;

    @FXML
    private TextField textfield_client_step_size;

    @FXML
    private TextField textfield_client_timeout_ms;

    @FXML
    private TextField textfield_client_window_size_width;

    @FXML
    private TextField textfield_client_window_size_height;

    @FXML
    private CheckBox checkbox_cheat_disable_war_fog;

    @FXML
    private CheckBox checkbox_cheat_god_mode;

    @FXML
    private CheckBox checkbox_cheat_enemy_control;

    @FXML
    private CheckBox checkbox_cheat_give_all_resources;

    @FXML
    private CheckBox checkbox_cheat_fast_build;

    @FXML
    private CheckBox checkbox_cheat_give_all_tech;

    @FXML
    private CheckBox checkbox_cheat_give_all_upgrades;

    @FXML
    private CheckBox checkbox_cheat_ignore_food;

    @FXML
    private CheckBox checkbox_cheat_ignore_mineral;

    @FXML
    private CheckBox checkbox_cheat_ignore_resource_cost;

    @FXML
    private CheckBox checkbox_cheat_no_cooldowns;

    @FXML
    private TextField textfield_cheat_score;

    @FXML
    private Button button_cheat_score_set;

    @FXML
    private ComboBox<UnitType> combobox_cheat_createunit_unittype;

    @FXML
    private TextField textfield_cheat_createunit_x;

    @FXML
    private TextField textfield_cheat_createunit_y;

    @FXML
    private Button button_cheat_createunit_create;

    @FXML
    private TextField textfield_cheat_createunit_alliance;

    @FXML
    private TextField textfield_cheat_createunit_amount;

    @FXML
    public ComboBox<UnitWrapper> combobox_cheat_killunit_target_unit;

    @FXML
    private Button button_cheat_killunit_kill;

    @FXML
    private TextArea textarea_cheat_killunit_unitinfo;

    @FXML
    private ComboBox<DrawGraphicsType> combobox_cheat_draw_graphics_type;

    @FXML
    private TextField textfield_cheat_draw_point1_x;

    @FXML
    private TextField textfield_cheat_draw_point1_y;

    @FXML
    private TextField textfield_cheat_draw_point2_x;

    @FXML
    private TextField textfield_cheat_draw_point2_y;

    @FXML
    private TextField textfield_cheat_draw_value1;

    @FXML
    private TextField textfield_cheat_draw_value2;

    @FXML
    private Button button_cheat_draw;

    @FXML
    private TextField textfield_cheat_draw_color_r;

    @FXML
    private TextField textfield_cheat_draw_color_g;

    @FXML
    private TextField textfield_cheat_draw_color_b;

    @FXML
    private TextField textfield_cheat_valuepercentagecontrol_lifepercentage;

    @FXML
    private TextField textfield_cheat_valuepercentagecontrol_shieldpercentage;

    @FXML
    private TextField textfield_cheat_valuepercentagecontrol_energypercentage;

    @FXML
    private ListView<?> list_cheat_valuespecificcontrol_unittypes;

    @FXML
    private TextField textfield_cheat_valuespecificcontrol_additem_life;

    @FXML
    private TextField textfield_cheat_valuespecificcontrol_additem_shield;

    @FXML
    private TextField textfield_cheat_valuespecificcontrol_additem_energy;

    @FXML
    private ComboBox<?> combobox_cheat_valuespecificcontrol_additem_unittype;

    @FXML
    private Button button_cheat_valuespecificcontrol_additem_add;

    @FXML
    private CheckBox checkbox_monitor_events;

    @FXML
    private TextArea textarea_monitor;

    @FXML
    private CheckBox checkbox_monitor_eventalert_idleworkeralert;

    @FXML
    private CheckBox checkbox_monitor_eventalert_nuclearlaunchdetectedalert;

    @FXML
    private CheckBox checkbox_monitor_eventalert_unitentervisionalert;

    @FXML
    private CheckBox checkbox_monitor_eventalert_nydusdetectedalert;

    @FXML
    private CheckBox checkbox_monitor_eventalert_unitcreatedalert;

    @FXML
    private CheckBox checkbox_monitor_eventalert_unitdestroyalert;

    @FXML
    private CheckBox checkbox_monitor_eventalert_upgradecompletedalert;

    @FXML
    private CheckBox checkbox_monitor_eventalert_buildingcompletedalert;

    @FXML
    void button_cheat_createunit_create_onAction(ActionEvent event) {
        UnitType unitType = combobox_cheat_createunit_unittype.getSelectionModel().getSelectedItem();
        float x = Float.parseFloat(textfield_cheat_createunit_x.getText());
        float y = Float.parseFloat(textfield_cheat_createunit_y.getText());
        int alliance = Integer.parseInt(textfield_cheat_createunit_alliance.getText());
        int amount = Integer.parseInt(textfield_cheat_createunit_amount.getText());

        TitaniumBot.getTitaniumBots().forEach(bot -> {
            bot.debug().debugCreateUnit(unitType, Point2d.of(x, y), alliance, amount).sendDebug();
        });
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    @FXML
    void button_cheat_draw_onAction(ActionEvent event) {

        /* Draw Graphics. */
        DrawGraphicsType drawGraphicsType = combobox_cheat_draw_graphics_type.getSelectionModel().getSelectedItem();
        Color color = Color.of(Integer.parseInt(textfield_cheat_draw_color_r.getText()), Integer.parseInt(textfield_cheat_draw_color_g.getText()), Integer.parseInt(textfield_cheat_draw_color_b.getText()));
        Point pointI = Point.of(Float.parseFloat(textfield_cheat_draw_point1_x.getText()), Float.parseFloat(textfield_cheat_draw_point1_y.getText()));
        Point pointII = Point.of(Float.parseFloat(textfield_cheat_draw_point2_x.getText()), Float.parseFloat(textfield_cheat_draw_point2_y.getText()));
        String valueI = textfield_cheat_draw_value1.getText();
        String valueII = textfield_cheat_draw_value2.getText();

        if (drawGraphicsType == DrawGraphicsType.LINE) {
            TitaniumBot.getTitaniumBots().forEach(bot -> {
                bot.debug().debugLineOut(pointI, pointII, color);
            });
            return;
        }

        if (drawGraphicsType == DrawGraphicsType.BOX) {
            TitaniumBot.getTitaniumBots().forEach(bot -> {
                bot.debug().debugBoxOut(pointI, pointII, color);
            });
            return;
        }

        if (drawGraphicsType == DrawGraphicsType.SPHERE) {
            TitaniumBot.getTitaniumBots().forEach(bot -> {
                bot.debug().debugSphereOut(pointI, Float.parseFloat(valueI), color);
            });
            return;
        }

        if (drawGraphicsType == DrawGraphicsType.TEXT) {
            TitaniumBot.getTitaniumBots().forEach(bot -> {
                bot.debug().debugTextOut(valueI, pointI, color, Integer.parseInt(valueII));
            });
            return;
        }

    }

    @FXML
    void button_cheat_killunit_kill_onAction(ActionEvent event) {
        UnitWrapper unitWrapper = combobox_cheat_killunit_target_unit.getSelectionModel().getSelectedItem();
        TitaniumBot.getTitaniumBots().forEach(bot -> {
            bot.debug().debugKillUnit(unitWrapper.getUnit()).sendDebug();
        });
    }

    @FXML
    void button_cheat_score_set_onAction(ActionEvent event) {
        float scoreNewValue = Float.parseFloat(textfield_cheat_score.getText());
        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugSetScore(scoreNewValue));
    }

    @FXML
    void button_cheat_valuespecificcontrol_additem_add_onAction(ActionEvent event) {

    }



    @FXML
    void checkbox_cheat_disable_war_fog_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.disableWarFog = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugShowMap().sendDebug());
    }

    @FXML
    void checkbox_cheat_enemy_control_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.enemyControl = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugEnemyControl().sendDebug());
    }


    @FXML
    void checkbox_monitor_events_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.monitor_events = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }


    @FXML
    void checkbox_monitor_eventalert_buildingcompletedalert_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.buildingCompletedAlert = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_monitor_eventalert_idleworkeralert_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.idleWorkerAlert = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();


    }

    @FXML
    void checkbox_monitor_eventalert_nucleardetectedalert_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.nuclearLaunchDetectedAlert = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_monitor_eventalert_nydusdetectedalert_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.nydusDetectedAlert = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();


    }

    @FXML
    void checkbox_monitor_eventalert_unitcreatedalert_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.unitCreatedAlert = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_monitor_eventalert_unitdestroyalert_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.unitDestroyAlert  = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();


    }

    @FXML
    void checkbox_monitor_eventalert_unitentervisionalert_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.unitEnterVisionAlert = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_monitor_eventalert_upgradecompletedalert_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.upgradeCompletedAlert = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_cheat_fast_build_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.fastBuild  = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugFastBuild().sendDebug());
    }

    @FXML
    void checkbox_cheat_give_all_resources_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.giveAllResources  = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> {
            for (int i = 0; i < 20; i++) {
                bot.debug().debugGiveAllResources().sendDebug();
            }
        });
    }

    @FXML
    void checkbox_cheat_give_all_tech_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.giveAllTech  = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugGiveAllTech().sendDebug());
    }

    @FXML
    void checkbox_cheat_give_all_upgrades_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.giveAllUpgrades = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugGiveAllUpgrades().sendDebug());
    }

    @FXML
    void checkbox_cheat_god_mode_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.godMode = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugGodMode().sendDebug());
    }

    @FXML
    void checkbox_cheat_ignore_food_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.ignoreFood = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugIgnoreFood().sendDebug());
    }

    @FXML
    void checkbox_cheat_ignore_mineral_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.ignoreMineral = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugIgnoreMineral().sendDebug());
    }

    @FXML
    void checkbox_cheat_ignore_resource_cost_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.ignoreResourceCost = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugIgnoreResourceCost().sendDebug());
    }

    @FXML
    void checkbox_client_multi_threads_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.multiThreads = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_client_needs_support_dir_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.needsSupportDir = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_cheat_no_cooldowns_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.noCooldowns = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

        TitaniumBot.getTitaniumBots().forEach(bot -> bot.debug().debugNoCooldowns().sendDebug());
    }

    @FXML
    void checkbox_client_raw_affects_selection_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.rawAffectsSelection = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_client_raw_crop_to_playable_area_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.rawCropToPlayableArea  = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_client_real_time_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.realTime = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();


    }

    @FXML
    void checkbox_client_show_burrowed_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.showBurrowed = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_client_show_cloaked_onAction(ActionEvent event) {

        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.showCloaked = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();

    }

    @FXML
    void checkbox_client_trace_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.trace = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_client_use_generalized_ability_id_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.useGeneralizedAbilityID = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void checkbox_client_verbose_onAction(ActionEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.verbose = ((CheckBox) event.getSource()).isSelected();
        saveUIConfig();
    }

    @FXML
    void combobox_cheat_createunit_unittype_onAction(ActionEvent event) {




    }

    private void resetUIWithDrawGraphicsType() {
        DrawGraphicsType drawGraphicsType = combobox_cheat_draw_graphics_type.getSelectionModel().getSelectedItem();

        if (drawGraphicsType == DrawGraphicsType.LINE
                || drawGraphicsType == DrawGraphicsType.BOX) {
            textfield_cheat_draw_point2_x.setDisable(false);
            textfield_cheat_draw_point2_y.setDisable(false);
            textfield_cheat_draw_value1.setDisable(true);
            textfield_cheat_draw_value2.setDisable(true);
        }

        if (drawGraphicsType == DrawGraphicsType.SPHERE) {
            textfield_cheat_draw_point2_x.setDisable(true);
            textfield_cheat_draw_point2_y.setDisable(true);
            textfield_cheat_draw_value1.setDisable(false);
            textfield_cheat_draw_value2.setDisable(true);
        }

        if (drawGraphicsType == DrawGraphicsType.TEXT) {
            textfield_cheat_draw_point2_x.setDisable(true);
            textfield_cheat_draw_point2_y.setDisable(true);
            textfield_cheat_draw_value1.setDisable(false);
            textfield_cheat_draw_value2.setDisable(false);
        }
    }

    @FXML
    void combobox_cheat_draw_graphics_type_onAction(ActionEvent event) {
        resetUIWithDrawGraphicsType();
    }

    @FXML
    void combobox_cheat_killunit_target_unit_onAction(ActionEvent event) {

    }

    @FXML
    void combobox_cheat_valuespecificcontrol_additem_unittype_onAction(ActionEvent event) {

    }


    @FXML
    void textfield_cheat_valuespecificcontrol_additem_energy_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValueSpecificControl.AddItem.energy = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_valuespecificcontrol_additem_life_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValueSpecificControl.AddItem.life  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_valuespecificcontrol_additem_shield_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValueSpecificControl.AddItem.shield  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_createunit_alliance_onKeyTyped(KeyEvent event) {

    }

    @FXML
    void textfield_cheat_createunit_amount_onKeyTyped(KeyEvent event) {

    }

    @FXML
    void textfield_cheat_createunit_x_onKeyTyped(KeyEvent event) {

    }

    @FXML
    void textfield_cheat_createunit_y_onKeyTyped(KeyEvent event) {

    }

    @FXML
    void textfield_client_data_dir_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.dataDir  = ((TextField) event.getSource()).getText();
        saveUIConfig();
    }

    @FXML
    void textfield_client_data_version_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.dataVersion  = ((TextField) event.getSource()).getText();
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_draw_color_b_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.colorB  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_draw_color_g_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.colorG  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_draw_color_r_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.colorR  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_draw_point1_x_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.pointI_x  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_draw_point1_y_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.pointI_y  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_draw_point2_x_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.pointII_x  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_draw_point2_y_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.pointII_y  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_draw_value1_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.valueI  = ((TextField) event.getSource()).getText();
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_draw_value2_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.valueII  = ((TextField) event.getSource()).getText();
        saveUIConfig();
    }

    @FXML
    void textfield_client_egl_path_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.eglPath  = ((TextField) event.getSource()).getText();
        saveUIConfig();
    }

    @FXML
    void textfield_client_load_settings_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.loadSettings  = ((TextField) event.getSource()).getText();
        saveUIConfig();
    }

    @FXML
    void textfield_client_os_mesa_path_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.osMesaPath  = ((TextField) event.getSource()).getText();
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_score_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.score  = Float.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_client_step_size_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.stepSize  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_client_temp_dir_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.tempDir  = ((TextField) event.getSource()).getText();
        saveUIConfig();
    }

    @FXML
    void textfield_client_timeout_ms_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.timeoutMS  = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_valuepercentagecontrol_energypercentage_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValuePercentageControl.energyPercentage  = Float.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_valuepercentagecontrol_lifepercentage_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValuePercentageControl.lifePercentage  = Float.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_cheat_valuepercentagecontrol_shieldpercentage_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValuePercentageControl.shieldPercentage  = Float.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_client_window_location_left_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowLocation.left = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_client_window_location_top_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowLocation.top = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_client_window_size_height_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowSize.height = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_client_window_size_width_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowSize.width = Integer.valueOf(((TextField) event.getSource()).getText());
        saveUIConfig();
    }

    @FXML
    void textfield_client_process_path_onKeyTyped(KeyEvent event) {
        FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.processPath = ((TextField) event.getSource()).getText();
        saveUIConfig();
    }

    @FXML
    void combobox_cheat_killunit_target_unit_onMouseClicked(MouseEvent event) {

        if (event.getButton() == MouseButton.SECONDARY) {
            this.combobox_cheat_killunit_target_unit.getItems().clear();

            for (TitaniumBot titaniumBot : TitaniumBot.getTitaniumBots()) {
                titaniumBot.observation().getUnits().forEach(unitInPool -> {
                    Unit unit = unitInPool.unit();
                    if (unit != null) {
                        this.combobox_cheat_killunit_target_unit.getItems().add(new UnitWrapper(unit));
                    }
                });


            }


        }


    }


    public void saveUIConfig() {
        // Save UIConfig from Memory to Disk.
        FileManager.applicationConfig_File.saveMemoryConfigToDisk();
    }

    public void loadUIConfig() {

        /* Client */
        this.checkbox_client_real_time.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.realTime);
        this.checkbox_client_multi_threads.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.multiThreads);
        this.checkbox_client_raw_affects_selection.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.rawAffectsSelection);
        this.checkbox_client_show_burrowed.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.showBurrowed);
        this.checkbox_client_show_cloaked.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.showCloaked);
        this.checkbox_client_trace.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.trace);
        this.checkbox_client_verbose.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.verbose);
        this.checkbox_client_needs_support_dir.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.needsSupportDir);
        this.checkbox_client_raw_crop_to_playable_area.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.rawCropToPlayableArea);
        this.checkbox_client_use_generalized_ability_id.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.useGeneralizedAbilityID);

        this.textfield_client_load_settings.setText(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.loadSettings);
        this.textfield_client_data_dir.setText(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.dataDir);
        this.textfield_client_data_version.setText(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.dataVersion);
        this.textfield_client_egl_path.setText(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.eglPath);
        this.textfield_client_os_mesa_path.setText(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.osMesaPath);
        this.textfield_client_process_path.setText(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.processPath);
        this.textfield_client_temp_dir.setText(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.tempDir);
        this.textfield_client_step_size.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.stepSize));
        this.textfield_client_timeout_ms.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.timeoutMS));
        this.textfield_client_window_location_left.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowLocation.left));
        this.textfield_client_window_location_top.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowLocation.top));
        this.textfield_client_window_size_width.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowSize.width));
        this.textfield_client_window_size_height.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Client.WindowSize.height));

        /* Cheat */
        this.checkbox_cheat_disable_war_fog.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.disableWarFog);
        this.checkbox_cheat_give_all_tech.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.giveAllTech);
        this.checkbox_cheat_give_all_upgrades.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.giveAllUpgrades);
        this.checkbox_cheat_give_all_resources.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.giveAllResources);
        this.checkbox_cheat_ignore_food.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.ignoreFood);
        this.checkbox_cheat_ignore_mineral.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.ignoreMineral);
        this.checkbox_cheat_ignore_resource_cost.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.ignoreResourceCost);
        this.checkbox_cheat_fast_build.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.fastBuild);
        this.checkbox_cheat_enemy_control.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.enemyControl);
        this.checkbox_cheat_god_mode.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.godMode);
        this.checkbox_cheat_no_cooldowns.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.noCooldowns);
        this.textfield_cheat_score.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Command.score));

        this.textfield_cheat_draw_color_r.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.colorR));
        this.textfield_cheat_draw_color_g.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.colorG));
        this.textfield_cheat_draw_color_b.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.colorB));
        this.textfield_cheat_draw_point1_x.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.pointI_x));
        this.textfield_cheat_draw_point1_y.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.pointI_y));
        this.textfield_cheat_draw_point2_x.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.pointII_x));
        this.textfield_cheat_draw_point2_y.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.pointII_y));
        this.textfield_cheat_draw_value1.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.valueI));
        this.textfield_cheat_draw_value2.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.Draw.valueII));

        this.textfield_cheat_valuepercentagecontrol_lifepercentage.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValuePercentageControl.lifePercentage));
        this.textfield_cheat_valuepercentagecontrol_shieldpercentage.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValuePercentageControl.shieldPercentage));
        this.textfield_cheat_valuepercentagecontrol_energypercentage.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValuePercentageControl.energyPercentage));
        this.textfield_cheat_valuespecificcontrol_additem_life.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValueSpecificControl.AddItem.life));
        this.textfield_cheat_valuespecificcontrol_additem_shield.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValueSpecificControl.AddItem.shield));
        this.textfield_cheat_valuespecificcontrol_additem_energy.setText(String.valueOf(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValueSpecificControl.AddItem.energy));

        /* Draw */
        this.checkbox_monitor_events.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.monitor_events);
        this.checkbox_monitor_eventalert_buildingcompletedalert.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.buildingCompletedAlert);
        this.checkbox_monitor_eventalert_upgradecompletedalert.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.upgradeCompletedAlert);
        this.checkbox_monitor_eventalert_idleworkeralert.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.idleWorkerAlert);
        this.checkbox_monitor_eventalert_nuclearlaunchdetectedalert.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.nuclearLaunchDetectedAlert);
        this.checkbox_monitor_eventalert_nydusdetectedalert.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.nydusDetectedAlert);
        this.checkbox_monitor_eventalert_unitcreatedalert.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.unitCreatedAlert);
        this.checkbox_monitor_eventalert_unitdestroyalert.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.unitDestroyAlert);
        this.checkbox_monitor_eventalert_unitentervisionalert.setSelected(FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.unitEnterVisionAlert);
    }

    @FXML
    public void initialize() {
        /** Load UIConfig. **/
        loadUIConfig();

        /* Load DrawGraphicsTypes. */
        loadDrawGraphicsTypes();

        /* Load UnitTypes */
        loadCreateUnitUnitTypes();
    }

    private void loadDrawGraphicsTypes() {
        this.combobox_cheat_draw_graphics_type.getItems().addAll(DrawGraphicsType.values());
        this.combobox_cheat_draw_graphics_type.getSelectionModel().selectFirst();
        this.resetUIWithDrawGraphicsType();
    }

    private void loadCreateUnitUnitTypes() {
        this.combobox_cheat_createunit_unittype.getItems().addAll(Units.values());
        this.combobox_cheat_createunit_unittype.getSelectionModel().selectFirst();
    }

}
