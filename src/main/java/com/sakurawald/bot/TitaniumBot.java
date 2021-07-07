package com.sakurawald.bot;

import SC2APIProtocol.Debug;
import SC2APIProtocol.Sc2Api;
import com.github.ocraft.s2client.bot.ClientEvents;
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
import com.sakurawald.debug.TimeClocker;
import com.sakurawald.ui.bean.DebugTextQueue;
import javafx.util.Pair;
import org.mvel2.debug.DebugTools;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class TitaniumBot extends S2Agent {

    @Override
    public void onStep() {
       // System.out.println("gamelLoop = " + this.observation().getGameLoop());


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
        String text =  time.getKey() + ":" + time.getValue() + unitInPool.getUnit().get().getType() + "进入了视野";
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
