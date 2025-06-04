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

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {

    private final List<JadwalModel> jadwalList;

    public JadwalAdapter(List<JadwalModel> jadwalList) {
        this.jadwalList = jadwalList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JadwalModel jadwal = jadwalList.get(position);

        // Format tanggal dan waktu menggunakan string resource
        String formatted = holder.itemView.getContext().getString(
                R.string.jadwal_format,
                jadwal.getDateEventLocal(),
                jadwal.getStrTimeLocal()
        );
        holder.tvJadwalPertandingan.setText(formatted);

        // Set nama tim dan skor
        holder.tvHomeTeam.setText(jadwal.getStrHomeTeam());
        holder.tvAwayTeam.setText(jadwal.getStrAwayTeam());
        holder.tvHomeScore.setText(String.valueOf(jadwal.getIntHomeScore()));
        holder.tvAwayScore.setText(String.valueOf(jadwal.getIntAwayScore()));

        // Load logo tim pakai Glide
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
