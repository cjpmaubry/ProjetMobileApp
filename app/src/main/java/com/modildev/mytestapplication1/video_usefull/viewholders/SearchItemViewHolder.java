package com.modildev.mytestapplication1.video_usefull.viewholders;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.modildev.mytestapplication1.WatchActivity;
import com.modildev.mytestapplication1.R;
import com.modildev.mytestapplication1.video_usefull.models.Snippet;
import com.modildev.mytestapplication1.video_usefull.models.YouTubeSearchItem;

public class SearchItemViewHolder extends RecyclerView.ViewHolder {
	
	private TextView title;
	private TextView description;
	private ImageView thumbnail;
	
	public SearchItemViewHolder(@NonNull View itemView) {
		super(itemView);
		this.title = itemView.findViewById(R.id.title);
		//this.description = itemView.findViewById(R.id.description);
		this.thumbnail = itemView.findViewById(R.id.thumbnail);
	}
	
	public void bind(final YouTubeSearchItem youTubeSearchItem) {
		final Snippet snippet = youTubeSearchItem.getSnippet();
		title.setText(snippet.getTitle());
		//description.setText(snippet.getDescription());

		Glide.with(itemView).load(snippet.getThumbnailUrl()).into(thumbnail);

		itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				WatchActivity.start(v.getContext(), youTubeSearchItem.getId().getVideoId());
			}
		});
		


	}
}
