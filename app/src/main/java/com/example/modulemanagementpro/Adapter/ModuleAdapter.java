package com.example.modulemanagementpro.Adapter;

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

import com.example.modulemanagementpro.Database.ModuleDetails;
import com.example.modulemanagementpro.Helper.DBHelper;
import com.example.modulemanagementpro.R;
import com.example.modulemanagementpro.UpdateActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder>{

    Context context;
    List<ModuleDetails> moduleDetailsList;
    View view;
    DBHelper helper;

    public ModuleAdapter(Context context) {
        this.context = context;
    }

    public ModuleAdapter(Context context, List<ModuleDetails> moduleDetailsList) {
        this.context = context;
        this.moduleDetailsList = moduleDetailsList;

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
        ModuleDetails itemModel=moduleDetailsList.get(position);

        if(moduleDetailsList!=null && moduleDetailsList.size()>0){
            ModuleDetails moduleDetails=moduleDetailsList.get(position);
            holder.mod_tv.setText(moduleDetails.getModuleID());
            holder.pay_tv.setText(moduleDetails.getPayment());
            holder.credit_tv.setText(moduleDetails.getCredit());
            holder.lect_tv.setText(moduleDetails.getLecturer());

            holder.more_tv.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    PopupMenu popupMenu=new PopupMenu(context,holder.more_tv);
                    popupMenu.getMenuInflater().inflate(R.menu.items,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.update_id:
                                    context.startActivity(new Intent(context, UpdateActivity.class)
                                            .putExtra("ModuleDatabase",moduleDetails));
                                    break;
                                case R.id.delete_id:
                                    helper.DeleteData(moduleDetails);
                                    moduleDetailsList.remove(position);
                                    notifyDataSetChanged();
                                    notifyItemRangeChanged(position,moduleDetailsList.size());
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
        return moduleDetailsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mod_tv,pay_tv ,credit_tv, lect_tv;
        ImageView more_tv;
        public ViewHolder(@Nullable View itemView) {
            super(itemView);

            mod_tv=itemView.findViewById(R.id.mod_tv);
            pay_tv=itemView.findViewById(R.id.pay_tv);
            credit_tv=itemView.findViewById(R.id.credit_tv);
            lect_tv=itemView.findViewById(R.id.lect_tv);
            more_tv=itemView.findViewById(R.id.more_iv);

        }

    }

//    public void searchFilter(String newText){
//        newText=newText.toLowerCase(Locale.getDefault());
//        moduleDetailsList.clear();
//        if(newText.length()==0){
//            moduleDetailsList.addAll(searchItemFilteredList);
//        }
//        else{
//            for(ModuleDetails item:searchItemFilteredList){
//                if(item.getModuleID().toLowerCase(Locale.getDefault()).contains(newText)){
//                    moduleDetailsList.add(item);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }

}

