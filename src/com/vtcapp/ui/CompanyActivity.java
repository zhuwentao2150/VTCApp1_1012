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

// 企业招聘
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
		menutop.setTitleText("企业招聘");
		
		mradioGroup=(RadioGroup) this.findViewById(R.id.company_rg);
		mradioGroup.setOnCheckedChangeListener(this);
		
		
		
		// 得到一个碎片管理器
		fragmentManager = this.getSupportFragmentManager();
		// 开始准备切换
		fragmentTransaction = fragmentManager.beginTransaction();
		allCompanyFragment = new AllCompanyFragment();
		fragmentTransaction.add(R.id.company_fl, allCompanyFragment);
		fragmentTransaction.show(allCompanyFragment);
		// 选择好Fragment进行提交
		fragmentTransaction.commit();
		
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub

		// 得到一个碎片管理器
		fragmentManager = this.getSupportFragmentManager();
		// 开始准备切换
		fragmentTransaction = fragmentManager.beginTransaction();
		
		// 让fragment有动画切换效果，突出渐进效果
		// fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		
		// 自定义动画效果：
		// 参数：1、事务加入fragment的时候。2、事务移除或者替换了某个fragment时触发
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
		
		
		

		// 选择好Fragment进行提交
		fragmentTransaction.commit();
		
	}
}
