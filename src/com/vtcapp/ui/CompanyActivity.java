package com.vtcapp.ui;

import com.example.vtcapp1_1012.R;
import com.vtcapp.fragment.AllCompanyFragment;
import com.vtcapp.fragment.AllSchoolFragment;
import com.vtcapp.fragment.ColCompanyFragment;
import com.vtcapp.widget.MenuTop;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

// ��ҵ��Ƹ
public class CompanyActivity extends FragmentActivity implements OnCheckedChangeListener {
	
	private RadioGroup mradioGroup;
	private FragmentManager fragmentManager;
	private FragmentTransaction fragmentTransaction;
	private AllCompanyFragment allCompanyFragment;
	private ColCompanyFragment colCompanyFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company);
		MenuTop menutop = (MenuTop)findViewById(R.id.company_menutop);
		menutop.setTitleText("��ҵ��Ƹ");
		
		mradioGroup=(RadioGroup) this.findViewById(R.id.company_rg);
		mradioGroup.setOnCheckedChangeListener(this);
		
		
		
		// �õ�һ����Ƭ������
		fragmentManager = this.getSupportFragmentManager();
		// ��ʼ׼���л�
		fragmentTransaction = fragmentManager.beginTransaction();
		allCompanyFragment = new AllCompanyFragment();
		fragmentTransaction.add(R.id.company_fl, allCompanyFragment);
		fragmentTransaction.show(allCompanyFragment);
		// ѡ���Fragment�����ύ
		fragmentTransaction.commit();
		
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub

		// �õ�һ����Ƭ������
		fragmentManager = this.getSupportFragmentManager();
		// ��ʼ׼���л�
		fragmentTransaction = fragmentManager.beginTransaction();
		
		// ��fragment�ж����л�Ч����ͻ������Ч��
		// fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		
		// �Զ��嶯��Ч����
		// ������1���������fragment��ʱ��2�������Ƴ������滻��ĳ��fragmentʱ����
		// fragmentTransaction.setCustomAnimations(arg0, arg1);
		
		
		
		if (allCompanyFragment != null) {
			fragmentTransaction.hide(allCompanyFragment);
		}
		if (colCompanyFragment != null) {
			fragmentTransaction.hide(colCompanyFragment);
		}
		
		
		switch (checkedId) {
		case R.id.company_rg_index:
			if (allCompanyFragment == null) {
				allCompanyFragment = new AllCompanyFragment();
				fragmentTransaction.add(R.id.company_fl, allCompanyFragment);
			}else {
				fragmentTransaction.show(allCompanyFragment);
			}
			break;
		case R.id.company_rg_gz:
			if (colCompanyFragment == null) {
				colCompanyFragment = new ColCompanyFragment();
				fragmentTransaction.add(R.id.company_fl, colCompanyFragment);
			}else {
				fragmentTransaction.show(colCompanyFragment);
			}
			break;

		default:
			break;
		}
		
		
		

		// ѡ���Fragment�����ύ
		fragmentTransaction.commit();
		
	}
}
