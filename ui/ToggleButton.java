package com.solarisclient.ui;

import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class ToggleButton extends ButtonWidget {
    public ToggleButton(int x, int y, int width, int height, String name, boolean enabled, PressAction onPress) {
        super(x, y, width, height, Text.literal(name + (enabled ? " ON" : " OFF")), onPress, DEFAULT_NARRATION_SUPPLIER);
    }
}
