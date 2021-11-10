package com.example.myapplication3;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication3.It;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<It> ItList;

    public MyAdapter(List<It> ItList) {
        this.ItList = ItList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        android.view.View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        It it = ItList.get(position);
        //holder.t.setText(it.getS());
        holder.textView.setText(it.getName());
        holder.textView2.setText(it.getTime());

    }



    @Override
    public int getItemCount() {
        return ItList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        Button button;
        CheckBox checkBox;

        public MyViewHolder(android.view.View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.textView);
            this.textView2 = itemView.findViewById(R.id.textView2);
            this.checkBox = itemView.findViewById(R.id.checkBox);
            this.button = itemView.findViewById(R.id.button);
        }
    }
}
