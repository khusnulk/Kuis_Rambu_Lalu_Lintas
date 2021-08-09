package com.praktek.kuis_rambu_lalu_lintas.Peringatan;

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

public class PeringatanActivity extends RecyclerView.Adapter<PeringatanActivity.ViewHolder> {

    Context ctxPeringatan;
    String[] judulperingatan;
    String[] ketperingatan;
    int[] foto;
    int[] suaraperingatan;

    boolean on =true;
    MediaPlayer mp,player;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView judul,ket;
        ImageView images;
        ImageButton btnperingatan;
        ImageView playerperingatan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            judul = itemView.findViewById(R.id.judul_peringatan);
            ket = itemView.findViewById(R.id.ket_peringatan);
            images = itemView.findViewById(R.id.img_peringatan);
            btnperingatan = itemView.findViewById(R.id.btn_peringatan);
            playerperingatan = itemView.findViewById(R.id.tv_suaraperingatan);
        }
    }

    public PeringatanActivity(Context ctxPeringatan, String[]judulperingatan, String[]ketperingatan, int[]foto,int[]suaraperingatan){

        this.ctxPeringatan = ctxPeringatan;
        this.judulperingatan = judulperingatan;
        this.ketperingatan = ketperingatan;
        this.foto = foto;
        this.suaraperingatan = suaraperingatan;
    }



    @NonNull
    @Override
    public PeringatanActivity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflaterperingatan = LayoutInflater.from(ctxPeringatan);
        View vperingatan = inflaterperingatan.inflate(R.layout.peringatan_activity,parent,false);
        ViewHolder vholderperingatan = new ViewHolder(vperingatan);

        return vholderperingatan;
    }

    @Override
    public void onBindViewHolder(@NonNull PeringatanActivity.ViewHolder holder, int position) {

        holder.judul.setText(judulperingatan[position]);
        holder.ket.setText(ketperingatan[position]);
        holder.images.setImageResource(foto[position]);
        holder.playerperingatan.setBackgroundResource(suaraperingatan[position]);

        //        playstop= MediaPlayer.create(ctxpetunjuk,suara[position]);

        mp = MediaPlayer.create(ctxPeringatan,R.raw.button_musik);

        holder.btnperingatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intenperingatan = new Intent(ctxPeringatan,Detail_Peringatan.class);

                intenperingatan.putExtra("detailjudulperingatan",judulperingatan[position]);
                intenperingatan.putExtra("detaildeskripsiperingatan",ketperingatan[position]);
                intenperingatan.putExtra("detailgambarperingatan",foto[position]);
                intenperingatan.putExtra("suaradetailperingatan",suaraperingatan[position]);
                ctxPeringatan.startActivity(intenperingatan);
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
        return judulperingatan.length;
    }


}
