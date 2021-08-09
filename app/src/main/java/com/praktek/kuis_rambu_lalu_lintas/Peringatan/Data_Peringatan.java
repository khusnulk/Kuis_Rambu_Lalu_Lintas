package com.praktek.kuis_rambu_lalu_lintas.Peringatan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.praktek.kuis_rambu_lalu_lintas.Informasi_Activity;
import com.praktek.kuis_rambu_lalu_lintas.Larangan.LaranganActivity;
import com.praktek.kuis_rambu_lalu_lintas.Petunjuk.PetunjukData;
import com.praktek.kuis_rambu_lalu_lintas.R;

public class Data_Peringatan extends AppCompatActivity {


    MediaPlayer mp;
    ImageButton btnperingatan;

    RecyclerView rv;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager lm;

    String[] judul = {"Simpang Empat","Simpang 3 Sisi Kiri","Simpang 3 Sisi Kanan","Tikungan Ke Kiri","Tikungan Ke Kanan","Tikungan Ganda Kiri"
            ,"Tikungan Ganda Kanan","Tikungan Tajam Ke Kiri" ,"Tikungan Tajam Ke Kanan","Tikungan Memutar Ke Kiri","Tikungan Memutar Kanan"
            ,"Melintasi Bundaran","Jalur Dua Arah","Rambu Turunan Landai","Peringatan Turunan Curam","Permukaan Jalan Licin","Jalan Rawan Runtuh"
            ,"Area Pejalan Kaki","Penyebrangan Pejalan Kaki","Isyarat Lalu lintas"};

    String[] ket = {"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya di persimpangan empat jalan. Pemasangan rambu peringatan persimpangan prioritas menginformasikan bila suatu persimpangan arus di jalan utama bersimpangan dengan jalan kecil, maka kendaraan yang berada di jalan utama mendapat hak terlebih dahulu."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya di persimpangan prioritas tiga arah dengan satu arah dari sisi kiri. Pemasangan rambu ini menginformasikan bila suatu persimpangan arus di jalan utama bersimpangan dengan jalan kecil, maka kendaraan yang berada di jalan utama mendapat hak terlebih dahulu."
            ," berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya di persimpangan prioritas tiga arah dengan satu arah dari sisi kanan. Pemasangan rambu ini menginformasikan bila suatu persimpangan arus di jalan utama bersimpangan dengan jalan kecil, maka kendaraan yang berada di jalan utama mendapat hak terlebih dahulu."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi tikungan ke arah kiri."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi tikungan ke arah kanan."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi tikungan ganda dengan tikungan pertama ke kiri."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi tikungan ganda dengan tikungan pertama ke kanan."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi tikungan tajam ke arah kiri."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi tikungan tajam ke arah kanan."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi tikungan memutar ke arah kiri."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi tikungan memutar ke arah kanan."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi bundaran."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi jalur lalu lintas dua arah tanpa bangunan pemisah. Pemasangan rambu ini bermanfaat untuk meminimalisasi kecelakaan lalu lintas, seperti tabrakan dari arah berlawanan."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi turunan landai."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya saat melintasi turunan curam."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati saat berkendara di permukaan jalan yang licin."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati akan adanya potensi bahaya longsoran tanah atau batu yang berjatuhan ke jalan. Pemasangan rambu ini bermanfaat sebagai peringatan kondisi jalan yang berbahaya guna meminimalisasi terjadinya kecelakaan lalu lintas , risiko tertimbun longsor, atau terkena batu yang berjatuhan."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati saat melintasi jalur lalu lintas yang sering dilintasi pejalan kaki."
            ,"berfungsi untuk memperingatkan pengguna jalan agar berhati-hati saat melintasi jalur lalu lintas yang sering dilintasi pejalan kaki."
            ,"berfungsi untuk mengatur kendaraan demi ketertiban berlalu lintas. Alat pemberi isyarat terdiri dari tiga warna, yaitu merah (berhenti), kuning (waspada), dan hijau (jalan terus). Pemasangan rambu ini bermanfaat sebagai peringatan pengaturan persinyalan guna meminimalisasi angka kecelakaan lalu lintas yang dapat mengancam keselamatan jiwa pengguna jalan."};

    int[] gambar= {R.drawable.tambah,R.drawable.simpang3kiri,R.drawable.simpang3kanan,R.drawable.tikungankiri
            ,R.drawable.tikungankanan,R.drawable.gandatikungankiri,R.drawable.gandakanan
            ,R.drawable.tajamkiri,R.drawable.tajamkanan,R.drawable.memutarkiri,R.drawable.memutarkanan
            ,R.drawable.bundarankuning,R.drawable.duaarah,R.drawable.landai,R.drawable.curam
            ,R.drawable.jalanlicin,R.drawable.rawanruntuh,R.drawable.pejalankaki
            ,R.drawable.penyebrang,R.drawable.rambu};


    int[] suara = {R.raw.peringatansimpangempat_suara,R.raw.peringgatansimpang3sisikiri,R.raw.peringatansimpang3sisikanan_suara,R.raw.peringatantikungankekiri
            ,R.raw.tikungan_kekanan,R.raw.tikungan_ganda_kiri,R.raw.tikungan_ganda_kanan
            ,R.raw.tikungan_tajam_kiri,R.raw.tikungan_tajam_kanan,R.raw.tikungan_memutar_kiri,R.raw.tikungan_memutar_kanan
            ,R.raw.melintasi_bundaran,R.raw.jalur_dua_arah,R.raw.turunan_landai,R.raw.turunan_curam
            ,R.raw.jalan_licin,R.raw.rawan_runtuh,R.raw.area_pejalan_kaki,R.raw.penyebrangan_pejalan_kaki,R.raw.isyarat_lalu_intas};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__peringatan);

        btnperingatan = (ImageButton) findViewById(R.id.panahkiridataperingatan);
        mp = MediaPlayer.create(this,R.raw.button_musik);


        rv = findViewById(R.id.rv_peringatan);
        rv.setHasFixedSize(true);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        Adapter = new PeringatanActivity(this,judul,ket,gambar,suara);
        rv.setAdapter(Adapter);
    }

    public void btnperingatan_kembali(View view) {
        Intent intentpringatan =new Intent(Data_Peringatan.this, Informasi_Activity.class);
        startActivity(intentpringatan);
        mp.start();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Data_Peringatan.this.finish();
    }
}