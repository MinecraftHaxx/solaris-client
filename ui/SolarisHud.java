package com.solarisclient.ui;

import com.solarisclient.modules.Module;
import com.solarisclient.modules.ModuleManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class SolarisHud extends Screen {
    public SolarisHud() {
        super(Text.literal("Solaris HUD"));
    }

    @Override
    protected void init() {
        int y = 30;
        for (Module m : ModuleManager.getModules()) {
            this.addDrawableChild(new ToggleButton(20, y, 140, 20, m.getName(), m.isEnabled(), btn -> {
                m.toggle();
                btn.setMessage(Text.literal(m.getName() + (m.isEnabled() ? " ON" : " OFF")));
            }));
            y += 28;
        }
    }

    @Override
    public boolean shouldPause() { return false; }
}
