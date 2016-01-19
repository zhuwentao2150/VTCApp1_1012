package com.vtcapp.config;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesConfig {
	Context context;
	SharedPreferences shared;
	public SharedPreferencesConfig(Context context){
		this.context=context;
		shared=context.getSharedPreferences("config", Context.MODE_PRIVATE);
	}
	public SharedPreferences GetConfig(){
		return shared;
	}
	public void ClearConfig(){
		shared.edit().clear().commit();
	}
}
