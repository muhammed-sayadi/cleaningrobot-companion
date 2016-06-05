package com.cleaningrobot.dao.service;

import com.cleaningrobot.dao.BaseDAO;
import com.cleaningrobot.dao.daointerface.ServiceInterface;
import com.cleaningrobot.model.Base;

import java.util.List;

public class BaseService implements ServiceInterface<Base>
{
    private static BaseDAO baseDAO;

    public BaseService()
    {
        baseDAO = new BaseDAO();

    } // end constructor

    public static BaseDAO getBaseDAO()
    {
        return baseDAO;

    } // end method getBaseDAO

    public static void setBaseDAO(BaseDAO baseDAO)
    {
        BaseService.baseDAO = baseDAO;

    } // end method setBaseDAO


    @Override
    public void create(Base base)
    {
        baseDAO.openCurrentSessionWithTransaction();
        baseDAO.create(base);
        baseDAO.closeCurrentSessionWithTransaction();

    } // end method create

    @Override
    public Base retrieve(int id)
    {
        baseDAO.openCurrentSession();
        Base base = baseDAO.retrieve(id);
        baseDAO.closeCurrentSession();
        return base;

    } // end method retrieve

    @Override
    public List<Base> retrieveAll()
    {
        baseDAO.openCurrentSession();
        List<Base> bases = baseDAO.retrieveAll();
        baseDAO.closeCurrentSession();
        return bases;

    } // end method retrieveAll

    @Override
    public void update(Base base)
    {
        baseDAO.openCurrentSessionWithTransaction();
        baseDAO.update(base);
        baseDAO.closeCurrentSessionWithTransaction();

    } // end method update

    @Override
    public void delete(int id)
    {
        baseDAO.openCurrentSessionWithTransaction();
        Base base = baseDAO.retrieve(id);
        baseDAO.delete(base);
        baseDAO.closeCurrentSessionWithTransaction();

    } // end method delete

    @Override
    public void deleteAll()
    {
        baseDAO.openCurrentSessionWithTransaction();
        baseDAO.deleteAll();
        baseDAO.closeCurrentSessionWithTransaction();

    } // end method deleteAll

} // end class BaseService
