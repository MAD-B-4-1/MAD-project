package com.example.lecturemanagement.Adapter;

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

import com.example.lecturemanagement.Helper.DBHelper;
import com.example.lecturemanagement.Database.LecturerDetails;
import com.example.lecturemanagement.R;
import com.example.lecturemanagement.UpdateLec_Activity;

import java.util.List;

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.ViewHolder>{

    Context context;
    List<LecturerDetails> lecturerDetailsList;
    View view;
    DBHelper helper;

    public LectureAdapter(Context context) {
        this.context = context;
    }

    public LectureAdapter(Context context, List<LecturerDetails> lecturerDetailsList) {
        this.context = context;
        this.lecturerDetailsList = lecturerDetailsList;

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
        if(lecturerDetailsList!=null && lecturerDetailsList.size()>0){
            LecturerDetails lecturerDetails=lecturerDetailsList.get(position);
            holder.lecid_tv.setText(lecturerDetails.getLectureID());
            holder.lecname_tv.setText(lecturerDetails.getName());
            holder.mod_tv.setText(lecturerDetails.getModuleID());
            holder.mail_tv.setText(lecturerDetails.getMail());
            holder.lecinc_tv.setText(lecturerDetails.getLecturer_incharge());


            holder.more_tv.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    PopupMenu popupMenu=new PopupMenu(context,holder.more_tv);
                    popupMenu.getMenuInflater().inflate(R.menu.items,popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()){
                                case R.id.update:
                                    context.startActivity(new Intent(context, UpdateLec_Activity.class)
                                            .putExtra("LecturerDatabase",lecturerDetails));
                                    break;
                                case R.id.delete:
                                    helper.DeleteData(lecturerDetails);
                                    lecturerDetailsList.remove(position);
                                    notifyDataSetChanged();
                                    notifyItemRangeChanged(position,lecturerDetailsList.size());
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
        return lecturerDetailsList.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView lecid_tv,lecname_tv ,mod_tv , mail_tv , lecinc_tv ;
    ImageView more_tv;
    public ViewHolder(@Nullable View itemView) {
        super(itemView);
        lecid_tv=itemView.findViewById(R.id.lecID_tv);
        lecname_tv=itemView.findViewById(R.id.lecName_tv);
        mod_tv=itemView.findViewById(R.id.Mod_tv);
        mail_tv=itemView.findViewById(R.id.Mail_tv);
        lecinc_tv=itemView.findViewById(R.id.Lecinc_tv);
        more_tv=itemView.findViewById(R.id.more_tv);

        }

    }
}
