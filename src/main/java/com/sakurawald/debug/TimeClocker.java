package com.sakurawald.debug;

import javafx.util.Pair;

public class TimeClocker {

    public static final int THREE_SECONDS_TO_WAIT = 3000;

    private long startTimestamp = 0;
    private final long offsetTimestamp;

    public TimeClocker(long offsetTimestamp) {
        this.offsetTimestamp = offsetTimestamp;
    }

    public TimeClocker() {
        this(0);
    }

    public void startTimeClock() {
        if (startTimestamp == 0) this.startTimestamp = System.currentTimeMillis();
    }

    public int getPassedSeconds() {
        return (int) (System.currentTimeMillis() - this.startTimestamp + offsetTimestamp) / 1000;
    }

    public Pair<Integer, Integer> getPassedTime() {
        int passedSeconds = this.getPassedSeconds();
        int minutes = passedSeconds / 60;
        int seconds = passedSeconds % 60;
        return new Pair<>(minutes, seconds);
    }
}
