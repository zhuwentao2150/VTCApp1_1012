package com.vtcapp.map;

import android.os.Bundle;

import com.amap.mapapi.core.GeoPoint;
import com.amap.mapapi.map.MapActivity;
import com.amap.mapapi.map.MapController;
import com.amap.mapapi.map.MapView;
import com.example.vtcapp1_1012.R;

public class GridMapView extends MapActivity {
	private MapView mMapView;
	private MapController mMapController;
	private GeoPoint point;

//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.mapview);
//		mMapView = (MapView) findViewById(R.id.mapView);
//		// 设置地图为矢量模式
//		mMapView.setVectorMap(true);
//		// 启动mMapView的自定义缩放控件
//		mMapView.setBuiltInZoomControls(true);
//		// 得到mMapView的控制权，可以用它来控制驱动平移和缩放
//		mMapController = mMapView.getController(); 
//		// 得到九江市的经纬度，GeoPoint(arg1,arg2),其中arg1是北纬,arg2是东经
//		point = new GeoPoint((int) (39.982378 * 1E6), (int) (116.304923 * 1E6)); // 用给定的经纬度构造一个GeoPoint，单位是微度(度*
//		// setCenter设置刚刚显示的地图中心点																// 1E6)
//		mMapController.setCenter(point);
//		mMapController.setZoom(12);	//设置地图zoom 级别
//		
//		// 覆盖图层
//		mMapView.getOverlays().add(new MyOverlay(getApplicationContext(), point));
//		
//	}
	
	
}