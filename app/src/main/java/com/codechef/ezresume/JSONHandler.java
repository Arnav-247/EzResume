package com.codechef.ezresume;

import android.content.Context;

import com.codechef.ezresume.DataWrappers.Contact;
import com.codechef.ezresume.DataWrappers.Education;
import com.codechef.ezresume.DataWrappers.Language;
import com.codechef.ezresume.DataWrappers.Project;
import com.codechef.ezresume.DataWrappers.TimePeriod;
import com.codechef.ezresume.DataWrappers.TitleInfo;
import com.codechef.ezresume.DataWrappers.WorkExperience;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JSONHandler
{
    Context context;
    Gson gson;
    private static final String FILE_WORK_EXPERIENCE = "WorkExperience.json";
    private static final String FILE_TITLE_INFO = "TitleInfo.json";
    private static final String FILE_TIME_PERIOD = "TimePeriod.json";
    private static final String FILE_PROJECT = "Project.json";
    private static final String FILE_LANGUAGE = "Language.json";
    private static final String FILE_EDUCATION = "Education.json";
    private static final String FILE_CONTACT = "Contact.json";
    //TO DO
    private static final String FILE_CV = "CV.json";
    private static final String FILE_RESUME = "Resume.json";
    private static final String FILE_COVER_LETTER = "CoverLetter.json";

    public JSONHandler(Context context)
    {
        this.context = context;
        gson = new Gson();
    }

    public <E> ArrayList<E> getDataList(Class<E> classT)
    {
        Type contactType = new TypeToken<ArrayList<E>>() {}.getType();
        String fileName = getFileName(classT);

        if(!fileName.isEmpty() && isFilePresent(fileName))
        {
            String json = readFile(fileName);
            ArrayList<E> data = gson.fromJson(json,contactType);
            return data;
        }
        else
        {
            return new ArrayList<>();
        }
    }

    public <E> boolean setDataList(ArrayList<E> data)
    {
        if(data.size() > 0)
        {
            Class<E> classT = (Class<E>) data.get(0).getClass();
            String fileName = getFileName(classT);
            String json = gson.toJson(data);
            boolean fileMade = createFile(fileName, json);
            return fileMade;
        }
        else
            return false;
    }


    private <T> String getFileName(Class<T> classT)
    {
        String file;
        if(classT == Contact.class)
            file = FILE_CONTACT;
        else if(classT == Education.class)
            file = FILE_EDUCATION;
        else if(classT == Language.class)
            file = FILE_LANGUAGE;
        else if(classT == Project.class)
            file = FILE_PROJECT;
        else if(classT == TimePeriod.class)
            file = FILE_TIME_PERIOD;
        else if(classT == TitleInfo.class)
            file = FILE_TITLE_INFO;
        else if(classT == WorkExperience.class)
            file = FILE_WORK_EXPERIENCE;
        else
            file = "";
        return file;
    }
    private String readFile(String fileName)
    {
        try
        {
            FileInputStream fis = context.openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                sb.append(line);
            }
            return sb.toString();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    private boolean createFile(String fileName, String jsonString)
    {
        try
        {
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            if (jsonString != null)
            {
                fos.write(jsonString.getBytes());
            }
            fos.close();
            return true;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isFilePresent(String fileName)
    {
        String path = context.getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = new File(path);
        return file.exists();
    }
}
