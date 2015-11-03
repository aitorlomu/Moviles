package com.example.com.ies.bdcoches;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class GestorBD extends SQLiteOpenHelper {

	public GestorBD(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase bd) {
		// TODO Auto-generated method stub
		String sqlTabla="create table "+MarcasContrato.NOMBRE_TABLA+" ("+ MarcasContrato.NOMBRE_COL_ID+" integer primary key, "
				+ MarcasContrato.NOMBRE_COL_NOMBRE+" varchar(40));";

		
		
		String insercion1="insert into "+ MarcasContrato.NOMBRE_TABLA+" values(1,'Ford');";
		

		String insercion2="insert into "+ MarcasContrato.NOMBRE_TABLA+" values(2,'Renault');";
		bd.execSQL(sqlTabla);
		
		bd.beginTransaction();

		bd.execSQL(insercion1);
		bd.execSQL(insercion2);
		bd.setTransactionSuccessful();
		bd.endTransaction();
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
