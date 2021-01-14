package com.example.musicapp.PagesPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.musicapp.BroadcastReceiversPackage.BroadcastReceiverAirPlaneMode;
import com.example.musicapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btInfo, btStart, btUrlYoutube, btnAddPlaylist, btnFavoritePlaylists, btnAlarmPlaylist;
    private TextView tvFullName;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initListeners();
    }

    private void initUI() {
        btInfo = findViewById(R.id.btInfo);
        btStart = findViewById(R.id.btStart);
        btUrlYoutube = findViewById(R.id.btUrlYoutube);
        btnAddPlaylist = findViewById(R.id.btnAddPlaylist);
        btnFavoritePlaylists = findViewById(R.id.btnFavoritePlaylists);
        btnAlarmPlaylist = findViewById(R.id.btnAlarmPlaylist);
        tvFullName = findViewById(R.id.tvFullName);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0);

        tvFullName.setText(pref.getString("first_name", "No First Name") +
                " " + pref.getString("last_name", "No Last Name"));

        if (!pref.getString("url_youtube", "No Last Playlist").equals("No Last Playlist")) {
            btUrlYoutube.setVisibility(View.VISIBLE);
        }

        registerReceiver(new BroadcastReceiverAirPlaneMode(), new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }

    private void initListeners() {
        btInfo.setOnClickListener(this);
        btStart.setOnClickListener(this);
        btUrlYoutube.setOnClickListener(this);
        btnAddPlaylist.setOnClickListener(this);
        btnFavoritePlaylists.setOnClickListener(this);
        btnAlarmPlaylist.setOnClickListener(this);
    }

    private void clicked(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btStart) {
            Intent resultsIn = new Intent(getApplicationContext(), QuestionLanguageActivity.class);
            resultsIn.putExtra("data", "Get");
            startActivity(resultsIn);
        }
        if (v.getId() == R.id.btInfo) {
            Intent resultsIn = new Intent(getApplicationContext(), InformationActivity.class);
            startActivity(resultsIn);
        }
        if (v.getId() == R.id.btUrlYoutube) {
            clicked(pref.getString("url_youtube", "No Last Playlist"));
        }
        if (v.getId() == R.id.btnAddPlaylist) {
            Intent resultsIn = new Intent(getApplicationContext(), QuestionLanguageActivity.class);
            resultsIn.putExtra("data", "Add");
            startActivity(resultsIn);
        }
        if (v.getId() == R.id.btnFavoritePlaylists) {
            Intent resultsIn = new Intent(getApplicationContext(), FavoritesActivity.class);
            startActivity(resultsIn);
        }
        if (v.getId() == R.id.btnAlarmPlaylist) {
            Intent resultsIn = new Intent(getApplicationContext(), AlarmActivity.class);
            startActivity(resultsIn);
        }
    }

}
