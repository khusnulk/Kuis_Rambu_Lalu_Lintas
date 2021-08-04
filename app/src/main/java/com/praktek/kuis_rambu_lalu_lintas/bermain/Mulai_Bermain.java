package com.praktek.kuis_rambu_lalu_lintas.bermain;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class Mulai_Bermain extends AppCompatActivity {

    MediaPlayer mp;
    TextView jmlskor;


    private AdapterLevel_1 ambildata = new AdapterLevel_1();
    private Score_Activity ambilscore = new Score_Activity();


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai__bermain);

        mp = MediaPlayer.create(this,R.raw.button_musik);
        jmlskor = (TextView) findViewById(R.id.tv_score);

          Intent initen = getIntent();
          int jmlh = initen.getIntExtra("Nilai Anda",0);

            SharedPreferences init = getPreferences(MODE_PRIVATE);
            int highscore = init.getInt("getdata",0);

            if (highscore >= jmlh ){
               int  k = highscore/20;
             jmlskor.setText(""+k+"/"+ambildata.foto.length);
            }else{
                int  m = jmlh/20;
                jmlskor.setText(""+m+"/"+ambildata.foto.length);
            }

            SharedPreferences.Editor get = init.edit();
            get.putInt("getdata",jmlh);
            get.commit();

//
//        SharedPreferences getdata = getSharedPreferences("Nilai Anda",MODE_PRIVATE);
//
//        if (getdata.contains("Nilai Anda")) {
//            jmlskor.setText(getdata.getInt("getdata", jmlh));
//
//        }else{
//            jmlskor.setText("nope");
//        }

    }



     public void mainlv1(View view) {

        Intent intentmainlv1 =new Intent(Mulai_Bermain.this, Level1.class);
        startActivity(intentmainlv1);
        mp.start();
    }
}