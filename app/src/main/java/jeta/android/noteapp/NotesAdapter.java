package jeta.android.noteapp;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {


    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_list, parent, false);

        return new NotesViewHolder(row);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final NotesViewHolder holder, int position) {

        holder.notesTitle.setText("Note " + position + " title");
        holder.notesDesc.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing");
        holder.notesDate.setText("15/02/03");

        shouldShowDots(holder);

    }

    //if notes content is longer than 9 rows, show three dots to tell that it continues
    private void shouldShowDots(final NotesViewHolder holder) {
        holder.notesDesc.post(new Runnable() {
            @Override
            public void run() {
                int lineCount = holder.notesDesc.getLineCount();
                // Use lineCount here
                if (lineCount > 9) {
                    holder.continuesDots.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        LinearLayout container;
        TextView notesTitle;
        TextView notesDesc;
        TextView notesDate;
        TextView continuesDots;

        NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            notesDate = itemView.findViewById(R.id.note_date);
            notesDesc = itemView.findViewById(R.id.note_desc);
            notesTitle = itemView.findViewById(R.id.note_title);
            container = itemView.findViewById(R.id.container);
            continuesDots = itemView.findViewById(R.id.continues);

        }


    }
}
