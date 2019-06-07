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
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        holder.notesTitle.setText("Titulli" + position);
        holder.notesDesc.setText("Deskripshen");
        holder.notesDate.setText("15/02/03");
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

        NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            notesDate = itemView.findViewById(R.id.note_date);
            notesDesc = itemView.findViewById(R.id.note_desc);
            notesTitle = itemView.findViewById(R.id.note_title);
            container = itemView.findViewById(R.id.container);

        }
    }
}
