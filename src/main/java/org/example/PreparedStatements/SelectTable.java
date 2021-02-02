package org.example.PreparedStatements;

import org.example.util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTable {
    public static final String SQL="Select * from demo_tbl where id=?";

    public static void main(String[] args) {
        try (

                PreparedStatement preparedStatement= DbUtil.getConnection().prepareStatement(SQL);

        ){
            preparedStatement.setInt(1,3);
            preparedStatement.executeQuery();
            ResultSet resultSet=preparedStatement.executeQuery();

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
