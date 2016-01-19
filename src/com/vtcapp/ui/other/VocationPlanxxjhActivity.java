package com.vtcapp.ui.other;

import com.example.vtcapp1_1012.R;
import com.vtcapp.tools.TextUtil;
import com.vtcapp.widget.MenuTop;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;


public class VocationPlanxxjhActivity extends Activity{

	
	private TextView tv_gh;
	private MenuTop menutop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gh);
		menutop = (MenuTop)findViewById(R.id.vocgh_menutop);
		menutop.setTitleText("职业规划");
		
		
		tv_gh = (TextView) findViewById(R.id.tv_vocgh);
		tv_gh.setMovementMethod(ScrollingMovementMethod.getInstance());
		
		tv_gh.setText(TextUtil.VOC_XXJH);
		
	}

	
	
}
