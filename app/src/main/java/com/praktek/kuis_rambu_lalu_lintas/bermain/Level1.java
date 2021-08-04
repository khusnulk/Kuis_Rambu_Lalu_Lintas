package com.praktek.kuis_rambu_lalu_lintas.bermain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.praktek.kuis_rambu_lalu_lintas.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Level1 extends AppCompatActivity {

    ImageView gambar;
    TextView nilai,count_soal;
    Button btn1,btn2,btn3,btn4;
    MediaPlayer suara_button_pilihan , suara_button_benar , suara_button_salah;

//    memanggil adapter
   private AdapterLevel_1 Alevel1 = new AdapterLevel_1();



//   cek jawban benar atau salah
  private   String cek_answer;
//    hitung jumlah soal
   private int hitungsoal = 0;
//    hitung jumlah score
    private int Score = 0;
//    menampilkan nomor pertanyaan
   private int nomor_pertanyaan = 0;

private    Random acak = new Random();


 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        btn1 = findViewById(R.id.btn_levelA1);
        btn2 = findViewById(R.id.btn_levelB1);
        btn3 = findViewById(R.id.btn_levelC1);
        btn4 = findViewById(R.id.btn_levelD1);
        gambar = findViewById(R.id.image_level1);
        nilai =findViewById(R.id.skor);
        count_soal = findViewById(R.id.jumlahsoal);

        suara_button_pilihan = MediaPlayer.create(this,R.raw.button_musik);
        suara_button_benar = MediaPlayer.create(this,R.raw.soalbenar);
        suara_button_salah = MediaPlayer.create(this,R.raw.soalsalah);

        updatequestion();
        updateScore(Score);
        acaksoal(Alevel1.foto);
        acak_pilihan(Alevel1.pilihanJawaban);
    }


    private void acaksoal( int[] array) {

//        int[] array = Alevel1.foto;
        for (int i = array.length - 1; i > 0; i--) {
            int j = acak.nextInt(i + 1);

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;


            }

    }

    private  void acak_pilihan(String[][] pilih){

        for (int m = pilih.length - 1; m > 0; m--) {
            for (int m1 = pilih[m].length - 1; m1 > 0; m1--) {
                int o = acak.nextInt(m + 1);
                int p = acak.nextInt(m1 + 1);
                String[] tempu = pilih[m];
                pilih[m] = pilih[o];
                pilih[o] = tempu;
            }
        }
     }



    private void updatequestion() {


            if (nomor_pertanyaan < Alevel1.foto.length) {

                gambar.setBackgroundResource(Alevel1.getsatuimage(nomor_pertanyaan));

                btn1.setText(Alevel1.getpilihanganda(nomor_pertanyaan, 1));
                btn2.setText(Alevel1.getpilihanganda(nomor_pertanyaan, 2));
                btn3.setText(Alevel1.getpilihanganda(nomor_pertanyaan, 3));
                btn4.setText(Alevel1.getpilihanganda(nomor_pertanyaan, 4));

//
//                btn1.setText(Alevel1.getpilihanA(nomor_pertanyaan));
//                btn2.setText(Alevel1.getpilihanB(nomor_pertanyaan));
//                btn3.setText(Alevel1.getpilihanC(nomor_pertanyaan));
//                btn4.setText(Alevel1.getpilihanD(nomor_pertanyaan));

            cek_answer = Alevel1.getsatujawaban(nomor_pertanyaan);
                nomor_pertanyaan++;
            } else {
                Intent masuk = new Intent(Level1.this, Score_Activity.class);
                masuk.putExtra("Nilai Anda", Score);

                startActivity(masuk);
            }
        }


    private  void updateScore(int point){
        count_soal.setText(""+hitungsoal+"/"+Alevel1.foto.length);
        nilai.setText(""+Score);

    }

//    pada saat button pilihan jawaban di klik


    public void klik_button(View view) {


        Button selanjutnya = (Button) view;
        hitungsoal = hitungsoal + 1;



        if (selanjutnya.getText() == cek_answer)
        {

            Score = Score + 20;
            Toast.makeText(Level1.this, "Benar", Toast.LENGTH_SHORT).show();
            suara_button_pilihan.start();
            suara_button_benar.start();


        }else{
            Toast.makeText(Level1.this, "Salah", Toast.LENGTH_SHORT).show();
            suara_button_pilihan.start();
            suara_button_salah.start();

        }
        updatequestion();
        updateScore(Score);
        acaksoal(Alevel1.foto);
        acak_pilihan(Alevel1.pilihanJawaban);
    }
}

