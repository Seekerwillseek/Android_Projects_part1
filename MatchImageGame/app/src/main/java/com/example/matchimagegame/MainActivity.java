package com.example.matchimagegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView1;
    Button btnplay1;
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);
        btnplay1 = (Button) findViewById(R.id.btnplay1);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        btnplay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent second = new Intent(MainActivity.this, MainGame.class);
                startActivity(second);
            }
        });
    }
}