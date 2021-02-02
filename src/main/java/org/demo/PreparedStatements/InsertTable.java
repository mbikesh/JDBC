package org.demo.PreparedStatements;

import org.demo.util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable {
    public static final String SQL="insert into demo_tbl(user_name,password,email,phone) VALUES (?,?,?,?)";

    public static void main(String[] args) {
        try (

                PreparedStatement preparedStatement= DbUtil.getConnection().prepareStatement(SQL);

        ){
            preparedStatement.setString(1,"userName");
            preparedStatement.setString(2,"pass");
            preparedStatement.setString(3,"Email");
            preparedStatement.setInt(4,12321321);


            preparedStatement.executeUpdate();

            System.out.println("Data Inserted");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
