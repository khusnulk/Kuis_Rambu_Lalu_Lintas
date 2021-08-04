package com.praktek.kuis_rambu_lalu_lintas.Larangan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Detail_Larangan extends AppCompatActivity {

    TextView judul,ket;
    ImageView gambar;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__larangan);

        mp = MediaPlayer.create(this,R.raw.button_musik);

        judul = findViewById(R.id.detail_judullarangan);
        ket =findViewById(R.id.detail_deskripsilarangan);
        gambar = findViewById(R.id.detail_imglarangan);

       dapatkandataLarangan();
    }

    private void dapatkandataLarangan() {

        if (getIntent().hasExtra("detailjudullarangan") && getIntent().hasExtra("detaildeskripsilarangan") &&
        getIntent().hasExtra("detailgambarlarangan")){

            String titlelarangan = getIntent().getStringExtra("detailjudullarangan");
            String ketlarangan = getIntent().getStringExtra("detaildeskripsilarangan");
            int gambarlarangan = getIntent().getIntExtra("detailgambarlarangan",0);

            tampilkandata(titlelarangan,ketlarangan,gambarlarangan);
        }
    }

    private void tampilkandata(String titlelarangan, String ketlarangan, int gambarlarangan) {

        judul.setText(titlelarangan);
        ket.setText(ketlarangan);
        gambar.setImageResource(gambarlarangan);
    }

    public void panah_kiri(View view) {

        Intent intentkembali = new Intent(Detail_Larangan.this, Informasi_Activity.class);
        startActivity(intentkembali);
        mp.start();
    }
}