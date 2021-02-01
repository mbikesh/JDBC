package org.example.Statments;

import util.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {

    public static final String SQL="create table demo_tbl(id int not null auto_increment PRIMARY KEY , user_name varchar(255), password varchar (255))";

    public static void main(String[] args) {
        try (
//                Connection connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);

                Statement statement= DbUtil.getConnection().createStatement();

        ){
            statement.executeUpdate(SQL);
            System.out.println("Table created");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
