package com.codechef.ezresume;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper
{
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "ResumeData";

    //Tables
    private static final String TABLE_WORK_EXPERIENCE = "WorkExperience";
    private static final String TABLE_TITLE_INFO = "TitleInfo";
    private static final String TABLE_TIME_PERIOD = "TimePeriod";
    private static final String TABLE_PROJECT = "Project";
    private static final String TABLE_LANGUAGE = "Language";
    private static final String TABLE_EDUCATION = "Education";
    private static final String TABLE_CONTACT = "Contact";

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
