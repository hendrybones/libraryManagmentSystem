package com.pluralsight.calcengine.util;

import java.sql.*;
import java.util.Properties;

public class DbUtil {
    private static Statement statement;
    private static Connection connection;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
            Connection connection=null;
            try {
                String url = "jdbc:mysql://localhost:3306/library";
                String root = "root";
                String password = "";
                final String className="com.mysql.jdbc.Driver";
                Class.forName(className);
                connection= DriverManager.getConnection(url, root, password);

            }catch (ClassNotFoundException | SQLException e){
                System.out.println(e);
            }
            return connection;
    }
    public static void closeConnections() throws SQLException {
        statement.close();
        connection.close();

    }


    }

