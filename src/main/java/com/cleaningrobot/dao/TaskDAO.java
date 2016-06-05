package com.cleaningrobot.dao;

import com.cleaningrobot.dao.daointerface.DAO;
import com.cleaningrobot.dao.daointerface.DAOInterface;
import com.cleaningrobot.model.Task;

import java.util.List;

public class TaskDAO
        extends DAO
        implements DAOInterface<Task>
{
    @Override
    public void create(Task task)
    {
        getCurrentSession().save(task);

    } // end method create

    @Override
    public Task retrieve(int id)
    {
        return getCurrentSession().get(Task.class, id);

    } // end method retrieve

    @SuppressWarnings("unchecked")
    @Override
    public List<Task> retrieveAll()
    {
        return (List<Task>) getCurrentSession().createQuery("from Task").list();

    } // end method retrieveAll

    public List<Task> retrieveAllByRobotSn(int robotSn)
    {
        List<Task> allTasks = retrieveAll();
        for(Task task: allTasks)
            if(task.getRobotSn() != robotSn)
                allTasks.remove(task);

        return allTasks;

    } // end method retrieveAllByRobotSn

    @Override
    public void update(Task task)
    {
        getCurrentSession().update(task);

    } // end method update

    @Override
    public void delete(Task task)
    {
        getCurrentSession().delete(task);

    } // end method delete

    @Override
    public void deleteAll()
    {
        List<Task> tasks = retrieveAll();
        for(Task task:tasks)
            delete(task);

    } // end method deleteAll

} // enc class TaskDAO
