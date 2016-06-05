package com.cleaningrobot.model.builder;

import com.cleaningrobot.model.Task;

public class TaskBuilder
{
    private int Id;
    private int robotSn;
    private String dueDate;
    private String startingTime;
    private String operation;

    public TaskBuilder()
    {

    }

    public TaskBuilder(int id, int robotSn, String dueDate, String startingTime, String operation)
    {
        Id = id;
        this.robotSn = robotSn;
        this.dueDate = dueDate;
        this.startingTime = startingTime;
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

    public String getDueDate()
    {
        return dueDate;
    }

    public String getStartingTime()
    {
        return startingTime;
    }

    public String getOperation()
    {
        return operation;
    }

    /*********/

    public TaskBuilder withId(int Id)
    {
        this.Id = Id;
        return this;
    }

    public TaskBuilder withRobotSn(int robotSn)
    {
        this.robotSn = robotSn;
        return this;
    }

    public TaskBuilder withDueDate(String dueDate)
    {
        this.dueDate = dueDate;
        return this;
    }

    public TaskBuilder withStartingTime(String startingTime)
    {
        this.startingTime = startingTime;
        return this;
    }

    public TaskBuilder withOperation(String operation)
    {
        this.operation = operation;
        return this;
    }

    public Task build()
    {
        return new Task(this);
    }
}
