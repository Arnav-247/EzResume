package com.codechef.ezresume.DataWrappers;

public class TemplateData
{
    private String name;
    private int imageID;
    private int layoutID;
    public TemplateData(String name, int imageID)
    {
        this.name = name;
        this.imageID = imageID;
        this.layoutID = layoutID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getImageID()
    {
        return imageID;
    }

    public void setImageID(int imageID)
    {
        this.imageID = imageID;
    }
}
