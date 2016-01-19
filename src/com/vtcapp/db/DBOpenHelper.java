package com.vtcapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBOpenHelper extends SQLiteOpenHelper {

	public DBOpenHelper(Context context) {
		super(context, "vtcapp.db", null, 1);	// <��>/databases/
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE myschool(" +
				"id integer primary key autoincrement, " +
				"schoolname varchar(20), " +
				"schoolcontent VARCHAR(20) " +
				")");
	}

	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {	// ���ݿ�İ汾�ŷ����仯��ʱ�򱻵���
//		db.execSQL("ALTER TABLE person ADD amount integer");
	}

}
