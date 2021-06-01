package com.example.databaselokal.entitas;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lamaran_db")
public class DataLamaran {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
        private int id;
    @ColumnInfo(name = "nama")
        private String nama;
    @ColumnInfo(name = "lahir")
        private String lahir;
    @ColumnInfo(name = "agama")
        private String agama;
    @ColumnInfo(name = "hp")
        private String hp;
    @ColumnInfo(name = "email")
        private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
