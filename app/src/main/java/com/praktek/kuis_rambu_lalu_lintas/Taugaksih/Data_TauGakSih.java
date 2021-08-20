package com.praktek.kuis_rambu_lalu_lintas.Taugaksih;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Data_TauGakSih extends AppCompatActivity {

    ImageButton btn_tau;
    MediaPlayer mp;

    RecyclerView rv;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager lm;

    String[] judul = {"Kuning","Putih","Biru","Hijau","Coklat","Jingga"};

    String[] deskripsi = {"Warna dasar kuning dipakai pada rambu-rambu peringatan kemungkinan adanya bahaya atau tempat berbahaya di depan agar pengemudi berhati-hati.Misalnya ada pekerjaan jalan, ada perlintasan sebidang kereta api, perlintasan kereta api tanpa pintu, lalu lintas pesawat terbang rendah, hembusan angin kencang, lalu lintas dua arah, dan yang lain.Penggunaan warna dasar kuning biasanya disertai garis tepi hitam, lambang warna hitam, dan huruf dan/atau angka juga hitam sehingga nampak kontras."
            ,"Warna dasar putih dipakai pada rambu-rambu larangan berjalan terus, rambu larangan masuk, rambu larangan parkir dan berhenti, rambu larangan pergerakan lalu lintas tertentu, rambu larangan membunyikan isyarat suara, dan rambu larangan dengan kata-kata.Penggunaan warna dasar putih bisa disertai warna garis tepi merah, warna lambang hitam, warna huruf dan/atau angka hitam, dan warna kata-kata merah."
            ,"Warna dasar biru menandakan perintah yang wajib dilakukan pengguna jalan. Misalnya perintah mengikuti petunjuk arah, perintah memilih salah satu arah yang ditunjuk, perintah batas minimum kecepatan, dan perintah menggunakan jalur khusus.Penggunaan warna dasar biru disertai warna garis tepi putih, warna lambang putih, warna huruf dan/atau angka putih, dan warna kata-kata juga putih."
            ,"Warna dasar hijau dipakai penunjuk jurusan/lokasi wilayah atau informasi lain kepada pengguna jalan. Letak rambu-rambu biasanya menjelang persimpangan, atau di jalur untuk mencapai jurusan yang dituju.Penggunaan warna dasar hijau disertai warna garis tepi putih, warna lambang putih, dan warna huruf dan/atau angka putih."
            ,"Warna dasar coklat dipakai untuk petunjuk jurusan khusus dan kawasan wisata. Penggunaannya disertai garis tepi putih, lambang putih, huruf dan/atau angka juga warna putih. Warna dasar coklat bisa juga disertai simbol atau lambang sesuai dengan kearifan lokal."
            ,"Warna dasar jingga dipakai pada rambu peringatan, rambu  larangan, rambu perintah, dan rambu petunjuk yang bersifat sementara. Karenanya rambu-rambu ini dibuat dalam bentuk kontruksi yang bisa dipindah-pindahkan dan dipasang untuk jangka waktu yang terbatas. Penggunaan warna dasar jingga disertai warna garis tepi hitam, warna lambang dan/atau tulisan hitam."};

    int[] gambar = {R.drawable.rambu_kuning,R.drawable.rambu_merah,R.drawable.rambu_biru
            ,R.drawable.rambu_hijau,R.drawable.rambu_coklat,R.drawable.rambu_jingga};

    int[] suara = {R.raw.taugaksihwarnakuning,R.raw.taugaksihwarnaputih,R.raw.taugaksihwarnabiru,R.raw.taugaksihwarnahijau
            ,R.raw.taugaksihwarnacoklat,R.raw.taugaksihwarnajingga};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__tau_gak_sih);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        btn_tau = (ImageButton) findViewById(R.id.panahkiridatataugaksih);
        mp = MediaPlayer.create(this,R.raw.button_musik);


        rv = findViewById(R.id.rv_taugaksih);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        Adapter = new TauGakSih_Activity(this,judul,deskripsi,gambar,suara);
        rv.setAdapter(Adapter);

    }

    public void btntaugaksih_kembali(View view) {

        Intent intentaugak = new Intent(Data_TauGakSih.this, Informasi_Activity.class);
        startActivity(intentaugak);
        mp.start();
    }

//    @Override
//    protected void onPause() {
//        super.onPause(); playerperingatan.release();
//    }

}