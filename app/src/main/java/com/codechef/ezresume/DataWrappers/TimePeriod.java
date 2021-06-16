package com.codechef.ezresume.DataWrappers;

public class TimePeriod
{
    private String startMonth,startYear,endMonth,endYear;
    private boolean toPresent;

    TimePeriod()
    {
        toPresent = false;
    }

    public String getStartMonth()
    {
        return startMonth;
    }

    public void setStartMonth(String startMonth)
    {
        this.startMonth = startMonth;
    }

    public String getStartYear()
    {
        return startYear;
    }

    public void setStartYear(String startYear)
    {
        this.startYear = startYear;
    }

    public String getEndMonth()
    {
        return endMonth;
    }

    public void setEndMonth(String endMonth)
    {
        this.endMonth = endMonth;
    }

    public String getEndYear()
    {
        return endYear;
    }

    public void setEndYear(String endYear)
    {
        this.endYear = endYear;
    }
    public boolean isPresent()
    {
        return toPresent;
    }

    public void setPresent(boolean toPresent)
    {
        this.toPresent = toPresent;
    }
}
