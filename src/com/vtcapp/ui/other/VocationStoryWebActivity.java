package com.vtcapp.ui.other;

import com.example.vtcapp1_1012.R;
import com.vtcapp.tools.Common;
import com.vtcapp.widget.MenuTop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class VocationStoryWebActivity extends Activity{

	private WebView webview;
	private ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vocationstoryweb);
		MenuTop menutop = (MenuTop)findViewById(R.id.vocationstoryweb_menutop);
		menutop.setTitleText("ְҵ����");
		
		progressBar = (ProgressBar) findViewById(R.id.vocweb_pb);
		webview = (WebView) findViewById(R.id.webview);
		// ����javascript����
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl(Common.URL_NET_VOCSTORY);
		
		webview.setWebViewClient(new WebViewClient(){
			
			// ��ҳ���ؿ�ʼʱ���ã���ʾ������ʾ��ת������
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				progressBar.setVisibility(View.VISIBLE);
			}
			
			// ��ҳ�������ʱ���ã����ؼ�����ʾ��ת������
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				progressBar.setVisibility(View.GONE);
			}
			
			// ��ҳ����ʧ��ʱ���ã����ؼ�����ʾ��ת������
			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				super.onReceivedError(view, errorCode, description, failingUrl);
				progressBar.setVisibility(View.VISIBLE);
			}
		});
		
	}
	
}
