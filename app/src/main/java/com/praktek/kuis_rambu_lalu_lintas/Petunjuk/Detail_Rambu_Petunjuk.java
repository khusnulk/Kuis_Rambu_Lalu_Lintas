package com.praktek.kuis_rambu_lalu_lintas.Petunjuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.R;

import java.io.IOException;

public class Detail_Rambu_Petunjuk extends AppCompatActivity {

    TextView juduldetail,deskripsidetail;
    ImageView foto;
    ImageButton mp3;
    MediaPlayer mp,mpsuara;

    boolean data = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__rambu__petunjuk);

        mp = MediaPlayer.create(this,R.raw.button_musik);

        juduldetail = findViewById(R.id.detail_textView);
        deskripsidetail =  findViewById(R.id.textViewdeskripsi);
        foto = findViewById(R.id.detail_img);
        mp3 = findViewById(R.id.ceklagipetunjuk);

        getincomingExtra();


    }

    private void getincomingExtra() {

        if (getIntent().hasExtra("detailjudul") && getIntent().hasExtra("deskripsipetunjuk")
                && getIntent().hasExtra("gambardetail") && getIntent().hasExtra("suaradetail")){

            String judul = getIntent().getStringExtra("detailjudul");
            String deskripsi = getIntent().getStringExtra("deskripsipetunjuk");
            int picture = getIntent().getIntExtra("gambardetail",0);
            int music = getIntent().getIntExtra("suaradetail",0);

            setDataActivity(judul,deskripsi,picture,music);

        }
    }

    private void setDataActivity(String judul, String deskripsi, int picture, int music) {

        juduldetail.setText(judul);
        deskripsidetail.setText(deskripsi);
        foto.setImageResource(picture);
        mp3.setImageResource(music);


        mp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (data){

                    mpsuara = MediaPlayer.create(Detail_Rambu_Petunjuk.this,music);
                    data = false;
                }

                if (mpsuara.isPlaying()){
                    mpsuara.pause();
                    mp3.setImageResource(R.drawable.volumebuttonoff);
                } else {
                    mpsuara.start();
                    mp3.setImageResource(R.drawable.volumebuttonon);

                }
            }
        });




    }

    public void panah_kiri(View view) {

        Intent intentpanahkiri = new Intent(Detail_Rambu_Petunjuk.this, PetunjukData.class);
        startActivity(intentpanahkiri);
        mp.start();


        if(!data){
            mpsuara.stop();
            mpsuara.release();
            data = true;

        }
    }




}