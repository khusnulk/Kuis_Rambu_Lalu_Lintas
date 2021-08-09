package com.praktek.kuis_rambu_lalu_lintas.Taugaksih;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.praktek.kuis_rambu_lalu_lintas.Perintah.Detail_Perintah;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class TauGakSih_Activity extends RecyclerView.Adapter<TauGakSih_Activity.ViewHolder> {

    Context ctxTauGakSih;
    String[] judultaugaksih;
    String[] kettaugaksih;
    int[] picture;
    int[] suara;

    MediaPlayer mptau,mplayertaugaksih;
    boolean on = true;



    public TauGakSih_Activity(Context ctxTauGakSih ,String[]judultaugaksih,String[]kettaugaksih,int[]picture,int[]suara){

        this.ctxTauGakSih = ctxTauGakSih;
        this.judultaugaksih = judultaugaksih;
        this.kettaugaksih = kettaugaksih;
        this.picture = picture;
        this.suara = suara;
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder{


        TextView title,ket;
        ImageView gambar;
        ImageButton btn;
        ImageView playertaugaksih;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.judul_taugaksih);
            ket = itemView.findViewById(R.id.ket_taugaksih);
            gambar = itemView.findViewById(R.id.img_taugaksih);
            btn = itemView.findViewById(R.id.btn_taugaksih);
            playertaugaksih = itemView.findViewById(R.id.tv_suarataugaskih);
        }
    }


    @NonNull
    @Override
    public TauGakSih_Activity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater ifataugaksih = LayoutInflater.from(ctxTauGakSih);
        View v = ifataugaksih.inflate(R.layout.cardview_taugaksih,parent,false);
        ViewHolder vholdertaugaksih = new ViewHolder(v);

        return vholdertaugaksih;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(judultaugaksih[position]);
        holder.ket.setText(kettaugaksih[position]);
        holder.gambar.setImageResource(picture[position]);
        holder.playertaugaksih.setBackgroundResource(suara[position]);

//        playstop= MediaPlayer.create(ctxpetunjuk,suara[position]);

        mptau = MediaPlayer.create(ctxTauGakSih,R.raw.button_musik);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_tau = new Intent(ctxTauGakSih, Detail_Taugaksih.class);

                intent_tau.putExtra("detailtaugaksih",judultaugaksih[position]);
                intent_tau.putExtra("detaildeskripsitaugaksih",kettaugaksih[position]);
                intent_tau.putExtra("detailgambartaugaksih",picture[position]);
                intent_tau.putExtra("suaradetailtaugaksih",suara[position]);
                ctxTauGakSih.startActivity(intent_tau);
                mptau.start();
            }
        });


//        holder.playertaugaksih.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//
//
//              if (on){
//
//                mptau = MediaPlayer.create(ctxTauGakSih,suara[position]);
//                on = false;
//              }
//
//              if (mptau.isPlaying()){
//                  mptau.stop();
//                  mptau.release();
//                  on = true;
//                  holder.playertaugaksih.setImageResource(R.drawable.volumebuttonoff);
//             } else {
//                  mptau.start();
//                  holder.playertaugaksih.setImageResource(R.drawable.volumebuttonon);
//              }
//           }
//       });



    }

    @Override
    public int getItemCount() {
        return judultaugaksih.length;
    }
}
