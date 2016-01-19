package com.vtcapp.ui;


import com.example.vtcapp1_1012.R;

import com.vtcapp.fragment.AllSchoolFragment;
import com.vtcapp.fragment.ColSchoolFragment;
import com.vtcapp.fragment.InSchoolFragment;
import com.vtcapp.fragment.ZhaoSchoolFragment;
import com.vtcapp.widget.MenuTop;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SchoolActivity extends FragmentActivity implements OnCheckedChangeListener{
	
	private RadioGroup mradioGroup;
	
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	// ѧУ���
	private AllSchoolFragment allSchoolFragment;
//	// ������ѧУ
//	private InSchoolFragment inSchoolFragment;
	// ������Ϣ
	private ZhaoSchoolFragment zhaoSchoolFragment;
	// �ղص�ѧУ
	private ColSchoolFragment colSchoolFragment;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_allschool);
		MenuTop menutop = (MenuTop)findViewById(R.id.allschool_menutop);
		menutop.setTitleText("ѧУ��ȫ");
		
		mradioGroup=(RadioGroup) this.findViewById(R.id.allschool_rg);
		mradioGroup.setOnCheckedChangeListener(this);
		
		// �õ�һ����Ƭ������
		fragmentManager = this.getSupportFragmentManager();
		// ��ʼ׼���л�
		fragmentTransaction = fragmentManager.beginTransaction();
		allSchoolFragment = new AllSchoolFragment();
		fragmentTransaction.add(R.id.allschool_fl, allSchoolFragment);
		fragmentTransaction.show(allSchoolFragment);
		// ѡ���Fragment�����ύ
		fragmentTransaction.commit();
		
	}

	// �ײ���ť�ĵ���¼�
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		// �õ�һ����Ƭ������
		fragmentManager = this.getSupportFragmentManager();
		// ��ʼ׼���л�
		fragmentTransaction = fragmentManager.beginTransaction();
		
		if (allSchoolFragment != null) {
			fragmentTransaction.hide(allSchoolFragment);
		}
		if (zhaoSchoolFragment != null) {
			fragmentTransaction.hide(zhaoSchoolFragment);
		}
		if (colSchoolFragment != null) {
			fragmentTransaction.hide(colSchoolFragment);
		}
		
		
		switch (checkedId) {
		case R.id.allschool_rg_index:
			if (allSchoolFragment == null) {
				allSchoolFragment = new AllSchoolFragment();
				fragmentTransaction.add(R.id.allschool_fl, allSchoolFragment);
			}else {
				fragmentTransaction.show(allSchoolFragment);
			}
			break;
		case R.id.inschool_rg_bm:
			if (zhaoSchoolFragment == null) {
				zhaoSchoolFragment = new ZhaoSchoolFragment();
				fragmentTransaction.add(R.id.allschool_fl, zhaoSchoolFragment);
			}else {
				fragmentTransaction.show(zhaoSchoolFragment);
			}
			break;
		case R.id.colschool_rg_sc:
			if (colSchoolFragment == null) {
				colSchoolFragment = new ColSchoolFragment();
				fragmentTransaction.add(R.id.allschool_fl, colSchoolFragment);
			}else {
				fragmentTransaction.show(colSchoolFragment);
			}
			break;

		default:
			break;
		}
		
		
		// ѡ���Fragment�����ύ
		fragmentTransaction.commit();
	}
}
