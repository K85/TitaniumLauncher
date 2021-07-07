package com.sakurawald.launcher;

import com.github.ocraft.s2client.bot.S2Coordinator;

public abstract class LaunchThread extends Thread {

    private final S2Coordinator s2Coordinator;

    public LaunchThread(S2Coordinator s2Coordinator) {
        this.s2Coordinator = s2Coordinator;
    }


}
