package com.vtcapp.adapter;

import java.util.List;

import com.example.vtcapp1_1012.R;
import com.vtcapp.bean.SchoolInfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class InSchoolAdapter extends BaseAdapter {
	
	
	private List<SchoolInfo> inschoolInfos;
	private Context context;
	
	public InSchoolAdapter(List<SchoolInfo> inschoolinfos, Context context) {
		this.inschoolInfos = inschoolinfos;
		this.context = context;
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return inschoolInfos == null ? 0 : inschoolInfos.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return inschoolInfos == null ? null : inschoolInfos.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View v = View.inflate(context, R.layout.item_list_inschool, null);
		
		
		// Ñ§Ð£Ãû³Æ
		TextView schoolName = (TextView) v.findViewById(R.id.tv_inschool_name);
		schoolName.setText(inschoolInfos.get(position).getSchoolName());
		
		return v;
	}

}
