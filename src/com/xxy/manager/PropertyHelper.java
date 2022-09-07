package com.xxy.manager;

import java.sql.*;

public class PropertyHelper {

    private Connection connection = null;

    private static PropertyHelper instance;

    private PropertyHelper() {}

    public static synchronized PropertyHelper getInstance() {
        if (instance == null) {
            instance = new PropertyHelper();
        }
        return instance;
    }

    public String getProperty(String name) {
        String value = "";
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:db/system.db");
            Statement statement = connection.createStatement();
            String sql = "select * from xy_property where key = " + "'" + name + "'";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                System.out.println("getProperty key = " + rs.getString("key") + " value = " + rs.getString("value"));
                value = rs.getString("value");
            } else {
                value = "";
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
        return value;
    }

    public void setProperty(String name, String value) {
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:db/system.db");
            Statement statement = connection.createStatement();
            String sql = "select * from xy_property where key = " + "'" + name + "'";
            ResultSet rs = statement.executeQuery(sql);
            if (!rs.next()) {
                String insertSql = "insert into xy_property values('" + name + "', '" + value + "')";
                statement.executeUpdate(insertSql);
            } else {
                String updateSql = "update xy_property set value = '" + value + "' where key = '" + name + "'";
                statement.executeUpdate(updateSql);
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
