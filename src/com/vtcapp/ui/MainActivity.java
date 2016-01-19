package com.vtcapp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.example.vtcapp1_1012.R;
import com.vtcapp.ResideMenu.ResideMenu;
import com.vtcapp.ResideMenu.ResideMenuItem;
import com.vtcapp.ui.other.VocationPlanActivity;
import com.vtcapp.ui.other.VocationStoryWebActivity;
import com.vtcapp.ui.other.WorkBriefActivity;
import com.vtcapp.widget.MenuTop;







import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;


public class MainActivity extends Activity implements OnClickListener{
	
	
	private ResideMenu resideMenu;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemAbout;
    
	private ViewPager viewPager; // android-support-v4中的滑动组件
	private List<ImageView> imageViews; // 滑动的图片集合
	private int[] imageResId; // 图片ID
	private List<View> dots; // 图片标题正文的那些点
	private int currentItem = 0; // 当前图片的索引号
	private long mExitTime;
	private ScheduledExecutorService scheduledExecutorService;	// 定时执行某项任务
	private ImageButton btn01,btn02,btn03,btn04,btn05,btn06;
	
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			// 切换当前显示的图片
			viewPager.setCurrentItem(currentItem);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 设置主页标题
		MenuTop menutop = (MenuTop)findViewById(R.id.main_menutop);
		menutop.setTitleText("职校通");
		// 标题栏左图标不显示
		menutop.setLeftGone();
		menutop.setLeftMenuVisible();
		showMenu();
		
		menutop.setLeftMenuListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
		initView();
		initViewPager();
	}
	
	
	
	public void showMenu(){
		
		resideMenu = new ResideMenu(this);
        resideMenu.setUse3D(true);
        resideMenu.setBackground(R.drawable.zygh_bj);
        resideMenu.attachToActivity(this);
        
        resideMenu.setScaleValue(0.8f);
        itemHome = new ResideMenuItem(this, R.drawable.icon_home, "主页");
        itemAbout = new ResideMenuItem(this, R.drawable.icon_settings, "关于软件");
        
        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemAbout, ResideMenu.DIRECTION_LEFT);
        
        itemHome.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});
        itemAbout.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        		startActivity(intent);
        	}
        });
        
	}
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }
	// 给其它的页面提供统一的菜单实例
    public ResideMenu getResideMenu(){
        return resideMenu;
    }
	
	
	
	
	
	
	@Override
	protected void onStart() {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		// 当Activity显示出来后，每两秒钟切换一次图片显示
		// 该方法是个定时执行的工具，参数1：要执行的线程，参数2：初始化延时,参数3：每次执行的时间间隔,参数4：计时单位
		scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2, TimeUnit.SECONDS);
		super.onStart();
	}
	@Override
	protected void onStop() {
		// 当Activity不可见的时候停止切换
		scheduledExecutorService.shutdown();
		super.onStop();
	}
	
	private void initView(){
		btn01 = (ImageButton) findViewById(R.id.main_btn_01);
		btn02 = (ImageButton) findViewById(R.id.main_btn_02);
		btn03 = (ImageButton) findViewById(R.id.main_btn_03);
		btn04 = (ImageButton) findViewById(R.id.main_btn_04);
		btn05 = (ImageButton) findViewById(R.id.main_btn_05);
		btn06 = (ImageButton) findViewById(R.id.main_btn_06);
		
		btn01.setOnClickListener(this);
		btn02.setOnClickListener(this);
		btn03.setOnClickListener(this);
		btn04.setOnClickListener(this);
		btn05.setOnClickListener(this);
		btn06.setOnClickListener(this);
	}
	
	// 初始化图片轮播
	private void initViewPager(){
		// 把图片资源ID放在数组中
		imageResId = new int[] { R.drawable.main_one, R.drawable.main_two, R.drawable.main_three, R.drawable.main_four, R.drawable.main_five };

		// 初始化图片资源
		imageViews = new ArrayList<ImageView>();
		for (int i = 0; i < imageResId.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setImageResource(imageResId[i]);
			imageView.setScaleType(ScaleType.CENTER_CROP);
			imageViews.add(imageView);
		}
		dots = new ArrayList<View>();
		dots.add(findViewById(R.id.v_dot0));
		dots.add(findViewById(R.id.v_dot1));
		dots.add(findViewById(R.id.v_dot2));
		dots.add(findViewById(R.id.v_dot3));
		dots.add(findViewById(R.id.v_dot4));
		viewPager = (ViewPager) findViewById(R.id.vp);
		viewPager.setAdapter(new MyAdapter());
		// 设置一个监听器，当ViewPager中的页面改变时调用
		viewPager.setOnPageChangeListener(new MyPageChangeListener());
	}
	
	// 设置小点的事件监听
	private class MyPageChangeListener implements OnPageChangeListener{

		private int oldPosition = 0;

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub
			currentItem = position;
			/* tv_title.setText(titles[position]); */
			// 老页面的原点变成未选中状态
			dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
			// 新页面的点变成选中状态
			dots.get(position).setBackgroundResource(R.drawable.dot_focused);
			oldPosition = position;
		}
	}
	
	// 填充ViewPager的适配器
	private class MyAdapter extends PagerAdapter {
		// 只需要实现前面的四个方法
		public int getCount() {
			return imageResId.length;
		}

		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(imageViews.get(arg1));
			return imageViews.get(arg1);
		}

		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView((View) arg2);
		}
		// 用于判断当前要显示的界面
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		
	}

	// 切换图片的线程
	private class ScrollTask implements Runnable {
		public void run() {
			// 加锁
			synchronized (viewPager) {
				currentItem = (currentItem + 1) % imageViews.size();
				handler.obtainMessage().sendToTarget(); // 通过Handler切换图片
			}
		}
	}

	// 按钮点击事件的监听
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.main_btn_01:	// 学校大全
			intent.setClass(getApplicationContext(), SchoolActivity.class);
			break;
		case R.id.main_btn_02:	// 企业招聘
			intent.setClass(getApplicationContext(), CompanyActivity.class);
			break;
		case R.id.main_btn_03:	// 工作简介
			intent.setClass(getApplicationContext(), WorkBriefActivity.class);
			break;
		case R.id.main_btn_04:	// 职业规划
			intent.setClass(getApplicationContext(), VocationPlanActivity.class);
			break;
		case R.id.main_btn_05:	// 职业故事
//			intent.setClass(getApplicationContext(), VocationStoryActivity.class);
			intent.setClass(getApplicationContext(), VocationStoryWebActivity.class);
			break;
		case R.id.main_btn_06:	// 关于我们
			intent.setClass(getApplicationContext(), AboutActivity.class);
			break;

		default:
			break;
		}
		
		// 启动界面
		startActivity(intent);
		
	}
	
	
	
	
	// 判断两次点击退出
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if (KeyEvent.KEYCODE_BACK == keyCode) {
			if((System.currentTimeMillis() - mExitTime) > 2000){
				Toast.makeText(this, "再按一次退出程序", 0).show();
				mExitTime = System.currentTimeMillis();	// 更新时间
			}else{
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	


}
