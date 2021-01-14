package com.example.musicapp.RoomPackage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FavoritesData.class}, version = 1, exportSchema = false)
public abstract class FavoritesRoomDatabaseData extends RoomDatabase {

    public abstract FavoritesDaoData favoritesDataDao();

    private static volatile FavoritesRoomDatabaseData INSTANCE;

    public static FavoritesRoomDatabaseData getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FavoritesRoomDatabaseData.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FavoritesRoomDatabaseData.class, "favorites_data")
                            .allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

}
