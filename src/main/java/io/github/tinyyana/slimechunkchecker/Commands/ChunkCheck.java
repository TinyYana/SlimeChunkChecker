package io.github.tinyyana.slimechunkchecker.Commands;

import io.github.tinyyana.slimechunkchecker.SlimeChunkCheckerPlugin;
import io.github.tinyyana.slimechunkchecker.Utils.Chat;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChunkCheck implements CommandExecutor {
    public ChunkCheck(SlimeChunkCheckerPlugin slimeChunkCheckerPlugin) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;
            Chat.send(consoleCommandSender, "notPlayer");
            return true;
        }

        Player player = (Player) sender;
        Chunk chunk = player.getWorld().getChunkAt(player.getLocation());

        if (chunk.isSlimeChunk()) {
            Chat.send(player, "isSlimeChunk");
        } else {
            Chat.send(player, "notSlimeChunk");
        }
        return true;
    }
}
