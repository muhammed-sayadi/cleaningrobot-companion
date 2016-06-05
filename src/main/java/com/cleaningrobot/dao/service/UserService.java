package com.cleaningrobot.dao.service;

import com.cleaningrobot.dao.UserDAO;
import com.cleaningrobot.dao.daointerface.ServiceInterface;
import com.cleaningrobot.model.User;

import java.util.List;

public class UserService implements ServiceInterface<User>
{
    private static UserDAO userDAO;


    public UserService()
    {
        userDAO = new UserDAO();

    } // end constructor

    public static UserDAO getUserDAO()
    {
        return userDAO;

    } // end method getUserDAO

    public static void setUserDAO(UserDAO userDAO)
    {
        UserService.userDAO = userDAO;

    } // end method setUserDAO

    public void create(User user)
    {
        userDAO.openCurrentSessionWithTransaction();
        userDAO.create(user);
        userDAO.closeCurrentSessionWithTransaction();

    } // end method create

    @Override
    public User retrieve (int id)
    {
        userDAO.openCurrentSession();
        User user = userDAO.retrieve(id);
        userDAO.closeCurrentSession();
        return user;

    } // end method retrieve

    @Override
    public List<User> retrieveAll()
    {
        userDAO.openCurrentSession();
        List<User> users = userDAO.retrieveAll();
        userDAO.closeCurrentSession();
        return users;

    } // end method retrieveAll

    public User retrieveByEmail(String email)
    {
        userDAO.openCurrentSession();
        User user = userDAO.retrieveByEmail(email);
        userDAO.closeCurrentSession();
        return user;

    } // end method retrieveByEmail

    @Override
    public void update(User user)
    {
        userDAO.openCurrentSessionWithTransaction();
        userDAO.update(user);
        userDAO.closeCurrentSessionWithTransaction();

    } // end method update

    @Override
    public void delete(int id)
    {
        userDAO.openCurrentSessionWithTransaction();
        User user = userDAO.retrieve(id);
        userDAO.delete(user);
        userDAO.closeCurrentSessionWithTransaction();

    } // end method delete

    @Override
    public void deleteAll()
    {
        userDAO.openCurrentSessionWithTransaction();
        userDAO.deleteAll();
        userDAO.closeCurrentSessionWithTransaction();

    } // end method deleteAll

} // end class UserService
