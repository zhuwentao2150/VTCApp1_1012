package com.vtcapp.ui;

import java.util.ArrayList;

import com.example.vtcapp1_1012.R;
import com.vtcapp.adapter.WelcomePagerAdapter;
import com.vtcapp.config.SharedPreferencesConfig;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

// 引导页面
public class FirstWelcomeActivity extends Activity implements OnPageChangeListener,OnClickListener {

	private int[] mimages;
	private Context context;
	private ViewPager mwelcomeviewPager;
	private ArrayList<View> views;
	private ImageView[] mimageviews = null; 
	private LinearLayout imageslinearlayout;
	private PagerAdapter pagerAdapter;
	private Button startButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_firstwelcome);
		context = this; 
		mimages = new int[] { R.drawable.wel_01, R.drawable.wel_02,R.drawable.wel_03};
		initView();
	}
	
	private void initView(){
		startButton = (Button) findViewById(R.id.start_welcome);
		startButton.setOnClickListener(this);
		
		views = new ArrayList<View>();
		imageslinearlayout = (LinearLayout) findViewById(R.id.imageslinearlayout);
		mwelcomeviewPager = (ViewPager) findViewById(R.id.welcome_viewpager);
		
		mimageviews = new ImageView[mimages.length];
		
		for (int i = 0; i < mimages.length; i++) {
			ImageView imageView = new ImageView(context);
			imageView.setBackgroundResource(mimages[i]);
			views.add(imageView);
			mimageviews[i] = new ImageView(context);
			mimageviews[i].setBackgroundResource(R.drawable.welcomepage_yd_one);
			if (i == 0) {
				mimageviews[i].setBackgroundResource(R.drawable.welcomepage_yd_two);
			}
			imageslinearlayout.addView(mimageviews[i]);
		}
		pagerAdapter = new WelcomePagerAdapter(views);
		mwelcomeviewPager.setAdapter(pagerAdapter); // 设置适配器
		mwelcomeviewPager.setOnPageChangeListener(this);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		// 更改指示器图片
		for (int i = 0; i < mimageviews.length; i++) {
			mimageviews[arg0].setBackgroundResource(R.drawable.welcomepage_yd_two);
			if (arg0 != i) {
				mimageviews[i].setBackgroundResource(R.drawable.welcomepage_yd_one);
			}
		}

		// 显示最后一个图片时显示按钮
		if (arg0 == mimageviews.length - 1) {
			startButton.setVisibility(View.VISIBLE);
		} else {
			startButton.setVisibility(View.INVISIBLE);
		}
	}

	// 按钮点击事件
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.start_welcome) {
			
			// 以下代码由于调试需要，可暂时关闭
			SharedPreferences sharedpreferences = new SharedPreferencesConfig(this).GetConfig();
			Editor editor = sharedpreferences.edit();
			editor.putBoolean("welcome", false);
			editor.commit();
			
			startActivity(new Intent(FirstWelcomeActivity.this, MainActivity.class));
			overridePendingTransition(R.anim.welcome_in_right, R.anim.welcome_out_right);
			this.finish();
		}
	}
}
