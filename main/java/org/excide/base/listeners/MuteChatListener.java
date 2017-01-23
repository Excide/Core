package org.excide.base.listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static org.excide.Core.plugin;
import static org.excide.base.commands.MuteChatCommand.muted;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.base.listeners
 * Time: 2017-01-22
 */
public class MuteChatListener implements Listener
{

    public MuteChatListener()
    {

        Bukkit.getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void onCheck(AsyncPlayerChatEvent event)
    {

        if(muted == true && !event.getPlayer().hasPermission("core.bypass.mutechat"))
        {

            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getPlugin().getConfig().getString("MESSAGES.GLOBAL_CHAT_MUTED")));

            event.setCancelled(true);

        }
        else
        {

            // do nothing

        }

    }

}
