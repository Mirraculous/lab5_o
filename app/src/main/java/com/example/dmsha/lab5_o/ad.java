package com.example.dmsha.lab5_o;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ad extends RecyclerView.Adapter<ad.VH> {

    public static class VH extends RecyclerView.ViewHolder {
        TextView name, date, comment;
        CheckBox solved;
        public VH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            date = itemView.findViewById(R.id.tv_date);
            comment = itemView.findViewById(R.id.tv_comment);
            solved = itemView.findViewById(R.id.ch);
        }

        void bind(event e)
        {
            name.setText(e.Name);
            Calendar c = Calendar.getInstance();
            c.set(e.y, e.m - 1, e.d);
            DateFormat df = SimpleDateFormat.getDateInstance();
            date.setText(df.format(c.getTime()));
            if (e.Comment.trim().isEmpty()) {
                comment.setText("<пусто>");
                comment.setTypeface(null, Typeface.ITALIC);
            }
            else {
                comment.setText(e.Comment);
                comment.setTypeface(null, Typeface.NORMAL);
            }
            solved.setChecked(e.Solved);
        }
    }

    ArrayList<event> events;

    public ad(ArrayList<event> list)
    {
        events = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);

    return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.bind(events.get(i));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}


