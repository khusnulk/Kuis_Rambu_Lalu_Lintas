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
import android.widget.ToggleButton;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class DataPetunjuk extends RecyclerView.Adapter<DataPetunjuk.ViewHolder> {

    Context ctxpetunjuk;
    String[] judulpetunjuk;
    String[] ketpetunjuk;
    int[] img;
    int[] suara;

//boolean on = true;
    MediaPlayer mp,playstop;


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView judul,ket;
        ImageView gambar;
        ImageButton btn_lanjut;
        ImageView player;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.judul_petunjuk);
            ket = itemView.findViewById(R.id.ket_petunjuk);
            gambar = itemView.findViewById(R.id.img_petunjuk);
            btn_lanjut = itemView.findViewById(R.id.btn_petunjuk);
            player = itemView.findViewById(R.id.tv_suara);
        }
    }

//    buat constructor
    public DataPetunjuk(Context ctxpetunjuk,String[]judulpetunjuk,String[]ketpetunjuk,int[]img,int[]suara){
        this.ctxpetunjuk = ctxpetunjuk;
        this.judulpetunjuk = judulpetunjuk;
        this.ketpetunjuk = ketpetunjuk;
        this.img = img;
        this.suara = suara;
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
        holder.player.setBackgroundResource(suara[position]);

//      playstop= MediaPlayer.create(ctxpetunjuk,suara[position]);

        mp = MediaPlayer.create(ctxpetunjuk,R.raw.button_musik);

        holder.btn_lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(ctxpetunjuk, judulpetunjuk[position], Toast.LENGTH_SHORT).show();

                Intent iten = new Intent(ctxpetunjuk,Detail_Rambu_Petunjuk.class);

              iten.putExtra("detailjudul",judulpetunjuk[position]);
              iten.putExtra("deskripsipetunjuk",ketpetunjuk[position]);
              iten.putExtra("gambardetail",img[position]);
              iten.putExtra("suaradetail",suara[position]);
              ctxpetunjuk.startActivity(iten);
              mp.start();
            }
        });

//        holder.player.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (on){
//
//                    playstop = MediaPlayer.create(ctxpetunjuk,suara[position]);
//                    on = false;
//                }
//
//                if (playstop.isPlaying()){
//                    playstop.stop();
//                    playstop.release();
//                    on = true;
//
//                    holder.player.setImageResource(R.drawable.volumebuttonoff);
//                } else {
//                    playstop.start();
//                    holder.player.setImageResource(R.drawable.volumebuttonon);
//
//                }
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return judulpetunjuk.length;
    }
}
