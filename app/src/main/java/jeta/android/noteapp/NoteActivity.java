package jeta.android.noteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class NoteActivity extends AppCompatActivity {


    int clickedItemPos;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        clickedItemPos = getIntent().getIntExtra(MainActivity.POSITON_EXTRA, 0);

        mButton = findViewById(R.id.button);
        mButton.setText("Note " + clickedItemPos);
    }


}
