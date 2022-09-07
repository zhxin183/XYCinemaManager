package com.xxy.ui;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xxy.manager.LoginManager;
import com.xxy.util.SwingUtil;

import javax.swing.*;

import static com.xxy.constants.Constants.UI_FRAME_HEIGHT;
import static com.xxy.constants.Constants.UI_FRAME_WIDTH;

public class Main {

    public static void main(String[] args)
    {
        boolean loginStatus = LoginManager.checkLoginStatus();
        if (loginStatus) {
            FrameHelper.showNewFrame(FrameHelper.FrameType.ADMIN_CINEMA, null);
        } else {
            FrameHelper.showNewFrame(FrameHelper.FrameType.LOGIN, null);
        }

        // initSystemSqlite();
    }

    public static void initSystemSqlite() {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:db/system.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists xy_property");
            statement.executeUpdate("create table xy_property (key string, value string)");
            statement.executeUpdate("insert into xy_property values(1, 'leo')");
            statement.executeUpdate("insert into xy_property values(2, 'yui')");
            ResultSet rs = statement.executeQuery("select * from xy_property");
            while(rs.next())
            {
                // read the result set
                System.out.println("key = " + rs.getString("key"));
                System.out.println("value = " + rs.getInt("value"));
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}
