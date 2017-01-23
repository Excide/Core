package org.excide.base.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.excide.Core.plugin;
import static org.excide.base.commands.FlyCommand.flyCache;
import static org.excide.base.commands.FlyCommand.setFlying;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.base.listeners
 * Time: 2017-01-22
 */
public class FlyListener implements Listener
{

    public FlyListener()
    {

        Bukkit.getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {

        setFlying(event.getPlayer());

    }

}
