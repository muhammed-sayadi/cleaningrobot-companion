package com.cleaningrobot.dao.daointerface;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public abstract class DAO
{
    protected Session currentSession;
    protected Transaction currentTransaction;

    public DAO()
    {

    } // end constructor

    public Session getCurrentSession()
    {
        return currentSession;

    } // end method getCurrentSession

    public void setCurrentSession(Session currentSession)
    {
        this.currentSession = currentSession;

    } // end method setCurrentSession

    public Transaction getCurrentTransaction()
    {
        return currentTransaction;

    } // end method getCurrentTransaction

    public void setCurrentTransaction(Transaction currentTransaction)
    {
        this.currentTransaction = currentTransaction;

    } // end method setCurrentTransaction

    private static SessionFactory buildSessionFactory()
    {
        final ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

    } // end method buildSessionFactory

    public Session openCurrentSession()
    {
        currentSession = buildSessionFactory().openSession();
        return currentSession;

    } // end method openCurrentSession

    public Session openCurrentSessionWithTransaction()
    {
        currentSession = buildSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;

    } // end method openCurrentSessionWithTransaction

    public void closeCurrentSession()
    {
        currentSession.close();

    } // end method closeCurrentSession

    public void closeCurrentSessionWithTransaction()
    {
        currentTransaction.commit();
        currentSession.close();

    } // end method closeCurrentSessionWithTransaction

} // end class DAO
