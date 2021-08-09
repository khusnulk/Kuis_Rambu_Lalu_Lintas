package com.praktek.kuis_rambu_lalu_lintas.Larangan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.Petunjuk.PetunjukData;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Data_Larangan extends AppCompatActivity {

    ImageButton btnlarangan;
     MediaPlayer mp;

    RecyclerView rv;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager lm;


    String[] nama = {"Dilarang Masuk","Dilarang Berhenti","Larangan Berjalan Terus","Dilarang Parkir","Dilarang Belok Kiri"
            ,"Dilarang Belok Kanan","Dilarang Memutar Balik","Mendahului Kendaraan Lain","Menghidupkan Isyarat Suara"
            ,"Batas Maksimal Kecepatan","Rambu Batas Tonase","Jarak Antar Kendaraan","Batas Ketinggian Kendaraan"
            ,"Ruang Lebar Kendaraan","Motor Dilarang Masuk","Mobil Dilarang Masuk","Sepeda Dilarang Masuk"
            ,"Larangan Mobil dan Motor"};


    String[] keterangan = {"larangan masuk bagi semua kendaraan bermotor maupun tidak bermotor. Seperti motor, mobil, atau sepeda."
            ,"digunakan untuk pengguna jalan bahwa di area tertentu mereka dilarang untuk menghentikan kendaraannya."
            ,"memberitahukan pengguna jalan bahwa di area tertentu mereka dilarang untuk berjalan terus karena wajib berhenti"
            ,"memberitahukan pengguna jalan bahwa di area tertentu mereka dilarang untuk memarkirkan kendaraannya"
            ,"memberitahukan pengguna jalan bahwa di area tertentu mereka dilarang untuk belok kiri."
            ,"memberitahukan pengguna jalan bahwa di area tertentu mereka dilarang untuk belok kanan."
            ,"memberitahukan pengguna jalan bahwa di area tertentu mereka dilarang untuk memutar balik kendaraannya."
            ,"memberitahukan pengguna jalan bahwa di area tertentu mereka dilarang untuk menyalip kendaraan lain."
            ,"dilarang untuk membunyikan isyarat suara.Seperti menghidupkan klakson."
            ,"dilarang menjalankan kendaraan dengan kecepatan lebih dari 80 km/jam."
            ,"kendaraan dilarang masuk dengan berat maksimal 8 ton"
            ,"jarak kendaraan kamu dengan kendaraan di depannya sejauh 25 m"
            ,"kendaraan dengan ketinggian lebih dari 4,2 m dilarang masuk."
            ,"kendaraan yang memiliki lebar lebih dari 2.9 m dilarang masuk"
            ,"memberitahukan pengguna jalan bahwa di area tertentu sepeda motor dilarang masuk."
            ,"memberitahukan pengguna jalan bahwa di area tertentu mobil dilarang masuk."
            ,"memberitahukan pengguna jalan bahwa di area tertentu sepeda dilarang masuk."
            ,"memberitahukan pengguna jalan bahwa di area tertentu sepeda motor dan mobil dilarang masuk."};


    int[] foto = {R.drawable.dilarangmasuk,R.drawable.dilarangberhenti,R.drawable.dilarangstop,R.drawable.dilarangparkir
            ,R.drawable.dilarangbelokiri,R.drawable.dilarangbelokkanan,R.drawable.dilarangputarbalik
            ,R.drawable.dilarangmenyalip,R.drawable.klakson,R.drawable.kecepatan,R.drawable.beratmak
            ,R.drawable.jarakkendaraan,R.drawable.tinggimak,R.drawable.bataslebar,R.drawable.motorlarang
            ,R.drawable.mobil,R.drawable.sepeda,R.drawable.motordanmobil};


    int[] suara = {R.raw.dilarangmasuk_suara,R.raw.dilarangberhenti_suara,R.raw.dilarangberjalanterus_suara,R.raw.dilarangparkir_suara
            ,R.raw.dilarangbelokkiri,R.raw.dilarangbelokkanan,R.raw.dilarangmemutarbalik
            ,R.raw.mendahuluikendaraan,R.raw.menghidupkanisyaratsuara,R.raw.btsmaksimalkecepatan,R.raw.rambubatastonase
            ,R.raw.jarakantarkendaraan,R.raw.batasketingggiankendaraan_suara,R.raw.ruanglebarkendaraan,R.raw.motordilarangsuara
            ,R.raw.mobildilarangsuara,R.raw.sepedadilarangmasuk,R.raw.laranganmotordanmobil};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__larangan);

        mp = MediaPlayer.create(this,R.raw.button_musik);
        btnlarangan = (ImageButton) findViewById(R.id.panahkiridatalarangan);


        rv = findViewById(R.id.rv_larangan);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        Adapter = new LaranganActivity(this,nama,keterangan,foto,suara);
        rv.setAdapter(Adapter);
    }


    public void btnlarangan_kembali(View view) {
        Intent larangankembali = new Intent(Data_Larangan.this,Informasi_Activity.class);
        startActivity(larangankembali);
        mp.start();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Data_Larangan.this.finish();
    }
}