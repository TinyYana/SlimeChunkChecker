package io.github.tinyyana.slimechunkchecker;

import io.github.tinyyana.slimechunkchecker.Commands.ReloadConfig;
import io.github.tinyyana.slimechunkchecker.Commands.ChunkCheck;
import io.github.tinyyana.slimechunkchecker.Utils.ConfigLoader;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlimeChunkCheckerPlugin extends JavaPlugin {

    public static ConfigLoader config;
    public static SlimeChunkCheckerPlugin plugin;

    public void onEnable() {
        config = new ConfigLoader("config");
        getCommand("slime").setExecutor(new ChunkCheck(this));
        getCommand("slimereload").setExecutor(new ReloadConfig(this));
    }

    public void onDisable() {
    }

    public void onLoad() {
        plugin = this;
    }

    public static SlimeChunkCheckerPlugin getInstance() {
        return SlimeChunkCheckerPlugin.plugin;
    }

    public static SlimeChunkCheckerPlugin getPlugin() {
        return plugin;
    }
}
