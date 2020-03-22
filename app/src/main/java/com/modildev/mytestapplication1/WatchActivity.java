package com.modildev.mytestapplication1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import androidx.appcompat.app.AppCompatActivity;

public class WatchActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
	
	private static final String VIDEO_ID = "VIDEO_ID";
	private String videoId;
	private TextView textView;
	private YouTubePlayer youTubePlayer;
	private String GOOGLE_API_KEY = "AIzaSyCHsI-KRdev78EduaFdBO57-o6Hg5UfuTU";
	
	public static void start(Context context, String videoId) {
		Intent intent = new Intent(context, WatchActivity.class);
		intent.putExtra(VIDEO_ID, videoId);
		context.startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_watch);
		Intent intent = getIntent();
		if (intent != null) {
			videoId = intent.getStringExtra(VIDEO_ID);
		}


		final YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
		youTubePlayerView.initialize(GOOGLE_API_KEY, this);

	}


	public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

		this.youTubePlayer = youTubePlayer;
		this.youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
		this.youTubePlayer.setPlaybackEventListener(playbackEventListener);


		if (!b) {
			this.youTubePlayer.cueVideo(videoId);
		}
	}


	private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
		@Override
		public void onPlaying() {

		}

		@Override
		public void onPaused() {

		}

		@Override
		public void onStopped() {

		}

		@Override
		public void onBuffering(boolean b) {

		}

		@Override
		public void onSeekTo(int i) {

		}
	};

	private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
		@Override
		public void onLoading() {

		}

		@Override
		public void onLoaded(String s) {

		}

		@Override
		public void onAdStarted() {

		}

		@Override
		public void onVideoStarted() {

		}

		@Override
		public void onVideoEnded() {

		}

		@Override
		public void onError(YouTubePlayer.ErrorReason errorReason) {

		}
	};



	public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

	}
}
