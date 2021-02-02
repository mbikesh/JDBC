package org.example.Statments;

import org.example.util.DbUtil;

import java.sql.SQLException;
import java.sql.Statement;

public class AlterTable {
    public static final String SQL="alter table demo_tbl add email varchar(255)";

    public static void main(String[] args) {
        try (
//                Connection connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);

                Statement statement= DbUtil.getConnection().createStatement();

        ){
            statement.executeUpdate(SQL);
            System.out.println("Email added");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
