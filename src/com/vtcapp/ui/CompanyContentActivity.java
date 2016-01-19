package com.vtcapp.ui;

import com.example.vtcapp1_1012.R;
import com.vtcapp.bean.CompanyInfo;
import com.vtcapp.widget.MenuTop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CompanyContentActivity extends Activity {
	
	private TextView xz_biaoti;
	private TextView xz_name;
	private TextView xz_content;
	private TextView xz_address;
	private TextView xz_wage;
	private Button btn_add;
	
	private CompanyInfo companyinfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_content);
		MenuTop menutop = (MenuTop)findViewById(R.id.comcont_menutop);
		menutop.setTitleText("’–∆∏œÍ«È");
		
		xz_biaoti = (TextView) findViewById(R.id.tv_comcont_title);
		xz_name = (TextView) findViewById(R.id.tv_comcont_name);
		xz_content = (TextView) findViewById(R.id.tv_comcont_content);
		xz_address = (TextView) findViewById(R.id.tv_comcont_address);
		xz_wage = (TextView) findViewById(R.id.tv_comcont_wage);
		btn_add = (Button) findViewById(R.id.btn_comcont_yingpin);
		
		xz_content.setMovementMethod(ScrollingMovementMethod.getInstance());
		
		companyinfo = (CompanyInfo) getIntent().getSerializableExtra("xz_company");
		
		xz_biaoti.setText(companyinfo.getCompanyTitle());
		xz_name.setText(companyinfo.getCompanyName());
		xz_content.setText(companyinfo.getCompanyContent());
		xz_address.setText(companyinfo.getCompanyAddress());
		xz_wage.setText(companyinfo.getCompanyWage());
		
		btn_add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), CompanyAddActivity.class);
				intent.putExtra("xz_namecom", companyinfo.getCompanyName());
				startActivity(intent);
			}
		});
	}
}
