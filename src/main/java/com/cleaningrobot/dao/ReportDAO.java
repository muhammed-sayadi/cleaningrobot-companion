package com.cleaningrobot.dao;

import com.cleaningrobot.dao.daointerface.DAO;
import com.cleaningrobot.dao.daointerface.DAOInterface;
import com.cleaningrobot.model.Report;

import java.util.List;

public class ReportDAO
    extends DAO
    implements DAOInterface<Report>
{

    @Override
    public void create(Report report)
    {
        getCurrentSession().save(report);

    } // end method create

    @Override
    public Report retrieve(int id)
    {
        return getCurrentSession().get(Report.class, id);

    } // end method retrieve

    @SuppressWarnings("unchecked")
    @Override
    public List<Report> retrieveAll()
    {
        return (List<Report>) getCurrentSession().createQuery("from Report").list();

    } // end method retrieveAll

    public List<Report> retrieveAllByRobotSn(int robotSn)
    {
        List<Report> allReports = retrieveAll();
        for(Report report: allReports)
            if(report.getRobotSn() != robotSn)
                allReports.remove(report);

        return allReports;

    } // end method retrieveAllByRobotSn

    @Override
    public void update(Report report)
    {
        getCurrentSession().update(report);

    } // end method update

    @Override
    public void delete(Report report)
    {
        getCurrentSession().delete(report);

    } // end method delete

    @Override
    public void deleteAll()
    {
        List<Report> reports = retrieveAll();
        for(Report report:reports)
            delete(report);

    } // end method deleteAll

} // end class ReportDAO
