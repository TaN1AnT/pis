package com.hostel.Service;

import com.hostel.Model.Dao.UserDao;
import com.hostel.Model.Dao.UserRoleDao;
import com.hostel.Model.DaoFactory;
import com.hostel.Model.Entities.User;
import com.hostel.Model.Entities.UserRole;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    final private UserDao userDao = DaoFactory.createUserDao();
    final private UserRoleDao rolesDao = DaoFactory.createUserRoleDao();

    public User isUserExists(String username, String password){
        ArrayList<User> users = userDao.findAll();
        for(User user: users){
            if(user.username().equals(username) && user.password().equals(password)){
                return user;
            }
        }
        return null;
    }

    public Boolean isUserAdmin(Integer id){
        UserRole role = rolesDao.findById(id);
        if(role != null)
            if(role.role_id() == 1)
                return true;
        return false;
    }

    public void createUser(User user){
         userDao.add(user);
    }

    public void updateUser(User user){
        userDao.update(user);
    }

    public List<User> getAllUsers(){
        UserDao userDao = new UserDao();
        return userDao.findAll();
    }

    public void deleteUser(Integer id){
        userDao.delete(id);
    }

    public Boolean isUserUnique(String username){
        List<User> users = userDao.findAll();
        for(User user: users){
            if(user.username().equals(username)){
                return false;
            }
        }
        return true;
    }

}
