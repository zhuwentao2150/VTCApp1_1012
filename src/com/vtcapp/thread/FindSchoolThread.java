package com.vtcapp.thread;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.vtcapp.tools.Common;
import com.vtcapp.tools.HttpUtil;

import android.os.Handler;
import android.os.Message;

public class FindSchoolThread extends Thread {
	
	private Handler handler;
	private String url;
	private String name;
	
	public FindSchoolThread(Handler handler, String url, String name){
		this.handler = handler;
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		Message msg = handler.obtainMessage();
		msg.what = Common.MSG_GET_FINDSCHOOL;
		String startmessage = "";
		try {
			startmessage = "name="+URLEncoder.encode(name, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String result = "";
		try {
			result = HttpUtil.sendPost(url,startmessage);
		} catch (IOException e) {
			result = "";
		}
		msg.obj = result;
		handler.sendMessage(msg);
	}
}
