package com.praktek.kuis_rambu_lalu_lintas.Petunjuk;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class DataPetunjuk extends RecyclerView.Adapter<DataPetunjuk.ViewHolder> {

    Context ctxpetunjuk;
    String[] judulpetunjuk;
    String[] ketpetunjuk;
    int[] img;
    MediaPlayer mp;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView judul,ket;
        ImageView gambar;
        ImageButton btn_lanjut;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.judul_petunjuk);
            ket = itemView.findViewById(R.id.ket_petunjuk);
            gambar = itemView.findViewById(R.id.img_petunjuk);
            btn_lanjut = itemView.findViewById(R.id.btn_petunjuk);

        }
    }

    public DataPetunjuk(Context ctxpetunjuk,String[]judulpetunjuk,String[]ketpetunjuk,int[]img){
        this.ctxpetunjuk = ctxpetunjuk;
        this.judulpetunjuk = judulpetunjuk;
        this.ketpetunjuk = ketpetunjuk;
        this.img = img;
    }

    @NonNull
    @Override
    public DataPetunjuk.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater infapetunjuk = LayoutInflater.from(ctxpetunjuk);
        View vpetunjuk = infapetunjuk.inflate(R.layout.data_petunjuk,parent,false);
        ViewHolder vh = new ViewHolder(vpetunjuk);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DataPetunjuk.ViewHolder holder, int position) {

        holder.judul.setText(judulpetunjuk[position]);
        holder.ket.setText(ketpetunjuk[position]);
        holder.gambar.setImageResource(img[position]);

        mp = MediaPlayer.create(ctxpetunjuk,R.raw.button_musik);

        holder.btn_lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ctxpetunjuk, judulpetunjuk[position], Toast.LENGTH_SHORT).show();

                Intent iten = new Intent(ctxpetunjuk,Detail_Rambu_Petunjuk.class);

              iten.putExtra("detailjudul",judulpetunjuk[position]);
              iten.putExtra("deskripsipetunjuk",ketpetunjuk[position]);
              iten.putExtra("gambardetail",img[position]);

              ctxpetunjuk.startActivity(iten);
              mp.start();
            }
        });

    }

    @Override
    public int getItemCount() {
        return judulpetunjuk.length;
    }
}
