package com.praktek.kuis_rambu_lalu_lintas.Perintah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.Petunjuk.Detail_Rambu_Petunjuk;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Detail_Perintah extends AppCompatActivity {

    TextView judul,ket;
    ImageView gambar;
    ImageButton suaraperintah;
    MediaPlayer mp,playerperintah;
    boolean dataperintah = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__perintah);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mp = MediaPlayer.create(this,R.raw.button_musik);

        judul = findViewById(R.id.detail_judulperintah);
        ket =findViewById(R.id.detail_deskripsiperintah);
        gambar = findViewById(R.id.detail_imgperintah);
        suaraperintah = findViewById(R.id.ceklagiperintah);

        dapatkandata();
    }

    private void dapatkandata() {
        if (getIntent().hasExtra("detailperintahjudul") && getIntent().hasExtra("detaildeskripsi")
                && getIntent().hasExtra("detailgambar") && getIntent().hasExtra("suaradetailperintah")){

            String DetailJudul = getIntent().getStringExtra("detailperintahjudul");
            String DetailDeskripsi = getIntent().getStringExtra("detaildeskripsi");
            int DetailGambar = getIntent().getIntExtra("detailgambar",0);
            int music = getIntent().getIntExtra("suaradetailperintah",0);


            tampilkandata(DetailJudul,DetailDeskripsi,DetailGambar,music);

        }
    }

    private void tampilkandata(String detailJudul, String detailDeskripsi, int detailGambar,int music) {

        judul.setText(detailJudul);
        ket.setText(detailDeskripsi);
        gambar.setImageResource(detailGambar);
        suaraperintah.setImageResource(music);


        suaraperintah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataperintah){

                    playerperintah = MediaPlayer.create(Detail_Perintah.this,music);
                    dataperintah = false;
                }

                if (playerperintah.isPlaying()){
                    playerperintah.pause();
                    suaraperintah.setImageResource(R.drawable.volumebuttonoff);
                } else {
                    playerperintah.start();
                    suaraperintah.setImageResource(R.drawable.volumebuttonon);

                }
            }
        });
    }

    public void panah_kiri(View view) {
        Intent intenkembali = new Intent(Detail_Perintah.this, Data_Perintah.class);
        startActivity(intenkembali);
        mp.start();

        if(!dataperintah){
            playerperintah.stop();
            playerperintah.release();
            dataperintah = true;

        }
    }


}