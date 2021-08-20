package com.praktek.kuis_rambu_lalu_lintas.bermain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.praktek.kuis_rambu_lalu_lintas.MainActivity;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Score_Salah_Actvity extends AppCompatActivity {


    MediaPlayer  suara_gagal ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score__salah__actvity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        suara_gagal = MediaPlayer.create(this,R.raw.suara_cobalagi);
        suara_gagal.start();
    }

    public void coba(View view) {

        Intent coba = new Intent(Score_Salah_Actvity.this,Level_1.class);
        startActivity(coba);
    }


    public void homesalah(View view) {
        Intent menu = new Intent(Score_Salah_Actvity.this, MainActivity.class);
        startActivity(menu);
    }
}