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
//		// ���õ�ͼΪʸ��ģʽ
//		mMapView.setVectorMap(true);
//		// ����mMapView���Զ������ſؼ�
//		mMapView.setBuiltInZoomControls(true);
//		// �õ�mMapView�Ŀ���Ȩ��������������������ƽ�ƺ�����
//		mMapController = mMapView.getController(); 
//		// �õ��Ž��еľ�γ�ȣ�GeoPoint(arg1,arg2),����arg1�Ǳ�γ,arg2�Ƕ���
//		point = new GeoPoint((int) (39.982378 * 1E6), (int) (116.304923 * 1E6)); // �ø����ľ�γ�ȹ���һ��GeoPoint����λ��΢��(��*
//		// setCenter���øո���ʾ�ĵ�ͼ���ĵ�																// 1E6)
//		mMapController.setCenter(point);
//		mMapController.setZoom(12);	//���õ�ͼzoom ����
//		
//		// ����ͼ��
//		mMapView.getOverlays().add(new MyOverlay(getApplicationContext(), point));
//		
//	}
	
	
}