package org.excide;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.excide.base.Base;
import org.excide.base.commands.ServerUptimeCommand;
import redis.clients.jedis.Jedis;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide
 * Time: 2017-01-22
 */
public class Core extends JavaPlugin
{

    @Getter public static Core plugin;
    @Getter public Jedis jedis;

    @Override
    public void onEnable()
    {

        plugin = this;

        new Base();

    }

    public void onDisable()
    {

        plugin = null;

    }

}
