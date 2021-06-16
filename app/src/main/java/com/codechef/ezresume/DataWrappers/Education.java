package com.codechef.ezresume.DataWrappers;

import java.util.ArrayList;

public class Education
{
    private String programName; // Program / Degree / Diploma / Course
    private String institution,place,grade,coursesHeading;
    private String[] courses;
    private TimePeriod period;


    public String getProgramName()
    {
        return programName;
    }

    public void setProgramName(String programName)
    {
        this.programName = programName;
    }

    public String getInstitution()
    {
        return institution;
    }

    public void setInstitution(String institution)
    {
        this.institution = institution;
    }

    public String getPlace()
    {
        return place;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getCoursesHeading()
    {
        return coursesHeading;
    }

    public void setCoursesHeading(String coursesHeading)
    {
        this.coursesHeading = coursesHeading;
    }

    public String[] getCourses()
    {
        return courses;
    }

    public void setCourses(ArrayList<String> courses)
    {
        this.courses = courses.toArray(new String[0]);
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
