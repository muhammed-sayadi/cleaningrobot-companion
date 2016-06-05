package com.cleaningrobot.model;

import com.cleaningrobot.model.builder.TaskBuilder;

import javax.persistence.*;

@Entity
@Table
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column
    private int robotSn;
    @Column
    private String dueDate;
    @Column
    private String startingTime;
    @Column
    private String operation;

    public Task()
    {
        this.Id = -1;
        this.robotSn = -1;
        this.dueDate = "";
        this.startingTime = "";
        this.operation = "";
    }

    public Task(int id, int robotSn, String dueDate, String startingTime, String operation)
    {
        this.Id = id;
        this.robotSn = robotSn;
        this.dueDate = dueDate;
        this.startingTime = startingTime;
        this.operation = operation;
    }

    public Task(TaskBuilder taskBuilder)
    {
        this.Id = taskBuilder.getId();
        this.robotSn = taskBuilder.getRobotSn();
        this.dueDate = taskBuilder.getDueDate();
        this.startingTime = taskBuilder.getStartingTime();
        this.operation = taskBuilder.getOperation();

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

    public String getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(String dueDate)
    {
        this.dueDate = dueDate;
    }

    public String getStartingTime()
    {
        return startingTime;
    }

    public void setStartingTime(String startingTime)
    {
        this.startingTime = startingTime;
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
        return "Task{" +
                "Id=" + Id +
                ", robotSn=" + robotSn +
                ", dueDate='" + dueDate + '\'' +
                ", startingTime='" + startingTime + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (Id != task.Id) return false;
        if (robotSn != task.robotSn) return false;
        if (!dueDate.equals(task.dueDate)) return false;
        if (!startingTime.equals(task.startingTime)) return false;
        return operation.equals(task.operation);

    }

    @Override
    public int hashCode()
    {
        int result = Id;
        result = 31 * result + robotSn;
        result = 31 * result + dueDate.hashCode();
        result = 31 * result + startingTime.hashCode();
        result = 31 * result + operation.hashCode();
        return result;
    }

}
