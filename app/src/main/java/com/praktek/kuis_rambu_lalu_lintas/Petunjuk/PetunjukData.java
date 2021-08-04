package com.praktek.kuis_rambu_lalu_lintas.Petunjuk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class PetunjukData extends AppCompatActivity {

    MediaPlayer mp;
    ImageButton btnpetunjuk;


    RecyclerView rv;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager lm;

    String[] title = {"Petunjuk Lokasi SPBU","Petunjuk Lokasi Mesjid","Petunjuk Lokasi Gereja","Lokasi Tempat Makan","Lokasi Pelayanan Kesehatan",
            "Petunjuk Tempat Wisata","Rambu Petunjuk Rute","Petunjuk Lokasi Wihara","Petunjuk Lokasi Pura","Lokasi Telepon Umun","Lokasi Bandar Udara",
    "Lokasi Stasiun Kereta","Terminal Kendaraan Umum","Petunjuk Masuk To","Petunjuk Keluar Tol"};

    String[] deskripsi = {"Digunakan untuk memberikan informasi mengenai lokasi pengisian bahan bakar motor atau mobil."
            ,"digunakan untuk memberikan informasi mengenai salah satu lokasi fasilitas umum, yaitu masjid."
            ,"digunakan untuk memberikan informasi mengenai salah satu lokasi fasilitas umum, yaitu gereja."
            ,"Digunakan untuk memberikan informasi mengenai lokasi tempat makan, seperti restoran, foodcourt dan sebagainya."
            ,"memberikan informasi mengenai lokasi pelayanan umum berupa balai kesehatan, puskesmas, balai pertolongan pertama, dan sejenisnya. "
            ,"digunakan untuk memberikan informasi kepada pengguna jalan mengenai lokasi tempat wisata."
            ,"digunakan untuk memberikan informasi kepada pengguna jalan mengenai rute perjalanan"
            ,"digunakan untuk memberikan informasi mengenai salah satu lokasi fasilitas umum, yaitu wihara."
            ,"digunakan untuk memberikan informasi mengenai salah satu lokasi fasilitas umum, yaitu pura."
            ,"Digunakan untuk memberikan informasi mengenai lokasi telepon umum."
            ,"digunakan untuk memberikan informasi mengenai lokasi bandar udara di kota tertentu."
            ,"digunakan untuk memberikan informasi mengenai lokasi stasiun kereta api."
            ,"digunakan untuk memberikan informasi mengenai lokasi terminal kendaraan umum, seperti bus."
            ,"digunakan untuk memberikan informasi kepada pengguna jalan yang ingin memasuki jalan tol."
            ,"digunakan untuk memberikan informasi kepada pengguna jalan mengenai tempat keluar dari jalan tol."};

    int[] picture = {R.drawable.spbu,R.drawable.masjid,R.drawable.gereja,R.drawable.restoran,R.drawable.klinik,R.drawable.wisata,R.drawable.rute
            ,R.drawable.wihara,R.drawable.pura,R.drawable.telepon,R.drawable.bandara,R.drawable.kereta,R.drawable.kendaraanumum,R.drawable.masuktol,R.drawable.keluartol};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk_data);

        mp = MediaPlayer.create(this,R.raw.button_musik);
        btnpetunjuk = (ImageButton) findViewById(R.id.panahkiridatapetunjuk);


        rv = findViewById(R.id.rv_petunjuk);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        Adapter = new DataPetunjuk(this,title,deskripsi,picture);
        rv.setAdapter(Adapter);
    }

    public void btnpetunjuk_kembali(View view) {

        Intent intentpetunjuk = new Intent(PetunjukData.this, Informasi_Activity.class);
        startActivity(intentpetunjuk);
        mp.start();
    }
}