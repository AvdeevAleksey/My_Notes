package ru.avdeev.android.mynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesDataAdapter extends RecyclerView.Adapter<NotesDataAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<NoteData> notes;

    NotesDataAdapter(Context context, List<NoteData> notes) {
        this.notes = notes;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public NotesDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesDataAdapter.ViewHolder holder, int position) {
        NoteData note = notes.get(position);
        holder.titleView.setText(note.getTitle());
        holder.bodyView.setText(note.getBody());
        holder.deadLineView.setText(note.getDeadline());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView titleView, bodyView, deadLineView;
        ViewHolder(View view){
            super(view);
            titleView = (TextView) view.findViewById(R.id.title);
            bodyView = (TextView) view.findViewById(R.id.body);
            deadLineView = (TextView) view.findViewById(R.id.deadline);
        }
    }
}
