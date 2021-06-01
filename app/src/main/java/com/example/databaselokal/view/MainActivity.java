package com.example.databaselokal.view;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databaselokal.R;
import com.example.databaselokal.entitas.AppDatabase;
import com.example.databaselokal.entitas.DataLamaran;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContact.view{
    private AppDatabase appDatabase;
    private MainPresenter mainPresenter;
    private MainAdapter mainAdapter;

    private Button btnSubmit;
    private RecyclerView recyclerView;
    private EditText etNama, etLahir, etAgama, etHp, etEmail;

    private int id = 0;
    boolean edit = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
        etNama = findViewById(R.id.et_nama);
        etLahir = findViewById(R.id.et_lahir);
        etAgama = findViewById(R.id.et_agama);
        etHp = findViewById(R.id.et_hp);
        etEmail = findViewById(R.id.et_email);
        recyclerView = findViewById(R.id.rc_main);

        appDatabase = AppDatabase.inidb(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mainPresenter = new MainPresenter(this);
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void successAdd() {
        Toast.makeText(this, "Berhasil Menambahkan Data", Toast.LENGTH_LONG).show();
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void successDelete() {
        Toast.makeText(this, "Berhasil Menghapus Data", Toast.LENGTH_LONG).show();
        mainPresenter.readData(appDatabase);
    }

    @Override
    public void resetForm() {
        etNama.setText("");
        etLahir.setText("");
        etAgama.setText("");
        etHp.setText("");
        etEmail.setText("");
        btnSubmit.setText("Submit");
    }

    @Override
    public void getData(List<DataLamaran> list) {
        mainAdapter = new MainAdapter(this,list, this);
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void editData(DataLamaran item) {
        etNama.setText(item.getNama());
        etLahir.setText(item.getLahir());
        etAgama.setText(item.getAgama());
        etHp.setText(item.getHp());
        etEmail.setText(item.getEmail());
        id = item.getId();
        edit = true;
        btnSubmit.setText("Edit Data");
    }

    @Override
    public void deleteData(DataLamaran item) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        }else{
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Menghapus Data")
                .setMessage("Apakah Anda Yakin Ingin Menghapus Data Ini?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetForm();
                        mainPresenter.deleteData(item,appDatabase);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_dialer)
                .show();
    }

    @Override
    public void onClick(View view) {
        if (view==btnSubmit){
            if(etNama.getText().toString().equals("")||etLahir.getText().toString().equals("")||etAgama.getText().toString().equals("")||etHp.getText().toString().equals("")||etEmail.getText().toString().equals("")){
                Toast.makeText(this, "Harap Isi Semua Data!", Toast.LENGTH_SHORT).show();
            }else{
                if(!edit){
                    mainPresenter.insertData(etNama.getText().toString(),etLahir.getText().toString(),etAgama.getText().toString(),etHp.getText().toString(),etEmail.getText().toString(),appDatabase);
                }else{
                    mainPresenter.editData(etNama.getText().toString(),etLahir.getText().toString(),etAgama.getText().toString(),etHp.getText().toString(),etEmail.getText().toString(),id,appDatabase);
                    edit = false;
                }
                resetForm();
            }
        }
    }
}
