package com.example.android.notepad;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class NoteColor extends Activity {
    private Cursor mCursor;
    private Uri mUri;
    private int color;
    private static final int COLUMN_INDEX_TITLE = 1;
    private static final String[] PROJECTION = new String[]{
            NotePad.Notes._ID, // 0
            NotePad.Notes.COLUMN_NAME_BACK_COLOR,
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_color);
        mUri = getIntent().getData();
        mCursor = getContentResolver().query(mUri, PROJECTION, null, null, null);
    }

    @Override
    protected void onResume() {
        if (mCursor != null) {
            mCursor.moveToFirst();
            //color = mCursor.getInt(COLUMN_INDEX_TITLE);
            color = mCursor.getInt(1); // 1是COLUMN_NAME_BACK_COLOR的索引
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mCursor != null) {//
            mCursor.close();//
        }//

        ContentValues values = new ContentValues();
        values.put(NotePad.Notes.COLUMN_NAME_BACK_COLOR, color);
        getContentResolver().update(mUri, values, null, null);
    }

    public void white(View view) {
        color = NotePad.Notes.DEFAULT_COLOR;
        finish();
    }

    public void yellow(View view) {
        color = NotePad.Notes.YELLOW_COLOR;
        finish();
    }

    public void blue(View view) {
        color = NotePad.Notes.BLUE_COLOR;
        finish();
    }

    public void green(View view) {
        color = NotePad.Notes.GREEN_COLOR;
        finish();
    }

    public void red(View view) {
        color = NotePad.Notes.RED_COLOR;
        finish();
    }
}
