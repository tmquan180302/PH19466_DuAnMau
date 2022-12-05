package com.example.ph19466_duanmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;



import java.util.Timer;
import java.util.TimerTask;

public class ManHinhChao extends AppCompatActivity {
    Timer timer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chao);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ManHinhChao.this,DangNhap.class);
                startActivity(intent);
                finish();
            }
        },3000);


    }
}