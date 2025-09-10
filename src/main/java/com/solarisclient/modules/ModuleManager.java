package com.solarisclient.modules;

import com.solarisclient.modules.impl.*;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private static final List<Module> modules = new ArrayList<>();

    public static void init() {
        modules.add(new PlayerESP());
        modules.add(new FullBright());
        modules.add(new FreeCam());
        // Add more modules here

        // Register rendering callback
        WorldRenderEvents.AFTER_ENTITIES.register(context -> {
            for (Module m : modules) {
                if (m.isEnabled()) m.onRender(context.tickDelta());
            }
        });
    }

    public static List<Module> getModules() { return modules; }

    public static Module getModuleByName(String name) {
        return modules.stream().filter(m -> m.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public static void onTick() {
        for (Module m : modules) {
            if (m.isEnabled()) m.onTick();
        }
    }
}
