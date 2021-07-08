package com.sakurawald.ui.bean;

public enum DrawGraphicsType {
    LINE("LINE"), BOX("BOX"), SPHERE("SPHERE"), TEXT("TEXT");

    private String name;

    DrawGraphicsType(String name) {
        this.name = name;
    }
}
