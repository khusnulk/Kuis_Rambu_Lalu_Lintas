package com.praktek.kuis_rambu_lalu_lintas.bermain;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.MainActivity;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Mulai_Bermain extends AppCompatActivity {

    MediaPlayer mp;
    TextView jmlskor, jmlskor2, jmlskor3, jmlskor4, jmlskor5;
    ImageButton level1, level2, level3, level4, level5;
    int k, k2, k3, k4, k5, a = 0;

    boolean click = true;
    private Adapter_Level_1 ambildata = new Adapter_Level_1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mulai__bermain);

        mp = MediaPlayer.create(this, R.raw.button_musik);
        jmlskor = (TextView) findViewById(R.id.tv_score);
        jmlskor2 = (TextView) findViewById(R.id.tv_score2);
        jmlskor3 = (TextView) findViewById(R.id.tv_score3);
        jmlskor4 = (TextView) findViewById(R.id.tv_score4);
        jmlskor5 = (TextView) findViewById(R.id.tv_score5);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);
        level5 = findViewById(R.id.level5);


        level1score();


        if (k != 0) {
            level2.setBackgroundResource(R.drawable.bg_level2);
            level1score2();
        } else if (k != k2) {
            level2.setClickable(true);
        }else{
            level2.setClickable(false);
        }


        if (k2 != 0) {
            level3.setBackgroundResource(R.drawable.bg_level3);
             level1score3();
        }else if(k2 != k3){
            level3.setClickable(true);
        }else{
            level3.setClickable(false);
        }

        if(k3 != 0) {
            level4.setBackgroundResource(R.drawable.bg_level4);
            level1score4();
        }else if(k3 != k4){
            level4.setClickable(true);
        }else{
            level4.setClickable(false);
        }


        if(k4 != 0){
          level5.setBackgroundResource(R.drawable.bg_level5);
           level1score5();
        }
        else if(k4 != k5) {
           level5.setClickable(true);
        }else{
            level5.setClickable(false);
        }


    }





    private void level1score5() {

        SharedPreferences init5  = getSharedPreferences("GETSKOr5",MODE_PRIVATE);
        int lv5 = init5.getInt("yang Tertinggi5",0);
         k5 = lv5 /20;
        jmlskor5.setText(""+k5+"/"+ambildata.foto.length);

    }

    private void level1score4() {

        SharedPreferences init4  = getSharedPreferences("GETSKOr4",MODE_PRIVATE);
        int lv4 = init4.getInt("yang Tertinggi4",0);
        k4 = lv4 /20;
        jmlskor4.setText(""+k4+"/"+ambildata.foto.length);

    }

    private void level1score3() {

        SharedPreferences init3  = getSharedPreferences("GETSKOR3",MODE_PRIVATE);
        int lv3 = init3.getInt("yang Tertinggi3",0);
        k3 = lv3 /20;
        jmlskor3.setText(""+k3+"/"+ambildata.foto.length);

    }

    private void level1score2() {

        SharedPreferences init2  = getSharedPreferences("NILAILAIn",MODE_PRIVATE);
        int lv2 = init2.getInt("tertinggi",0);
         k2 = lv2 /20;
        jmlskor2.setText(""+k2+"/"+ambildata.foto.length);

    }


    private void level1score(){
         SharedPreferences init  = getSharedPreferences("Ambilnumber1",MODE_PRIVATE);
         int lv1 = init.getInt("yang Tertinggi",0);
          k = lv1 /20;
         jmlskor.setText(""+k+"/"+ambildata.foto.length);

    }



    public void btnkembali(View view) {
        Intent intentback =new Intent(Mulai_Bermain.this, MainActivity.class);
        startActivity(intentback);
        mp.start();
    }

     public void mainlv1(View view) {

        Intent intentmainlv1 =new Intent(Mulai_Bermain.this,Level_1.class);
        startActivity(intentmainlv1);
        mp.start();
    }

    public void mainlv2(View view) {
        Intent intent =new Intent(Mulai_Bermain.this, Level_2.class);
        startActivity(intent);
        mp.start();
    }

    public void mainlv3(View view) {

        Intent intent =new Intent(Mulai_Bermain.this, Level_3.class);
        startActivity(intent);
        mp.start();
    }

    public void mainlv4(View view) {

        Intent intent =new Intent(Mulai_Bermain.this, Level_4.class);
        startActivity(intent);
        mp.start();
    }

    public void mainlv5(View view) {

        Intent intent =new Intent(Mulai_Bermain.this, Level_5.class);
        startActivity(intent);
        mp.start();
    }
}