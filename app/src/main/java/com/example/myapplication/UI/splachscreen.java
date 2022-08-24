package com.example.myapplication.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class splachscreen extends AppCompatActivity {
    Handler handler;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splachscreen);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                 intent=new Intent(splachscreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);



    }
}