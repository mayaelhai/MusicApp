package com.example.musicapp.RoomPackage;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FavoritesRepositoryData {

    private FavoritesDaoData mFavoritesDaoData;
    private LiveData<List<FavoritesData>> mAllData;

    public FavoritesRepositoryData(Application application) {
        FavoritesRoomDatabaseData db = FavoritesRoomDatabaseData.getDatabase(application);
        mFavoritesDaoData = db.favoritesDataDao();
        mAllData = mFavoritesDaoData.getAll();
    }

    public LiveData<List<FavoritesData>> getAll() {
        return mAllData;
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {

        private FavoritesDaoData favoritesDaoData;

        private DeleteAllAsyncTask(FavoritesDaoData dao) {
            favoritesDaoData = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            favoritesDaoData.deleteAll();
            return null;
        }
    }

    void deleteAll() {
        DeleteAllAsyncTask deleteAllAsyncTask = new DeleteAllAsyncTask(mFavoritesDaoData);
        deleteAllAsyncTask.execute();
    }

    private static class deleteAsyncTask extends AsyncTask<FavoritesData, Void, Void> {

        private FavoritesDaoData favoritesDaoData;

        private deleteAsyncTask(FavoritesDaoData dao) {
            favoritesDaoData = dao;
        }

        @Override
        protected Void doInBackground(final FavoritesData... params) {
            favoritesDaoData.delete(params[0]);
            return null;
        }
    }

    void delete(FavoritesData favoritesData) {
        new deleteAsyncTask(mFavoritesDaoData).execute(favoritesData);
    }

    private static class insertAsyncTask extends AsyncTask<FavoritesData, Void, Void> {

        private FavoritesDaoData favoritesDaoData;

        private insertAsyncTask(FavoritesDaoData dao) {
            favoritesDaoData = dao;
        }

        @Override
        protected Void doInBackground(final FavoritesData... params) {
            try {
                favoritesDaoData.insert(params[0]);
            } catch (Exception e) {

            }
            return null;
        }
    }

    public void insert(FavoritesData favoritesData) {
        new insertAsyncTask(mFavoritesDaoData).execute(favoritesData);
    }

}
