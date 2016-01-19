package com.vtcapp.ui.other;

import com.example.vtcapp1_1012.R;
import com.vtcapp.bean.StoryInfo;
import com.vtcapp.widget.MenuTop;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class VocationStoryContentActivity extends Activity {
	
	private TextView xz_title;
	private TextView xz_content;
	private StoryInfo stroyinfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vocationstory_content);
		MenuTop menutop = (MenuTop)findViewById(R.id.vocationstory_content_menutop);
		menutop.setTitleText("π  ¬œÍ«È");
		
		xz_title = (TextView) findViewById(R.id.tv_vocationstory_title);
		xz_content = (TextView) findViewById(R.id.tv_vocationstory_content);
		xz_content.setMovementMethod(ScrollingMovementMethod.getInstance());
		
		stroyinfo = (StoryInfo) getIntent().getSerializableExtra("xz_story");
		
		xz_title.setText(stroyinfo.getStorytitle());
		xz_content.setText(stroyinfo.getStorycontent());
		
		
	}
}
