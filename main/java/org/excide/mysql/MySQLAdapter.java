package org.excide.mysql;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Project: Core
 * Created by: defcon
 * Package: org.excide.mysql
 * Time: 2017-01-22
 */
public class MySQLAdapter
{

    @Getter public Connection connection;

    public MySQLAdapter()
    {

        try
        {

            Class.forName("com.mysql.jdbc.Drive");

        }
        catch (ClassNotFoundException exception)
        {

            System.out.println();

            exception.printStackTrace();

        }

        try
        {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excide", "root", "123456");

        }
        catch (SQLException exception)
        {

            exception.printStackTrace();

        }

    }

}
