package jeta.android.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView notesList = findViewById(R.id.notes_list);

        setTitle(R.string.notes);
        notesList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        notesList.setHasFixedSize(true);
        notesList.setAdapter(new NotesAdapter());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.action_add) {
            //open new intent
            Intent intent = new Intent(MainActivity.this, AddNewNoteActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
