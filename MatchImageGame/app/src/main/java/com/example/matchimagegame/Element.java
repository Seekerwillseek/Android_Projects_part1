package com.example.matchimagegame;
import android.graphics.drawable.Drawable;
import android.widget.ImageButton;
public class Element {
    public int hiddenImage;
    boolean state = false;
    boolean isMatched = false;
    ImageButton image;
    public void update() {
        if (state) {
            image.setImageResource(this.hiddenImage);
        } else {
            image.setImageResource(R.drawable.img_5);
        }
    }

}
