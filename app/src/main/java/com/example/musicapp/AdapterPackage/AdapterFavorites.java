package com.example.musicapp.AdapterPackage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;
import com.example.musicapp.RoomPackage.FavoritesData;
import com.example.musicapp.RoomPackage.FavoritesViewModelData;
import com.example.musicapp.UtilsPackage.ApplicationUtil;

import java.util.List;

public class AdapterFavorites extends RecyclerView.Adapter<ViewHolderAdapterFavorites> {

    private List<FavoritesData> list_data;
    private Activity activity;
    private FavoritesViewModelData favoritesViewModelData;

    public AdapterFavorites(Activity activity) {
        this.activity = activity;

        favoritesViewModelData = new FavoritesViewModelData(ApplicationUtil.getApplication());
    }

    @NonNull
    @Override
    public ViewHolderAdapterFavorites onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_favorites, parent, false);
        return new ViewHolderAdapterFavorites(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterFavorites holder, int position) {
        FavoritesData listData = list_data.get(position);

        holder.language.setText(listData.getLanguage());
        holder.where.setText(listData.getWhere());
        holder.with.setText(listData.getWith());
        holder.mood.setText(listData.getMood());
        holder.why.setText(listData.getWhy());

        holder.btnLink.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(listData.getLink()));
            activity.startActivity(intent);
        });

        holder.ivDelete.setOnClickListener(v -> {
            favoritesViewModelData.delete(listData);
            notifyDataSetChanged();
        });
    }

    public void setData(List<FavoritesData> list_data) {
        this.list_data = list_data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (list_data != null)
            return list_data.size();
        else return 0;
    }

}
