package com.jonce.pcfilter.modal;

public class Computer
{
    private int img;
    private String pcName;
    private int pcCPU;
    private int pcGPU;
    private int pcStorage;
    private float pcSize;
    private float pcBatteryLife;

    public Computer(int img, String pcName, int pcCPU, int pcGPU, int pcStorage, float pcSize, float pcBatteryLife)
    {
        this.img = img;
        this.pcName = pcName;
        this.pcCPU = pcCPU;
        this.pcGPU = pcGPU;
        this.pcStorage = pcStorage;
        this.pcSize = pcSize;
        this.pcBatteryLife = pcBatteryLife;
    }

    public int getImg()
    {
        return img;
    }

    public void setImg(int img)
    {
        this.img = img;
    }

    public String getPcName()
    {
        return pcName;
    }

    public void setPcName(String pcName)
    {
        this.pcName = pcName;
    }

    public int getPcCPU()
    {
        return pcCPU;
    }

    public void setPcCPU(int pcCPU)
    {
        this.pcCPU = pcCPU;
    }

    public int getPcGPU()
    {
        return pcGPU;
    }

    public void setPcGPU(int pcGPU)
    {
        this.pcGPU = pcGPU;
    }

    public int getPcStorage()
    {
        return pcStorage;
    }

    public void setPcStorage(int pcStorage)
    {
        this.pcStorage = pcStorage;
    }

    public float getPcSize()
    {
        return pcSize;
    }

    public void setPcSize(float pcSize)
    {
        this.pcSize = pcSize;
    }

    public float getPcBatteryLife()
    {
        return pcBatteryLife;
    }

    public void setPcBatteryLife(float pcBatteryLife)
    {
        this.pcBatteryLife = pcBatteryLife;
    }
}
