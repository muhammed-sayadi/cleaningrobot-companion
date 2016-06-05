package com.cleaningrobot.model.builder;

import com.cleaningrobot.model.Report;

public class ReportBuilder
{
    private int Id;
    private int robotSn;
    private String startTime;
    private String finishTime;
    private byte[] completionMap;
    private String operation;

    public ReportBuilder()
    {

    }

    public ReportBuilder(int id, int robotSn, String startTime, String finishTime, byte[] completionMap, String operation)
    {
        Id = id;
        this.robotSn = robotSn;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.completionMap = completionMap;
        this.operation = operation;
    }

    public int getId()
    {
        return Id;
    }

    public int getRobotSn()
    {
        return robotSn;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public String getFinishTime()
    {
        return finishTime;
    }

    public byte[] getCompletionMap()
    {
        return completionMap;
    }

    public String getOperation()
    {
        return operation;
    }

    /****/

    public ReportBuilder withId(int id)
    {
        Id = id;
        return this;
    }

    public ReportBuilder withRobotSn(int robotSn)
    {
        this.robotSn = robotSn;
        return this;
    }

    public ReportBuilder withStartTime(String startTime)
    {
        this.startTime = startTime;
        return this;
    }

    public ReportBuilder withFinishTime(String finishTime)
    {
        this.finishTime = finishTime;
        return this;
    }

    public ReportBuilder withCompletionMap(byte[] completionMap)
    {
        this.completionMap = completionMap;
        return this;
    }

    public ReportBuilder withOperation(String operation)
    {
        this.operation = operation;
        return this;
    }

    public Report build()
    {
        return new Report(this);
    }
}
