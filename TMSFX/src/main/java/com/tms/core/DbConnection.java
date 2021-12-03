package com.tms.core;

import java.io.File;
import java.sql.*;

public class DbConnection {

    public static final String DB_NAME = "ServiceBase.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Projects/TMSFx/src/" + DB_NAME;

    public static Connection connection = null;

    public static void connect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            //System.out.println("===> Connect to database has been established.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Close connection failed: " + e.getMessage());
        }
    }

    protected static void getSampleData() {

        System.out.println(new File("").getAbsolutePath());

        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Users");
            while (resultset.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append(resultset.getString("PasswordHash"));
                System.out.println(sb.toString());
            }

            resultset.close();
            statement.close();
            connection.close();

        } catch (SQLException exception) {
            System.out.println("===>" + exception.getMessage());
        }

    }

}
