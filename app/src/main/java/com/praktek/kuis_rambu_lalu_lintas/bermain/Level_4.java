package com.praktek.kuis_rambu_lalu_lintas.bermain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.praktek.kuis_rambu_lalu_lintas.MainActivity;
import com.praktek.kuis_rambu_lalu_lintas.R;

import java.util.Arrays;
import java.util.Random;

public class Level_4 extends AppCompatActivity {

    ImageView gambar;
    TextView nilai,count_soal;
    Button btn1,btn2,btn3,btn4;
    MediaPlayer suara_button_pilihan , suara_button_benar , suara_button_salah;

    //    memanggil adapter
    private Adapter_Level_4 Alevel4 = new Adapter_Level_4();

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
        setContentView(R.layout.activity_level_4);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn1 = findViewById(R.id.btn_levelA4);
        btn2 = findViewById(R.id.btn_levelB4);
        btn3 = findViewById(R.id.btn_levelC4);
        btn4 = findViewById(R.id.btn_levelD4);
        gambar = findViewById(R.id.image_level4);
        nilai =findViewById(R.id.skor4);
        count_soal = findViewById(R.id.jumlahsoal4);

        suara_button_pilihan = MediaPlayer.create(this,R.raw.button_musik);
        suara_button_benar = MediaPlayer.create(this,R.raw.soalbenar);
        suara_button_salah = MediaPlayer.create(this,R.raw.soalsalah);

        int newlength =Alevel4.foto.length;
        sebelumAcak = Arrays.copyOf(Alevel4.foto,newlength);
// mendapatkan indeks variabel sebelum acak

        acaksoal(Alevel4.foto);

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



    private void updatequestion() {


        if (nomor_pertanyaan < Alevel4.foto.length) {

            int indeks= 0;
            for (int i=0; i<sebelumAcak.length; i++){
                if(Alevel4.foto[nomor_pertanyaan] == sebelumAcak[i]){
                    indeks = i;
                    break;
                }
            }

            gambar.setBackgroundResource(Alevel4.getsatuimage(nomor_pertanyaan));
            acak_String(Alevel4.getpilihan(indeks));

            btn1.setText(Alevel4.getpilihan(indeks)[0]);
            btn2.setText(Alevel4.getpilihan(indeks)[1]);
            btn3.setText(Alevel4.getpilihan(indeks)[2]);
            btn4.setText(Alevel4.getpilihan(indeks)[3]);

            cek_answer = Alevel4.getsatujawaban(indeks);
            nomor_pertanyaan++;

        }  else if (Score == 0){
            Intent masuk = new Intent(Level_4.this, Score_Salah_Actvity.class);
            startActivity(masuk);
        }else {
            Intent masuk = new Intent(Level_4.this, Score_Activity_4.class);
            masuk.putExtra("Nilai Anda4", Score);

            startActivity(masuk);
        }
    }


    private  void updateScore(int point){
        count_soal.setText(""+hitungsoal+"/"+Alevel4.foto.length);
        nilai.setText(""+Score);

    }

//    pada saat button pilihan jawaban di klik


    public void klik_button(View view) {

        Button selanjutnya = (Button) view;
        hitungsoal = hitungsoal + 1;

        if (selanjutnya.getText() == cek_answer)
        {

            Score = Score + 20;
            Toast.makeText(Level_4.this, "Benar", Toast.LENGTH_SHORT).show();
            suara_button_pilihan.start();
            suara_button_benar.start();


        }else{
            Toast.makeText(Level_4.this, "Salah", Toast.LENGTH_SHORT).show();
            suara_button_pilihan.start();
            suara_button_salah.start();

        }


        updatequestion();
        updateScore(Score);
    }


    public void home(View view) {
        Intent home = new Intent(Level_4.this, MainActivity.class);
        startActivity(home);
        suara_button_pilihan.start();

    }

    public void ulang(View view) {
        Intent ulang = new Intent(Level_4.this,Level_4.class);
        startActivity(ulang);
        suara_button_pilihan.start();
        Toast.makeText(Level_4.this, "soal telah diacak kembali", Toast.LENGTH_SHORT).show();
    }
}