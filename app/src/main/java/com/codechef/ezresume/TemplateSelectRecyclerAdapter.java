package com.codechef.ezresume;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codechef.ezresume.DataWrappers.TemplateData;

import java.util.ArrayList;

public class TemplateSelectRecyclerAdapter extends RecyclerView.Adapter<TemplateSelectRecyclerAdapter.CardViewHolder>
{
    ArrayList<TemplateData> data;

    public TemplateSelectRecyclerAdapter(ArrayList<TemplateData> data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_template, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  TemplateSelectRecyclerAdapter.CardViewHolder holder, int position)
    {
        holder.imageView.setImageResource(data.get(position).getImageID());
        holder.textView.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        public CardViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_template_img);
            textView = itemView.findViewById(R.id.text_title);
        }
    }
}
