package com.solarisclient;

import com.solarisclient.modules.ModuleManager;
import com.solarisclient.ui.SolarisHud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.lwjgl.glfw.GLFW;

public class SolarisClient implements ClientModInitializer {
    private static boolean hudOpen = false;
    public static SolarisHud solHud;

    @Override
    public void onInitializeClient() {
        ModuleManager.init();
        solHud = new SolarisHud();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            long handle = client.getWindow().getHandle();
            if (client.currentScreen == null && org.lwjgl.glfw.GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_INSERT) == GLFW.GLFW_PRESS) {
                hudOpen = !hudOpen;
                if (hudOpen) client.setScreen(solHud);
                else client.setScreen(null);
            }
            ModuleManager.onTick();
        });
    }
}
