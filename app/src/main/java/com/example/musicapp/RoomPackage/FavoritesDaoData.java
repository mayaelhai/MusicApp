package com.example.musicapp.RoomPackage;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavoritesDaoData {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FavoritesData favoritesData);

    @Delete
    void delete(FavoritesData favoritesData);

    @Query("DELETE FROM favorites_data")
    void deleteAll();

    @Query("SELECT * from favorites_data")
    LiveData<List<FavoritesData>> getAll();
}
