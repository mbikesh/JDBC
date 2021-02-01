package org.example.Statments;

import util.DbUtil;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable {

    public static final String SQL="insert into demo_tbl(user_name,password) VALUES ('Name','Pass')";

    public static void main(String[] args) {
        try (
//                Connection connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);

                Statement statement= DbUtil.getConnection().createStatement();

        ){
            statement.executeUpdate(SQL);
            System.out.println("Data Inserted");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
