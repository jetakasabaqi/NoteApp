package jeta.android.noteapp;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private RecyclerView notesList;
    private FloatingActionButton addButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesList = findViewById(R.id.notes_list);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open new intent

            }
        });

        notesList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        notesList.setHasFixedSize(true);
        notesList.setAdapter(new NotesAdapter());
    }

    private class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {


        @NonNull
        @Override
        public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_list, parent, false);

            return new NotesViewHolder(row);
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

//            if(position ==0){
//
//                holder.container.setBackgroundColor(getColor(R.color.greenCard));
//            } else {
//               if (position % 2 == 0) {
//                    holder.container.setBackgroundColor(getColor(R.color.greenCard));
//                } else {
//                    holder.container.setBackgroundColor(getColor(R.color.pinkCard));
//
//                }
//            }
            holder.notesTitle.setText("Titulli"+position);
            holder.notesDesc.setText("Deskripshen");
            holder.notesDate.setText("15/02/03");
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class NotesViewHolder extends RecyclerView.ViewHolder {

            LinearLayout container;
            TextView notesTitle;
            TextView notesDesc;
            TextView notesDate;

            public NotesViewHolder(@NonNull View itemView) {
                super(itemView);
                notesDate = itemView.findViewById(R.id.note_date);
                notesDesc = itemView.findViewById(R.id.note_desc);
                notesTitle = itemView.findViewById(R.id.note_title);
                container = itemView.findViewById(R.id.container);

            }
        }
    }


}
