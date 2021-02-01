package PreparedStatements;

import util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable {
    public static final String SQL="insert into demo_tbl(user_name,password) VALUES (?,?)";

    public static void main(String[] args) {
        try (

                PreparedStatement preparedStatement= DbUtil.getConnection().prepareStatement(SQL);

        ){
            preparedStatement.setString(1,"userName");
            preparedStatement.setString(2,"pass");
            preparedStatement.executeUpdate();

            System.out.println("Data Inserted");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
