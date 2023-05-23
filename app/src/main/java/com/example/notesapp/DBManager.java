package com.example.notesapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="notes";
    private static final String TABLE_NAME ="note";
    private static final String ID ="id";
    private static final String title ="";
    private static final String note ="";
    private static final String date = "";
    private static final Boolean pinned = false;
    private Context context;
    private SQLiteDatabase db;

    public DBManager(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }
    public DBManager(Context context) {
        super(context, DATABASE_NAME,null, 1); //tạo csdl
        Log.d("DBManager", "DBManager: ");
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                ID +" integer primary key AUTOINCREMENT, "+
                title +" TEXT," + note +"TEXT,"+ date+ "TEXT,"+ pinned+ "INTEGER)";
        db.execSQL(sqlQuery);
        Toast.makeText(context, "Create successfylly",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "Drop successfylly",
                Toast.LENGTH_SHORT).show();
    }
    //Add new a person
    public void addNote(Notes notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(title, notes.getTitle());
        values.put(note, notes.getNote());
        values.put(date, notes.getDate());
        values.put(String.valueOf(pinned), notes.getPinned());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    //Select a Notes by title
    public Notes getNotesByName(String title){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { ID, title },
                title + "=?",new String[] { String.valueOf(title) },
                null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Notes notes = new
                Notes();
        cursor.close();
        db.close();
        return notes;
    }
    public int Update(Notes notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(title, notes.getTitle());
        values.put(note, notes.getNote());
        values.put(date, notes.getDate());
        values.put(String.valueOf(pinned), notes.getPinned());
        return db.update(TABLE_NAME,values,ID +"=?",
                new String[] { String.valueOf(notes.getId())});
    }// Getting All person
    public List<Notes> getAllPeople() {
        List<Notes> listPerson = new ArrayList<Notes>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Notes notes = new Notes();
                notes.setId(cursor.getInt(0));
                notes.setTitle(cursor.getString(1));
                notes.setNote(cursor.getString(1));
                /*notes.getDate(cursor.getString(1));
                notes.getPinned(cursor.getString(1));*/
                listPerson.add(notes);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listPerson;
    }
}
