package com.sakurawald.file.config.adapter;

import com.github.ocraft.s2client.protocol.data.UnitType;
import com.github.ocraft.s2client.protocol.data.Units;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class UnitTypeAdapter implements JsonDeserializer<UnitType> {

    @Override
    public UnitType deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement == null) {
            return null;
        } else {
            try {
                return Units.valueOf(jsonElement.getAsString());
            } catch (Exception e) {
                return null;
            }
        }
    }
}
