package com.praktek.kuis_rambu_lalu_lintas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.praktek.kuis_rambu_lalu_lintas.bermain.Mulai_Bermain;
import com.praktek.kuis_rambu_lalu_lintas.bermain.Score_Activity;
import com.praktek.kuis_rambu_lalu_lintas.bermain.SkorTertinggi;
//
//import com.praktek.kuis_rambu_lalu_lintas.bermain.Level1;
//import com.praktek.kuis_rambu_lalu_lintas.bermain.Level_1;

public class MainActivity extends AppCompatActivity {

     MediaPlayer suara_button;
//     MediaPlayer bg_musik;
    TextView mulai,informasi,score,tentang,keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mulai = findViewById(R.id.btn_mulai);
        informasi = findViewById(R.id.btn_Informasi);
        score = findViewById(R.id.btn_Score);
        tentang = findViewById(R.id.btn_Tentang);
        keluar = findViewById(R.id.btn_Keluar);

        suara_button  = MediaPlayer.create(this,R.raw.button_musik);
//        bg_musik = MediaPlayer.create(this,R.raw.bg_musik);
//        bg_musik.start();
//        bg_musik.setLooping(true); //ini untuk melakukan perulangan lagu


      mulai.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent intentmulai = new Intent(MainActivity.this, Mulai_Bermain.class);
              startActivity(intentmulai);
              suara_button.start();
//              bg_musik.pause();
          }
      });

      informasi.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent informasiintent = new Intent(MainActivity.this,Informasi_Activity.class);
              startActivity(informasiintent);
              suara_button.start();
          }
      });

      score.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

//              Intent skorintent = new Intent(MainActivity.this,About_Activity.class);
//              startActivity(skorintent);
//              suara_button.start();
          }
      });

      tentang.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              suara_button.start();
              Intent movetoabout = new Intent(MainActivity.this,About_Activity.class);
              startActivity(movetoabout);
//
//              AlertDialog.Builder halamantentang = new AlertDialog.Builder(this)
//                .setMessage("R.drawable.restoran");


          }
      });

      keluar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              suara_button.start();
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

    //    method ini untuk menghentikan/stop musik saat keluar aplikasi
//    @Override
//    protected void onPause() {
//        super.onPause();
//        bg_musik.release();
//    }
}