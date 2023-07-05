package com.example.software_project;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PMedicalReportAdapter extends RecyclerView.Adapter<PMedicalReportAdapter.MyViewHolder> {
    Context context;
    ArrayList<MedicalReportModel> allReports;
    //My edit
    ArrayList<String> reportKeys;
    //* 88
    private EditButtonClickListener editButtonClickListener;

    public void setEditButtonClickListener(EditButtonClickListener listener) {
        this.editButtonClickListener = listener;
    }
    //My edit;*/


    public PMedicalReportAdapter(Context context, ArrayList<MedicalReportModel>list){
        this.context = context;
        this.allReports = list;

    }


    //My delete

    private DeleteButtonClickListener deleteButtonClickListener;
    //My delete

    public interface DeleteButtonClickListener {
        void onDeleteButtonClick(int position);
    }


    //My delete

    public void setDeleteButtonClickListener(DeleteButtonClickListener listener) {
        this.deleteButtonClickListener = listener;
    }



    //My delete



    //My edit

    public void setReportKeys(ArrayList<String> reportKeys) {
        this.reportKeys = reportKeys;
    }

    //My edit*/
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, sys, dys, hr, date_time;
        Button editButton, deleteButton;

        public MyViewHolder(@NonNull View itemView, DeleteButtonClickListener deleteButtonClickListener) {
            super(itemView);
            name = itemView.findViewById(R.id.name_view);
            sys = itemView.findViewById(R.id.systolic_pressure_view);
            dys = itemView.findViewById(R.id.diastolic_pressure_view);
            hr = itemView.findViewById(R.id.heart_rate_view);
            date_time = itemView.findViewById(R.id.date_time_view);
            editButton = itemView.findViewById(R.id.edit_button);
            deleteButton = itemView.findViewById(R.id.delete_button);


            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (deleteButtonClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            deleteButtonClickListener.onDeleteButtonClick(position);
                        }
                    }
                }
            });


            //My delete


        }
    }

    @NonNull
    @Override
    public PMedicalReportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.medical_report_card,parent,false);
        return new MyViewHolder(v,deleteButtonClickListener);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull PMedicalReportAdapter.MyViewHolder holder, int position) {
        MedicalReportModel medicalReportModel = allReports.get(position);
        holder.name.setText(medicalReportModel.getName());
        holder.sys.setText(medicalReportModel.getSystolic());
        holder.dys.setText(medicalReportModel.getDiastolic());
        holder.hr.setText(medicalReportModel.getHeartRate());
        holder.date_time.setText(medicalReportModel.getDate() + " - " + medicalReportModel.getTime());

        if(Integer.parseInt(medicalReportModel.getSystolic()) > 140 || Integer.parseInt(medicalReportModel.getSystolic()) < 90){
            holder.sys.setTextColor(Color.rgb(255, 0,0));
        }

        if(Integer.parseInt(medicalReportModel.getDiastolic()) > 90 || Integer.parseInt(medicalReportModel.getDiastolic()) < 60){
            holder.dys.setTextColor(Color.rgb(255, 0,0));
        }


        //*My edit 88
        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Get the key of the clicked database record
                    String key = reportKeys.get(position);

                    // Invoke the listener callback
                    if (editButtonClickListener != null) {
                        editButtonClickListener.onEditButtonClick(key);
                    }
                } catch (IndexOutOfBoundsException e) {
                    // Handle index out of bounds exception
                    e.printStackTrace();
                } catch (Exception e) {
                    // Handle any other exceptions
                    e.printStackTrace();
                }
            }
        });
        //My edit*/

        //My delete

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deleteButtonClickListener != null) {
                    deleteButtonClickListener.onDeleteButtonClick(position);
                }
            }
        });
        //my delete


    }
    //*My edit 88

    public interface EditButtonClickListener {
        void onEditButtonClick(String key);
    }


    //My edit*/



    @Override
    public int getItemCount() {
        return allReports.size();
    }


}