package com.praktek.kuis_rambu_lalu_lintas.Peringatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.Petunjuk.Detail_Rambu_Petunjuk;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Detail_Peringatan extends AppCompatActivity {

    TextView judul,ket;
    ImageView gambar;
    ImageButton suaraperingatan;
    MediaPlayer mp,playerperingatan;
    boolean dataperingatan =true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__peringatan);

        mp = MediaPlayer.create(this,R.raw.button_musik);

        judul = findViewById(R.id.detail_judulperingatan);
        ket = findViewById(R.id.detail_deskripsiperingatan);
        gambar = findViewById(R.id.detail_imgperingatan);
        suaraperingatan = findViewById(R.id.ceklagiperingatan);

        dapatkandataperingatan();

    }

    private void dapatkandataperingatan() {

        if (getIntent().hasExtra("detailjudulperingatan") && getIntent().hasExtra("detaildeskripsiperingatan")
                && getIntent().hasExtra("detailgambarperingatan") && getIntent().hasExtra("suaradetailperingatan")){

            String DetailJudul = getIntent().getStringExtra("detailjudulperingatan");
            String DetailDeskripsi = getIntent().getStringExtra("detaildeskripsiperingatan");
            int DetailGambar = getIntent().getIntExtra("detailgambarperingatan",0);
            int music = getIntent().getIntExtra("suaradetailperingatan",0);


            tampilkandata(DetailJudul,DetailDeskripsi,DetailGambar,music);

        }
    }

    private void tampilkandata(String detailJudul, String detailDeskripsi, int detailGambar,int music) {

        judul.setText(detailJudul);
        ket.setText(detailDeskripsi);
        gambar.setImageResource(detailGambar);
        suaraperingatan.setImageResource(music);




        suaraperingatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dataperingatan){

                    playerperingatan = MediaPlayer.create(Detail_Peringatan.this,music);
                    dataperingatan = false;
                }

                if (playerperingatan.isPlaying()){

                    playerperingatan.pause();
                    suaraperingatan.setImageResource(R.drawable.volumebuttonoff);
                } else {
                    playerperingatan.start();
                    suaraperingatan.setImageResource(R.drawable.volumebuttonon);

                }
            }
        });

    }

    public void panah_kiri(View view) {

        Intent intentkembali = new Intent(Detail_Peringatan.this,Data_Peringatan.class);
        startActivity(intentkembali);
        mp.start();

        if(!dataperingatan){
            playerperingatan.stop();
            playerperingatan.release();
            dataperingatan = true;

        }
    }


}