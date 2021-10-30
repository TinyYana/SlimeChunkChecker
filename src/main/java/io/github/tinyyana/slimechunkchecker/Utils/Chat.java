package io.github.tinyyana.slimechunkchecker.Utils;

import io.github.tinyyana.slimechunkchecker.SlimeChunkCheckerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Chat {
    public static void send(CommandSender sender, String message) {
        String content = SlimeChunkCheckerPlugin.getInstance().getConfig().getString(message);
        if (content.equalsIgnoreCase("")) return;
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', content));
    }
}
