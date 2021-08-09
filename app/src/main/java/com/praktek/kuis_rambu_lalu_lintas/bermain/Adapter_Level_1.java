package com.praktek.kuis_rambu_lalu_lintas.bermain;

import com.praktek.kuis_rambu_lalu_lintas.R;

public class Adapter_Level_1 {

        String[] jawaban ={
                "Tikungan Tajam Ke Kiri"
                ,"Mengikuti Arah Bundaran"
                ,"Rambu Batas Tonase"
                ,"Jarak Antar Kendaraan"
                ,"Motor Dilarang Masuk"};


        String[][] pilihanJawaban = {
                {"dilarang parkir","dilarang masuk","kecepetan 40 km saja","Tikungan Tajam Ke Kiri"}
                ,{"Simpang 3 Sisi Kanan","Dilarang Belok Kiri","Mengikuti Arah Bundaran","Petunjuk Keluar Tol"}
                ,{"Tikungan Tajam Ke Kiri","Sepeda Dilarang Masuk","Rambu Batas Tonase","Larangan Mobil dan Motor"}
                ,{"Jarak Antar Kendaraan","Batas Ketinggian Kendaraan","Sepeda Dilarang Masuk","Petunjuk Lokasi SPBU"}
                ,{"Larangan Mobil dan Motor","Motor Dilarang Masuk","Rambu Batas Tonase","Mobil Dilarang Masuk"}};


        int[] foto = {R.drawable.tajamkiri,R.drawable.rambubundaran
                ,R.drawable.beratmak,R.drawable.jarakkendaraan,R.drawable.motorlarang};



//    public String getpilihanganda(int index,int num){
//        String choice = pilihanJawaban[index][num-1];
//        return choice;
//    }

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

