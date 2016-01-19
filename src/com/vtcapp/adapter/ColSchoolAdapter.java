package com.vtcapp.adapter;

import java.util.List;

import com.example.vtcapp1_1012.R;
import com.vtcapp.bean.SchoolInfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColSchoolAdapter extends BaseAdapter {

	private List<SchoolInfo> colschoolInfos;
	private Context context;
	
	public ColSchoolAdapter(List<SchoolInfo> colschoolinfos, Context context) {
		this.colschoolInfos = colschoolinfos;
		this.context = context;
	}
	public void getColSchoolData(List<SchoolInfo> colschoolinfos){
		this.colschoolInfos = colschoolinfos;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return colschoolInfos == null ? 0 : colschoolInfos.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return colschoolInfos == null ? null : colschoolInfos.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = View.inflate(context, R.layout.item_list_colschool, null);
		
		
		// Ñ§Ð£Ãû³Æ
		TextView colschoolName = (TextView) v.findViewById(R.id.tv_item_colschool_name);
		colschoolName.setText(colschoolInfos.get(position).getSchoolName());
		
		
		return v;
	}

}
