package com.vtcapp.ui;


import com.amap.mapapi.core.GeoPoint;
import com.amap.mapapi.map.MapActivity;
import com.amap.mapapi.map.MapController;
import com.amap.mapapi.map.MapView;
import com.example.vtcapp1_1012.R;
import com.vtcapp.bean.SchoolInfo;
import com.vtcapp.db.SchoolSqlHelper;
import com.vtcapp.map.MyOverlay;
import com.vtcapp.widget.MenuTop;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SchoolContentActivity extends MapActivity {
	
	
	private MapView mMapView;
	private MapController mMapController;
	private GeoPoint point;

	private TextView xz_biaoti;
	private TextView xz_content;
	private Button btn_add;
	
	
	private SchoolInfo schoolinfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_school_content);
		MenuTop menutop = (MenuTop)findViewById(R.id.schcontent_menutop);
		menutop.setTitleText("学校详情");
		menutop.setRightVisible();
		menutop.setRightListener(ock);
		
		xz_biaoti = (TextView) findViewById(R.id.tv_schoolcen_name);
		xz_content = (TextView) findViewById(R.id.tv_schoolcen_content);
		btn_add = (Button) findViewById(R.id.btn_schoolcen_baoming);
		
		// 设置textview可以滚动
		xz_content.setMovementMethod(ScrollingMovementMethod.getInstance());
		// 获得从activity传递过来的数据
		schoolinfo = (SchoolInfo) getIntent().getSerializableExtra("xz_school");
		
		xz_biaoti.setText(schoolinfo.getSchoolName());
		xz_content.setText(schoolinfo.getSchoolContent());
		
		
		// 按钮点击事件
		btn_add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), SchoolAddActivity.class);
				intent.putExtra("xz_biaoti", schoolinfo.getSchoolName());
				startActivity(intent);
			}
		});
		
		
		
		ConnectivityManager cwjManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if(!cwjManager.getActiveNetworkInfo().isAvailable()){
			Toast.makeText(getApplicationContext(), "没有网络", 0).show();
		}else{
			// 显示地图
			showMap();
		}
		
	}
	
	
	OnClickListener ock = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			SchoolSqlHelper schsql = new SchoolSqlHelper(getApplicationContext());
			schsql.save(new SchoolInfo(schoolinfo.getSchoolName(), schoolinfo.getSchoolContent()));
			Toast.makeText(getApplicationContext(), "已加入收藏夹", 0).show();
		}
	};
	
	

	private void showMap() {
		// 取得map视图控件
		mMapView = (MapView) findViewById(R.id.mapView);
		// 设置启用内置的缩放控件
		mMapView.setBuiltInZoomControls(true);	
		// 得到mMapView的控制权,可以用它控制和驱动平移和缩放
		mMapController = mMapView.getController();
		
		// 获取经纬度
		double longitude =  Double.valueOf(schoolinfo.getSchoollongitude());
		double latitude = Double.valueOf(schoolinfo.getSchoollatitude());
		
		point = new GeoPoint((int)(latitude * 1E6),(int)(longitude*1E6));
		// 地图的中心点设置
		mMapController.setCenter(point);
		// zoom级别就是地图初始显示的大小
		mMapController.setZoom(17);
		// 覆盖图层
		mMapView.getOverlays().add(new MyOverlay(getApplicationContext(), point));
	}
}
