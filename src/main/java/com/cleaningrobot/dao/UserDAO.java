package com.cleaningrobot.dao;

import com.cleaningrobot.dao.daointerface.DAO;
import com.cleaningrobot.dao.daointerface.DAOInterface;
import com.cleaningrobot.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDAO
        extends DAO
        implements DAOInterface<User>

{
    @Override
    public void create(User user)
    {
        getCurrentSession().save(user);

    } // end method create

    @Override
    public User retrieve(int id)
    {
        return getCurrentSession().get(User.class, id);
    }

    public User retrieveByEmail(String email)
    {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));

        try
        {
            return (User) criteria.list().get(0);

        } // end try

        catch (Exception e)
        {
            return null;

        } // end catch

    } // end method retrieveByEmail

    @SuppressWarnings("unchecked")
    @Override
    public List<User> retrieveAll()
    {
        return (List<User>) getCurrentSession().createQuery("from User").list();

    } // end method retrieveAll

    @Override
    public void update(User user)
    {
        getCurrentSession().update(user);

    } // end method update

    @Override
    public void delete(User user)
    {
        getCurrentSession().delete(user);

    } // end method delete

    @Override
    public void deleteAll()
    {
        List<User> users = retrieveAll();
        for(User user:users)
            delete(user);

    } // end method deleteAll

} // end class UserDAO
