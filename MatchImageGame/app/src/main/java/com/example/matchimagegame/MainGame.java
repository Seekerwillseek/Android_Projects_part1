
package com.example.matchimagegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.matchimagegame.Element;
public class MainGame extends AppCompatActivity {
    ImageButton imageButton, imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11;
    private Element lastopened = null;
    Button goback;

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        goback = (Button) findViewById(R.id.goback);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Element allElements[] = new Element[12];

        for (int i = 0; i < allElements.length; i++) {
            allElements[i] = new Element();
        }


        allElements[0].image = (ImageButton) findViewById(R.id.imageButton);
        allElements[1].image = (ImageButton) findViewById(R.id.imageButton1);
        allElements[2].image = (ImageButton) findViewById(R.id.imageButton2);
        allElements[3].image = (ImageButton) findViewById(R.id.imageButton3);
        allElements[4].image = (ImageButton) findViewById(R.id.imageButton4);
        allElements[5].image = (ImageButton) findViewById(R.id.imageButton5);
        allElements[6].image = (ImageButton) findViewById(R.id.imageButton6);
        allElements[7].image = (ImageButton) findViewById(R.id.imageButton7);
        allElements[8].image = (ImageButton) findViewById(R.id.imageButton8);
        allElements[9].image = (ImageButton) findViewById(R.id.imageButton9);
        allElements[10].image = (ImageButton) findViewById(R.id.imageButton10);
        allElements[11].image = (ImageButton) findViewById(R.id.imageButton11);

        allElements[0].hiddenImage = R.drawable.img_10;
        allElements[1].hiddenImage = R.drawable.img_4;
        allElements[2].hiddenImage = R.drawable.img_9;
        allElements[3].hiddenImage = R.drawable.img_2;
        allElements[4].hiddenImage = R.drawable.img_4;
        allElements[5].hiddenImage = R.drawable.img_3;
        allElements[6].hiddenImage = R.drawable.img_2;
        allElements[7].hiddenImage = R.drawable.img_10;
        allElements[8].hiddenImage = R.drawable.img_3;
        allElements[9].hiddenImage = R.drawable.img_9;
        allElements[10].hiddenImage = R.drawable.img_7;
        allElements[11].hiddenImage = R.drawable.img_7;


        for (int i = 0; i < allElements.length; ++i) {
            final int index = i; // declare final variable to hold i value
            allElements[i].image.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {

                    if (score != 50 ){
                        if (!allElements[index].isMatched) {
                            allElements[index].state = !allElements[index].state;
                            allElements[index].update();

                            if (allElements[index].state) {
                                if (lastopened == null) {
                                    lastopened = allElements[index];
                                    lastopened.update();
                                } else {
                                    if (lastopened.hiddenImage == allElements[index].hiddenImage) {
                                        score += 10;
                                        allElements[index].isMatched = true;
                                        lastopened.isMatched = true;
                                        lastopened = null;
                                        Toast.makeText(getApplicationContext(), "Score: " + score, Toast.LENGTH_SHORT).show();
                                    } else {
                                        lastopened.state = false;
                                        lastopened.update();
                                        allElements[index].state = false;
                                        allElements[index].update();
                                        lastopened = null;
                                    }
                                }

                            } else {
                                lastopened = null;
                            }
                        }
                    }
                else {
                        Intent third = new Intent(MainGame.this, WinPage.class);
                        startActivity(third);
                    }

                }


            });




        }
    }
}


