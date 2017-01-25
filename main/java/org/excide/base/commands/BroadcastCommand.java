package org.excide.base.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.excide.Core.plugin;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.base.commands
 * Time: 2017-01-24
 */
public class BroadcastCommand
{

    public String message;

    public BroadcastCommand()
    {



    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("broadcast"))
        {

            if (sender.hasPermission("core.command.broadcast"))
            {

                if (args.length < 1)
                {

                    sender.sendMessage(ChatColor.RED + "/broadcast <message>");

                }

                message = StringUtils.join(args, ' ', 0, args.length);

                /*for(Player players : Bukkit.getOnlinePlayers())
                {

                    players.sendMessage(message);

                }*/

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MESSAGES.BROADCAST_PREFIX_MESSAGE") + message));

                return true;

            }

        }

        return false;

    }

}
