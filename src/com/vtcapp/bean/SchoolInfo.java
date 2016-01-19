package com.vtcapp.bean;

import java.io.Serializable;

public class SchoolInfo implements Serializable{
	private int schoolId;	// ѧУid
	private String schoolName;	// ѧУ����
	private String schoolContent; // ѧУ��Ϣ
	private String schoolimagesrc;	// ͼƬ·��
	private String schoollongitude;	// ����
	private String schoollatitude;	// γ��
	
	
	public SchoolInfo(){
		
	}
	public SchoolInfo(int schoolId, String schoolName, String schoolContent){
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.schoolContent = schoolContent;
	}
	public SchoolInfo(String schoolName, String schoolContent){
		this.schoolName = schoolName;
		this.schoolContent = schoolContent;
	}
	
	
	
	
	
	
	public String getSchoolimagesrc() {
		return schoolimagesrc;
	}
	public void setSchoolimagesrc(String schoolimagesrc) {
		this.schoolimagesrc = schoolimagesrc;
	}
	public String getSchoollongitude() {
		return schoollongitude;
	}
	public void setSchoollongitude(String schoollongitude) {
		this.schoollongitude = schoollongitude;
	}
	public String getSchoollatitude() {
		return schoollatitude;
	}
	public void setSchoollatitude(String schoollatitude) {
		this.schoollatitude = schoollatitude;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolContent() {
		return schoolContent;
	}
	public void setSchoolContent(String schoolContent) {
		this.schoolContent = schoolContent;
	}
	
	
	

}
