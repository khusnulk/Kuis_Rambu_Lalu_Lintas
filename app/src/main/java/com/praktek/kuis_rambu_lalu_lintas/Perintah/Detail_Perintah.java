package com.praktek.kuis_rambu_lalu_lintas.Perintah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Detail_Perintah extends AppCompatActivity {

    TextView judul,ket;
    ImageView gambar;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__perintah);

        mp = MediaPlayer.create(this,R.raw.button_musik);

        judul = findViewById(R.id.detail_judulperintah);
        ket =findViewById(R.id.detail_deskripsiperintah);
        gambar = findViewById(R.id.detail_imgperintah);

        dapatkandata();
    }

    private void dapatkandata() {
        if (getIntent().hasExtra("detailperintahjudul") &&
                getIntent().hasExtra("detaildeskripsi") && getIntent().hasExtra("detailgambar")){

            String DetailJudul = getIntent().getStringExtra("detailperintahjudul");
            String DetailDeskripsi = getIntent().getStringExtra("detaildeskripsi");
            int DetailGambar = getIntent().getIntExtra("detailgambar",0);

            tampilkandata(DetailJudul,DetailDeskripsi,DetailGambar);

        }
    }

    private void tampilkandata(String detailJudul, String detailDeskripsi, int detailGambar) {

        judul.setText(detailJudul);
        ket.setText(detailDeskripsi);
        gambar.setImageResource(detailGambar);
    }

    public void panah_kiri(View view) {
        Intent intenkembali = new Intent(Detail_Perintah.this, Informasi_Activity.class);
        startActivity(intenkembali);
        mp.start();
    }
}