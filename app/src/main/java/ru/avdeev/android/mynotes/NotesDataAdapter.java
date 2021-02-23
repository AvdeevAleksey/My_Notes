package ru.avdeev.android.mynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesDataAdapter extends RecyclerView.Adapter<NotesDataAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<NoteData> notes;
    private ItemClickListener noteClickListener;
    private OnItemLongClickListener noteLongClickListener;

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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, OnItemLongClickListener {
        final TextView titleView, bodyView, deadLineView;
        ViewHolder(View view){
            super(view);
            titleView = (TextView) view.findViewById(R.id.title);
            bodyView = (TextView) view.findViewById(R.id.body);
            deadLineView = (TextView) view.findViewById(R.id.deadline);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (noteClickListener != null) {
                noteClickListener.onItemClick(view, getAdapterPosition());
            }
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            if (noteLongClickListener != null) {
                return true;
            } else {
                noteLongClickListener.onItemLongClick(parent,view, getAdapterPosition(),getItemId());
                return false;
            }
        }
    }
    public NoteData getItem(int id) {
        return notes.get(id);
    }

    void setClickListener(ItemClickListener noteClickListener) {
        this.noteClickListener = noteClickListener;
    }

    boolean setOnItemLongClickListener(OnItemLongClickListener noteLongClickListener) {
        this.noteLongClickListener = noteLongClickListener;
        return true;
    }
}
