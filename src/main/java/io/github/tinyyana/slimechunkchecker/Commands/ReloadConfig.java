package io.github.tinyyana.slimechunkchecker.Commands;

import io.github.tinyyana.slimechunkchecker.SlimeChunkCheckerPlugin;
import io.github.tinyyana.slimechunkchecker.Utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ReloadConfig implements CommandExecutor {
    Plugin plugin = SlimeChunkCheckerPlugin.getPlugin();

    public ReloadConfig(SlimeChunkCheckerPlugin slimeChunkCheckerPlugin) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;
            plugin.reloadConfig();
            Chat.send(consoleCommandSender, "reloadSuccess");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            if (player.hasPermission("SlimeChunkChecker.reload") || player.isOp()) {
                plugin.reloadConfig();
                Chat.send(player, "reloadSuccess");
                return true;
            }
        }
        Chat.send(player, "noPermission");
        return true;
    }
}
