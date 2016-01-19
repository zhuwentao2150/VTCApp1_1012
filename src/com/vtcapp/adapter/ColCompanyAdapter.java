package com.vtcapp.adapter;

import java.util.List;

import com.example.vtcapp1_1012.R;
import com.vtcapp.bean.CompanyInfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColCompanyAdapter extends BaseAdapter {

	private List<CompanyInfo> colCompanyInfos;
	private Context context;
	
	public ColCompanyAdapter(List<CompanyInfo> colCompanyInfos, Context context) {
		this.colCompanyInfos = colCompanyInfos;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return colCompanyInfos == null ? 0 : colCompanyInfos.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return colCompanyInfos == null ? null : colCompanyInfos.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = View.inflate(context, R.layout.item_list_colcompany, null);
		
		
		// ¹«Ë¾Ãû³Æ
		TextView colschoolName = (TextView) v.findViewById(R.id.tv_item_colcompany_name);
		colschoolName.setText(colCompanyInfos.get(position).getCompanyName());
		
		
		return v;
	}

}
