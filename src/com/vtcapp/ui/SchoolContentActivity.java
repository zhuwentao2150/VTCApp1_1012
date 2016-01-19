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
		menutop.setTitleText("ѧУ����");
		menutop.setRightVisible();
		menutop.setRightListener(ock);
		
		xz_biaoti = (TextView) findViewById(R.id.tv_schoolcen_name);
		xz_content = (TextView) findViewById(R.id.tv_schoolcen_content);
		btn_add = (Button) findViewById(R.id.btn_schoolcen_baoming);
		
		// ����textview���Թ���
		xz_content.setMovementMethod(ScrollingMovementMethod.getInstance());
		// ��ô�activity���ݹ���������
		schoolinfo = (SchoolInfo) getIntent().getSerializableExtra("xz_school");
		
		xz_biaoti.setText(schoolinfo.getSchoolName());
		xz_content.setText(schoolinfo.getSchoolContent());
		
		
		// ��ť����¼�
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
			Toast.makeText(getApplicationContext(), "û������", 0).show();
		}else{
			// ��ʾ��ͼ
			showMap();
		}
		
	}
	
	
	OnClickListener ock = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			SchoolSqlHelper schsql = new SchoolSqlHelper(getApplicationContext());
			schsql.save(new SchoolInfo(schoolinfo.getSchoolName(), schoolinfo.getSchoolContent()));
			Toast.makeText(getApplicationContext(), "�Ѽ����ղؼ�", 0).show();
		}
	};
	
	

	private void showMap() {
		// ȡ��map��ͼ�ؼ�
		mMapView = (MapView) findViewById(R.id.mapView);
		// �����������õ����ſؼ�
		mMapView.setBuiltInZoomControls(true);	
		// �õ�mMapView�Ŀ���Ȩ,�����������ƺ�����ƽ�ƺ�����
		mMapController = mMapView.getController();
		
		// ��ȡ��γ��
		double longitude =  Double.valueOf(schoolinfo.getSchoollongitude());
		double latitude = Double.valueOf(schoolinfo.getSchoollatitude());
		
		point = new GeoPoint((int)(latitude * 1E6),(int)(longitude*1E6));
		// ��ͼ�����ĵ�����
		mMapController.setCenter(point);
		// zoom������ǵ�ͼ��ʼ��ʾ�Ĵ�С
		mMapController.setZoom(17);
		// ����ͼ��
		mMapView.getOverlays().add(new MyOverlay(getApplicationContext(), point));
	}
}
