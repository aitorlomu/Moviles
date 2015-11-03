package com.ies.bdcoches2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class GestorDB extends SQLiteOpenHelper {

	public GestorDB(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql_create_marcas="create table marcas (id integer primary key, nombre varcar(40))";
		db.execSQL(sql_create_marcas);
		
		Log.d("DB",sql_create_marcas);
		
		String sql_create_modelos="create table modelos(id_modelo integer primary key,"
				+ "id_marca integer,"
				+ "nombre varchar(40),"
				+ "foreign key(id_marca) references marca(id))";
		
		
		
		db.execSQL(sql_create_modelos);
		
		Log.d("DB",sql_create_modelos);
		
		String insercion1="insert into marcas values(1,'Ford');";
		String insercion2="insert into marcas values(2,'Renault');";
		String insercion3="insert into modelos values(1,1,'Focus')";
		String insercion4="insert into modelos values(2,1,'Mondeo')";
		String insercion5="insert into modelos values(3,2,'Megane')";
		String insercion6="insert into modelos values(4,2,'Clio')";
		
		db.beginTransaction();
		
		db.execSQL(insercion1);
		db.execSQL(insercion2);
		db.execSQL(insercion3);
		db.execSQL(insercion4);
		db.execSQL(insercion5);
		db.execSQL(insercion6);
		
		db.setTransactionSuccessful();
		db.endTransaction();
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
