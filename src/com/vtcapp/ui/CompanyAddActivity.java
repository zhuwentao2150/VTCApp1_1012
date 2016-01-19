package com.vtcapp.ui;

import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.vtcapp1_1012.R;
import com.vtcapp.thread.AccountThread;
import com.vtcapp.tools.Common;
import com.vtcapp.widget.MenuTop;

public class CompanyAddActivity extends Activity {
	
	private TextView xz_name;
	private EditText edt_name;
	private EditText edt_qq;
	private EditText edt_phone;
	private EditText edt_email;
	private Button btn_qued;
	private Button btn_quxiao;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_companyadd);
		MenuTop menutop = (MenuTop)findViewById(R.id.companyadd_menutop);
		menutop.setTitleText("应聘");
		
		String companyName = (String) getIntent().getSerializableExtra("xz_namecom");
		xz_name = (TextView) findViewById(R.id.tv_companydd_name);
		xz_name.setText(companyName);
		
		info();
		
		
		btn_qued.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = edt_name.getText().toString();
				String qq = edt_qq.getText().toString();
				String phone = edt_phone.getText().toString();
				String email = edt_email.getText().toString();
				setComAddMessage(Common.URL_SET_ACCOUNT, name, qq, phone, email);
			}
		});
		btn_quxiao.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				edt_name.setText("");
				edt_qq.setText("");
				edt_phone.setText("");
				edt_email.setText("");
			}
		});
	}
	private void info(){
		edt_name = (EditText) findViewById(R.id.add_edtcom_name);
		edt_qq = (EditText) findViewById(R.id.add_edtcom_qq);
		edt_phone = (EditText) findViewById(R.id.add_edtcom_phone);
		edt_email = (EditText) findViewById(R.id.add_edtcom_email);
		btn_qued = (Button) findViewById(R.id.add_btncom_qued);
		btn_quxiao = (Button) findViewById(R.id.add_btncom_quxiao);
	}
	
	
	private void setComAddMessage(String url, String name, String qq, String phone,
			String email) {
		StringBuffer buf = new StringBuffer();
		try{
			buf.append("name=");
			buf.append(URLEncoder.encode(name, "UTF-8"));
			buf.append("&qq=");
			buf.append(URLEncoder.encode(qq, "UTF-8"));
			buf.append("&phone=");
			buf.append(URLEncoder.encode(phone, "UTF-8"));
			buf.append("&email=");
			buf.append(URLEncoder.encode(email, "UTF-8"));
			String comaccmsg = buf.toString();
			new AccountThread(handler, url, comaccmsg).start();
		}catch(Exception e){}
		
	}
	
	
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if(msg.what == Common.MSG_SET_ACCOUNT){
				if (msg.arg1 == 0) {
					Toast.makeText(getApplicationContext(), "提交失败", 1).show();
				} else if (msg.arg1 > 0) {
					Toast.makeText(getApplicationContext(), "提交成功", 1).show();
					finish();
				}
			}
		}
	};
	

}
