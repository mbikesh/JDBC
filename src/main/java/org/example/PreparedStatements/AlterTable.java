package org.example.PreparedStatements;

import org.example.util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AlterTable {
    public static final String SQL="alter table demo_tbl add phone int (20)";

    public static void main(String[] args) {
        try (

                PreparedStatement preparedStatement= DbUtil.getConnection().prepareStatement(SQL);

        ){


            preparedStatement.executeUpdate();

            System.out.println("Phone added");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
