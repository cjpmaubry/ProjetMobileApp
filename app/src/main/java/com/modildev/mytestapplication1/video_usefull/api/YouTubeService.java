package com.modildev.mytestapplication1.video_usefull.api;

import com.modildev.mytestapplication1.video_usefull.models.YouTubeSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YouTubeService {
	@GET("search?part=snippet&type=video&maxResults=50")
	Call<YouTubeSearchResponse> search(@Query("q") String query, @Query("key") String apiKey);
}
