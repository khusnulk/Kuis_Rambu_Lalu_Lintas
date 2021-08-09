package com.praktek.kuis_rambu_lalu_lintas.bermain;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class Adapter_Level_3 {

    String[] jawaban ={
            "Dilarang Masuk"
            ,"Simpang 3 Sisi Kiri"
            ,"Mengikuti Arah Ke Kanan"
            ,"Rambu Petunjuk Rute"
            ,"Lokasi Tempat Makan"};


    String[][] pilihanJawaban = {
            {"Dilarang Masuk","Isyarat Lalu lintas","Mengikuti Arah Ke Kanan","Petunjuk Keluar Tol"}
            ,{"Larangan Mobil dan Motor","Simpang 3 Sisi Kiri","Rambu Halte Bus","Terminal Kendaraan Umum"}
            ,{"Dilarang Berhenti","Melintasi Bundaran","Mengikuti Arah Ke Kanan","Petunjuk Lokasi Wihara"}
            ,{"Mendahului Kendaraan Lain","Peringatan Turunan Curam","Tempat Parkir khusus","Rambu Petunjuk Rute"}
            ,{"Dilarang Belok Kiri","Lokasi Tempat Makan","Simpang Empat","Rambu Tempat Parkir"}};


    int[] foto = {R.drawable.dilarangmasuk,R.drawable.simpang3kiri
            , R.drawable.rambubelokanan,R.drawable.rute,R.drawable.restoran};


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
