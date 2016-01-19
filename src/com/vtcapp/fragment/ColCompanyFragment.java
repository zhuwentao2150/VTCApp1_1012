package com.vtcapp.fragment;


import com.example.vtcapp1_1012.R;
import com.vtcapp.tools.Common;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.ProgressBar;

public class ColCompanyFragment extends Fragment{

	private WebView webview;
	private ProgressBar progressBar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_colcompany, container, false);
		
		progressBar = (ProgressBar) view.findViewById(R.id.colcompany_pb);
		webview = (WebView) view.findViewById(R.id.colcompany_webview);

		// ����javascript����
		webview.getSettings().setJavaScriptEnabled(true);
		
		webview.loadUrl(Common.URL_NET_COLCOMP);
		
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
		

		return view;
		
	}
	
}
