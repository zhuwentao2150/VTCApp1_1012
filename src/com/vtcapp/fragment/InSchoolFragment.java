package com.vtcapp.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.vtcapp1_1012.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.vtcapp.adapter.InSchoolAdapter;
import com.vtcapp.bean.SchoolInfo;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

// 参加学校
public class InSchoolFragment extends Fragment{
	
	private InSchoolAdapter inAdapter;
	private ListView mlistview;
	// 存放所有获取到的学校信息
	private List<SchoolInfo>  inschoolInfos = new ArrayList<SchoolInfo>();
	
	
	private PullToRefreshListView mPullToRefreshListView;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//填充器：作用：把xml文件变成java文件中的一个view
		View view = inflater.inflate(R.layout.fragment_inschool, container, false);

		// 调试用的数据
		getSchoolsTest();

		// 初始化控件
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.lv_inschool);
		mlistview = mPullToRefreshListView.getRefreshableView();
		inAdapter = new InSchoolAdapter(inschoolInfos, getActivity());
		
		mlistview.setAdapter(inAdapter);
		
		// 设置pull-to-refresh模式为Mode.Both，该模式为可上拉也可下拉
		// Mode.PULL_FROM_START：只支持下拉Pulling Down
		// Mode.PULL_FROM_END：只支持上拉Pulling Up
		mPullToRefreshListView.setMode(Mode.PULL_FROM_END);
		
		// 设置上拉下拉事件
		mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				if(refreshView.isHeaderShown()){
					// 下拉刷新,当Mode设置为PULL_FROM_END的时候不执行
				}else{
				
					// 刷新适配器数据
					inAdapter.notifyDataSetChanged();
					// 刷新完后关闭
					new FinishReftesh().execute();
				}
			}
		});
		
		
		return view;
	}
	
	
	// 调试用的数据
	private void getSchoolsTest() {

		

	}
	
	// 加载更多数据
	private void getInSchoolData(){
		
	}
	
	// 加载完跟多数据后关闭
	private class FinishReftesh extends AsyncTask<Void,Void,Void>{

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			mPullToRefreshListView.onRefreshComplete();
		}
		
	}
}
