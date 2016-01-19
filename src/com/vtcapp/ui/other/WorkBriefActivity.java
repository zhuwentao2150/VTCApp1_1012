package com.vtcapp.ui.other;

import com.example.vtcapp1_1012.R;
import com.vtcapp.fragment.AllSchoolFragment;
import com.vtcapp.fragment.ColSchoolFragment;
import com.vtcapp.fragment.InSchoolFragment;
import com.vtcapp.tools.TextUtil;
import com.vtcapp.widget.FlowRadioGroup;
import com.vtcapp.widget.MenuTop;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class WorkBriefActivity extends Activity implements OnCheckedChangeListener{
	
	private FlowRadioGroup mradioGroup;
	private TextView mtvworkbrief;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workbrief);
		MenuTop menutop = (MenuTop)findViewById(R.id.workbrief_menutop);
		menutop.setTitleText("职业介绍");
		
		mtvworkbrief = (TextView) findViewById(R.id.tv_workbrief_brief);
		mtvworkbrief.setText("职业简介");
		mtvworkbrief.setMovementMethod(ScrollingMovementMethod.getInstance());
		
		
		mradioGroup = (FlowRadioGroup) this.findViewById(R.id.rg_workbrief);
		mradioGroup.setOnCheckedChangeListener(this);
		
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		
		switch (checkedId) {
		case R.id.rg_workbrief_01:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_01);
			break;
		case R.id.rg_workbrief_02:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_02);
			break;
		case R.id.rg_workbrief_03:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_03);
			break;
		case R.id.rg_workbrief_04:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_04);
			break;
		case R.id.rg_workbrief_05:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_05);
			break;
		case R.id.rg_workbrief_06:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_06);
			break;
		case R.id.rg_workbrief_07:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_07);
			break;
		case R.id.rg_workbrief_08:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_08);
			break;
		case R.id.rg_workbrief_09:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_09);
			break;
		case R.id.rg_workbrief_10:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_10);
			break;
		case R.id.rg_workbrief_11:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_11);
			break;
		case R.id.rg_workbrief_12:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_12);
			break;
		case R.id.rg_workbrief_13:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_13);
			break;
		case R.id.rg_workbrief_14:
			mtvworkbrief.setText(TextUtil.WORK_BRIE_14);
			break;

		default:
			break;
		}
	}
}
