package com.praktek.kuis_rambu_lalu_lintas.bermain;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class Adapter_Level_2 {

    String[] jawaban ={
            "Menghidupkan Isyarat Suara"
            ,"Permukaan Jalan Licin"
            ,"Rambu Halte Bus"
            ,"Petunjuk Keluar Tol"
            ,"Rambu Belok Ke Kiri"};


    String[][] pilihanJawaban = {
            {"Menggunakan Jalur Bus","Menghidupkan Isyarat Suara","Lokasi Bandar Udara","Simpang Empat"}
            ,{"Permukaan Jalan Licin","Batas Minimum Kecepatan","Petunjuk Lokasi SPBU","Dilarang Berhenti"}
            ,{"Penyebrangan Pejalan Kaki","Petunjuk Lokasi SPBU","Batas Ketinggian Kendaraan","Rambu Halte Bus"}
            ,{"Rambu Halte Bus","Jarak Antar Kendaraan","Petunjuk Keluar Tol","Simpang Empat"}
            ,{"Rambu Belok Ke Kiri","Mengikuti Arah Ke Kiri","Dilarang Belok Kiri","Dilarang Memutar Balik"}};


    int[] foto = {R.drawable.klakson,R.drawable.jalanlicin
            ,R.drawable.haltebus,R.drawable.keluartol,R.drawable.perintahbelokkiri};


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
