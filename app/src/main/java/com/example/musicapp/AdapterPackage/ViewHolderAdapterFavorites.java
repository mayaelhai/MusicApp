package com.example.musicapp.AdapterPackage;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.R;

public class ViewHolderAdapterFavorites extends RecyclerView.ViewHolder {

    public TextView language, where, with, mood, why;
    public Button btnLink;
    public ImageView ivDelete;

    public ViewHolderAdapterFavorites(View itemView) {
        super(itemView);

        language = itemView.findViewById(R.id.language);
        where = itemView.findViewById(R.id.where);
        with = itemView.findViewById(R.id.with);
        mood = itemView.findViewById(R.id.mood);
        why = itemView.findViewById(R.id.why);
        btnLink = itemView.findViewById(R.id.btnLink);
        ivDelete = itemView.findViewById(R.id.ivDelete);
    }

}
