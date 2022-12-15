package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static String name = "login.db";
    private static int version = 1;

    String sql[] = {
            "CREATE TABLE utilizador (login TEXT NOT NULL UNIQUE,email TEXT NOT NULL,password TEXT NOT NULL,id INTEGER NOT NULL UNIQUE,PRIMARY KEY(id AUTOINCREMENT));"
    };

    public DBHelper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (int i = 0; i < sql.length; i++) {
            sqLiteDatabase.execSQL(sql[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insert(String log, String mail, String senha) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("login", log);
        cv.put("email", mail);
        cv.put("password", senha);
        return db.insert("utilizador", null, cv);
    }
    //VERIFICA LOGIN
    public int verificaLogin(String log, String senha) {
            SQLiteDatabase db = getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM utilizador WHERE login = ? and password = ?", new String[]{log, senha});
            c.moveToFirst();
            if (c.getCount() == 1) {
                return c.getInt(c.getColumnIndex("id"));
            }
            return -1;
        }
    //DELETAR UTILIZADORES
    public long eliminaUtilizador(int id){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete("utilizador", "id=?", new String[]{String.valueOf(id)});
    }
}