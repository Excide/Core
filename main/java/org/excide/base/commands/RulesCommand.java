package org.excide.base.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

import static org.excide.Core.plugin;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.base.commands
 * Time: 2017-01-22
 */
public class RulesCommand implements CommandExecutor
{

    public RulesCommand()
    {

        plugin.getPlugin().getCommand("rules").setExecutor(this);

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        if(command.getName().equalsIgnoreCase("rules"))
        {

            if(sender.hasPermission("core.command.rules"))
            {

                for(String rule : plugin.getPlugin().getConfig().getStringList("RULES"))
                {

                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', rule));

                }

            }

        }

        return false;

    }

}
