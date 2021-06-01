package com.example.databaselokal.entitas;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataLamaranDAO {
    @Insert
    Long insertData(DataLamaran dataLamaran);

    @Query("Select * from lamaran_db")
    List<DataLamaran> getData();

    @Update
    int updateData(DataLamaran item);

    @Delete
    void deleteData(DataLamaran item);
}
