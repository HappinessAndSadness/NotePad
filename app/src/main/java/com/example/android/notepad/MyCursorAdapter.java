package com.example.android.notepad;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.View;
import android.widget.SimpleCursorAdapter;

public class MyCursorAdapter extends SimpleCursorAdapter {
    public MyCursorAdapter(Context context, int layout, Cursor c,
                           String[] from, int[] to) {
        super(context, layout, c, from, to);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        //int x = cursor.getInt(cursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_BACK_COLOR));
        int columnIndex = cursor.getColumnIndex(NotePad.Notes.COLUMN_NAME_BACK_COLOR);
        if (columnIndex != -1) {
            int x = cursor.getInt(columnIndex);
            switch (x) {
                case NotePad.Notes.DEFAULT_COLOR:
                    view.setBackgroundColor(Color.rgb(255, 255, 255));
                    break;
                case NotePad.Notes.YELLOW_COLOR:
                    view.setBackgroundColor(Color.rgb(247, 216, 133));
                    break;
                case NotePad.Notes.BLUE_COLOR:
                    view.setBackgroundColor(Color.rgb(165, 202, 237));
                    break;
                case NotePad.Notes.GREEN_COLOR:
                    view.setBackgroundColor(Color.rgb(161, 214, 174));
                    break;
                case NotePad.Notes.RED_COLOR:
                    view.setBackgroundColor(Color.rgb(244, 149, 133));
                    break;
                default:
                    view.setBackgroundColor(Color.rgb(255, 255, 255));
                    break;
            }
        }
//        switch (x){
//            case NotePad.Notes.DEFAULT_COLOR:
//                view.setBackgroundColor(Color.rgb(255, 255, 255));
//                break;
//            case NotePad.Notes.YELLOW_COLOR:
//                view.setBackgroundColor(Color.rgb(247, 216, 133));
//                break;
//            case NotePad.Notes.BLUE_COLOR:
//                view.setBackgroundColor(Color.rgb(165, 202, 237));
//                break;
//            case NotePad.Notes.GREEN_COLOR:
//                view.setBackgroundColor(Color.rgb(161, 214, 174));
//                break;
//            case NotePad.Notes.RED_COLOR:
//                view.setBackgroundColor(Color.rgb(244, 149, 133));
//                break;
//            default:
//                view.setBackgroundColor(Color.rgb(255, 255, 255));
//                break;
//        }
    }
}
