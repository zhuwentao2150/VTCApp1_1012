package com.vtcapp.ui.other;

import java.util.ArrayList;
import java.util.List;

import com.example.vtcapp1_1012.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.vtcapp.adapter.StoryAdapter;
import com.vtcapp.bean.StoryInfo;
import com.vtcapp.widget.MenuTop;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class VocationStoryActivity extends Activity {

	private StoryAdapter mAdapter;
	private ListView mlistview;
	private PullToRefreshListView mPullToRefreshListView;
	
	private List<StoryInfo>  storyInfos = new ArrayList<StoryInfo>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vocationstory);
		MenuTop menutop = (MenuTop)findViewById(R.id.vocationstory_menutop);
		menutop.setTitleText("ְҵ����");
		
		mPullToRefreshListView = (PullToRefreshListView) findViewById(R.id.lv_vocationstory);
		mlistview = mPullToRefreshListView.getRefreshableView();
		mAdapter = new StoryAdapter(storyInfos, getApplicationContext());
		
		
		mlistview.setAdapter(mAdapter);
		
		mPullToRefreshListView.setMode(Mode.PULL_FROM_END);
		
		// �������������¼�
		mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				if(refreshView.isHeaderShown()){
					// ����ˢ��,��Mode����ΪPULL_FROM_END��ʱ��ִ��
				}else{
					// ����ˢ��
					for(int i=0; i<2; i++){
						storyInfos.add(new StoryInfo(i, "���±���"+i, "���ֻ�ǹ���"));
					}
					// ˢ������������
					mAdapter.notifyDataSetChanged();
					// ˢ�����ر�
					new FinishReftesh().execute();
				}
			}
		});
		
		
		// ���õ������
		mlistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// ��ת������ҳ��
				Intent intent = new Intent(getApplicationContext(), VocationStoryContentActivity.class);
				intent.putExtra("xz_story", storyInfos.get((int)id));
				startActivity(intent);

			}
		});
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
