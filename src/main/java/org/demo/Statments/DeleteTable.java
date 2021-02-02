package org.demo.Statments;

import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTable {
    public static final String SQL="DELETE from demo_tbl where id=1";
    private static org.demo.util.DbUtil DbUtil;

    public static void main(String[] args) {
        try (
//                Connection connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);

                Statement statement= DbUtil.getConnection().createStatement();

        ){
            statement.executeUpdate(SQL);
            System.out.println("Data deleted");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
