package com.example.notesapp.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.Notes;
import com.example.notesapp.R;

import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesViewHolder> {
    Context context;
    List<Notes>list;

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class NotesViewHolder extends RecyclerView.ViewHolder {
    CardView notes_container;
    TextView tv_date,tv_notes,tv_title;
    ImageView imageView_pin;

    public NotesViewHolder(@NonNull View itemView){
        super(itemView);
        notes_container = itemView.findViewById(R.id.notes_container);
        tv_date = itemView.findViewById(R.id.tv_date);
        tv_notes = itemView.findViewById(R.id.tv_notes);
        tv_title = itemView.findViewById(R.id.tv_title);
        imageView_pin = itemView.findViewById(R.id.imageView_pin);



    }
}
