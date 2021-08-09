package com.praktek.kuis_rambu_lalu_lintas.bermain;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class Adapter_Level_5 {

    String[] jawaban ={
            "Larangan Mobil dan Motor"
            ,"Simpang Empat"
            ,"Batas Minimum Kecepatan"
            ,"Petunjuk Tempat Wisata"
            ,"Memasuki Jalur Kiri"};


    String[][] pilihanJawaban = {
            {"Larangan Mobil dan Motor","Rambu Turunan Landai","Mengikuti Arah Bundaran","Larangan Berjalan Terus"}
            ,{"Jarak Antar Kendaraan","Simpang Empat","Lokasi Stasiun Kereta","Simpang 3 Sisi Kanan"}
            ,{"Dilarang Berhenti","Batas Minimum Kecepatan","Menggunakan Jalur Sepeda","Dilarang Belok Kiri"}
            ,{"Mendahului Kendaraan Lain","Tempat Parkir khusus","Petunjuk Tempat Wisata","Jalur Dua Arah"}
            ,{"Rambu Batas Tonase","Isyarat Lalu lintas","Memasuki Jalur Kiri","Petunjuk Keluar Tol"}};


    int[] foto = {R.drawable.motordanmobil,R.drawable.tambah,R.drawable.enampuluhkm,R.drawable.wisata,R.drawable.rambuserongjalurkiri};


    public String[] getpilihan(int index){
        String[] choice = pilihanJawaban[index];
        return choice;
    }

    public int getsatuimage(int index){

        return foto[index];
    }

    public String getsatujawaban(int a){
        String answer = jawaban[a];
        return answer;
    }
}
