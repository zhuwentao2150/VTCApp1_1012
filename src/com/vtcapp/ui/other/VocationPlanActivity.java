package com.vtcapp.ui.other;


import com.example.vtcapp1_1012.R;
import com.vtcapp.widget.MenuTop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class VocationPlanActivity extends Activity implements OnClickListener{
	
	private ViewFlipper viewFlipper;
	private Button vocplan_01;
	private Button vocplan_02;
	private Button vocplan_03;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vocationplan);
		MenuTop menutop = (MenuTop)findViewById(R.id.vocationplan_menutop);
		menutop.setTitleText("职业规划");
		
		
		viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
		viewFlipper.setInAnimation(this, R.anim.in_alpha);
		viewFlipper.setOutAnimation(this, R.anim.out_alpha);
		// 设定viewFlipper的切换间隔
		viewFlipper.setFlipInterval(3000);
		// 开始播放
		viewFlipper.startFlipping();
		
		vocplan_01 = (Button) findViewById(R.id.vocplan_01);
		vocplan_02 = (Button) findViewById(R.id.vocplan_02);
		vocplan_03 = (Button) findViewById(R.id.vocplan_03);
		
		vocplan_01.setOnClickListener(this);
		vocplan_02.setOnClickListener(this);
		vocplan_03.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.vocplan_01:
			intent.setClass(getApplicationContext(), VocationPlanzyghActivity.class);
			break;
		case R.id.vocplan_02:
			intent.setClass(getApplicationContext(), VocationPlanxxjhActivity.class);
			break;
		case R.id.vocplan_03:
			intent.setClass(getApplicationContext(), VocationPlanzyqjActivity.class);
			break;

		default:
			break;
			
		}
		startActivity(intent);
	}
}
