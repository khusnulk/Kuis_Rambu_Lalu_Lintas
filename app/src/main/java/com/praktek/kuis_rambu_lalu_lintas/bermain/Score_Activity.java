package com.praktek.kuis_rambu_lalu_lintas.bermain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.MainActivity;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Score_Activity extends AppCompatActivity {

    TextView Skor_Tertinggi,Skor_kamu;
    Button coba_lagi,Home,menulevel;
    int default_score = 0,total;
    MediaPlayer suara_berhasil , suara_gagal;

    private Level1 ambiladapter = new Level1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        final MediaPlayer suara_button_score = MediaPlayer.create(this,R.raw.button_musik);
        Skor_Tertinggi = findViewById(R.id.skor_tertinggi);
        Skor_kamu = findViewById(R.id.tampil_Skor);
        coba_lagi = findViewById(R.id.cobalagi);
        Home = findViewById(R.id.utama);
        menulevel = findViewById(R.id.menulevel);

        Intent intent = getIntent();
// nama dari  "Nilai Anda" pada getinExtra dihalaman ini harus sama dengan yang ada di Activity Level1 bagian "PutExtra"
         total = intent.getIntExtra("Nilai Anda",0);
        Skor_kamu.setText("Score "+" : "+total);

// memunculkan background musik saat activity dibuka
        suara_berhasil = MediaPlayer.create(this,R.raw.suaraberhasil);
        suara_gagal = MediaPlayer.create(this,R.raw.suara_cobalagi);

        if (total > default_score){

        suara_berhasil.start();
        }else{
             suara_gagal.start();
        }

// shared preference untuk menampung skor tetinggi yang bersifat sementara
       SharedPreferences inisial = getPreferences(MODE_PRIVATE);
        int tertinggi = inisial.getInt("yang Tertinggi",0);


     if (tertinggi >= total) {

            Skor_Tertinggi.setText("Score Tertinggi "+ " : "+tertinggi);
        }else {
            Skor_Tertinggi.setText("Score "+" : "+total);

            SharedPreferences.Editor coba = inisial.edit();
            coba.putInt("yang Tertinggi",total);
//   menampilkan nilai
            coba.commit(); }



        coba_lagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent coba = new Intent(Score_Activity.this,Level1.class);
                startActivity(coba);
                suara_button_score.start();
                suara_berhasil.pause();
                suara_gagal.pause();
            }
        });

        menulevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent menu = new Intent(Score_Activity.this,Mulai_Bermain.class);
                menu.putExtra("Nilai Anda",total);
                startActivity(menu);

            suara_button_score.start();
                suara_berhasil.pause();
                suara_gagal.pause();
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Score_Activity.this,MainActivity.class);
                startActivity(home);

                suara_button_score.start();
                suara_berhasil.pause();
                suara_gagal.pause();
            }
        });

    }




}