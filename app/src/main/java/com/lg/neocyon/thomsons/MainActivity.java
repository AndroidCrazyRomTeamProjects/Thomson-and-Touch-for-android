package com.lg.neocyon.thomsons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.media.AudioManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // full screan action
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void button(View view)
    {
        Intent intent = new Intent(MainActivity.this, ChefGame.class);
        startActivity(intent);
    }
}