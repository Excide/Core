package org.excide.base.commands;

import lombok.Getter;
import net.md_5.bungee.api.ChatColor;
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
public class MuteChatCommand implements CommandExecutor
{

    @Getter public static boolean muted = false;

    public MuteChatCommand()
    {

        plugin.getPlugin().getCommand("mutechat").setExecutor(this);

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        if(command.getName().equalsIgnoreCase("mutechat"))
        {

            if(sender.hasPermission("core.command.mutechat"))
            {

                if(muted == false)
                {

                    muted = true;

                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getPlugin().getConfig().getString("MESSAGES.CHAT_MUTED_BROADCAST")).replaceAll("%PLAYER%", sender.getName()));

                    return true;

                }
                else
                {

                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getPlugin().getConfig().getString("MESSAGES.CHAT_UNMUTED_BROADCAST")).replaceAll("%PLAYER%", sender.getName()));

                    muted = false;

                    return true;

                }

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
