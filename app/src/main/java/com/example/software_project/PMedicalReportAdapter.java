package com.example.software_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PMedicalReportAdapter extends RecyclerView.Adapter<PMedicalReportAdapter.MyViewHolder> {
    Context context;
    ArrayList<MedicalReportModel> allReports;
    public PMedicalReportAdapter(Context context, ArrayList<MedicalReportModel>list){
        this.context = context;
        this.allReports = list;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView s, g, n,glu,so,u;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            s = itemView.findViewById(R.id.sugarView);
            g = itemView.findViewById(R.id.gasView);
            n = itemView.findViewById(R.id.nillView);
            so = itemView.findViewById(R.id.sodiumView);
            u = itemView.findViewById(R.id.acidView);
            glu = itemView.findViewById(R.id.glucoseView);
        }
    }


    @NonNull
    @Override
    public PMedicalReportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.p_medical_report_card,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PMedicalReportAdapter.MyViewHolder holder, int position) {
        MedicalReportModel medicalReportModel = allReports.get(position);
        holder.s.setText(medicalReportModel.getDate());
        holder.g.setText(medicalReportModel.getTime());
        holder.n.setText(medicalReportModel.getSystolic());
        holder.so.setText(medicalReportModel.getDiastolic());
        holder.u.setText(medicalReportModel.getHeartRate());
        holder.glu.setText(medicalReportModel.getComment());
    }

    @Override
    public int getItemCount() {
        return allReports.size();
    }
}