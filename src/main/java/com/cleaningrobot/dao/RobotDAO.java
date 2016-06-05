package com.cleaningrobot.dao;

import com.cleaningrobot.dao.daointerface.DAO;
import com.cleaningrobot.dao.daointerface.DAOInterface;
import com.cleaningrobot.model.Robot;

import java.util.List;

public class RobotDAO
    extends DAO
    implements DAOInterface<Robot>
{

    @Override
    public void create(Robot robot)
    {
        getCurrentSession().save(robot);

    } // end class create

    @Override
    public Robot retrieve(int id)
    {
        return getCurrentSession().get(Robot.class, id);

    } // end method retrieve

    @Override
    @SuppressWarnings("unchecked")
    public List<Robot> retrieveAll()
    {
        return (List<Robot>) getCurrentSession().createQuery("from Robot").list();

    } // end method retrieveAll

    public Robot retrieveByUserId(int userId)
    {
        List<Robot> robots = retrieveAll();
        for(Robot robot:robots)
            if(robot.getUserId() == userId)
                return robot;

        return null;

    } // end method retrieveByUserId

    @Override
    public void update(Robot robot)
    {
        getCurrentSession().update(robot);

    } // end method update

    @Override
    public void delete(Robot robot)
    {
        getCurrentSession().delete(robot);

    } // end method delete

    @Override
    public void deleteAll()
    {
        List<Robot> robots = retrieveAll();
        for(Robot robot: robots)
            delete(robot);

    } // end method deleteAll

} // end class RobotDAO
