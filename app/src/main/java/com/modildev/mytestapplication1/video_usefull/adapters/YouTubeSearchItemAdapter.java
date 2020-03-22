package com.modildev.mytestapplication1.video_usefull.adapters;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import com.modildev.mytestapplication1.R;
import com.modildev.mytestapplication1.video_usefull.models.YouTubeSearchItem;
import com.modildev.mytestapplication1.video_usefull.viewholders.SearchItemViewHolder;


public class YouTubeSearchItemAdapter extends RecyclerView.Adapter<SearchItemViewHolder> {
	
	private final List<YouTubeSearchItem> items;
	
	public YouTubeSearchItemAdapter(List<YouTubeSearchItem> items) {
		this.items = items;
	}
	
	@NonNull
	@Override
	public SearchItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_search_item, viewGroup, false);
		return new SearchItemViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(@NonNull SearchItemViewHolder searchItemViewHolder, int position) {
		searchItemViewHolder.bind(items.get(position));
	}
	
	@Override
	public int getItemCount() {
		return items != null ? items.size() : 0;
	}
}
