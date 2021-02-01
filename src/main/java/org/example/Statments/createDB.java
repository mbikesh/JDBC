package org.example.Statments;

import java.sql.*;

public class createDB {
    public static final String Driver="com.mysql.cj.jdbc.Driver";
    public static final String URL="jdbc:mysql://localhost:3306/";
    public static final String USER_NAME="root";
    public static final String PASSWORD="root";
    public static final String SQL="create database demo_db";

    public static void main(String[] args) {
        try (
                Connection connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);

                Statement statement=connection.createStatement();

                ){
                statement.executeUpdate(SQL);
            System.out.println("Database created");


        } catch ( SQLException e) {
            e.printStackTrace();
        }

    }
}
