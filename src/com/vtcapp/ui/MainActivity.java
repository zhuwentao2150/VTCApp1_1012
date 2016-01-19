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
    
	private ViewPager viewPager; // android-support-v4�еĻ������
	private List<ImageView> imageViews; // ������ͼƬ����
	private int[] imageResId; // ͼƬID
	private List<View> dots; // ͼƬ�������ĵ���Щ��
	private int currentItem = 0; // ��ǰͼƬ��������
	private long mExitTime;
	private ScheduledExecutorService scheduledExecutorService;	// ��ʱִ��ĳ������
	private ImageButton btn01,btn02,btn03,btn04,btn05,btn06;
	
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			// �л���ǰ��ʾ��ͼƬ
			viewPager.setCurrentItem(currentItem);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ������ҳ����
		MenuTop menutop = (MenuTop)findViewById(R.id.main_menutop);
		menutop.setTitleText("ְУͨ");
		// ��������ͼ�겻��ʾ
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
        itemHome = new ResideMenuItem(this, R.drawable.icon_home, "��ҳ");
        itemAbout = new ResideMenuItem(this, R.drawable.icon_settings, "�������");
        
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
	// ��������ҳ���ṩͳһ�Ĳ˵�ʵ��
    public ResideMenu getResideMenu(){
        return resideMenu;
    }
	
	
	
	
	
	
	@Override
	protected void onStart() {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		// ��Activity��ʾ������ÿ�������л�һ��ͼƬ��ʾ
		// �÷����Ǹ���ʱִ�еĹ��ߣ�����1��Ҫִ�е��̣߳�����2����ʼ����ʱ,����3��ÿ��ִ�е�ʱ����,����4����ʱ��λ
		scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2, TimeUnit.SECONDS);
		super.onStart();
	}
	@Override
	protected void onStop() {
		// ��Activity���ɼ���ʱ��ֹͣ�л�
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
	
	// ��ʼ��ͼƬ�ֲ�
	private void initViewPager(){
		// ��ͼƬ��ԴID����������
		imageResId = new int[] { R.drawable.main_one, R.drawable.main_two, R.drawable.main_three, R.drawable.main_four, R.drawable.main_five };

		// ��ʼ��ͼƬ��Դ
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
		// ����һ������������ViewPager�е�ҳ��ı�ʱ����
		viewPager.setOnPageChangeListener(new MyPageChangeListener());
	}
	
	// ����С����¼�����
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
			// ��ҳ���ԭ����δѡ��״̬
			dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
			// ��ҳ��ĵ���ѡ��״̬
			dots.get(position).setBackgroundResource(R.drawable.dot_focused);
			oldPosition = position;
		}
	}
	
	// ���ViewPager��������
	private class MyAdapter extends PagerAdapter {
		// ֻ��Ҫʵ��ǰ����ĸ�����
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
		// �����жϵ�ǰҪ��ʾ�Ľ���
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		
	}

	// �л�ͼƬ���߳�
	private class ScrollTask implements Runnable {
		public void run() {
			// ����
			synchronized (viewPager) {
				currentItem = (currentItem + 1) % imageViews.size();
				handler.obtainMessage().sendToTarget(); // ͨ��Handler�л�ͼƬ
			}
		}
	}

	// ��ť����¼��ļ���
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.main_btn_01:	// ѧУ��ȫ
			intent.setClass(getApplicationContext(), SchoolActivity.class);
			break;
		case R.id.main_btn_02:	// ��ҵ��Ƹ
			intent.setClass(getApplicationContext(), CompanyActivity.class);
			break;
		case R.id.main_btn_03:	// �������
			intent.setClass(getApplicationContext(), WorkBriefActivity.class);
			break;
		case R.id.main_btn_04:	// ְҵ�滮
			intent.setClass(getApplicationContext(), VocationPlanActivity.class);
			break;
		case R.id.main_btn_05:	// ְҵ����
//			intent.setClass(getApplicationContext(), VocationStoryActivity.class);
			intent.setClass(getApplicationContext(), VocationStoryWebActivity.class);
			break;
		case R.id.main_btn_06:	// ��������
			intent.setClass(getApplicationContext(), AboutActivity.class);
			break;

		default:
			break;
		}
		
		// ��������
		startActivity(intent);
		
	}
	
	
	
	
	// �ж����ε���˳�
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if (KeyEvent.KEYCODE_BACK == keyCode) {
			if((System.currentTimeMillis() - mExitTime) > 2000){
				Toast.makeText(this, "�ٰ�һ���˳�����", 0).show();
				mExitTime = System.currentTimeMillis();	// ����ʱ��
			}else{
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	


}
