package com.vtcapp.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vtcapp1_1012.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.vtcapp.ResideMenu.ResideMenu;
import com.vtcapp.adapter.ColSchoolAdapter;
import com.vtcapp.bean.SchoolInfo;
import com.vtcapp.db.SchoolSqlHelper;
import com.vtcapp.ui.MainActivity;
import com.vtcapp.ui.SchoolColContentActivity;
import com.vtcapp.ui.SchoolContentActivity;

public class ColSchoolFragment extends Fragment{

	private ColSchoolAdapter colAdapter;
	private ListView mlistview;
	// 存放所有获取到的学校信息
	private List<SchoolInfo>  colschoolInfos = new ArrayList<SchoolInfo>();
	private SchoolSqlHelper schSqlHelper;
	
	private PullToRefreshListView mPullToRefreshListView;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_colschool, container, false);
		
		schSqlHelper = new SchoolSqlHelper(getActivity());
		colschoolInfos =  schSqlHelper.getSchoolSqlData();
		
		
		// 初始化控件
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.lv_colschool);
		mlistview = mPullToRefreshListView.getRefreshableView();
		colAdapter = new ColSchoolAdapter(colschoolInfos, getActivity());
		
		mlistview.setAdapter(colAdapter);
		
		
		mPullToRefreshListView.setMode(Mode.PULL_FROM_END);


		// 设置上拉事件
		mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				if(refreshView.isHeaderShown()){
					// 下拉刷新,当Mode设置为PULL_FROM_END的时候不执行
				}else{
					// 刷新适配器数据
					colAdapter.notifyDataSetChanged();
					// 刷新完后关闭
					new FinishReftesh().execute();
				}
			}
		});
		
		mlistview.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					final int position, final long id) {
				new AlertDialog.Builder(getActivity())
				.setTitle("操作选项")
				.setItems(new CharSequence[]{"删除"}, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						case 0:
							schSqlHelper.delete(colschoolInfos.get(position-1));
							Toast.makeText(getActivity(), "删除成功", 0).show();
							gengxinData();
							break;
						default:
							break;
						}
					}
				}).setNegativeButton("取消", null).show();
				return true;
			}
		});
		mlistview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// 跳转到内容页面
				Intent intent = new Intent(getActivity(), SchoolColContentActivity.class);
				intent.putExtra("sc_school", colschoolInfos.get((int)id));
				startActivity(intent);
			}
		});

		
		return view;
		
	}
	
	

	public void gengxinData(){
		colschoolInfos =  schSqlHelper.getSchoolSqlData();
		colAdapter.getColSchoolData(colschoolInfos);
		mlistview.setAdapter(colAdapter);
		colAdapter.notifyDataSetChanged();
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		gengxinData();
	}
	
	
	// 加载完更多数据后关闭
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
