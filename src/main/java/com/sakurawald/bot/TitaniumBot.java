package com.sakurawald.bot;

import com.github.ocraft.s2client.bot.S2Agent;
import com.github.ocraft.s2client.bot.S2ReplayObserver;
import com.github.ocraft.s2client.bot.gateway.*;
import com.github.ocraft.s2client.protocol.data.UnitType;
import com.github.ocraft.s2client.protocol.debug.*;
import com.github.ocraft.s2client.protocol.game.Observer;
import com.github.ocraft.s2client.protocol.game.PlayerInfoExtra;
import com.github.ocraft.s2client.protocol.observation.Alert;
import com.github.ocraft.s2client.protocol.observation.Observation;
import com.github.ocraft.s2client.protocol.spatial.Point;
import com.github.ocraft.s2client.protocol.spatial.Point2d;
import com.github.ocraft.s2client.protocol.spatial.PointI;
import com.github.ocraft.s2client.protocol.unit.Unit;
import com.sakurawald.Titanium;
import com.sakurawald.debug.TimeClocker;
import com.sakurawald.ui.bean.DebugTextQueue;
import javafx.util.Pair;
import org.mvel2.debug.DebugTools;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class TitaniumBot extends S2Agent {

    /** Currently running TitaniumBots. **/
    private static ArrayList<TitaniumBot> titaniumBots = new ArrayList<>();

    public TitaniumBot() {
        getTitaniumBots().add(this);
    }

    public static ArrayList<TitaniumBot> getTitaniumBots() {
        return titaniumBots;
    }

    @Override
    public void onStep() {

    }


    @Override
    public void onUnitDestroyed(UnitInPool unitInPool) {

    }

    @Override
    public void onNuclearLaunchDetected() {

    }

    public DebugTextQueue debugTextQueue = new DebugTextQueue(5);

    @Override
    public void onUnitEnterVision(UnitInPool unitInPool) {
        Pair<Integer, Integer> time =  timeClocker.getPassedTime();
        String text =  time.getKey() + ":" + time.getValue() + unitInPool.getUnit().get().getType() + "enter vision";
        debugTextQueue.addText(text);

        this.debug().debugTextOut(debugTextQueue.formatTexts(), Color.BLUE).sendDebug();

    }

    @Override
    public void onUnitCreated(UnitInPool unitInPool) {
        Unit unit = unitInPool.getUnit().get();
        Point point = unit.getPosition();




    }


    TimeClocker timeClocker = new TimeClocker(TimeClocker.THREE_SECONDS_TO_WAIT);

    @Override
    public void onGameFullStart() {
        timeClocker.startTimeClock();
    }

    @Override
    public void onGameStart() {

        this.debug().debugGiveAllResources().sendDebug();
        this.debug().debugGiveAllResources().sendDebug();
        this.debug().debugGiveAllResources().sendDebug();
        this.debug().debugGiveAllResources().sendDebug();
        // this.debug().debugGodMode().sendDebug();
        // this.debug().debugShowMap().sendDebug();

    //        PointI pointI = this.observation().getGameInfo().findCenterOfMap();
    //        this.debug().debugSphereOut(Point.of(pointI.getX(), pointI.getY()), 10, Color.RED).sendDebug();



    }



}
