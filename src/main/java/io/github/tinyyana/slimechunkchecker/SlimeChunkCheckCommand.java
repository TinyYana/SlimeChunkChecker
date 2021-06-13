package io.github.tinyyana.slimechunkchecker;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SlimeChunkCheckCommand implements CommandExecutor {

    private SlimeChunkCheckerPlugin plugin;

    public SlimeChunkCheckCommand(SlimeChunkCheckerPlugin slimeChunkCheckerPlugin) {
        plugin = slimeChunkCheckerPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Chunk chunk = p.getWorld().getChunkAt(p.getLocation());
        String isSlimeChunk = plugin.getConfig().getString("isSlimeChunk");
        String notSlimeChunk = plugin.getConfig().getString("notSlimeChunk");
        String notPlayer = plugin.getConfig().getString("notPlayer");

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',notPlayer));
            return true;
        }

        if(chunk.isSlimeChunk()) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', isSlimeChunk));
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', notSlimeChunk));
        }
        return true;

    }
}
