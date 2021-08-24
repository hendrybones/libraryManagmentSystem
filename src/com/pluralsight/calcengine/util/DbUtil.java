package com.pluralsight.calcengine.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtil {
    private Connection connection;
    private Statement statement;

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
    public void closeConnections() throws SQLException {
        statement.close();
        connection.close();

    }


    }

