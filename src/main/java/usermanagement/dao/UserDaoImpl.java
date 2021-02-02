package usermanagement.dao;

import usermanagement.Util.DbUtil;
import usermanagement.Util.QueryUtil;
import usermanagement.model.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public int saveUser(User user) {

        int saved=0;
        try(PreparedStatement preparedStatement=DbUtil.getConnection().prepareStatement(QueryUtil.SAVE_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getMobileNo());
            preparedStatement.setDouble(4, user.getSalary());
            preparedStatement.setBoolean(5, user.isEnable());
            saved = preparedStatement.executeUpdate();


        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


        return saved;
    }

    @Override
    public int updateUser(User user) {
        int update=0;
        try(PreparedStatement preparedStatement=DbUtil.getConnection().prepareStatement(QueryUtil.UPDATE_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getMobileNo());
            preparedStatement.setDouble(4, user.getSalary());
            preparedStatement.setBoolean(5, user.isEnable());
            preparedStatement.setDate(6, Date.valueOf(user.getDob()));
            preparedStatement.setInt(7, user.getId());

            update = preparedStatement.executeUpdate();


        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


        return update;
    }

    @Override
    public int deleteUser(int id) {
        int delete=0;
        try(PreparedStatement preparedStatement=DbUtil.getConnection().prepareStatement(QueryUtil.DELETE_SQL)) {
           preparedStatement.setInt(1,id);

            delete = preparedStatement.executeUpdate();


        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }


        return delete;
    }

    @Override
    public User getUserById(int id) {
        User user=new User();


        try(PreparedStatement preparedStatement=DbUtil.getConnection().prepareStatement(QueryUtil.GET_BY_ID_SQL)) {
            ResultSet resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEnable(resultSet.getBoolean("enable"));
                user.setMobileNo(resultSet.getLong("mobileNo"));
                user.setSalary(resultSet.getDouble("salary"));
                user.setDob(resultSet.getDate("dob").toLocalDate());

            }

        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return user;

    }


    @Override
    public List<User> getAllUser() {

        List<User> userList=new ArrayList<>();


        try(PreparedStatement preparedStatement=DbUtil.getConnection().prepareStatement(QueryUtil.SELECT_SQL)) {
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEnable(resultSet.getBoolean("enable"));
                user.setMobileNo(resultSet.getLong("mobileNo"));
                user.setSalary(resultSet.getDouble("salary"));
                user.setDob(resultSet.getDate("dob").toLocalDate());



                userList.add(user);

            }

        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return userList;

    }
}
