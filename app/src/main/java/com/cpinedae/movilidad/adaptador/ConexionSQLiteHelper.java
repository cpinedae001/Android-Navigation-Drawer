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
            db.execSQL("create table guia (no_guia text primary key, fecha text, nomrem text, nomdes text, dirrem text, " +
                    "dirdes text, telrem text, teldes text, entregado text, ruta text , transmitido text )");
            //insert into guia (no_guia, nomrem, nomdes, dirrem, dirdes, telrem, teldes)
            // select no_guia, nomrem, nomdes, dirrem, dirdes, telrem, teldes
            //db.execSQL(Utilidades.CREA_TABLA_USUARIO);
            db.execSQL("create table usuario (user text, ruta text, password text)");
        } catch (Exception e) {
            System.out.println("error al crear la tablas");
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//    db.execSQL("drop table if exists configuracion");
//    onCreate(db);
    }
}
