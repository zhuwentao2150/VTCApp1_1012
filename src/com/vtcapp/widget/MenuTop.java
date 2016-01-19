package com.vtcapp.widget;


import com.example.vtcapp1_1012.R;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MenuTop extends FrameLayout {

	private Button mBtnLeft;
	private Button mBtnRight;
	private Button title_bar_left_menu;
	private TextView mTopTitle;

	public MenuTop(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.menu_top, this);

		mTopTitle = (TextView)findViewById(R.id.tv_menutop_title);
		mBtnLeft = (Button) findViewById(R.id.btn_menutop_left);
		mBtnRight = (Button) findViewById(R.id.btn_menutop_right);
		title_bar_left_menu = (Button) findViewById(R.id.title_bar_left_menu);

		//左边点击返回 结束页面
		mBtnLeft.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((Activity)getContext()).finish();
			}
		});
	}

	// 设置中间要显示的标题
	public void setTitleText(String s){
		mTopTitle.setText(s);
	}

	// 设置左边的按钮为不可见状态
	public void setLeftGone(){
		mBtnLeft.setVisibility(View.GONE);
	}
	// 设置右边的按钮为可见状态
	public void setRightVisible(){
		mBtnRight.setVisibility(View.VISIBLE);
	}

	public void setLeftMenuVisible(){
		title_bar_left_menu.setVisibility(View.VISIBLE);
	}
	public void setLeftMenuListener(OnClickListener listener){
		title_bar_left_menu.setOnClickListener(listener);
	}

	// 设置右边按钮的事件监听
	public void setRightListener(OnClickListener listener){
		mBtnRight.setOnClickListener(listener);
	}
	// 设置右边按钮的事件监听
	public void setLeftListener(OnClickListener listener){
		mBtnLeft.setOnClickListener(listener);
	}

}
