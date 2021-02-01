package org.example.Statments;

import util.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTable {
    public static final String SQL="select * from demo_tbl";

    public static void main(String[] args) {
        try (
//                Connection connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);

                Statement statement= DbUtil.getConnection().createStatement();

        ){
           ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                System.out.println("Id is: "+resultSet.getInt("id"));
                System.out.println("Name is: "+resultSet.getString("user_name"));
                System.out.println("Password is: "+resultSet.getString("password"));

            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
