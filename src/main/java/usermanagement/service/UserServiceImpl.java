package usermanagement.service;

import usermanagement.dao.UserDao;
import usermanagement.dao.UserDaoImpl;
import usermanagement.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
   UserDao userDao=new UserDaoImpl();


    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
