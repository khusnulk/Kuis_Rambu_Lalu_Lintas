package com.praktek.kuis_rambu_lalu_lintas.Peringatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Detail_Peringatan extends AppCompatActivity {

    TextView judul,ket;
    ImageView gambar;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__peringatan);

        mp = MediaPlayer.create(this,R.raw.button_musik);

        judul = findViewById(R.id.detail_judulperingatan);
        ket = findViewById(R.id.detail_deskripsiperingatan);
        gambar = findViewById(R.id.detail_imgperingatan);

        dapatkandataperingatan();

    }

    private void dapatkandataperingatan() {

        if (getIntent().hasExtra("detailjudulperingatan") &&
                getIntent().hasExtra("detaildeskripsiperingatan") && getIntent().hasExtra("detailgambarperingatan")){

            String DetailJudul = getIntent().getStringExtra("detailjudulperingatan");
            String DetailDeskripsi = getIntent().getStringExtra("detaildeskripsiperingatan");
            int DetailGambar = getIntent().getIntExtra("detailgambarperingatan",0);

            tampilkandata(DetailJudul,DetailDeskripsi,DetailGambar);

        }
    }

    private void tampilkandata(String detailJudul, String detailDeskripsi, int detailGambar) {

        judul.setText(detailJudul);
        ket.setText(detailDeskripsi);
        gambar.setImageResource(detailGambar);
    }

    public void panah_kiri(View view) {

        Intent intentkembali = new Intent(Detail_Peringatan.this, Informasi_Activity.class);
        startActivity(intentkembali);
        mp.start();
    }

}