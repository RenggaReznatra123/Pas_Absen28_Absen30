package com.example.pas_absen28_absen30;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class PremierFragment extends Fragment{
    RecyclerView rvpremiere;
    ProgressBar progressBar;
    Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premier_league, container, false);

        rvpremiere = view.findViewById(R.id.rv_premier);
        progressBar = view.findViewById(R.id.progressBar);
        rvpremiere.setLayoutManager(new LinearLayoutManager(getContext()));

        APIservise api = RetrofitClient.getInstance().create(APIservise.class);
        fetchJadwal(api);

        return view;
    }

    private void fetchJadwal(APIservise api) {
        api.getEnglishPremierleague("English Premier League").enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getTeams() != null) {
                    List<Team> jadwal = response.body().getTeams();
                    adapter = new Adapter(jadwal);
                    rvpremiere.setAdapter(adapter);
                    rvpremiere.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
            }
        });
    }
}
