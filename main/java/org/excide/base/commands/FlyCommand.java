package org.excide.base.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

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

    //TODO: FINISH THIS CLASS
    // MYSQL state

    public List<UUID> flyCache;

    public FlyCommand()
    {

        flyCache = new ArrayList<UUID>();

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("fly"))
        {

            if(sender.hasPermission("core.command.fly"))
            {

                if (args.length == 0)
                {

                    if (!flyCache.contains(player.getUniqueId()))
                    {

                        player.setFlying(true);
                        player.setAllowFlight(true);

                        flyCache.add(player.getUniqueId());

                    }
                    else
                    {

                        player.setFlying(true);
                        player.setAllowFlight(true);

                        flyCache.add(player.getUniqueId());

                    }

                }

            }

        }

        return false;

    }

}
