package PreparedStatements;

import util.DbUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTable {
    public static final String SQL="update demo_tbl set user_name=?, password=? where id=?";

    public static void main(String[] args) {
        try (

                PreparedStatement preparedStatement= DbUtil.getConnection().prepareStatement(SQL);

        ){
            preparedStatement.setString(1,"userName");
            preparedStatement.setString(2,"pass");
            preparedStatement.setInt(3,2);
            preparedStatement.executeUpdate();

            System.out.println("Data Updated");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
