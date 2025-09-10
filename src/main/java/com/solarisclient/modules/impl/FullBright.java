package com.solarisclient.modules.impl;

import com.solarisclient.modules.Module;
import net.minecraft.client.MinecraftClient;

public class FullBright extends Module {
    private float prevGamma;

    public FullBright() { super("Full Bright"); }

    @Override
    protected void onEnable() {
        prevGamma = MinecraftClient.getInstance().options.getGamma().getValue().floatValue();
        MinecraftClient.getInstance().options.getGamma().setValue(16.0f);
    }

    @Override
    protected void onDisable() {
        MinecraftClient.getInstance().options.getGamma().setValue(prevGamma);
    }
}
