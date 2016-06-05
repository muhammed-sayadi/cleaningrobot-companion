package com.cleaningrobot.model;

import com.cleaningrobot.model.builder.RobotBuilder;

import javax.persistence.*;

@Entity
@Table
public class Robot
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Sn;
    @Column
    private String model;
    @Column
    private String nickname;
    @Column
    private int userId;
    @Column
    private String purchaseDate;
    @Column
    private double batteryLevel;
    @Column
    private String waterStatus;
    @Column
    private double dustLevel;

    public Robot()
    {
        Sn = -1;
        this.model = "";
        this.nickname = "";
        this.userId = -1;
        this.purchaseDate = "";
        this.batteryLevel = -1;
        this.waterStatus = "";
        this.dustLevel = -1;

    }

    public Robot(int Sn, String model, String nickName, int userId, String purchaseDate, double batteryLevel, String waterStatus, double dustLevel)
    {
        this.Sn = Sn;
        this.model = model;
        this.nickname = nickName;
        this.userId = userId;
        this.purchaseDate = purchaseDate;
        this.batteryLevel = batteryLevel;
        this.waterStatus = waterStatus;
        this.dustLevel = dustLevel;
    }

    public Robot(RobotBuilder robotBuilder)
    {
        this.Sn = robotBuilder.getSn();
        this.model = robotBuilder.getModel();
        this.nickname = robotBuilder.getNickName();
        this.userId = robotBuilder.getUserId();
        this.purchaseDate = robotBuilder.getPurchaseDate();
        this.batteryLevel = robotBuilder.getBatteryLevel();
        this.waterStatus = robotBuilder.getWaterStatus();
        this.dustLevel = robotBuilder.getDustLevel();
    }

    public int getSn()
    {
        return Sn;
    }

    public void setSn(int sn)
    {
        Sn = sn;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getPurchaseDate()
    {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate)
    {
        this.purchaseDate = purchaseDate;
    }

    public double getBatteryLevel()
    {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel)
    {
        this.batteryLevel = batteryLevel;
    }

    public String getWaterStatus()
    {
        return waterStatus;
    }

    public void setWaterStatus(String waterStatus)
    {
        this.waterStatus = waterStatus;
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
        return "Robot{" +
                "Sn=" + Sn +
                ", model='" + model + '\'' +
                ", nickName='" + nickname + '\'' +
                ", userId=" + userId +
                ", purchaseDate=" + purchaseDate +
                ", batteryLevel=" + batteryLevel +
                ", waterStatus='" + waterStatus + '\'' +
                ", dustLevel=" + dustLevel +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Robot)) return false;

        Robot robot = (Robot) o;

        if (Sn != robot.Sn) return false;
        if (userId != robot.userId) return false;
        if (Double.compare(robot.batteryLevel, batteryLevel) != 0) return false;
        if (Double.compare(robot.dustLevel, dustLevel) != 0) return false;
        if (!model.equals(robot.model)) return false;
        if (!nickname.equals(robot.nickname)) return false;
        if (!purchaseDate.equals(robot.purchaseDate)) return false;
        return waterStatus.equals(robot.waterStatus);

    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = Sn;
        result = 31 * result + model.hashCode();
        result = 31 * result + nickname.hashCode();
        result = 31 * result + userId;
        result = 31 * result + purchaseDate.hashCode();
        temp = Double.doubleToLongBits(batteryLevel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + waterStatus.hashCode();
        temp = Double.doubleToLongBits(dustLevel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
