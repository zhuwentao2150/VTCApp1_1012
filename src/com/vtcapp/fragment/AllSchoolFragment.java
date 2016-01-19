package com.vtcapp.fragment;



import java.util.ArrayList;
import java.util.List;

import com.example.vtcapp1_1012.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

import com.vtcapp.adapter.SchoolAdapter;

import com.vtcapp.bean.SchoolInfo;
import com.vtcapp.thread.FindSchoolThread;
import com.vtcapp.thread.SchoolThread;
import com.vtcapp.tools.Common;
import com.vtcapp.tools.JsonTools;
import com.vtcapp.ui.SchoolContentActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


// ȫ��ѧУ
public class AllSchoolFragment extends Fragment{
	
	private int startRows=0;
	private EditText edt_findschool;
	private Button btn_findschool;
	
	private SchoolAdapter schAdapter;
	private ListView mlistview;
	// ������л�ȡ����ѧУ��Ϣ
	private List<SchoolInfo>  schoolInfos = new ArrayList<SchoolInfo>();
	private PullToRefreshListView mPullToRefreshListView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_school, container, false);
		
		// ��ʼ���ؼ�
		edt_findschool = (EditText) view.findViewById(R.id.edt_findschool);
		btn_findschool = (Button) view.findViewById(R.id.btn_findschool);
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.lv_school);
		mlistview = mPullToRefreshListView.getRefreshableView();
		schAdapter = new SchoolAdapter(schoolInfos, getActivity());
		// ������ȡ���ݵ��߳�
		new SchoolThread(handler, Common.URL_GET_SCHOOL, startRows).start();
		
		mlistview.setAdapter(schAdapter);
		
		mPullToRefreshListView.setMode(Mode.PULL_FROM_END);
		// ���������¼�
		mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				if(refreshView.isHeaderShown()){
					// ����ˢ��,��Mode����ΪPULL_FROM_END��ʱ��ִ��
				}else{
					new SchoolThread(handler, Common.URL_GET_SCHOOL, startRows).start();
					schAdapter.notifyDataSetChanged();
					// ˢ�����ر�
					new FinishReftesh().execute();
				}
			}
		});
		
		btn_findschool.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = edt_findschool.getText().toString();
				if(!name.equals("")){
					new FindSchoolThread(handler, Common.URL_GET_FINDSCHOOL, name).start();
				}else{
					Toast.makeText(getActivity(), "��������Ҫ��ѯ��У��", 0).show();
					if(schAdapter.getCount() <= 0){
						new SchoolThread(handler, Common.URL_GET_SCHOOL, startRows).start();
					}
				}
			}
		});
		
		
		
		
		// ���õ������
		mlistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// ��ת������ҳ��
				Intent intent = new Intent(getActivity(), SchoolContentActivity.class);
				intent.putExtra("xz_school", schoolInfos.get((int)id));
				startActivity(intent);
			}
		});
		
		
		
		return view;
		
		
	}

	
	
	private Handler handler = new Handler(){
		
		public void handleMessage(android.os.Message msg) {
			
			if(msg.what == Common.MSG_GET_SCHOOL){
				String json = (String) msg.obj;
				if(json == ""){
					
				}else{
					List<SchoolInfo> schools = new ArrayList<SchoolInfo>();
					schools = JsonTools.parseSchoolJson(json);
					for(int i=0; i<schools.size(); i++){
						schoolInfos.add(schools.get(i));
					}
					schAdapter.getSchoolData(schoolInfos);
					schAdapter.notifyDataSetChanged();
					startRows = schAdapter.getCount();
				}
			} else if(msg.what == Common.MSG_GET_FINDSCHOOL){
				String json = (String) msg.obj;
				if(json == ""){
					Toast.makeText(getActivity(), "���ӷ���������", 0).show();
				}else{
					schoolInfos = JsonTools.parseSchoolJson(json);
					schAdapter.getSchoolData(schoolInfos);
					schAdapter.notifyDataSetChanged();
					startRows = schAdapter.getCount();
				}
			}
			
		}
	};

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ������������ݺ�ر�
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
