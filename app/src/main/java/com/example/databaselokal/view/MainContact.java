package com.example.databaselokal.view;

import android.view.View;

import com.example.databaselokal.entitas.AppDatabase;
import com.example.databaselokal.entitas.DataLamaran;

import java.util.List;

public interface MainContact {
    interface view extends View.OnClickListener{
        void successAdd();
        void successDelete();
        void resetForm();
        void getData(List<DataLamaran> list);
        void editData(DataLamaran item);
        void deleteData(DataLamaran item);
    }

    interface presenter{
        void insertData(String nama, String lahir, String agama, String hp, String email, AppDatabase database);
        void readData(AppDatabase database);
        void editData(String nama, String lahir, String agama, String hp, String email, int id, AppDatabase database);
        void deleteData(DataLamaran dataLamaran, AppDatabase database);
    }
}
