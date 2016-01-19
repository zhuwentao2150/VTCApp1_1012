package com.vtcapp.map;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Paint.Style;

import com.amap.mapapi.core.GeoPoint;
import com.amap.mapapi.map.MapView;
import com.amap.mapapi.map.Overlay;
import com.example.vtcapp1_1012.R;

public class MyOverlay extends Overlay{

	private Context context;
	private GeoPoint point;
	
	/**
	 * 构造方法
	 * @param context 上下文对象
	 * @param point	坐标
	 */
	public MyOverlay(Context context, GeoPoint point) {
		this.context = context;
		this.point = point;
	}
	
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		
		super.draw(canvas, mapView, shadow);
		
		Point screenPts = new Point();
		mapView.getProjection().toPixels(point, screenPts);
		// add the marker
		Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.mapzb);
		
		canvas.drawBitmap(bmp, screenPts.x, screenPts.y-50, null);		
	}
	
	@Override
	public boolean onTap(GeoPoint arg0, MapView arg1) {
		// TODO Auto-generated method stub
		return super.onTap(arg0, arg1);
	}
	
}
