package com.sakurawald.bot;

import com.github.ocraft.s2client.bot.S2Agent;
import com.github.ocraft.s2client.bot.gateway.UnitInPool;
import com.github.ocraft.s2client.protocol.data.Units;
import com.github.ocraft.s2client.protocol.data.Upgrade;
import com.github.ocraft.s2client.protocol.debug.Color;
import com.github.ocraft.s2client.protocol.unit.Unit;
import com.sakurawald.debug.TimeClocker;
import com.sakurawald.file.config.FileManager;
import com.sakurawald.ui.bean.CheatCommands;
import com.sakurawald.ui.bean.DebugTextQueue;
import com.sakurawald.ui.bean.UnitValueSetter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class TitaniumBot extends S2Agent {

    /**
     * Currently running TitaniumBots.
     **/
    private static final ArrayList<TitaniumBot> titaniumBots = new ArrayList<>();
    private final TimeClocker timeClocker = new TimeClocker(-TimeClocker.THREE_SECONDS_TO_WAIT);
    private final DebugTextQueue debugTextQueue = new DebugTextQueue(5);

    public TitaniumBot() {
        getTitaniumBots().add(this);
    }

    public static void clearInvalidTitaniumBots() {

        Iterator<TitaniumBot> it = TitaniumBot.getTitaniumBots().stream().filter(bot -> bot.control().isFinishedGame()).iterator();

        while (it.hasNext()) {
            it.next().selfRemoveFromTitaniumBotList();
        }
    }

    public static ArrayList<TitaniumBot> getTitaniumBots() {
        return titaniumBots;
    }

    public DebugTextQueue getDebugTextQueue() {
        return debugTextQueue;
    }

    public void selfRemoveFromTitaniumBotList() {
        getTitaniumBots().remove(this);
    }

    @Override
    public void onUnitDestroyed(UnitInPool unitInPool) {

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.monitor_events
                && FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.unitDestroyAlert) {

            unitInPool.getUnit().ifPresent(unit -> {
                String text = timeClocker.getGameTimePrefix() + "unit " + unit.getType() + " destroyed";
                debugTextQueue.addText(text);
                this.debug().debugTextOut(debugTextQueue.formatTexts(), Color.BLUE).sendDebug();
            });

        }


    }

    @Override
    public void onNuclearLaunchDetected() {
        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.monitor_events
                && FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.nuclearLaunchDetectedAlert) {
            String text = timeClocker.getGameTimePrefix() + "nuclear launch detected !";
            debugTextQueue.addText(text);
            this.debug().debugTextOut(debugTextQueue.formatTexts(), Color.BLUE).sendDebug();
        }
    }


    @Override
    public void onNydusDetected() {
        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.monitor_events
                && FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.nydusDetectedAlert) {
            String text = timeClocker.getGameTimePrefix() + "nydus detected !";
            debugTextQueue.addText(text);
            this.debug().debugTextOut(debugTextQueue.formatTexts(), Color.BLUE).sendDebug();
        }
    }

    @Override
    public void onUnitIdle(UnitInPool unitInPool) {

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.monitor_events
                && FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.idleWorkerAlert) {
            unitInPool.getUnit().ifPresent(unit -> {
                        if (unit.getType() == Units.ZERG_DRONE ||
                                unit.getType() == Units.PROTOSS_PROBE ||
                                unit.getType() == Units.TERRAN_SCV) {
                            String text = timeClocker.getGameTimePrefix() + "worker idle";
                            debugTextQueue.addText(text);
                            this.debug().debugTextOut(debugTextQueue.formatTexts(), Color.BLUE).sendDebug();
                        }
                    }
            );
        }

    }

    @Override
    public void onUnitEnterVision(UnitInPool unitInPool) {

        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.monitor_events
                && FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.unitEnterVisionAlert) {
            String text = timeClocker.getGameTimePrefix() + unitInPool.getUnit().get().getType() + " enter vision";
            debugTextQueue.addText(text);
            this.debug().debugTextOut(debugTextQueue.formatTexts(), Color.BLUE).sendDebug();
        }


    }

    @Override
    public void onUpgradeCompleted(Upgrade upgrade) {
        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.monitor_events
                && FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.upgradeCompletedAlert) {
            String text = timeClocker.getGameTimePrefix() + "upgrade " + upgrade + " completed";
            debugTextQueue.addText(text);
            this.debug().debugTextOut(debugTextQueue.formatTexts(), Color.BLUE).sendDebug();
        }
    }

    @Override
    public void onBuildingConstructionComplete(UnitInPool unitInPool) {

        unitInPool.getUnit().ifPresent(unit -> {
            if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.monitor_events
                    && FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.buildingCompletedAlert) {
                String text = timeClocker.getGameTimePrefix() + "building " + unit + " completed";
                debugTextQueue.addText(text);
                this.debug().debugTextOut(debugTextQueue.formatTexts(), Color.BLUE).sendDebug();
            }
        });

    }

    @Override
    public void onUnitCreated(UnitInPool unitInPool) {

        Unit unit = unitInPool.unit();
        if (unit == null) return;

        /* Value Control: Percentage */
        float rate;
        if ((rate = FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValuePercentageControl.lifePercentage)
                != 1.0F && unit.getHealth().isPresent()) {
            this.debug().debugSetLife(unit.getHealth().get() * rate, unit);
        }

        if ((rate = FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValuePercentageControl.shieldPercentage)
                != 1.0F && unit.getShield().isPresent()) {
            this.debug().debugSetShields(unit.getShield().get() * rate, unit);
        }

        if ((rate = FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValuePercentageControl.energyPercentage)
                != 1.0F && unit.getEnergy().isPresent()) {
            this.debug().debugSetEnergy(unit.getEnergy().get() * rate, unit);
        }

        /* Value Control: Specific */
        Optional<UnitValueSetter> unitValueSetter = FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Cheat.ValueControl.ValueSpecificControl.addedUnitTypeList.stream().filter(setter -> setter.getUnitType() == unit.getType()).findFirst();
        unitValueSetter.ifPresent(valueSetter -> this.debug().debugSetLife(valueSetter.getHealth(), unit)
                .debugSetShields(valueSetter.getShield(), unit)
                .debugSetEnergy(valueSetter.getEnergy(), unit).sendDebug());


        /* Monitor */
        if (FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.monitor_events
                && FileManager.applicationConfig_File.getConfigDataClassInstance().Settings.Monitor.EventAlert.unitCreatedAlert) {
            String text = timeClocker.getGameTimePrefix() + "unit " + unit.getType() + " created";
            debugTextQueue.addText(text);
            this.debug().debugTextOut(debugTextQueue.formatTexts(), Color.BLUE).sendDebug();
        }
    }


    @Override
    public void onGameFullStart() {
        timeClocker.startTimeClock();
    }

    @Override
    public void onGameStart() {
        /* Quick Cheat. */
        CheatCommands.quickCheatAccordingToConfig();
    }


}
