package com.vtcapp.adapter;

import java.util.List;


import com.example.vtcapp1_1012.R;
import com.lidroid.xutils.BitmapUtils;
import com.vtcapp.bean.SchoolInfo;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SchoolAdapter extends BaseAdapter {
	
	private List<SchoolInfo> schoolInfos;
	private Context context;
	
	public SchoolAdapter(List<SchoolInfo> schoolinfos, Context context) {
		this.schoolInfos = schoolinfos;
		this.context = context;
	}
	public void getSchoolData(List<SchoolInfo> schoolinfos){
		this.schoolInfos = schoolinfos;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return schoolInfos == null ? 0 : schoolInfos.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return schoolInfos == null ? null : schoolInfos.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// 一个item布局
		View v = View.inflate(context, R.layout.item_list_school, null);
		
		
		// 学校名称
		TextView schoolName = (TextView) v.findViewById(R.id.tv_school_name);
		schoolName.setText(schoolInfos.get(position).getSchoolName());
		
		// 学校图片
		ImageView schoolIcon = (ImageView) v.findViewById(R.id.iv_school_src);
		BitmapUtils bitmaputils = new BitmapUtils(context);
		bitmaputils.display(schoolIcon, schoolInfos.get(position).getSchoolimagesrc());
		
		
		
		
		return v;
	}

}
