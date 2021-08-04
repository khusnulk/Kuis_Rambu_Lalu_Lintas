package com.praktek.kuis_rambu_lalu_lintas.Perintah;

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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class PerintahActivity extends RecyclerView.Adapter<PerintahActivity.ViewHolder> {

    Context ctx;
    String[] judulperintah;
    String[] ketperintah;
    int[] img;
    MediaPlayer mp;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView title,ket;
        ImageView gambar;
        ImageButton btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.judul_perintah);
            ket = itemView.findViewById(R.id.ket_perintah);
            gambar = itemView.findViewById(R.id.img_perintah);
            btn = itemView.findViewById(R.id.btn_perintah);
        }
    }

    public PerintahActivity(Context ctx,String[] judulperintah,String[]ketperintah,int[] img){
        this.ctx = ctx;
        this.judulperintah = judulperintah;
        this.ketperintah = ketperintah;
        this.img = img;
    }

    @NonNull
    @Override
    public PerintahActivity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater infla = LayoutInflater.from(ctx);
        View vperintah = infla.inflate(R.layout.perintah_activity,parent,false);
        ViewHolder vhperintah = new ViewHolder(vperintah);

        return vhperintah;
    }

    @Override
    public void onBindViewHolder(@NonNull PerintahActivity.ViewHolder holder, int position) {

        holder.title.setText(judulperintah[position]);
        holder.ket.setText(ketperintah[position]);
        holder.gambar.setImageResource(img[position]);

        mp = MediaPlayer.create(ctx,R.raw.button_musik);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_perintah = new Intent(ctx,Detail_Perintah.class);

                intent_perintah.putExtra("detailperintahjudul",judulperintah[position]);
                intent_perintah.putExtra("detaildeskripsi",ketperintah[position]);
                intent_perintah.putExtra("detailgambar",img[position]);

                ctx.startActivity(intent_perintah);
                mp.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return judulperintah.length;
    }
}
