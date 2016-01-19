package com.vtcapp.tools;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.amap.mapapi.core.GeoPoint;
import com.vtcapp.bean.CompanyInfo;
import com.vtcapp.bean.SchoolInfo;

public class JsonTools {
	
	// ����������ѧУ��Ϣ
	public static List<SchoolInfo> parseSchoolJson(String schooljson){
		List<SchoolInfo> schools = new ArrayList<SchoolInfo>();
		try {
			JSONArray jsonarr = new JSONArray(schooljson);
			for(int i=0; i<jsonarr.length(); i++){
				JSONObject obj = jsonarr.getJSONObject(i);
				SchoolInfo school = new SchoolInfo();
				
				school.setSchoolId(obj.getInt("id"));
				school.setSchoolName(obj.getString("schoolname"));
				school.setSchoolContent(obj.getString("schoolcontent"));
				school.setSchoolimagesrc(obj.getString("schoolimagesrc"));
				// ����map
				school.setSchoollongitude(obj.getString("schoollongitude"));	// ����
				school.setSchoollatitude(obj.getString("schoollatitude"));		// γ��
				
				schools.add(school);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return schools;
	}
	
	// ���������Ĺ�˾��Ƹ��Ϣ
	public static List<CompanyInfo> parseCompanyJson(String Companyjson){
		List<CompanyInfo> companys = new ArrayList<CompanyInfo>();

		try {
			JSONArray jsonarr = new JSONArray(Companyjson);
			for(int i=0; i<jsonarr.length(); i++){
				JSONObject obj = jsonarr.getJSONObject(i);
				CompanyInfo company = new CompanyInfo();

				company.setCompanyId(obj.getInt("id"));
				company.setCompanyTitle(obj.getString("companyTitle"));
				company.setCompanyName(obj.getString("companyName"));
				company.setCompanyAddress(obj.getString("companyAddress"));
				company.setCompanyContent(obj.getString("companyContent"));
				company.setCompanyWage(obj.getString("companyWage"));
				company.setCompanyDate(obj.getString("companyDate"));

				companys.add(company);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return companys;
	}

}
