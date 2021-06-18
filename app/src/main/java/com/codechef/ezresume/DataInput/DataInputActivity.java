package com.codechef.ezresume.DataInput;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.codechef.ezresume.DataWrappers.TemplateData;
import com.codechef.ezresume.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;

import java.util.ArrayList;


public class DataInputActivity extends AppCompatActivity
{

    TemplateData templateData;
    ViewPager2 pager;
    TabLayout tabLayout;
    DataInputPagerAdapter pagerAdapter;
    enum FragmentName
    {
        CONTACT,EDUCATION,LANGUAGE,PROJECT,TITLE_INFO,WORK_EXPERIENCE
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_input);
        String json = getIntent().getStringExtra("templateData");
        Gson gson = new Gson();
        templateData = gson.fromJson(json,TemplateData.class);

        pager = findViewById(R.id.pager_info);
        tabLayout = findViewById(R.id.tab_layout);

        pagerAdapter = new DataInputPagerAdapter(this);
        pager.setAdapter(pagerAdapter);
        new TabLayoutMediator(tabLayout, pager,
                (tab, position) -> getTabName(position)).attach();
    }

    private String getTabName(int position)
    {
        switch (pagerAdapter.fragmentList.get(position))
        {
            case CONTACT:
                return "Contact";
            case EDUCATION:
                return "Education";
            case LANGUAGE:
                return "Languages";
            case PROJECT:
                return "Projects";
            case TITLE_INFO:
                return "Title";
            case WORK_EXPERIENCE:
                return "Work Experience";
            default:
                return "Null";
        }
    }


    static class DataInputPagerAdapter extends FragmentStateAdapter
    {

        ArrayList<FragmentName> fragmentList;
        public DataInputPagerAdapter(@NonNull  FragmentActivity fragmentActivity)
        {
            super(fragmentActivity);
            fragmentList = new ArrayList<>();
        }

        void addFragment(FragmentName fragmentName)
        {
            fragmentList.add(fragmentName);
            notifyDataSetChanged();
        }
        void addFragment(FragmentName name, int index)
        {
            fragmentList.add(index, name);
            notifyDataSetChanged();
        }
        void removeFragment(FragmentName fragmentName)
        {
            fragmentList.remove(fragmentName);
            notifyDataSetChanged();
        }
        void removeFragment(int index)
        {
            fragmentList.remove(index);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public Fragment createFragment(int position)
        {
            switch (position)
            {
                case 0:
                    return DataInputFragment.newInstance(0,"1");
                case 1:
                    return DataInputFragment.newInstance(1,"2");
            }
            return DataInputFragment.newInstance(3,"Null");
        }

        @Override
        public int getItemCount()
        {
            return fragmentList.size();
        }

        @Override
        public long getItemId(int position)
        {
            return fragmentList.get(position).ordinal();
        }

        @Override
        public boolean containsItem(long itemId)
        {
            return fragmentList.contains(FragmentName.values()[(int) itemId]);
        }
    }


}