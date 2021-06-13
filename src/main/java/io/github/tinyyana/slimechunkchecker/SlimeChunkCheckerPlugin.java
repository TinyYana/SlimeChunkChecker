package io.github.tinyyana.slimechunkchecker;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlimeChunkCheckerPlugin extends JavaPlugin {

    FileConfiguration config = getConfig();

    public void onEnable() {
        loadConfig();
        getCommand("slime").setExecutor(new SlimeChunkCheckCommand(this));
        getCommand("slimereload").setExecutor(new ReloadConfigCommand(this));
    }

    public void onDisable() {

    }

    public void loadConfig() {
        config.options().copyDefaults(true);
        this.saveDefaultConfig();
        this.getConfig();
        saveConfig();
    }
}
