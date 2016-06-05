package com.cleaningrobot.dao.service;

import com.cleaningrobot.dao.ReportDAO;
import com.cleaningrobot.dao.daointerface.ServiceInterface;
import com.cleaningrobot.model.Report;

import java.util.List;

public class ReportService implements ServiceInterface<Report>
{
    private static ReportDAO reportDAO;

    public ReportService()
    {
        reportDAO = new ReportDAO();

    } // end constructor

    public static ReportDAO getReportDAO()
    {
        return reportDAO;

    } // end method ReportDAO

    public static void setReportDAO(ReportDAO reportDAO)
    {
        ReportService.reportDAO = reportDAO;

    } // end method setReportDAO

    @Override
    public void create(Report report)
    {
        reportDAO.openCurrentSessionWithTransaction();
        reportDAO.create(report);
        reportDAO.closeCurrentSessionWithTransaction();

    } // end method create

    @Override
    public Report retrieve(int id)
    {
        reportDAO.openCurrentSession();
        Report report = reportDAO.retrieve(id);
        reportDAO.closeCurrentSession();
        return report;

    } // end method retrieve

    @Override
    public List<Report> retrieveAll()
    {
        reportDAO.openCurrentSession();
        List<Report> reports = reportDAO.retrieveAll();
        reportDAO.closeCurrentSession();
        return reports;

    } // end method retrieveAll

    public List<Report> retrieveAllByRobotSn(int robotSn)
    {
        reportDAO.openCurrentSession();
        List<Report> reports = reportDAO.retrieveAllByRobotSn(robotSn);
        reportDAO.closeCurrentSession();
        return reports;

    } // end method retrieveAllByRobotSn

    @Override
    public void update(Report report)
    {
        reportDAO.openCurrentSessionWithTransaction();
        reportDAO.update(report);
        reportDAO.closeCurrentSessionWithTransaction();

    } // end method update

    @Override
    public void delete(int id)
    {
        reportDAO.openCurrentSessionWithTransaction();
        Report report = reportDAO.retrieve(id);
        reportDAO.closeCurrentSessionWithTransaction();
        reportDAO.delete(report);

    } // end method delete

    @Override
    public void deleteAll()
    {
        reportDAO.openCurrentSessionWithTransaction();
        reportDAO.deleteAll();
        reportDAO.closeCurrentSessionWithTransaction();

    } // end method deleteAll

} // end class ReportService
