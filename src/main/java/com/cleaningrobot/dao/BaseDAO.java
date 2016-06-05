package com.cleaningrobot.dao;

import com.cleaningrobot.dao.daointerface.DAO;
import com.cleaningrobot.dao.daointerface.DAOInterface;
import com.cleaningrobot.model.Base;

import java.util.List;

public class BaseDAO
    extends DAO
    implements DAOInterface<Base>

{

    @Override
    public void create(Base base)
    {
        getCurrentSession().save(base);

    } // end method create

    @Override
    public Base retrieve(int id)
    {
        return getCurrentSession().get(Base.class, id);

    } // end method retrieve

    @Override
    @SuppressWarnings("unchecked")
    public List<Base> retrieveAll()
    {
        return (List<Base>) getCurrentSession().createQuery("from Base").list();

    } // end method retrieveAll

    @Override
    public void update(Base base)
    {
        getCurrentSession().update(base);

    } // end method update

    @Override
    public void delete(Base base)
    {
        getCurrentSession().delete(base);

    } // end method delete

    @Override
    public void deleteAll()
    {
        List<Base> bases = retrieveAll();
        for(Base base: bases)
            delete(base);

    } // end method deleteAll

} // end class BaseDAO
