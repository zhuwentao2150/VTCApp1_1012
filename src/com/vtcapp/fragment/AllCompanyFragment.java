package com.vtcapp.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.vtcapp1_1012.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.vtcapp.adapter.CompanyAdapter;
import com.vtcapp.adapter.SchoolAdapter;
import com.vtcapp.bean.CompanyInfo;
import com.vtcapp.thread.CompanyThread;
import com.vtcapp.tools.Common;
import com.vtcapp.tools.JsonTools;
import com.vtcapp.ui.CompanyContentActivity;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class AllCompanyFragment extends Fragment{

	private int startRows=0;
	
	private CompanyAdapter comAdapter;
	
	private ListView mlistview;
	private List<CompanyInfo>  companyinfos = new ArrayList<CompanyInfo>();
	private PullToRefreshListView mPullToRefreshListView;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_allcompany, container, false);
		
		
		
		// 初始化控件
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.lv_allcompany);
		mlistview = mPullToRefreshListView.getRefreshableView();
		
		comAdapter = new CompanyAdapter(companyinfos, getActivity());
		// 启动获取数据的线程
		new CompanyThread(handler, Common.URL_GET_COMPANY, startRows).start();
		
		mlistview.setAdapter(comAdapter);
		
		mPullToRefreshListView.setMode(Mode.PULL_FROM_END);
		
		
		// 设置上拉事件
		mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub

				if(refreshView.isHeaderShown()){
					// 下拉刷新,当Mode设置为PULL_FROM_END的时候不执行
				}else{
					new CompanyThread(handler, Common.URL_GET_COMPANY, startRows).start();
					// 刷新完后关闭
					new FinishReftesh().execute();
				}
			}
		});
		
		
		// 设置点击事件监听
		mlistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// 跳转到内容页面
				Intent intent = new Intent(getActivity(), CompanyContentActivity.class);
				intent.putExtra("xz_company", companyinfos.get((int)id));
				startActivity(intent);
			}
		});
		
		
		return view;
	}


	private Handler handler = new Handler(){

		public void handleMessage(android.os.Message msg) {
			if(msg.what == Common.MSG_GET_COMPANY){
				String json = (String) msg.obj;
				if(json == ""){
					System.out.println("数据为空");
				}else{
					List<CompanyInfo> companys = new ArrayList<CompanyInfo>();
					companys = JsonTools.parseCompanyJson(json);
					for(int i=0; i<companys.size(); i++){
						companyinfos.add(companys.get(i));
					}
					comAdapter.getCompanyData(companyinfos);
					comAdapter.notifyDataSetChanged();
					startRows = comAdapter.getCount();
				}
			}
		}
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
