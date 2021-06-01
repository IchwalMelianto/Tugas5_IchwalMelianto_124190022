package com.example.databaselokal.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databaselokal.R;
import com.example.databaselokal.entitas.DataLamaran;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {
    Context context;
    List<DataLamaran> list;
    MainContact.view aView;

    public MainAdapter(Context context, List<DataLamaran> list, MainContact.view aView) {
        this.context = context;
        this.list = list;
        this.aView = aView;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_lamaran,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.viewHolder holder, int position) {
        final DataLamaran item = list.get(position);
        holder.tvNama.setText(item.getNama());
        holder.tvLahir.setText(item.getLahir());
        holder.tvAgama.setText(item.getAgama());
        holder.tvHp.setText(item.getHp());
        holder.tvEmail.setText(item.getEmail());
        holder.id.setText(Integer.toString(item.getId()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aView.editData(item);
            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                aView.deleteData(item);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tvNama,tvLahir,tvAgama,tvHp,tvEmail,id;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama  =   itemView.findViewById(R.id.tv_item_nama);
            tvLahir  =   itemView.findViewById(R.id.tv_item_lahir);
            tvAgama  =   itemView.findViewById(R.id.tv_item_agama);
            tvHp  =   itemView.findViewById(R.id.tv_item_hp);
            tvEmail  =   itemView.findViewById(R.id.tv_item_email);
            id  =   itemView.findViewById(R.id.tv_item_id);
            cardView  =   itemView.findViewById(R.id.cv);
        }
    }
}
