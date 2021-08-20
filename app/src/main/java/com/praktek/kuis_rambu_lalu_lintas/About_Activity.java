package com.praktek.kuis_rambu_lalu_lintas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class About_Activity extends AppCompatActivity {

//        ImageView halamanTentang;

        MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
       


//        halamanTentang = (ImageView) findViewById(R.id.img_about);
        mp = MediaPlayer.create(this,R.raw.button_musik);

    }


    public void btn_kembali(View view) {

        Intent intentpanahkiri = new Intent(About_Activity.this, MainActivity.class);
        startActivity(intentpanahkiri);
        mp.start();
    }
}