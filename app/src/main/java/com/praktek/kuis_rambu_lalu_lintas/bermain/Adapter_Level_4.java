package com.praktek.kuis_rambu_lalu_lintas.bermain;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class Adapter_Level_4 {

    String[] jawaban ={
            "Sepeda Dilarang Masuk"
            ,"Jalan Rawan Runtuh"
            ,"Tempat Parkir khusus"
            ,"Petunjuk Lokasi Mesjid"
            ,"Terminal Kendaraan Umum"};


    String[][] pilihanJawaban = {
            {"Sepeda Dilarang Masuk","Tikungan Ke Kiri","Petunjuk Lokasi Gereja","Jarak Antar Kendaraan"}
            ,{"Rambu Batas Tonase","Simpang 3 Sisi Kiri","Jalan Rawan Runtuh","Tikungan Tajam Ke Kanan"}
            ,{"Ruang Lebar Kendaraan","Tempat Parkir khusus","Jalur Dua Arah","Rambu Halte Bus"}
            ,{"Tikungan Memutar Ke Kiri","Tempat Parkir khusus","Petunjuk Lokasi Mesjid","Petunjuk Masuk Tol"}
            ,{"Dilarang Belok Kanan","Isyarat Lalu lintas","Menggunakan Jalur Motor","Terminal Kendaraan Umum"}};


    int[] foto = {R.drawable.sepeda,R.drawable.rawanruntuh,R.drawable.parkirkhusus,R.drawable.masjid,R.drawable.kendaraanumum};


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
