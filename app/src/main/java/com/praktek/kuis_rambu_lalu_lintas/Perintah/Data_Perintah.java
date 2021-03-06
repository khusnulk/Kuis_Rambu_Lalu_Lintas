package com.praktek.kuis_rambu_lalu_lintas.Perintah;

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
import com.praktek.kuis_rambu_lalu_lintas.Petunjuk.PetunjukData;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Data_Perintah extends AppCompatActivity {

    MediaPlayer mp;
    ImageButton btn_kembali;

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutManager;

    String[] listdata = {"Mengikuti Arah Ke Kiri","Mengikuti Arah Ke Kanan","Memasuki Jalur Kiri","Memasuki Jalur Kanan"
            ,"Mengikuti Arah Bundaran","Rambu Belok Ke Kiri","Rambu Belok Ke Kanan","Batas Minimum Kecepatan"
            ,"Menggunakan Jalur Motor","Menggunakan Jalur Bus","Menggunakan Jalur Sepeda","Jalur Pejalan Kaki"
            ,"Rambu Jalur Penyebrangan","Rambu Halte Bus","Rambu Tempat Parkir","Tempat Parkir khusus"};

    String[] keterangan = {"menyatakan perintah kepada pengguna jalan untuk mengikuti jalan ke arah kiri"
            ,"menyatakan perintah kepada pengguna jalan untuk mengikuti jalan ke arah kanan."
            ,"menyatakan perintah kepada pengguna jalan untuk wajib memasuki jalur kiri saat berkendara"
            ,"menyatakan perintah kepada pengguna jalan untuk wajib memasuki jalur kanan saat berkendara."
            ,"menyatakan perintah kepada pengguna jalan untuk mengikuti arah yang ditunjukkan saat memasuki bundaran."
            ,"digunakan untuk menyatakan perintah kepada pengguna jalan untuk wajib belok kiri."
            ,"digunakan untuk menyatakan perintah kepada pengguna jalan untuk wajib belok kanan."
            ,"rambu ini menyatakan perintah kepada pengguna jalan untuk berkendara dengan kecepatan minimum"
            ,"digunakan untuk menyatakan perintah kepada pengendara motor untuk menggunakan jalur atau lajur lalu lintas khusus sepeda motor."
            ,"digunakan untuk menyatakan perintah kepada pengendara bus untuk menggunakan jalur atau lajur lalu lintas khusus bus."
            ,"digunakan untuk menyatakan perintah kepada pengendara sepeda untuk menggunakan jalur atau lajur lalu lintas khusus pengendara sepeda."
            ,"digunakan untuk menyatakan perintah kepada pejalan kaki untuk menggunakan jalur khusus pejalan kaki."
            ,"digunakan untuk menyatakan perintah kepada pejalan kaki untuk menggunakan jalur khusus untuk menyebrangi jalan."
            ,"digunakan untuk menyatakan perintah kepada bus untuk menggunakan jalur atau lajur lalu lintas khusus perhentian bus,agar bus tidak berhenti disembarangan tempat"
            ,"digunakan untuk menyatakan perintah kepada pengendara untuk menggunakan tempat khusus parkir kendaraan."
            ,"digunakan untuk menyatakan perintah untuk menggunakan tempat khusus parkir bagi orang yang berkebutuhan khusus.Misalnya seseorang yang menggunakan kursi roda."};

    int[] gambar = {R.drawable.rambubelokkiri, R.drawable.rambubelokanan, R.drawable.rambuserongjalurkiri,
            R.drawable.rambuserongjalurkanan,R.drawable.rambubundaran,R.drawable.perintahbelokkiri,R.drawable.perintahbelokkanan
            ,R.drawable.enampuluhkm,R.drawable.jalurmotor,R.drawable.jalurangkutanumum,R.drawable.jalursepeda
            ,R.drawable.perintahpejalankaki,R.drawable.penyebaranganjalan,R.drawable.haltebus,R.drawable.tempatparkir
            ,R.drawable.parkirkhusus};

    int[] suara = {R.raw.perintahmengikutiarahkekiri,R.raw.perintahmengikutiarahkekanan,R.raw.perintahmemasukijalurkiri
            ,R.raw.perintahmemasukijalurkanan,R.raw.mengikuti_arah_bundaran,R.raw.belok_kiri,R.raw.belok_kanan
            ,R.raw.minimum_kecepatan,R.raw.menggunakan_jalur_motor,R.raw.jalur_bus,R.raw.jalur_sepeda
            ,R.raw.pejalan_kaki,R.raw.jalur_penyeberangan,R.raw.rambu_halte_bus,R.raw.rambu_tempatparkir
            ,R.raw.parkir_khusus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__perintah);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mp = MediaPlayer.create(this,R.raw.button_musik);
        btn_kembali = (ImageButton) findViewById(R.id.panahkiridataperintah);

        recyclerView = findViewById(R.id.rv_perintah);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        programAdapter = new PerintahActivity(this,listdata,keterangan,gambar,suara);
        recyclerView.setAdapter(programAdapter);



    }

    public void btnperintah_kembali(View view) {

        Intent kembali = new Intent(Data_Perintah.this, Informasi_Activity.class);
        startActivity(kembali);
        mp.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Data_Perintah.this.finish();
    }
}