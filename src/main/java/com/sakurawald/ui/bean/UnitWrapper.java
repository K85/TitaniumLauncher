package com.sakurawald.ui.bean;

import com.github.ocraft.s2client.protocol.unit.Unit;

public class UnitWrapper {

    private final Unit unit;

    public UnitWrapper(Unit unit) {
        this.unit = unit;
    }

    public Unit getUnit() {
        return unit;
    }

    public String toString() {

        String str = String.format("%s [%s] [%.1f, %.1f, %.1f]", unit.getType().toString(), unit.getAlliance().toString(), unit.getPosition().getX(), unit.getPosition().getY(), unit.getPosition().getZ());

        if (unit.getHealth().isPresent() && unit.getHealthMax().isPresent()
                && unit.getHealth().get() != 0 && unit.getHealthMax().get() != 0) {
            str += String.format(" [Health: %.1f/%.1f]", unit.getHealth().get(), unit.getHealthMax().get());
        }

        if (unit.getShield().isPresent() && unit.getShieldMax().isPresent()
                && unit.getShield().get() != 0 && unit.getShieldMax().get() != 0) {
            str += String.format(" [Shield: %.1f/%.1f]", unit.getShield().get(), unit.getShieldMax().get());
        }

        if (unit.getEnergy().isPresent() && unit.getEnergyMax().isPresent()
                && unit.getEnergy().get() != 0 && unit.getEnergyMax().get() != 0) {
            str += String.format(" [Energy: %.1f/%.1f]", unit.getEnergy().get(), unit.getEnergyMax().get());
        }

        return str;
    }
}
