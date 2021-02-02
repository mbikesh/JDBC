package org.demo.PreparedStatements;

import org.demo.util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTable {
    public static final String SQL="Delete from demo_tbl where id=?";

    public static void main(String[] args) {
        try (

                PreparedStatement preparedStatement= DbUtil.getConnection().prepareStatement(SQL);

        ){

            preparedStatement.setInt(1,2);
            preparedStatement.executeUpdate();

            System.out.println("Data Deleted");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
