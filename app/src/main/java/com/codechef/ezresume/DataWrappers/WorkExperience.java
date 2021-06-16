package com.codechef.ezresume.DataWrappers;

import java.util.ArrayList;

public class WorkExperience
{
    private String title, company, place, description, achievementHeading, contactHeading, contactPerson, contactInfo;
    private String[] achievements;
    private TimePeriod period;

    public static final String KEY_TITLE = "title";
    public static final String KEY_COMPANY = "company";
    public static final String KEY_PLACE = "place";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_ACHIEVEMENT_HEADING = "achievement_heading";
    public static final String KEY_CONTACT_HEADING = "contact_heading";
    public static final String KEY_CONTACT_PERSION = "contact_person";
    public static final String KEY_CONTACT_INFO = "contact_info";

    public String getDescription()
    {

        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getAchievementHeading()
    {
        return achievementHeading;
    }

    public void setAchievementHeading(String achievementHeading)
    {
        this.achievementHeading = achievementHeading;
    }

    public String getContactHeading()
    {
        return contactHeading;
    }

    public void setContactHeading(String contactHeading)
    {
        this.contactHeading = contactHeading;
    }

    public String getContactPerson()
    {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    public String getContactInfo()
    {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public String[] getAchievements()
    {
        return achievements;
    }

    public void setAchievements(ArrayList<String> achievements)
    {
        this.achievements = achievements.toArray(new String[0]);
    }

    public TimePeriod getPeriod()
    {
        return period;
    }

    public void setPeriod(TimePeriod period)
    {
        this.period = period;
    }
}
