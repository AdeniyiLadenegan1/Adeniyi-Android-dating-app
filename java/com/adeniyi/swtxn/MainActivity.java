package com.adeniyi.swtxn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    ImageView luv1, luv2;

    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text1 = findViewById(R.id.swit1);
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.oneanim);
        text1.startAnimation(anim1);

        text2 = findViewById(R.id.swit2);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.oneanim);
        text2.startAnimation(anim2);

        luv1 = findViewById(R.id.coup1);
        Animation anim3 = AnimationUtils.loadAnimation(this, R.anim.oneanim);
        luv1.startAnimation(anim3);

        luv2 = findViewById(R.id.coup2);
        Animation anim4 = AnimationUtils.loadAnimation(this, R.anim.oneanim);
        luv2.startAnimation(anim4);

        Intent intentRedirect = new Intent(this, welcome.class);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(intentRedirect);
                finish();
            }
        }, 6000);
    }
}
