package com.vtcapp.thread;

import java.io.IOException;

import com.vtcapp.tools.Common;
import com.vtcapp.tools.HttpUtil;

import android.os.Handler;
import android.os.Message;

public class AccountThread extends Thread {
	
	private Handler handler;
	private String url;
	private String message;
	
	public AccountThread(Handler handler, String url, String message){
		this.handler = handler;
		this.url = url;
		this.message = message;
	}

	@Override
	public void run() {
		Message msg = handler.obtainMessage();
		msg.what = Common.MSG_SET_ACCOUNT;
		
		String result = "0";
		try {
			result = HttpUtil.sendPost(url, message);
			if(result.equals("")){
				result = "0";
			}
		} catch (IOException e) {
			result = "0";
		}
		msg.arg1 = Integer.valueOf(result);
		handler.sendMessage(msg);
		
	}
}
