package org.example.util;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    public static final String Driver="com.mysql.cj.jdbc.Driver";
    public static final String URL="jdbc:mysql://localhost:3306/demo_db";
    public static final String USER_NAME="root";
    public static final String PASSWORD="root";
    public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
    }
}
