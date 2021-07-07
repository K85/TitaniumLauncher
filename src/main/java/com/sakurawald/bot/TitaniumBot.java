package com.sakurawald.bot;

import SC2APIProtocol.Debug;
import com.github.ocraft.s2client.bot.S2Agent;
import com.github.ocraft.s2client.bot.S2ReplayObserver;
import com.github.ocraft.s2client.bot.gateway.ActionFeatureLayerInterface;
import com.github.ocraft.s2client.bot.gateway.ActionInterface;
import com.github.ocraft.s2client.bot.gateway.DebugInterface;
import com.github.ocraft.s2client.bot.gateway.UnitInPool;
import com.github.ocraft.s2client.protocol.data.UnitType;
import com.github.ocraft.s2client.protocol.debug.Color;
import com.github.ocraft.s2client.protocol.debug.DebugCommand;
import com.github.ocraft.s2client.protocol.debug.DebugDraw;
import com.github.ocraft.s2client.protocol.debug.DebugText;
import com.github.ocraft.s2client.protocol.game.Observer;
import com.github.ocraft.s2client.protocol.game.PlayerInfoExtra;
import com.github.ocraft.s2client.protocol.observation.Alert;
import com.github.ocraft.s2client.protocol.spatial.Point;
import com.github.ocraft.s2client.protocol.spatial.PointI;
import com.github.ocraft.s2client.protocol.unit.Unit;
import org.mvel2.debug.DebugTools;

public class TitaniumBot extends S2Agent {

    @Override
    public void onStep() {

    }




    @Override
    public void onUnitCreated(UnitInPool unitInPool) {
        Unit unit = unitInPool.getUnit().get();
        Point point = unit.getPosition();

//        System.out.println("文本总数：" +  Debug.DebugDraw.getDefaultInstance().getTextList().size());
        //Debug.DebugDraw.getDefaultInstance().getTextList().add()

        //this.debug().debugBoxOut(Point.of(point.getX(), point.getY()), Point.of(point.getX() - 20, point.getY() - 20), Color.GREEN).sendDebug();
//        this.debug().debugSphereOut(point, 10, Color.RED).sendDebug();
//        this.debug().debugSetLife(1500F, unit);
//        this.debug().debugSetShields(3000L, unit);
//        Debug.DebugText debugText = new DebugText.Builder().of("通过DebugText.build创建").withColor(Color.RED).withSize(64).build().toSc2Api();
//        Debug.DebugDraw.getDefaultInstance().getTextList().add(debugText);




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
