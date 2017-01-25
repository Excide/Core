package org.excide.base.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.excide.Core.plugin;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.base.commands
 * Time: 2017-01-24
 */
public class SetSpawnCommand implements CommandExecutor
{

    public int X;
    public int Y;
    public int Z;

    public int PITCH;
    public int YAW;

    public SetSpawnCommand()
    {

        plugin.getPlugin().getCommand("setspawn").setExecutor(this);

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("setspawn"))
        {

            if(sender.hasPermission("core.command.setspawn"))
            {

                X = (int) player.getLocation().getX();
                Y = (int) player.getLocation().getY();
                Z = (int) player.getLocation().getZ();

                PITCH = (int) player.getLocation().getPitch();
                YAW = (int) player.getLocation().getYaw();

                plugin.getPlugin().getConfig().set("TELEPORTS.SPAWN.X", X);
                plugin.getPlugin().getConfig().set("TELEPORTS.SPAWN.Y", Y);
                plugin.getPlugin().getConfig().set("TELEPORT.SPAWN.Z", Z);
                plugin.getPlugin().getConfig().set("TELEPORT.SPAWN.PITCH", PITCH);
                plugin.getPlugin().getConfig().set("TELEPORT.SPAWN.YAW", YAW);

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getPlugin().getConfig().getString("MESSAGES.SETSPAWN_MESSAGE")));

                plugin.getPlugin().saveConfig();

            }
            else
            {

                sender.sendMessage("Unknown command. Type \"/help\" for help.");

                return true;

            }

        }

        return false;

    }

}
