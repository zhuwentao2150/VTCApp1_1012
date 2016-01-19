package com.vtcapp.adapter;

import java.util.List;

import com.example.vtcapp1_1012.R;
import com.vtcapp.bean.CompanyInfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CompanyAdapter extends BaseAdapter {

	private List<CompanyInfo> companyInfos;
	private Context context;
	
	public CompanyAdapter(List<CompanyInfo> companyInfos, Context context) {
		this.companyInfos = companyInfos;
		this.context = context;
	}
	public void getCompanyData(List<CompanyInfo> companyinfos){
		this.companyInfos = companyinfos;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return companyInfos == null ? 0 : companyInfos.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return companyInfos == null ? null : companyInfos.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View v = View.inflate(context, R.layout.item_list_company, null);

		TextView companyTitle = (TextView) v.findViewById(R.id.tv_company_title);
		companyTitle.setText(companyInfos.get(position).getCompanyTitle());
		
		TextView companyName = (TextView) v.findViewById(R.id.tv_company_name);
		companyName.setText(companyInfos.get(position).getCompanyName());
		
		TextView companyWage = (TextView) v.findViewById(R.id.tv_company_wage);
		companyWage.setText(companyInfos.get(position).getCompanyWage());
		
		TextView companyAddress = (TextView) v.findViewById(R.id.tv_company_address);
		companyAddress.setText(companyInfos.get(position).getCompanyAddress());
		
		TextView companyDate = (TextView) v.findViewById(R.id.tv_company_date);
		companyDate.setText(companyInfos.get(position).getCompanyDate());
		
		
		return v;
	}

}
