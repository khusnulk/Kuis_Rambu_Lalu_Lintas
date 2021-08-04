package com.praktek.kuis_rambu_lalu_lintas.bermain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.praktek.kuis_rambu_lalu_lintas.R;

import java.util.Calendar;

public class SkorTertinggi extends AppCompatActivity {
    TextView jmlsoal;
    int hari,bulan,tahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor_tertinggi);     Calendar kalender = Calendar.getInstance();
        hari = kalender.get(Calendar.DAY_OF_MONTH);
        bulan  = kalender.get(Calendar.MONTH);
        tahun = kalender.get(Calendar.YEAR);

        String gabungan = hari +"/"+bulan+"/"+tahun;






        Intent inte = getIntent();
        double skor=20;
        int total = inte.getIntExtra("hasil kamu" ,0);
        jmlsoal.setText(gabungan + total);
    }
}