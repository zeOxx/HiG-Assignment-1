package com.themineralpatch.hig_assignment_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 2000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splashscreen);

        /* New handler that starts the main activity and stops
         * the splash after the given length			        */
        new Handler().postDelayed(new Runnable() {
            public void run() {
                /* Create an Intent that will start the main activity. */
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}