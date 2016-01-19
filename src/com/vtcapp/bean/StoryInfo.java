package com.vtcapp.bean;

import java.io.Serializable;

public class StoryInfo implements Serializable{
	
	private int storyid;
	private String storytitle;
	private String storycontent;
	
	
	
	public StoryInfo() {
	}
	public StoryInfo(int storyid, String storytitle, String storycontent) {
		super();
		this.storyid = storyid;
		this.storytitle = storytitle;
		this.storycontent = storycontent;
	}
	public int getStoryid() {
		return storyid;
	}
	public void setStoryid(int storyid) {
		this.storyid = storyid;
	}
	public String getStorytitle() {
		return storytitle;
	}
	public void setStorytitle(String storytitle) {
		this.storytitle = storytitle;
	}
	public String getStorycontent() {
		return storycontent;
	}
	public void setStorycontent(String storycontent) {
		this.storycontent = storycontent;
	}
	
	
	

}
