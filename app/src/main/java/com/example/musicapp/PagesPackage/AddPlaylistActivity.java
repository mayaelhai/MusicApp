package com.example.musicapp.PagesPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.musicapp.ModelsPackage.PlaylistModel;
import com.example.musicapp.R;
import com.example.musicapp.UtilsPackage.FirebaseManager;

public class AddPlaylistActivity extends AppCompatActivity implements View.OnClickListener {

    private String language, where, with, mood, why;
    private FirebaseManager firebaseManager;
    private EditText urlPlaylist;
    private Button btnAddPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_playlist);

        initUI();
        initListeners();
    }

    private void initUI() {
        urlPlaylist = findViewById(R.id.urlPlaylist);
        btnAddPlaylist = findViewById(R.id.btnAddPlaylist);

        language = getIntent().getStringExtra("language");
        where = getIntent().getStringExtra("where");
        with = getIntent().getStringExtra("with");
        mood = getIntent().getStringExtra("mood");
        why = getIntent().getStringExtra("why");

        Log.i("check1", language + ", " + where + ", " + with + ", " + mood + ", " + why);

        firebaseManager = new FirebaseManager();

        firebaseManager.initFirestore();
    }

    private void initListeners() {
        btnAddPlaylist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddPlaylist) {
            String strUrlPlaylist = urlPlaylist.getText().toString();

            firebaseManager.firestoreAddData(language, where, with, mood, why, strUrlPlaylist)
                    .addOnSuccessListener(aVoid -> {
                        Intent intent = new Intent(AddPlaylistActivity.this, MainActivity.class);
                        startActivity(intent);

                        finish();
                    })
                    .addOnFailureListener(e -> Toast.makeText(AddPlaylistActivity.this, "Error: " + e, Toast.LENGTH_LONG).show());

        }
    }

}
