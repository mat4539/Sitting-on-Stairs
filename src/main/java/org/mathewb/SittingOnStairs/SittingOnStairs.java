package org.mathewb.SittingOnStairs;

import org.bukkit.plugin.java.JavaPlugin;

public class SittingOnStairs extends JavaPlugin {
    @Override
    public void onEnable(){
        getLogger().info("onEnable is called!");
        getServer().getPluginManager().registerEvents(new PlayerListener(),this);
    }

    @Override
    public void onDisable(){
        getLogger().info("onDisable is called");
    }
}
