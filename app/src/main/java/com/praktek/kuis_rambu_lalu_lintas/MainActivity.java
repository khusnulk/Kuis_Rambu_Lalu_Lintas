package com.praktek.kuis_rambu_lalu_lintas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.praktek.kuis_rambu_lalu_lintas.bermain.Mulai_Bermain;
import com.praktek.kuis_rambu_lalu_lintas.bermain.Score_Activity;

public class MainActivity extends AppCompatActivity {

    TextView mulai,informasi,pengaturan,tentang,keluar;

    MediaPlayer buttonmusikmain;
    MediaPlayer bgmusikmain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mulai = findViewById(R.id.btn_mulai);
        informasi = findViewById(R.id.btn_Informasi);
//        pengaturan = findViewById(R.id.btn_Score);
        tentang = findViewById(R.id.btn_Tentang);
        keluar = findViewById(R.id.btn_Keluar);


        buttonmusikmain = MediaPlayer.create(this,R.raw.button_musik);
        bgmusikmain= MediaPlayer.create(this,R.raw.bg_musik);
//
//        bgmusikmain.start();
//        bgmusikmain.setLooping(true);



      mulai.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent intentmulai = new Intent(MainActivity.this, Mulai_Bermain.class);
              startActivity(intentmulai);
             buttonmusikmain.start();
//             bgmusikmain.release();
          }
      });

      informasi.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent informasiintent = new Intent(MainActivity.this,Informasi_Activity.class);
              startActivity(informasiintent);
              buttonmusikmain.start();
          }
      });


      tentang.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent movetoabout = new Intent(MainActivity.this,About_Activity.class);
              startActivity(movetoabout);
              buttonmusikmain.start();

          }
      });

      keluar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

             buttonmusikmain.start();
              keluar_aplikasi();
          }
      });



    }

    private void keluar_aplikasi() {
        AlertDialog.Builder keluar =  new AlertDialog.Builder(this)
                .setMessage("Anda Yakin Ingin Keluar ? ")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })

                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        moveTaskToBack(true);//membuat aplikasi keluar tanpa ada kembali kehalaman yang sudah dibuka sebelumnya
                        Toast.makeText(MainActivity.this, "Berhasil keluar dari aplikasi", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog kata = keluar.create();
        kata.show();
    }

//        method ini untuk menghentikan/stop musik saat keluar aplikasi
    @Override
    protected void onPause() {
        super.onPause();
       bgmusikmain.release();
    }
}