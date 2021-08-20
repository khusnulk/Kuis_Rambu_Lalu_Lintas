package com.praktek.kuis_rambu_lalu_lintas.Larangan;

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
import com.praktek.kuis_rambu_lalu_lintas.Peringatan.Detail_Peringatan;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Detail_Larangan extends AppCompatActivity {

    TextView judul,ket;
    ImageView gambar;
    ImageButton suaralarangan;
    MediaPlayer mp,playerlarangan;
    boolean datalarangan = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__larangan);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mp = MediaPlayer.create(this,R.raw.button_musik);

        judul = findViewById(R.id.detail_judullarangan);
        ket =findViewById(R.id.detail_deskripsilarangan);
        gambar = findViewById(R.id.detail_imglarangan);
        suaralarangan = findViewById(R.id.suaralarangan1);


       dapatkandataLarangan();
    }

    private void dapatkandataLarangan() {

        if (getIntent().hasExtra("detailjudullarangan") && getIntent().hasExtra("detaildeskripsilarangan")
                && getIntent().hasExtra("detailgambarlarangan") && getIntent().hasExtra("suaradetaillarangan")){

            String titlelarangan = getIntent().getStringExtra("detailjudullarangan");
            String ketlarangan = getIntent().getStringExtra("detaildeskripsilarangan");
            int gambarlarangan = getIntent().getIntExtra("detailgambarlarangan",0);
            int music = getIntent().getIntExtra("suaradetaillarangan",0);


            tampilkandata(titlelarangan,ketlarangan,gambarlarangan,music);
        }
    }

    private void tampilkandata(String titlelarangan, String ketlarangan, int gambarlarangan,int music) {

        judul.setText(titlelarangan);
        ket.setText(ketlarangan);
        gambar.setImageResource(gambarlarangan);
        suaralarangan.setImageResource(music);


        suaralarangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (datalarangan){

                    playerlarangan = MediaPlayer.create(Detail_Larangan.this,music);
                    datalarangan = false;
                }

                if (playerlarangan.isPlaying()){

                    playerlarangan.pause();
                    suaralarangan.setImageResource(R.drawable.volumebuttonoff);
                } else {
                    playerlarangan.start();
                    suaralarangan.setImageResource(R.drawable.volumebuttonon);

                }
            }
        });
    }

    public void panah_kiri(View view) {

        Intent intentkembali = new Intent(Detail_Larangan.this, Data_Larangan.class);
        startActivity(intentkembali);
        mp.start();

        if(!datalarangan){
            playerlarangan.stop();
            playerlarangan.release();
            datalarangan = true;

        }
    }




}