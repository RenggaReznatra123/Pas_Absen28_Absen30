package com.example.pas_absen28_absen30;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder>{
    private List<JadwalModel> jadwalList;

    public JadwalAdapter(List<JadwalModel> jadwalList) {
        this.jadwalList = jadwalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_jadwal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JadwalModel jadwal = jadwalList.get(position);

        holder.tvJadwalPertandingan.setText(jadwal.getDateEventLocal() + " • " + jadwal.getStrTimeLocal());
        holder.tvHomeTeam.setText(jadwal.getStrHomeTeam());
        holder.tvAwayTeam.setText(jadwal.getStrAwayTeam());
        holder.tvHomeScore.setText(jadwal.getIntHomeScore());
        holder.tvAwayScore.setText(jadwal.getIntAwayScore());

        // Load logo tim
        Glide.with(holder.itemView.getContext())
                .load(jadwal.getStrHomeTeamBadge())
                .into(holder.ivHomeTeam);

        Glide.with(holder.itemView.getContext())
                .load(jadwal.getStrAwayTeamBadge())
                .into(holder.ivAwayTeam);
    }

    @Override
    public int getItemCount() {
        return jadwalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJadwalPertandingan, tvHomeTeam, tvAwayTeam, tvHomeScore, tvAwayScore;
        ImageView ivHomeTeam, ivAwayTeam;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJadwalPertandingan = itemView.findViewById(R.id.tvJadwalPertandingan);
            tvHomeTeam = itemView.findViewById(R.id.tvHomeTeam);
            tvAwayTeam = itemView.findViewById(R.id.tvAwayTeam);
            tvHomeScore = itemView.findViewById(R.id.tvHomeScore);
            tvAwayScore = itemView.findViewById(R.id.tvAwayScore);
            ivHomeTeam = itemView.findViewById(R.id.ivHomeTeam);
            ivAwayTeam = itemView.findViewById(R.id.ivAwayTeam);
        }
    }
}