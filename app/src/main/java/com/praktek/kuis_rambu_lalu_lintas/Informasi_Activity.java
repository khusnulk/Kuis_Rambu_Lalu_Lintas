package com.praktek.kuis_rambu_lalu_lintas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.praktek.kuis_rambu_lalu_lintas.Larangan.Data_Larangan;
import com.praktek.kuis_rambu_lalu_lintas.Peringatan.Data_Peringatan;
import com.praktek.kuis_rambu_lalu_lintas.Perintah.Data_Perintah;
import com.praktek.kuis_rambu_lalu_lintas.Petunjuk.PetunjukData;
import com.praktek.kuis_rambu_lalu_lintas.Taugaksih.Data_TauGakSih;
import com.praktek.kuis_rambu_lalu_lintas.Taugaksih.TauGakSih_Activity;

public class Informasi_Activity extends AppCompatActivity {


    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        mp = MediaPlayer.create(this,R.raw.button_musik);


    }


    public void panah_kiri(View view) {

        Intent intentpanahkiri = new Intent(Informasi_Activity.this, MainActivity.class);
        startActivity(intentpanahkiri);
        mp.start();
    }



    public void pindah_perintah(View view) {

        Intent intentperintah = new Intent(Informasi_Activity.this, Data_Perintah.class);
        startActivity(intentperintah);
        mp.start();
    }

    public void pindah_larangan(View view) {

        Intent intentlarangan = new Intent(Informasi_Activity.this, Data_Larangan.class);
        startActivity(intentlarangan);
        mp.start();
    }

    public void pindah_peringatan(View view) {

        Intent intentperingatan = new Intent(Informasi_Activity.this, Data_Peringatan.class);
        startActivity(intentperingatan);
        mp.start();
    }

    public void pindah_fakta(View view) {

        Intent intenttaugaksih = new Intent(Informasi_Activity.this, Data_TauGakSih.class);
        startActivity(intenttaugaksih);
        mp.start();
    }


    public void pindahbtn_petunjuk(View view) {

        Intent intentpetunjuk = new Intent(Informasi_Activity.this,PetunjukData.class);
        startActivity(intentpetunjuk);
        mp.start();
    }
}