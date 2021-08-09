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

import com.praktek.kuis_rambu_lalu_lintas.MainActivity;
import com.praktek.kuis_rambu_lalu_lintas.R;

import java.util.Arrays;
import java.util.Random;

public class Level_1 extends AppCompatActivity {

    ImageView gambar;
    TextView nilai,count_soal;
    Button btn1,btn2,btn3,btn4;
    MediaPlayer suara_button_pilihan , suara_button_benar , suara_button_salah;

    //    memanggil adapter
    private Adapter_Level_1 Alevel1 = new Adapter_Level_1();
    private Mulai_Bermain main = new Mulai_Bermain();

    //   cek jawban benar atau salah
    private   String cek_answer;
    //    hitung jumlah soal
    private int hitungsoal = 0;
    //    hitung jumlah score
    private int Score = 0;
    //    menampilkan nomor pertanyaan
    private int nomor_pertanyaan = 0;

    private Random acak = new Random();
    int[] sebelumAcak;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1);


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

        int newlength =Alevel1.foto.length;
        sebelumAcak = Arrays.copyOf(Alevel1.foto,newlength);
// mendapatkan indeks variabel sebelum acak

        acaksoal(Alevel1.foto);

        updatequestion();
        updateScore(Score);

    }

        private void acaksoal( int[] array) {

            for (int i = array.length - 1; i > 0; i--) {
                int j = acak.nextInt(i + 1);

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;


            }

        }

        private void acak_String( String[] array) {

            for (int i = array.length - 1; i > 0; i--) {
                int j = acak.nextInt(i + 1);

                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;


            }

        }


//        private  void acak_pilihan(String[][] pilih){
//
//            for (int m = pilih.length - 1; m > 0; m--) {
//                for (int m1 = pilih[m].length - 1; m1 > 0; m1--) {
//                    int o = acak.nextInt(m + 1);
//                    int p = acak.nextInt(m1 + 1);
//
//                    String tempu = pilih[m][m1];
//                    pilih[m][m1] = pilih[o][p];
//                    pilih[o][p] = tempu;
//
//
//                }
//            }
//        }



        private void updatequestion() {


            if (nomor_pertanyaan < Alevel1.foto.length) {

                int indeks= 0;
                for (int i=0; i<sebelumAcak.length; i++){
                    if(Alevel1.foto[nomor_pertanyaan] == sebelumAcak[i]){
                        indeks = i;
                        break;
                    }
                }

                gambar.setBackgroundResource(Alevel1.getsatuimage(nomor_pertanyaan));
                acak_String(Alevel1.getpilihan(indeks));

                btn1.setText(Alevel1.getpilihan(indeks)[0]);
                btn2.setText(Alevel1.getpilihan(indeks)[1]);
                btn3.setText(Alevel1.getpilihan(indeks)[2]);
                btn4.setText(Alevel1.getpilihan(indeks)[3]);

                cek_answer = Alevel1.getsatujawaban(indeks);
                nomor_pertanyaan++;

            }else if(Score == 0) {
                Intent masuk = new Intent(Level_1.this, Score_Salah_Actvity.class);
                startActivity(masuk);

            } else {
                 Intent masuk = new Intent(Level_1.this, Score_Activity.class);
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
            Toast.makeText(Level_1.this, "Benar", Toast.LENGTH_SHORT).show();
            suara_button_pilihan.start();
            suara_button_benar.start();


        }else{
            Toast.makeText(Level_1.this, "Salah", Toast.LENGTH_SHORT).show();
            suara_button_pilihan.start();
            suara_button_salah.start();

        }


        updatequestion();
        updateScore(Score);
    }


    public void home(View view) {
        Intent home = new Intent(Level_1.this, MainActivity.class);
        startActivity(home);
        suara_button_pilihan.start();

    }

    public void ulang(View view) {
        Intent ulang = new Intent(Level_1.this,Level_1.class);
        startActivity(ulang);
        suara_button_pilihan.start();
        Toast.makeText(Level_1.this, "soal telah diacak kembali", Toast.LENGTH_SHORT).show();
    }
}