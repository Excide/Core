package org.excide.base.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.excide.Core.plugin;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.base.commands
 * Time: 2017-01-22
 */
public class FlyCommand implements CommandExecutor
{

    public static List<UUID> flyCache;

    public FlyCommand()
    {

        flyCache = new ArrayList<UUID>();

        plugin.getPlugin().getCommand("fly").setExecutor(this);

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("fly"))
        {

            if(sender.hasPermission("core.command.fly"))
            {

                if(args.length == 0)
                {

                    setFlying(player);

                    return true;

                }

                if(args.length == 1)
                {

                    Player target = Bukkit.getPlayer(args[0]);

                    if(target == null)
                    {

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getPlugin().getConfig().getString("MESSAGES.TARGET-NULL")));

                        return false;

                    }

                    setFlying(target);

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

    public static void setFlying(Player player)
    {

        if(!flyCache.contains(player.getUniqueId()))
        {

            player.setFlying(true);
            player.setAllowFlight(true);

            flyCache.add(player.getUniqueId());

            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getPlugin().getConfig().getString("MESSAGES.FLYING_ON_MESSAGE")));

        }
        else
        {

            player.setFlying(true);
            player.setAllowFlight(true);

            flyCache.add(player.getUniqueId());

            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getPlugin().getConfig().getString("MESSAGES.FLYING_OFF_MESSAGE")));

        }

    }

}
