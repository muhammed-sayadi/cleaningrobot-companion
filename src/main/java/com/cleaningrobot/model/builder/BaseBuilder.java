package com.cleaningrobot.model.builder;

import com.cleaningrobot.model.Base;

public class BaseBuilder
{
    private int Sn;
    private int robotSn;
    private String purchaseDate;
    private byte[] localMap;
    private double cleanWaterLevel;
    private double dirtyWaterLevel;
    private double dustLevel;

    public BaseBuilder()
    {

    }

    public BaseBuilder(int Sn, int robotSn, String purchaseDate, byte[] localMap, double cleanWaterLevel, double dirtyWaterLevel, double dustLevel)
    {
        this.Sn = Sn;
        this.robotSn = robotSn;
        this.purchaseDate = purchaseDate;
        this.localMap = localMap;
        this.cleanWaterLevel = cleanWaterLevel;
        this.dirtyWaterLevel = dirtyWaterLevel;
        this.dustLevel = dustLevel;
    }

    public int getSn()
    {
        return Sn;
    }

    public int getRobotSn()
    {
        return robotSn;
    }

    public String getPurchaseDate()
    {
        return purchaseDate;
    }

    public byte[] getLocalMap()
    {
        return localMap;
    }

    public double getCleanWaterLevel()
    {
        return cleanWaterLevel;
    }

    public double getDirtyWaterLevel()
    {
        return dirtyWaterLevel;
    }

    public double getDustLevel()
    {
        return dustLevel;
    }

    /******/

    public BaseBuilder withSn(int sn)
    {
        Sn = sn;
        return this;
    }

    public BaseBuilder withRobotSn(int robotSn)
    {
        this.robotSn = robotSn;
        return this;
    }

    public BaseBuilder withPurchaseDate(String purchaseDate)
    {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public BaseBuilder withLocalMap(byte[] localMap)
    {
        this.localMap = localMap;
        return this;
    }

    public BaseBuilder withCleanWaterLevel(double cleanWaterLevel)
    {
        this.cleanWaterLevel = cleanWaterLevel;
        return this;
    }

    public BaseBuilder withDirtyWaterLevel(double dirtyWaterLevel)
    {
        this.dirtyWaterLevel = dirtyWaterLevel;
        return this;
    }

    public BaseBuilder withDustLevel(double dustLevel)
    {
        this.dustLevel = dustLevel;
        return this;
    }

    public Base build()
    {
        return new Base(this);
    }
}
