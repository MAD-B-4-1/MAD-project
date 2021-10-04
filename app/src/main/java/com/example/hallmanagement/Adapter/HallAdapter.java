package com.example.hallmanagement.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hallmanagement.Database.HallDetails;
import com.example.hallmanagement.Helper.DBHelper;
import com.example.hallmanagement.R;
import com.example.hallmanagement.UpdateActivity;



import java.util.List;

public class HallAdapter extends RecyclerView.Adapter<HallAdapter.ViewHolder>{

    Context context;
    List<HallDetails> hallDetailsList;
    View view;
    DBHelper helper;

    public HallAdapter(Context context) {
        this.context = context;
    }

    public HallAdapter(Context context, List<HallDetails> hallDetailsList) {
        this.context = context;
        this.hallDetailsList = hallDetailsList;

        helper=DBHelper.getInstance(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.row_lay,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        HallDetails itemModel=hallDetailsList.get(position);

        if(hallDetailsList!=null && hallDetailsList.size()>0){
            HallDetails hallDetails=hallDetailsList.get(position);
            holder.hallid_tv.setText(hallDetails.getHallID());
            holder.time_tv.setText(hallDetails.getTime());
            holder.moduleid_tv.setText(hallDetails.getModule_id());
            holder.modulename_tv.setText(hallDetails.getModule_name());
            holder.lecturename_tv.setText(hallDetails.getLecturer_name());

            holder.more_tv.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    PopupMenu popupMenu=new PopupMenu(context,holder.more_tv);
                    popupMenu.getMenuInflater().inflate(R.menu.items,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @SuppressLint({"NotifyDataSetChanged", "NonConstantResourceId"})
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.update_id:
                                    context.startActivity(new Intent(context, UpdateActivity.class)
                                            .putExtra("HallDatabase",hallDetails));
                                    break;
                                case R.id.delete_id:
                                    helper.DeleteData(hallDetails);
                                    hallDetailsList.remove(position);
                                    notifyDataSetChanged();
                                    notifyItemRangeChanged(position,hallDetailsList.size());
                                    break;
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return hallDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hallid_tv, time_tv , moduleid_tv, modulename_tv, lecturename_tv;
        ImageView more_tv;
        public ViewHolder(@Nullable View itemView) {
            super(itemView);

            hallid_tv=itemView.findViewById(R.id.hallid_tv);
            time_tv=itemView.findViewById(R.id.time_tv);
            moduleid_tv=itemView.findViewById(R.id.moduleid_tv);
            modulename_tv=itemView.findViewById(R.id.modulename_tv);
            lecturename_tv=itemView.findViewById(R.id.lecturename_tv);
            more_tv=itemView.findViewById(R.id.more_iv);

        }

    }

}


