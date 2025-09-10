package com.solarisclient.modules;

public abstract class Module {
    private final String name;
    private boolean enabled;

    public Module(String name) {
        this.name = name;
        this.enabled = false;
    }

    public String getName() { return name; }
    public boolean isEnabled() { return enabled; }

    public void toggle() {
        enabled = !enabled;
        if (enabled) onEnable(); else onDisable();
    }

    protected void onEnable() {}
    protected void onDisable() {}

    public void onTick() {}
    public void onRender(float tickDelta) {}
}
