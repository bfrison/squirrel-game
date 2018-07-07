package com.frison.blaise.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToGame(View view) {
    Intent gameIntent = new Intent(MainActivity.this, Game.class);

        startActivity(gameIntent);
    }
}
