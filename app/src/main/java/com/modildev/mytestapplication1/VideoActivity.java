package com.modildev.mytestapplication1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.modildev.mytestapplication1.video_usefull.adapters.YouTubeSearchItemAdapter;
import com.modildev.mytestapplication1.video_usefull.api.YouTubeService;
import com.modildev.mytestapplication1.video_usefull.models.YouTubeSearchItem;
import com.modildev.mytestapplication1.video_usefull.models.YouTubeSearchResponse;

import com.modildev.mytestapplication1.video_usefull.api.YouTubeService;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoActivity extends AppCompatActivity {
    private static final String TAG = "VideoActivity";
    private static final String API_KEY = "AIzaSyCHsI-KRdev78EduaFdBO57-o6Hg5UfuTU";

    private EditText editText;
    private RecyclerView recyclerView;
    private YouTubeService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        editText = findViewById(R.id.editText);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(YouTubeService.class);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 0) {
                    launchSearch(s.toString());
                } else {
                    launchSearch("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    private void launchSearch(String query) {
        service.search(query, API_KEY).enqueue(new Callback<YouTubeSearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<YouTubeSearchResponse> call, @NonNull Response<YouTubeSearchResponse> response) {
                Log.d(TAG, "onResponse");
                if (response.isSuccessful()) {
                    YouTubeSearchResponse youTubeSearchResponse = response.body();
                    List<YouTubeSearchItem> itemList = youTubeSearchResponse.getItems();
                    recyclerView.setAdapter(new YouTubeSearchItemAdapter(itemList));
                }
            }

            @Override
            public void onFailure(Call<YouTubeSearchResponse> call, Throwable t) {
                Log.e(TAG, "onFailure", t);
            }
        });
    }

}