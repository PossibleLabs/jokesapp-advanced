package com.example.tivesoft.jokes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by tivesoft on 9/12/15.
 */
public class JokesActivity extends Activity {

    private ImageButton btnChuckNorris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }

    public void nextJoke(View v) {
        Intent chuk= new Intent(JokesActivity.this, ChuckNorrisActivity.class);
        startActivity(chuk);
    }

}
