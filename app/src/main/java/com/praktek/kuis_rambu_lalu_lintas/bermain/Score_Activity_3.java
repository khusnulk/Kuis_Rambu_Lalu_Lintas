package com.praktek.kuis_rambu_lalu_lintas.bermain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class Score_Activity_3 extends AppCompatActivity {

    TextView Skor_Tertinggi,Skor_kamu;
    Button coba_lagi,menulevel,next3;
    int default_score = 0,total;
    MediaPlayer suara_berhasil , suara_gagal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score__3);

        final MediaPlayer suara_button_score = MediaPlayer.create(this,R.raw.button_musik);
        Skor_Tertinggi = findViewById(R.id.skor3);
        Skor_kamu = findViewById(R.id.tampil_Skor3);
        coba_lagi = findViewById(R.id.cobalagi3);
        menulevel = findViewById(R.id.menulevel3);
        next3 = findViewById(R.id.next3);

        Intent intent = getIntent();
// nama dari  "Nilai Anda" pada getinExtra dihalaman ini harus sama dengan yang ada di Activity Level1 bagian "PutExtra"
        total = intent.getIntExtra("Nilai Anda3",0);
        Skor_kamu.setText(""+total);

// memunculkan background musik saat activity dibuka
        suara_berhasil = MediaPlayer.create(this,R.raw.suaraberhasil);
        suara_gagal = MediaPlayer.create(this,R.raw.suara_cobalagi);

        if (total > default_score){

            suara_berhasil.start();
        }else{
            suara_gagal.start();
        }

// shared preference untuk menampung skor tetinggi yang bersifat sementara
        SharedPreferences inisial = getSharedPreferences("Getskor3",MODE_PRIVATE);
        int tertinggi = inisial.getInt("yang Tertinggi3",0);


        if (tertinggi >= total) {

            Skor_Tertinggi.setText(""+tertinggi);
        }else {
            Skor_Tertinggi.setText(""+total);

            SharedPreferences.Editor coba = inisial.edit();
            coba.putInt("yang Tertinggi3",total);
//   menampilkan nilai
            coba.commit(); }



        coba_lagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent coba = new Intent(Score_Activity_3.this,Level_3.class);
                startActivity(coba);
                suara_button_score.start();
                suara_berhasil.pause();
                suara_gagal.pause();
            }
        });

        menulevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Score_Activity_3.this,Mulai_Bermain.class);
                startActivity(menu);

                suara_button_score.start();
                suara_berhasil.pause();
                suara_gagal.pause();
            }
        });


        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Score_Activity_3.this,Level_4.class);
                startActivity(menu);

                suara_button_score.start();
                suara_berhasil.pause();
                suara_gagal.pause();
            }
        });
    }
}