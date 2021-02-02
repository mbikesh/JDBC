package org.demo.Statments;


import org.demo.util.DbUtil;

import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {

    public static final String SQL="update demo_tbl set user_name='USERNAME',password='PASSWORD' where id=1";

    public static void main(String[] args) {
        try (
//                Connection connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);

                Statement statement= DbUtil.getConnection().createStatement();

        ){
            statement.executeUpdate(SQL);
            System.out.println("Data updated");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
