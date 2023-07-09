package com.example.matchimagegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class WinPage extends AppCompatActivity {
    Button btnplayagain, btnexit;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_page);
        btnplayagain = (Button) findViewById(R.id.btnplayagain);
        btnexit = (Button) findViewById(R.id.btnexit);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
        btnplayagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fourth = new Intent(WinPage.this, MainGame.class);
                startActivity(fourth);
            }
        });
    }
}