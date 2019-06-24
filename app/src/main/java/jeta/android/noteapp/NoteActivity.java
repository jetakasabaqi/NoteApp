package jeta.android.noteapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class NoteActivity extends AppCompatActivity {


    int clickedItemPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        clickedItemPos = getIntent().getIntExtra(MainActivity.POSITON_EXTRA, 0);


    }


}
