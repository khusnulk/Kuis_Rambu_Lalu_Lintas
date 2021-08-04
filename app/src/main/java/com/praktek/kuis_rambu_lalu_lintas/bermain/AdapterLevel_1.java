package com.praktek.kuis_rambu_lalu_lintas.bermain;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class AdapterLevel_1{
//    String[] pertanyaan = {
//            "Apakah arti petunjuk dari Rambu lalu lintas ini"
//            ,"apa arti dari rambu ini ?? ?"
//            ,"Apa arti dari rambu diatas ?"
//            ,"hmm apa ya maksud dari rambu tersebut?"
//            ,"apa ini"
//            ,"wah ad mobil"
//            ,"rambu batas kendaraan"
//            ,"Ruang Lebar Kendaraan ??"
//            ,"Motor Dilarang Masuk ??"
//            ,"Sepeda Dilarang Masuk ??"
//            ,"Larangan Mobil dan Motor ??? "};

    String[] jawaban ={
            "Rambu Tempat Parkir"
            ,"Tikungan Tajam Ke Kiri"
            ,"Mengikuti Arah Bundaran"
            ,"Rambu Batas Tonase"
            ,"Jarak Antar Kendaraan"
            ,"Motor Dilarang Masuk"};


    String[][] pilihanJawaban = {
            {"Rambu Tempat Parkir","kecepetan 40 km saja","dilarang parkir","dilarang masuk"}
            ,{"dilarang parkir","dilarang masuk","kecepetan 40 km saja","Tikungan Tajam Ke Kiri"}
            ,{"Simpang 3 Sisi Kanan","Dilarang Belok Kiri","Mengikuti Arah Bundaran","Petunjuk Keluar Tol"}
            ,{"Tikungan Tajam Ke Kiri","Sepeda Dilarang Masuk","Rambu Batas Tonase","Larangan Mobil dan Motor"}
            ,{"Jarak Antar Kendaraan","Batas Ketinggian Kendaraan","Sepeda Dilarang Masuk","Petunjuk Lokasi SPBU"}
            ,{"Larangan Mobil dan Motor","Motor Dilarang Masuk","Rambu Batas Tonase","Mobil Dilarang Masuk"}};


    int[] foto = {R.drawable.tempatparkir,R.drawable.tajamkiri,R.drawable.rambubundaran
            ,R.drawable.beratmak,R.drawable.jarakkendaraan,R.drawable.motorlarang};



    public String getpilihanganda(int index,int num){
        String choice = pilihanJawaban[index][num-1];
        return choice;
    }

    public int getsatuimage(int index){

        return foto[index];
    }


//
//    public String getpilihanA(int a){
//        String choice = pilihanJawaban[a][0];
//        return choice;
//    }
//
//    public String getpilihanB(int a){
//        String choice = pilihanJawaban[a][1];
//        return choice;
//    }
//
//    public String getpilihanC(int a){
//        String choice = pilihanJawaban[a][2];
//        return choice;
//    }
//
//    public String getpilihanD(int a){
//        String choice = pilihanJawaban[a][3];
//        return choice;
//    }
    public String getsatujawaban(int a){
        String answer = jawaban[a];
        return answer;
    }



}