package com.sakurawald.ui.bean;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DebugTextQueue {

    private final int maxTextAmount;
    private final Deque<String> textQueue = new LinkedList();

    public DebugTextQueue(int maxTextAmount) {
        this.maxTextAmount = maxTextAmount;
    }

    public void addText(String text) {
        this.textQueue.addLast(text);

        if (this.textQueue.size() > this.maxTextAmount) {
            this.textQueue.removeFirst();
        }
    }

    public String formatTexts() {
        StringBuilder sb = new StringBuilder();
        textQueue.forEach(text -> {sb.append(text).append("\n");});
        return sb.toString();
    }

}
