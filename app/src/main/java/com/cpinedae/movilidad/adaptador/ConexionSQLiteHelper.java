package com.cpinedae.movilidad.adaptador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.cpinedae.movilidad.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(Utilidades.CREA_TABLA_CONFIG);
            //db.execSQL(Utilidades.CREA_TABLA_USUARIO);
            db.execSQL("create table usuario (user text, ruta text, password text)");
        } catch (Exception e) {
            System.out.println("eror al crear la tablas");
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//    db.execSQL("drop table if exists configuracion");
//    onCreate(db);
    }
}
