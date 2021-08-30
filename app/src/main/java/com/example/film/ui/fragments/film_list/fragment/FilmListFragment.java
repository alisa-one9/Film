package com.example.film.ui.fragments.film_list.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.film.App;
import com.example.film.R;
import com.example.film.data.model.Film;
import com.example.film.data.model.RetrofitB;
import com.example.film.databinding.FragmentFilmListBinding;
import com.example.film.ui.fragments.film_list.adapters.ApiAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmListFragment extends Fragment implements ApiAdapter.Callback,
        ApiAdapter.SaveRoom {

   private final ApiAdapter adapter =new ApiAdapter(this,this);
   private FragmentFilmListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentFilmListBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        getFilmFromRetrofitB();
    }

    private void getFilmFromRetrofitB() {
        RetrofitB.getInstance().getFilm().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.addItems(response.body());
                    Log.d("tag", "success:" + response.body());
                } else {
                    Log.d("tag", "error!:" + response.code());
                }
            }
            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Log.e("tag", t.getLocalizedMessage());
            }
        });
    }

    private void initView(View view) {
        binding.filmRecyclerView.setAdapter(adapter);
    }

    @Override
    public void filmClick(Film film) {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.fragment);
        Bundle bundle = new Bundle();
        bundle.putString("filmId", film.getId());
        Log.d("tag", "success: " + film.getId());
        navController.navigate(R.id.filmDetailFragment, bundle);
    }

    @Override
    public void click(Film film) {
        App.getAppDatabase().filmDao().insert(new Film
                (film.getTitle(),
                 film.getTitleJapan(),
                film.getDescF() ) );
        Log.d("tag", "success: " + film.getId());

    }
}