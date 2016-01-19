package com.vtcapp.ui;

import com.example.vtcapp1_1012.R;
import com.vtcapp.bean.SchoolInfo;
import com.vtcapp.widget.MenuTop;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class SchoolColContentActivity extends Activity{

	
	private TextView tv_name;
	private TextView tv_content;
	
	private SchoolInfo schoolinfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schoolcolcontent);
		MenuTop menutop = (MenuTop)findViewById(R.id.schoolcolcont_menutop);
		menutop.setTitleText("—ß–£œÍ«È");
		
		
		tv_name = (TextView) findViewById(R.id.schoolcolcont_name);
		tv_content = (TextView) findViewById(R.id.schoolcolcont_content);
		tv_content.setMovementMethod(ScrollingMovementMethod.getInstance());

		schoolinfo = (SchoolInfo) getIntent().getSerializableExtra("sc_school");

		tv_name.setText(schoolinfo.getSchoolName());
		tv_content.setText(schoolinfo.getSchoolContent());
		
		
	}
}
