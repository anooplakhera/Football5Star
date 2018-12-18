package com.app.football5star.AppModules.News.NewsAdapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.football5star.R;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    private final Activity context;
    ArrayList<String> allData;

    public RecycleViewAdapter(Activity context, ArrayList<String> allData) {
        this.context = context;
        this.allData = allData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txtString.setText(allData.get(position));
    }

    @Override
    public int getItemCount() {
        return allData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtString;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtString = (TextView) itemView.findViewById(R.id.txtString);

        }
    }
}
