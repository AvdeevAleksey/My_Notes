package ru.avdeev.android.mynotes;

import android.view.View;
import android.widget.AdapterView;

public interface ItemClickListener{
    void onItemClick(View view, int position);
    void onItemLongClick(View view, int position);
}
