package com.example.databaselokal.entitas;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataLamaran.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataLamaranDAO dao();
    private static AppDatabase appDatabase;

    public static AppDatabase inidb(Context context){
        if(appDatabase==null)
            appDatabase= Room.databaseBuilder(context,AppDatabase.class, "dbLamaran").allowMainThreadQueries().build();
        return appDatabase;
    }
}
