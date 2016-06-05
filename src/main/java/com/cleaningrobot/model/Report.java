package com.cleaningrobot.model;

import com.cleaningrobot.model.builder.ReportBuilder;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table
public class Report
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column
    private int robotSn;
    @Column
    private String startTime;
    @Column
    private String finishTime;
    @Column
    private byte[] completionMap;
    @Column
    private String operation;

    public Report()
    {
        this.Id = -1;
        this.robotSn = -1;
        this.startTime = "";
        this.finishTime = "";
        this.completionMap = null;
        this.operation = "";

    }

    public Report(int Id, int robotSn, String startTime, String finishTime, byte[] completionMap, String operation)
    {
        this.Id = Id;
        this.robotSn = robotSn;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.completionMap = completionMap;
        this.operation = operation;
    }

    public Report(ReportBuilder reportBuilder)
    {
        this.Id = reportBuilder.getId();
        this.robotSn = reportBuilder.getRobotSn();
        this.startTime = reportBuilder.getStartTime();
        this.finishTime = reportBuilder.getFinishTime();
        this.completionMap = reportBuilder.getCompletionMap();
        this.operation = reportBuilder.getOperation();

    }

    public int getId()
    {
        return Id;
    }

    public void setId(int id)
    {
        Id = id;
    }

    public int getRobotSn()
    {
        return robotSn;
    }

    public void setRobotSn(int robotSn)
    {
        this.robotSn = robotSn;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getFinishTime()
    {
        return finishTime;
    }

    public void setFinishTime(String finishTime)
    {
        this.finishTime = finishTime;
    }

    public byte[] getCompletionMap()
    {
        return completionMap;
    }

    public void setCompletionMap(byte[] completionMap)
    {
        this.completionMap = completionMap;
    }

    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    @Override
    public String toString()
    {
        return "Report{" +
                "Id=" + Id +
                ", robotSn=" + robotSn +
                ", startTime='" + startTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", completionMap=" + Arrays.toString(completionMap) +
                ", operation='" + operation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Report)) return false;

        Report report = (Report) o;

        if (Id != report.Id) return false;
        if (robotSn != report.robotSn) return false;
        if (!startTime.equals(report.startTime)) return false;
        if (!finishTime.equals(report.finishTime)) return false;
        if (!Arrays.equals(completionMap, report.completionMap)) return false;
        return operation.equals(report.operation);

    }

    @Override
    public int hashCode()
    {
        int result = Id;
        result = 31 * result + robotSn;
        result = 31 * result + startTime.hashCode();
        result = 31 * result + finishTime.hashCode();
        result = 31 * result + Arrays.hashCode(completionMap);
        result = 31 * result + operation.hashCode();
        return result;
    }
}
