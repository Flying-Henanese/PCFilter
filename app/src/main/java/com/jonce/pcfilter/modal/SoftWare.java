package com.jonce.pcfilter.modal;

public class SoftWare
{
    private int img;
    private String sfName;
    private int sFCPU;
    private int sFGPU;
    private int sFStorage;
    private float sFSize;
    private float sFBatteryLife;

    public SoftWare(int img, String sfName, int sFCPU, int sFGPU, int sFStorage)
    {
        this.img = img;
        this.sfName = sfName;
        this.sFCPU = sFCPU;
        this.sFGPU = sFGPU;
        this.sFStorage = sFStorage;
    }

    public int getImg()
    {
        return img;
    }

    public void setImg(int img)
    {
        this.img = img;
    }

    public String getSfName()
    {
        return sfName;
    }

    public void setSfName(String sfName)
    {
        this.sfName = sfName;
    }

    public int getsFCPU()
    {
        return sFCPU;
    }

    public void setsFCPU(int sFCPU)
    {
        this.sFCPU = sFCPU;
    }

    public int getsFGPU()
    {
        return sFGPU;
    }

    public void setsFGPU(int sFGPU)
    {
        this.sFGPU = sFGPU;
    }

    public int getsFStorage()
    {
        return sFStorage;
    }

    public void setsFStorage(int sFStorage)
    {
        this.sFStorage = sFStorage;
    }

    public float getsFSize()
    {
        return sFSize;
    }

    public void setsFSize(float sFSize)
    {
        this.sFSize = sFSize;
    }

    public float getsFBatteryLife()
    {
        return sFBatteryLife;
    }

    public void setsFBatteryLife(float sFBatteryLife)
    {
        this.sFBatteryLife = sFBatteryLife;
    }
}
