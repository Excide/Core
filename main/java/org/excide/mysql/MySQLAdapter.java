package org.excide.mysql;

import lombok.Getter;
import org.bukkit.Bukkit;
import paulek.mysql.Main;
import paulek.mysql.MySQL;

import static org.excide.Core.plugin;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.mysql
 * Time: 2017-01-22
 */
public class MySQLAdapter
{

    @Getter public String USER;
    @Getter public String PASSWORD;
    @Getter public String DATABASE;
    @Getter public String HOST;
    @Getter public MySQL mySQL;

    public MySQLAdapter()
    {

        USER = plugin.getPlugin().getConfig().getString("MYSQL.USER");
        PASSWORD = plugin.getPlugin().getConfig().getString("MYSQL.PASSWORD");
        DATABASE = plugin.getPlugin().getConfig().getString("MYSQL.DATABASE");
        HOST = plugin.getPlugin().getConfig().getString("MYSQL.HOST");

        mySQL = new MySQL((Main) Bukkit.getServer().getPluginManager().getPlugin("MySQL"), "SQL");

        mySQL.Connect(HOST, DATABASE, USER, PASSWORD);

    }



}
