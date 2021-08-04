package com.praktek.kuis_rambu_lalu_lintas.Petunjuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Detail_Rambu_Petunjuk extends AppCompatActivity {

    TextView juduldetail,deskripsidetail;
    ImageView foto;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__rambu__petunjuk);

        mp = MediaPlayer.create(this,R.raw.button_musik);

        juduldetail = findViewById(R.id.detail_textView);
        deskripsidetail =  findViewById(R.id.textViewdeskripsi);
        foto = findViewById(R.id.detail_img);

        getincomingExtra();
    }

    private void getincomingExtra() {

        if (getIntent().hasExtra("detailjudul") && getIntent().hasExtra("deskripsipetunjuk") && getIntent().hasExtra("gambardetail")){

            String judul = getIntent().getStringExtra("detailjudul");
            String deskripsi = getIntent().getStringExtra("deskripsipetunjuk");
            int picture = getIntent().getIntExtra("gambardetail",0);

            setDataActivity(judul,deskripsi,picture);

        }
    }

    private void setDataActivity(String judul,String deskripsi,int picture) {

        juduldetail.setText(judul);
        deskripsidetail.setText(deskripsi);
        foto.setImageResource(picture);
    }

    public void panah_kiri(View view) {

        Intent intentpanahkiri = new Intent(Detail_Rambu_Petunjuk.this, Informasi_Activity.class);
        startActivity(intentpanahkiri);
        mp.start();
    }
}