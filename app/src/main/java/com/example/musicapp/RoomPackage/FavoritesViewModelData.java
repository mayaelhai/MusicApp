package com.example.musicapp.RoomPackage;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FavoritesViewModelData extends AndroidViewModel {

    private FavoritesRepositoryData favoritesRepositoryData;
    private LiveData<List<FavoritesData>> mAllFavoritesData;

    public FavoritesViewModelData(Application application) {
        super(application);

        favoritesRepositoryData = new FavoritesRepositoryData(application);
        mAllFavoritesData = favoritesRepositoryData.getAll();
    }

    public LiveData<List<FavoritesData>> getAll() {
        return mAllFavoritesData;
    }

    public void insert(FavoritesData favoritesData) {
        favoritesRepositoryData.insert(favoritesData);
    }

    public void deleteAll() {
        favoritesRepositoryData.deleteAll();
    }

    public void delete(FavoritesData favoritesData) {
        favoritesRepositoryData.delete(favoritesData);
    }

}
