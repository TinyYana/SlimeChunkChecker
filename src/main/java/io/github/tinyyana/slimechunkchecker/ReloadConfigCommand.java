package io.github.tinyyana.slimechunkchecker;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadConfigCommand implements CommandExecutor {

    private SlimeChunkCheckerPlugin plugin;

    public ReloadConfigCommand(SlimeChunkCheckerPlugin slimeChunkCheckerPlugin) {
        plugin = slimeChunkCheckerPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        String noPerm = plugin.getConfig().getString("noPermission");
        String reloadSuccess = plugin.getConfig().getString("reloadSuccess");

        if(!p.isOp() | !p.hasPermission("SlimeChunkChecker.reload")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',noPerm));
            return true;
        }

        if(args.length == 0) {
            plugin.reloadConfig();
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',reloadSuccess));
            return true;
        }

        return false;
    }
}
