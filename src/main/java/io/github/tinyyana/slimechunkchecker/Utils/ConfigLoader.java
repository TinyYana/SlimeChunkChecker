package io.github.tinyyana.slimechunkchecker.Utils;

import io.github.tinyyana.slimechunkchecker.SlimeChunkCheckerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

import static org.bukkit.Bukkit.getLogger;

public class ConfigLoader {
    private File file;
    private FileConfiguration fileConfiguration;

    private final String fileName;
    private final SlimeChunkCheckerPlugin plugin = SlimeChunkCheckerPlugin.getPlugin();

    public ConfigLoader(String fileName) {
        this.fileName = fileName;
        this.load();
    }

    public void load() {
        this.file = new File(plugin.getDataFolder().getPath(), File.separator + this.fileName + ".yml");
        this.fileConfiguration = new YamlConfiguration();

        if (!file.exists()) {
            try {
                plugin.saveResource(this.fileName + ".yml", false);
            } catch (IllegalArgumentException e) {
                Bukkit.getLogger().info("Failed to get file " + this.fileName + ".yml");
            }
        }

        try {
            this.fileConfiguration = YamlConfiguration.loadConfiguration(this.file);
            Bukkit.getLogger().info("Load " + this.fileName + ".yml" + " successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration get() {
        return this.fileConfiguration;
    }

}
