package com.example.android.notepad;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class NoteSearch extends Activity implements SearchView.OnQueryTextListener {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    private static final String[] PROJECTION = new String[]{
            NotePad.Notes._ID,
            NotePad.Notes.COLUMN_NAME_TITLE,
            NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE
    };

    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this, "you choose:" + query, Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_search);
        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        Intent intent = getIntent();
        if (intent.getData() == null) {
            intent.setData(NotePad.Notes.CONTENT_URI);
        }
        listView = (ListView) findViewById(R.id.list_view);
        sqLiteDatabase = new NotePadProvider.DatabaseHelper(this).getReadableDatabase();
        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("search");
        searchView.setOnQueryTextListener(this);
    }

    public boolean onQueryTextChange(String string) {
        String selection1 = NotePad.Notes.COLUMN_NAME_TITLE + " like ? or " + NotePad.Notes.COLUMN_NAME_NOTE + " like ?";
        String[] selection2 = {"%" + string + "%", "%" + string + "%"};
        Cursor cursor = sqLiteDatabase.query(NotePad.Notes.TABLE_NAME, PROJECTION,
                selection1, selection2, null, null, NotePad.Notes.DEFAULT_SORT_ORDER);
        String[] dataColumns = {NotePad.Notes.COLUMN_NAME_TITLE,
                NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE};
        int[] viewIDs = {android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this, R.layout.noteslist_item, cursor, dataColumns, viewIDs);
        listView.setAdapter(adapter);
        return true;
    }
}
