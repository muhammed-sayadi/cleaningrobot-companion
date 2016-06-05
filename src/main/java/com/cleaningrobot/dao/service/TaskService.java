package com.cleaningrobot.dao.service;

import com.cleaningrobot.dao.TaskDAO;
import com.cleaningrobot.dao.daointerface.ServiceInterface;
import com.cleaningrobot.model.Task;

import java.util.List;

public class TaskService implements ServiceInterface<Task>
{
    private static TaskDAO taskDAO;


    public TaskService()
    {
        taskDAO = new TaskDAO();

    } // end constructor

    public static TaskDAO getTaskDAO()
    {
        return taskDAO;

    } // end method getTaskDAO

    public static void setTaskDAO(TaskDAO taskDAO)
    {
        TaskService.taskDAO = taskDAO;

    } // end method setTaskDAO

    public void create(Task task)
    {
        taskDAO.openCurrentSessionWithTransaction();
        taskDAO.create(task);
        taskDAO.closeCurrentSessionWithTransaction();

    } // end method create

    @Override
    public Task retrieve (int id)
    {
        taskDAO.openCurrentSession();
        Task task = taskDAO.retrieve(id);
        taskDAO.closeCurrentSession();
        return task;

    } // end method retrieve

    @Override
    public List<Task> retrieveAll()
    {
        taskDAO.openCurrentSession();
        List<Task> tasks = taskDAO.retrieveAll();
        taskDAO.closeCurrentSession();
        return tasks;

    } // end method retrieveAll

    public List<Task> retrieveAllByRobotSn(int robotSn)
    {
        taskDAO.openCurrentSession();
        List<Task> tasks = taskDAO.retrieveAllByRobotSn(robotSn);
        taskDAO.closeCurrentSession();
        return tasks;

    } // end method retrieveAllByRobotSn

    @Override
    public void update(Task task)
    {
        taskDAO.openCurrentSessionWithTransaction();
        taskDAO.update(task);
        taskDAO.closeCurrentSessionWithTransaction();

    } // end method update

    @Override
    public void delete(int id)
    {
        taskDAO.openCurrentSessionWithTransaction();
        Task task = taskDAO.retrieve(id);
        taskDAO.delete(task);
        taskDAO.closeCurrentSessionWithTransaction();

    } // end method delete

    @Override
    public void deleteAll()
    {
        taskDAO.openCurrentSessionWithTransaction();
        taskDAO.deleteAll();
        taskDAO.closeCurrentSessionWithTransaction();

    } // end method deleteAll

} // end class TaskService
