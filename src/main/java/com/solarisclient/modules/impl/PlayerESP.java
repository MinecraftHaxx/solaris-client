package com.solarisclient.modules.impl;

import com.solarisclient.modules.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class PlayerESP extends Module {
    public PlayerESP() { super("Player ESP"); }

    @Override
    public void onRender(float tickDelta) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null || mc.player == null) return;
        for (PlayerEntity p : mc.world.getPlayers()) {
            if (p == mc.player) continue;
            // TODO: Implement ESP drawing logic (box & name)
            // Pseudocode: RenderUtils.drawBox(p.getBoundingBox(), Color.CYAN);
            // Pseudocode: RenderUtils.drawName(p.getName().getString(), p.getPos());
        }
    }
}
