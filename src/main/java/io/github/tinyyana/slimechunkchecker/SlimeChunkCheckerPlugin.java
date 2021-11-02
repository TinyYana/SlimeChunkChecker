package io.github.tinyyana.slimechunkchecker;

import io.github.tinyyana.slimechunkchecker.Commands.ChunkCheck;
import io.github.tinyyana.slimechunkchecker.Commands.ReloadConfig;
import io.github.tinyyana.slimechunkchecker.Utils.ConfigLoader;
import io.github.tinyyana.slimechunkchecker.Utils.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

public final class SlimeChunkCheckerPlugin extends JavaPlugin {

    public static ConfigLoader config;
    public static SlimeChunkCheckerPlugin plugin;

    @Override
    public void onEnable() {
        config = new ConfigLoader("config");
        checkUpdate();
        loadCommands();
    }

    @Override
    public void onDisable() {
    }

    private void loadCommands() {
        getCommand("slime").setExecutor(new ChunkCheck(this));
        getCommand("slimereload").setExecutor(new ReloadConfig(this));
    }

    private void checkUpdate() {
        new UpdateChecker(this, 86279).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                getLogger().info("Plugin is the latest version.");
            } else {
                getLogger().warning("Plugin is outdated. Need to be updated!");
            }
        });
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
