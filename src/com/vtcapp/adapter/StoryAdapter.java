package com.vtcapp.adapter;

import java.util.List;

import com.example.vtcapp1_1012.R;
import com.vtcapp.bean.SchoolInfo;
import com.vtcapp.bean.StoryInfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StoryAdapter extends BaseAdapter{

	private List<StoryInfo> storys;
	private Context context;
	
	public StoryAdapter(List<StoryInfo> storys, Context context) {
		this.storys = storys;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return storys == null ? 0 : storys.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return storys == null ? null : storys.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = View.inflate(context, R.layout.item_list_story, null);
		
		TextView stroytitle = (TextView) v.findViewById(R.id.tv_item_storytitle);
		stroytitle.setText(storys.get(position).getStorytitle());
		
		return v;
	}

}
