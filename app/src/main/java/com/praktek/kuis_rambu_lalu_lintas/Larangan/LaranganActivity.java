package com.praktek.kuis_rambu_lalu_lintas.Larangan;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class LaranganActivity extends RecyclerView.Adapter<LaranganActivity.ViewHolder> {

    Context ctx;
    String[] judulLarangan;
    String[] ketLarangan;
    int[] img;
    MediaPlayer mp;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView judul,ket;
        ImageView gambar;
        ImageButton btn_larangan;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.judul_larangan);
            ket = itemView.findViewById(R.id.ket_larangan);
            gambar = itemView.findViewById(R.id.img_larangan);
            btn_larangan = itemView.findViewById(R.id.btn_larangan);

        }
    }

    public LaranganActivity(Context ctx,String[]judulLarangan,String[]ketLarangan,int[]img){
        this.ctx = ctx;
        this.judulLarangan = judulLarangan;
        this.ketLarangan = ketLarangan;
        this.img = img;
    }

    @NonNull
    @Override
    public LaranganActivity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater ifalarangan = LayoutInflater.from(ctx);
        View v =ifalarangan.inflate(R.layout.larangan_activity,parent,false);
        ViewHolder vhlarangan = new ViewHolder(v);

        return vhlarangan;
    }

    @Override
    public void onBindViewHolder(@NonNull LaranganActivity.ViewHolder holder, int position) {

        holder.judul.setText(judulLarangan[position]);
        holder.ket.setText(ketLarangan[position]);
        holder.gambar.setImageResource(img[position]);

        mp = MediaPlayer.create(ctx,R.raw.button_musik);

        holder.btn_larangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intenlarangan = new Intent(ctx, Detail_Larangan.class);

                intenlarangan.putExtra("detailjudullarangan",judulLarangan[position]);
                intenlarangan.putExtra("detaildeskripsilarangan",ketLarangan[position]);
                intenlarangan.putExtra("detailgambarlarangan",img[position]);

                ctx.startActivity(intenlarangan);
                mp.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return judulLarangan.length;
    }
}

