package com.blinkinganimation.max.blinkinganimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startAnimation;
    TextView Text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startAnimation = (Button) findViewById(R.id.button);
        Text = (TextView) findViewById(R.id.textView);

        startAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text.setVisibility(TextView.VISIBLE);
                final Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
                Text.startAnimation(fadeInAnimation);

                fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Text.setVisibility(TextView.VISIBLE);
                        Text.startAnimation(fadeInAnimation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }
}
