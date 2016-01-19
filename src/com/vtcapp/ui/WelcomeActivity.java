package com.vtcapp.ui;


import com.example.vtcapp1_1012.R;
import com.vtcapp.config.SharedPreferencesConfig;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;

// 软件的入口，第一次使用则进入欢迎界面
public class WelcomeActivity extends Activity {
	private boolean firstComeApp;	//判断是否第一次打开软件
	private View view;
	private Context context;
	private Animation animation;
	private SharedPreferences shared;
	private static int TIME = 1000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = View.inflate(this, R.layout.activity_welcome, null);
		setContentView(view);
		context = this;
		shared = new SharedPreferencesConfig(context).GetConfig(); 	// 得到配置文件
	}
	@Override
	protected void onResume() {
		init();
		super.onResume();
	}
	private void init(){
		
		firstComeApp = shared.getBoolean("welcome", true);

		animation = AnimationUtils.loadAnimation(this, R.anim.main_dongzuo);
		// 给view设置动画效果
		view.startAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation arg0) {
			}
			@Override
			public void onAnimationRepeat(Animation arg0) {
			}
			@Override
			public void onAnimationEnd(Animation arg0) {
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						Intent intent;
						//如果第一次，则进入引导页WelcomeActivity
						if (firstComeApp) {
							intent = new Intent(WelcomeActivity.this,FirstWelcomeActivity.class);
						} else {
							intent = new Intent(WelcomeActivity.this, MainActivity.class);
						}
						startActivity(intent);
						// 设置Activity的切换效果
						overridePendingTransition(R.anim.welcome_in_right, R.anim.welcome_out_right);
						WelcomeActivity.this.finish();
					}
				}, TIME);
			}
		});
	}
	
}
