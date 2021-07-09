package com.sakurawald.ui.bean;

import com.github.ocraft.s2client.protocol.data.UnitType;

public class UnitValueSetter {
    private final UnitType unitType;
    private final Float health;
    private final Float shield;
    private final Float energy;

    public UnitValueSetter(UnitType unitType, Float health, Float shield, Float energy) {
        this.unitType = unitType;
        this.health = health;
        this.shield = shield;
        this.energy = energy;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        return this.unitType == ((UnitValueSetter) obj).getUnitType();
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public Float getHealth() {
        return health;
    }

    public Float getShield() {
        return shield;
    }

    public Float getEnergy() {
        return energy;
    }

    @Override
    public String toString() {
        return String.format("%s [Health: %.1f] [Shield: %.1f] [Energy: %.1f]", this.getUnitType(), this.getHealth(), this.getShield(), this.getEnergy());
    }
}
