package com.codechef.ezresume;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codechef.ezresume.DataWrappers.TemplateData;

import java.util.ArrayList;

public class TemplateSelectPagerAdapter extends RecyclerView.Adapter<TemplateSelectPagerAdapter.MyViewHolder>
{

    ArrayList<TemplateData> cvData, resumeData;
    Context context;
    public TemplateSelectPagerAdapter(Context context)
    {
        this.context = context;
        cvData = new ArrayList<>();
        resumeData = new ArrayList<>();

        cvData.add(new TemplateData("Basic",R.mipmap.ic_launcher));
        cvData.add(new TemplateData("Executive",R.mipmap.ic_launcher));
        cvData.add(new TemplateData("College",R.mipmap.ic_launcher));
        cvData.add(new TemplateData("Creative",R.mipmap.ic_launcher));
        cvData.add(new TemplateData("Functional",R.mipmap.ic_launcher));
        cvData.add(new TemplateData("Modern",R.mipmap.ic_launcher));
        cvData.add(new TemplateData("Professional",R.mipmap.ic_launcher));
        cvData.add(new TemplateData("Simple",R.mipmap.ic_launcher));

        resumeData.add(new TemplateData("Basic",R.mipmap.ic_launcher_round));
        resumeData.add(new TemplateData("Executive",R.mipmap.ic_launcher_round));
        resumeData.add(new TemplateData("College",R.mipmap.ic_launcher_round));
        resumeData.add(new TemplateData("Creative",R.mipmap.ic_launcher_round));
        resumeData.add(new TemplateData("Functional",R.mipmap.ic_launcher_round));
        resumeData.add(new TemplateData("Modern",R.mipmap.ic_launcher_round));
        resumeData.add(new TemplateData("Professional",R.mipmap.ic_launcher_round));
        resumeData.add(new TemplateData("Simple",R.mipmap.ic_launcher_round));
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_template,parent,false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull  TemplateSelectPagerAdapter.MyViewHolder holder, int position)
    {

        TemplateSelectRecyclerAdapter adapter = new TemplateSelectRecyclerAdapter((position == 0) ? resumeData: cvData);
        GridLayoutManager manager = new GridLayoutManager(context,2);
        holder.recyclerView.setLayoutManager(manager);
        holder.recyclerView.setAdapter(adapter);

    }

    @Override
    public int getItemCount()
    {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        RecyclerView recyclerView;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_template_grid);

        }
    }
}
