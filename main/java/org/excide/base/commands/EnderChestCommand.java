package org.excide.base.commands;

import org.bukkit.Bukkit;
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
public class EnderChestCommand implements CommandExecutor
{

    public EnderChestCommand()
    {



    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("enderchest"))
        {

            if(sender.hasPermission("core.command.enderchest"))
            {

                if(args.length < 1)
                {

                    player.openInventory(player.getEnderChest());

                    return true;

                }

                if(sender.hasPermission("core.command.enderchest.others"))
                {

                    Player target = Bukkit.getPlayer(args[0]);

                    if (target == null)
                    {

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getPlugin().getConfig().getString("MESSAGES.TARGET-NULL")));

                        return false;

                    }

                    player.openInventory(target.getEnderChest());

                }
                else
                {

                    sender.sendMessage("Unknown command. Type \"/help\" for help.");

                    return true;

                }

            }

        }

        return false;

    }

}
