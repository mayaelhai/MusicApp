package com.example.musicapp.PagesPackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.musicapp.R;
import com.example.musicapp.RoomPackage.FavoritesData;
import com.example.musicapp.RoomPackage.FavoritesViewModelData;
import com.example.musicapp.UtilsPackage.ApplicationUtil;
import com.example.musicapp.UtilsPackage.FirebaseManager;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class PlaylistActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvNoPlaylist;
    private Button btYoutube, btnAddFavorites;
    private String language, where, with, mood, why, urlYoutube;
    private FirebaseManager firebaseManager;
    private FavoritesViewModelData favoritesViewModelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        initUI();
        initListeners();
    }

    private void initUI() {
        btYoutube = findViewById(R.id.btYoutube);
        btnAddFavorites = findViewById(R.id.btnAddFavorites);
        tvNoPlaylist = findViewById(R.id.tvNoPlaylist);

        language = getIntent().getStringExtra("language");
        where = getIntent().getStringExtra("where");
        with = getIntent().getStringExtra("with");
        mood = getIntent().getStringExtra("mood");
        why = getIntent().getStringExtra("why");

        Log.i("check1", language + ", " + where + ", " + with + ", " + mood + ", " + why);

        firebaseManager = new FirebaseManager();
        firebaseManager.initFirestore();

        favoritesViewModelData = new FavoritesViewModelData(ApplicationUtil.getApplication());

        getDataFirestore();
    }

    private void initListeners() {
        btYoutube.setOnClickListener(this);
        btnAddFavorites.setOnClickListener(this);
    }

    private void getDataFirestore() {
        firebaseManager.firestoreGetData(language, where, with, mood, why)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            urlYoutube = document.getData().get("link").toString();
                            Log.i("check1", document.getId() + " => " + document.getData().get("link"));

                            if (urlYoutube != null) {
                                tvNoPlaylist.setVisibility(View.GONE);
                                btYoutube.setVisibility(View.VISIBLE);
                                btnAddFavorites.setVisibility(View.VISIBLE);
                            }
                        }
                    } else {
                        Log.i("check1", "Error getting documents: ", task.getException());
                    }
                });
    }

    private void clicked(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btYoutube) {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("url_youtube", urlYoutube);
            editor.apply();

            clicked(urlYoutube);
        }
        if (v.getId() == R.id.btnAddFavorites) {
            FavoritesData favoritesData = new FavoritesData(language, where, with, mood, why, urlYoutube);
            favoritesViewModelData.insert(favoritesData);

            Intent intent = new Intent(this, FavoritesActivity.class);
            startActivity(intent);
        }
    }

}
