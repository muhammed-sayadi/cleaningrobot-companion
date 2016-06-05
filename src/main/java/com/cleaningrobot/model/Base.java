package com.cleaningrobot.model;

import com.cleaningrobot.model.builder.BaseBuilder;

import javax.persistence.*;

@Entity
@Table
public class Base
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Sn;
    @Column
    private int robotSn;
    @Column
    private String purchaseDate;
    @Column
    private byte[] localMap;
    @Column
    private double cleanWaterLevel;
    @Column
    private double dirtyWaterLevel;
    @Column
    private double dustLevel;

    public Base()
    {
        Sn = -1;
        this.robotSn = -1;
        this.purchaseDate = "";
        this.localMap = null;
        this.cleanWaterLevel = -1;
        this.dirtyWaterLevel = -1;
        this.dustLevel = -1;

    }

    public Base(int Sn, int robotSn, String purchaseDate, byte[] localMap, double cleanWaterLevel, double dirtyWaterLevel, double dustLevel)
    {
        this.Sn = Sn;
        this.robotSn = robotSn;
        this.purchaseDate = purchaseDate;
        this.localMap = localMap;
        this.cleanWaterLevel = cleanWaterLevel;
        this.dirtyWaterLevel = dirtyWaterLevel;
        this.dustLevel = dustLevel;
    }

    public Base(BaseBuilder baseBuilder)
    {
        Sn = baseBuilder.getSn();
        this.robotSn = baseBuilder.getRobotSn();
        this.purchaseDate = baseBuilder.getPurchaseDate();
        this.localMap = baseBuilder.getLocalMap();
        this.cleanWaterLevel = baseBuilder.getCleanWaterLevel();
        this.dirtyWaterLevel = baseBuilder.getDirtyWaterLevel();
        this.dustLevel = baseBuilder.getDustLevel();

    }

    public int getSn()
    {
        return Sn;
    }

    public void setSn(int sn)
    {
        Sn = sn;
    }

    public int getRobotSn()
    {
        return robotSn;
    }

    public void setRobotSn(int robotSn)
    {
        this.robotSn = robotSn;
    }

    public String getPurchaseDate()
    {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }

    public byte[] getLocalMap()
    {
        return localMap;
    }

    public void setLocalMap(byte[] localMap)
    {
        this.localMap = localMap;
    }

    public double getCleanWaterLevel()
    {
        return cleanWaterLevel;
    }

    public void setCleanWaterLevel(double cleanWaterLevel)
    {
        this.cleanWaterLevel = cleanWaterLevel;
    }

    public double getDirtyWaterLevel()
    {
        return dirtyWaterLevel;
    }

    public void setDirtyWaterLevel(double dirtyWaterLevel)
    {
        this.dirtyWaterLevel = dirtyWaterLevel;
    }

    public double getDustLevel()
    {
        return dustLevel;
    }

    public void setDustLevel(double dustLevel)
    {
        this.dustLevel = dustLevel;
    }

    @Override
    public String toString()
    {
        return "Base{" +
                "Sn=" + Sn +
                ", robotSn=" + robotSn +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", localMap=" + localMap +
                ", cleanWaterLevel=" + cleanWaterLevel +
                ", dirtyWaterLevel=" + dirtyWaterLevel +
                ", dustLevel=" + dustLevel +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Base)) return false;

        Base base = (Base) o;

        if (Sn != base.Sn) return false;
        if (robotSn != base.robotSn) return false;
        if (Double.compare(base.cleanWaterLevel, cleanWaterLevel) != 0) return false;
        if (Double.compare(base.dirtyWaterLevel, dirtyWaterLevel) != 0) return false;
        if (Double.compare(base.dustLevel, dustLevel) != 0) return false;
        if (!purchaseDate.equals(base.purchaseDate)) return false;
        return localMap.equals(base.localMap);

    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = Sn;
        result = 31 * result + robotSn;
        result = 31 * result + purchaseDate.hashCode();
        result = 31 * result + localMap.hashCode();
        temp = Double.doubleToLongBits(cleanWaterLevel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dirtyWaterLevel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dustLevel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
