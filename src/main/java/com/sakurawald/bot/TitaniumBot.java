package com.sakurawald.bot;

import SC2APIProtocol.Debug;
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
import com.github.ocraft.s2client.protocol.spatial.PointI;
import com.github.ocraft.s2client.protocol.unit.Unit;
import org.mvel2.debug.DebugTools;

public class TitaniumBot extends S2Agent {

    @Override
    public void onStep() {

    }


    @Override
    public void onUnitDestroyed(UnitInPool unitInPool) {

    }

    @Override
    public void onUnitCreated(UnitInPool unitInPool) {
        Unit unit = unitInPool.getUnit().get();
        Point point = unit.getPosition();



    }



    @Override
    public void onGameStart() {
        //debug().debugTextOut("游戏已经开始", Color.RED).sendDebug();


        this.debug().debugGodMode().sendDebug();
        this.debug().debugShowMap().sendDebug();

//        PointI pointI = this.observation().getGameInfo().findCenterOfMap();
//        this.debug().debugSphereOut(Point.of(pointI.getX(), pointI.getY()), 10, Color.RED).sendDebug();




    }



}
