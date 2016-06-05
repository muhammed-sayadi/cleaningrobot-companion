package com.cleaningrobot.dao.service;

import com.cleaningrobot.dao.RobotDAO;
import com.cleaningrobot.dao.daointerface.ServiceInterface;
import com.cleaningrobot.model.Robot;

import java.util.List;

public class RobotService implements ServiceInterface<Robot>
{
    private static RobotDAO robotDAO;

    public RobotService()
    {
        robotDAO = new RobotDAO();

    } // end constructor

    public static RobotDAO getRobotDAO()
    {
        return robotDAO;

    } // end method getRobotDAO

    public static void setRobotDAO(RobotDAO robotDAO)
    {
        RobotService.robotDAO = robotDAO;

    } // end method setRobotDAO

    @Override
    public void create(Robot robot)
    {
        robotDAO.openCurrentSessionWithTransaction();
        robotDAO.create(robot);
        robotDAO.closeCurrentSessionWithTransaction();

    } // end method create

    @Override
    public Robot retrieve(int id)
    {
        robotDAO.openCurrentSession();
        Robot robot = robotDAO.retrieve(id);
        robotDAO.closeCurrentSession();
        return robot;

    } // end method retrieve

    @Override
    public List<Robot> retrieveAll()
    {
        robotDAO.openCurrentSession();
        List<Robot> robots = robotDAO.retrieveAll();
        robotDAO.closeCurrentSession();
        return robots;

    } // end method retrieveAll

    public Robot retrieveByUserId(int userId)
    {
        robotDAO.openCurrentSession();
        Robot robot = robotDAO.retrieveByUserId(userId);
        robotDAO.closeCurrentSession();
        return robot;

    } // end method retrieveByUserId

    @Override
    public void update(Robot robot)
    {
        robotDAO.openCurrentSessionWithTransaction();
        robotDAO.update(robot);
        robotDAO.closeCurrentSessionWithTransaction();

    } // end method update

    @Override
    public void delete(int id)
    {
        robotDAO.openCurrentSessionWithTransaction();
        Robot robot = robotDAO.retrieve(id);
        robotDAO.delete(robot);
        robotDAO.closeCurrentSessionWithTransaction();

    } // end method delete

    @Override
    public void deleteAll()
    {
        robotDAO.openCurrentSessionWithTransaction();
        robotDAO.deleteAll();
        robotDAO.closeCurrentSessionWithTransaction();

    } // end method deleteAll

} // end class RobotService
