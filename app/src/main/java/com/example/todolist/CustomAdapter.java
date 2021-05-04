package com.example.todolist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<ToDo> works;
    CustomAdapter(Context c,ArrayList<ToDo> w)
    {
        context=c;
        works=w;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView tvmsg=holder.itemView.findViewById(R.id.msg);
        tvmsg.setText(works.get(position).work);
    }

    @Override
    public int getItemCount() {
        return works.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.msg);
        }
    }
}
