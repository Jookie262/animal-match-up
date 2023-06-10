package com.example.animalmatchup.game;

import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class ScoreAnimation {
    AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f );
    AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f );

    public void animationScore(final TextView textView, String score) {
        textView.setText(score);
        Runnable endAction;
        final int slideDistance = textView.getHeight(); // Distance to slide up

        // Fade-in animation
        textView.animate()
                .alpha(1f)
                .setDuration(200)
                .setStartDelay(0)
                .withEndAction(endAction = new Runnable() {
                    public void run() {
                        // Slide-up animation
                        textView.animate()
                                .alpha(0f)
                                .translationYBy(-slideDistance)
                                .setDuration(200)
                                .setStartDelay(200)
                                .withEndAction(new Runnable() {
                                    public void run() {
                                        textView.setTranslationY(0); // Reset translation
                                    }
                                });
                    }
                });
    }

    public void delaySetText(TextView textView, String text){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setText(text);
            }
        }, 500); // Delay of 3000 milliseconds (3 seconds)
    }

}
