package com.example.musicapp.PagesPackage;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp.AdapterPackage.AdapterFavorites;
import com.example.musicapp.R;
import com.example.musicapp.RoomPackage.FavoritesViewModelData;
import com.example.musicapp.UtilsPackage.ApplicationUtil;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterFavorites adapter;
    private FavoritesViewModelData favoritesViewModelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        initUI();
    }

    private void initUI() {
        recyclerView = findViewById(R.id.recyclerView);

        favoritesViewModelData = new FavoritesViewModelData(ApplicationUtil.getApplication());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterFavorites(this);
        recyclerView.setAdapter(adapter);

        favoritesViewModelData.getAll().observe(this, favoritesData -> {
            adapter.setData(favoritesData);

            Log.i("check1", favoritesData.size() + " ");
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_favorites, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteAll:
                favoritesViewModelData.deleteAll();
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
