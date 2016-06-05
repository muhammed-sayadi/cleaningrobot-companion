package com.cleaningrobot.model.builder;

import com.cleaningrobot.model.Robot;

public class RobotBuilder
{
    private int Sn;
    private String model;
    private String nickName;
    private int userId;
    private String purchaseDate;
    private double batteryLevel;
    private String waterStatus;
    private double dustLevel;

    public RobotBuilder()
    {
        new RobotBuilder();

    }

    public RobotBuilder(int sn, String model, String nickName, int userId, String purchaseDate, double batteryLevel, String waterStatus, double dustLevel)
    {
        Sn = sn;
        this.model = model;
        this.nickName = nickName;
        this.userId = userId;
        this.purchaseDate = purchaseDate;
        this.batteryLevel = batteryLevel;
        this.waterStatus = waterStatus;
        this.dustLevel = dustLevel;
    }

    public int getSn()
    {
        return Sn;
    }

    public String getModel()
    {
        return model;
    }

    public String getNickName()
    {
        return nickName;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getPurchaseDate()
    {
        return purchaseDate;
    }

    public double getBatteryLevel()
    {
        return batteryLevel;
    }

    public String getWaterStatus()
    {
        return waterStatus;
    }

    public double getDustLevel()
    {
        return dustLevel;
    }

    /*
    ****************************** Withers!! *************************************
     */

    public RobotBuilder withSn(int sn)
    {
        this.Sn = sn;
        return this;
    }

    public RobotBuilder withModel(String model)
    {
        this.model = model;
        return this;
    }

    public RobotBuilder withNickName(String nickName)
    {
        this.nickName = nickName;
        return this;
    }

    public RobotBuilder withUserId(int userId)
    {
        this.userId = userId;
        return this;
    }

    public RobotBuilder withPurchaseDate(String purchaseDate)
    {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public RobotBuilder withBatteryLevel(double batteryLevel)
    {
        this.batteryLevel = batteryLevel;
        return this;
    }

    public RobotBuilder withWaterStatus(String waterStatus)
    {
        this.waterStatus = waterStatus;
        return this;
    }

    public RobotBuilder withDustLevel(double dustLevel)
    {
        this.dustLevel = dustLevel;
        return this;
    }

    public Robot build()
    {
        return new Robot(this);
    }
}
