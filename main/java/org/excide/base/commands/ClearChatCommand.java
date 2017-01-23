package org.excide.base.commands;

import net.md_5.bungee.api.ChatColor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.excide.Core.plugin;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.base.commands
 * Time: 2017-01-22
 */
public class ClearChatCommand implements CommandExecutor
{

    public ClearChatCommand()
    {

        plugin.getPlugin().getCommand("clearchat").setExecutor(this);

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        if(command.getName().equalsIgnoreCase("clearchat"))
        {

            if(sender.hasPermission("core.command.clearchat"))
            {

                /*for(int i = 0; i < 350; i++)
                {

                    Bukkit.broadcastMessage(" ");

                }*/

                Bukkit.broadcastMessage(StringUtils.repeat("\n", 300));

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getPlugin().getConfig().getString("MESSAGES.CLEARCHAT_BROADCAST")));

                return true;

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
