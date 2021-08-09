package com.praktek.kuis_rambu_lalu_lintas;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Pengaturan_Activity extends AppCompatActivity {

    MediaPlayer buttonmusik;
    MediaPlayer bgmusik;

    ToggleButton musik,button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan_);

        musik = findViewById(R.id.tooglemusik);
        button = findViewById(R.id.tooglebutton);



    }

    public void toggle(View view) {
        boolean on = ((ToggleButton)view).isChecked();

        if (on){
            bgmusik.setVolume(0,0);
            Toast.makeText(this, "musik telah di matikan", Toast.LENGTH_SHORT).show();
        }else{
            bgmusik.setVolume(1,1);
            Toast.makeText(this, "musik telah di aktifkan", Toast.LENGTH_SHORT).show();
        }

    }




    public void togglebutton(View view) {
         boolean on  = ((ToggleButton) view).isChecked();

         if (on) {
             buttonmusik.setVolume(0,0);
             Toast.makeText(this, "suara button telah di matikan", Toast.LENGTH_SHORT).show();
         }else{
             buttonmusik.setVolume(1,1);
             Toast.makeText(this, "suara button telah di aktifkan", Toast.LENGTH_SHORT).show();
         }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        bgmusik.stop();
        buttonmusik.stop();
        Pengaturan_Activity.this.finish();
    }
}
