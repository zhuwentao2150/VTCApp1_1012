package com.vtcapp.ui;

import com.example.vtcapp1_1012.R;
import com.vtcapp.widget.MenuTop;

import android.app.Activity;
import android.os.Bundle;

public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		// ���ñ�����
		MenuTop menutop = (MenuTop)findViewById(R.id.about_menutop);
		menutop.setTitleText("�������");
		
	}
}
