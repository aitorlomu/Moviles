package com.ies.bdseguros;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class GestorBD extends SQLiteOpenHelper {

	private String sqlCreacion="create table marcas(\r\n" + 
			"	id integer primary key,\r\n" + 
			"	marca char(30)\r\n" + 
			");";
	private String ins1="insert into marcas values(1,'ford');\r\n";
	private String ins2="insert into marcas values(1,'ford');\r\n";
	public GestorBD(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase bd) {

		bd.execSQL(sqlCreacion);

		bd.execSQL(ins1);
		bd.execSQL(ins2);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
