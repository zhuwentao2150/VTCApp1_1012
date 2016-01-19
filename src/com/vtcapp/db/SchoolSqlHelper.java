package com.vtcapp.db;


import java.util.ArrayList;
import java.util.List;

import com.vtcapp.bean.SchoolInfo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class SchoolSqlHelper {
	
	private DBOpenHelper dbOpenhelper;
	public SchoolSqlHelper(Context context) {
		this.dbOpenhelper = new DBOpenHelper(context);
	}
	
	// ����
	public void save(SchoolInfo school) {
		SQLiteDatabase db = dbOpenhelper.getWritableDatabase();
		db.execSQL("insert into myschool(schoolname, schoolcontent) values(?,?)", 
				new Object[]{school.getSchoolName(), school.getSchoolContent()}
				);
	}
	// ɾ��
	public void delete(SchoolInfo school) {
		SQLiteDatabase db = dbOpenhelper.getWritableDatabase();
		db.execSQL("delete from myschool where id=?",
				new Object[]{school.getSchoolId()});
	}
	public void delete(Integer id) {
		SQLiteDatabase db = dbOpenhelper.getWritableDatabase();
		db.execSQL("delete from myschool where id=?",
				new Object[]{id});
	}
	
	public List<SchoolInfo> getSchoolSqlData() {
		List<SchoolInfo> schools = new ArrayList<SchoolInfo>();
		SQLiteDatabase db = dbOpenhelper.getReadableDatabase();	// ���ֻ�Ƕ����ݣ���ô�����ô˷���
		Cursor cursor = db.rawQuery("select * from myschool", null);
		while(cursor.moveToNext()) {	// �ƶ�����һ����¼
			int schoolid = cursor.getInt(cursor.getColumnIndex("id"));
			String schoolname = cursor.getString(cursor.getColumnIndex("schoolname"));
			String schoolcontent = cursor.getString(cursor.getColumnIndex("schoolcontent"));
			schools.add(new SchoolInfo(schoolid, schoolname, schoolcontent));
		}
		cursor.close();
		return schools;
	}
	
}
