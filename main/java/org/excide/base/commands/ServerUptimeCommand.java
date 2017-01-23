package org.excide.base.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;

import static org.excide.Core.plugin;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.base.commands
 * Time: 2017-01-22
 */
public class ServerUptimeCommand implements CommandExecutor
{

    private long UP_TIME;
    private SimpleDateFormat dateFormat;

    public ServerUptimeCommand()
    {

        dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        UP_TIME = ManagementFactory.getRuntimeMXBean().getUptime();

        plugin.getCommand("uptime").setExecutor(this);

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {

        if(command.getName().equalsIgnoreCase("uptime"))
        {

            if(sender.hasPermission("core.command.uptime"))
            {

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getPlugin().getConfig().getString("MESSAGES.UPTIME_MESSAGE").replaceAll("%UPTIME%", dateFormat.format(UP_TIME))));

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
