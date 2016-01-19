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

// �μ�ѧУ
public class InSchoolFragment extends Fragment{
	
	private InSchoolAdapter inAdapter;
	private ListView mlistview;
	// ������л�ȡ����ѧУ��Ϣ
	private List<SchoolInfo>  inschoolInfos = new ArrayList<SchoolInfo>();
	
	
	private PullToRefreshListView mPullToRefreshListView;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//����������ã���xml�ļ����java�ļ��е�һ��view
		View view = inflater.inflate(R.layout.fragment_inschool, container, false);

		// �����õ�����
		getSchoolsTest();

		// ��ʼ���ؼ�
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.lv_inschool);
		mlistview = mPullToRefreshListView.getRefreshableView();
		inAdapter = new InSchoolAdapter(inschoolInfos, getActivity());
		
		mlistview.setAdapter(inAdapter);
		
		// ����pull-to-refreshģʽΪMode.Both����ģʽΪ������Ҳ������
		// Mode.PULL_FROM_START��ֻ֧������Pulling Down
		// Mode.PULL_FROM_END��ֻ֧������Pulling Up
		mPullToRefreshListView.setMode(Mode.PULL_FROM_END);
		
		// �������������¼�
		mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				if(refreshView.isHeaderShown()){
					// ����ˢ��,��Mode����ΪPULL_FROM_END��ʱ��ִ��
				}else{
				
					// ˢ������������
					inAdapter.notifyDataSetChanged();
					// ˢ�����ر�
					new FinishReftesh().execute();
				}
			}
		});
		
		
		return view;
	}
	
	
	// �����õ�����
	private void getSchoolsTest() {

		

	}
	
	// ���ظ�������
	private void getInSchoolData(){
		
	}
	
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
