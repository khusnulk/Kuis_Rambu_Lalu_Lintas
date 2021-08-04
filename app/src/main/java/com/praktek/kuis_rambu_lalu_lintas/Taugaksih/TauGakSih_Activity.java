package com.praktek.kuis_rambu_lalu_lintas.Taugaksih;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class TauGakSih_Activity extends RecyclerView.Adapter<TauGakSih_Activity.ViewHolder> {

    Context ctxTauGakSih;
    String[] judultaugaksih;
    String[] kettaugaksih;
    int[] picture;

    public TauGakSih_Activity(Context ctxTauGakSih ,String[]judultaugaksih,String[]kettaugaksih,int[]picture){

        this.ctxTauGakSih = ctxTauGakSih;
        this.judultaugaksih = judultaugaksih;
        this.kettaugaksih = kettaugaksih;
        this.picture = picture;
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder{

        TextView tittle,ket;
        ImageView foto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tittle = itemView.findViewById(R.id.tv_judultaugaksih);
            ket = itemView.findViewById(R.id.tv_deskripsitaugaksih);
            foto = itemView.findViewById(R.id.img_taugaksih);

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
    public void onBindViewHolder(@NonNull TauGakSih_Activity.ViewHolder holder, int position) {

        holder.tittle.setText(judultaugaksih[position]);
        holder.ket.setText(kettaugaksih[position]);
        holder.foto.setImageResource(picture[position]);

    }

    @Override
    public int getItemCount() {
        return judultaugaksih.length;
    }
}
