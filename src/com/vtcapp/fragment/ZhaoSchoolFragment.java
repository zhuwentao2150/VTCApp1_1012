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
import android.widget.ProgressBar;

public class ZhaoSchoolFragment extends Fragment{
	
	private WebView webview;
	private ProgressBar progressBar;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_zhaoschool, container, false);

		progressBar = (ProgressBar) view.findViewById(R.id.zhaoschoolweb_pb);
		webview = (WebView) view.findViewById(R.id.zhaoschool_webview);


		// 设置javascript可用
		webview.getSettings().setJavaScriptEnabled(true);
		//		webview.getSettings().setSupportZoom(true);	
		// 设置是否可以缩放
		//		webview.getSettings().setBuiltInZoomControls(true);
		// 无限缩放
		//		webview.getSettings().setUseWideViewPort(true);
		webview.loadUrl(Common.URL_NET_ZHAOSCHOOL);


		webview.setWebViewClient(new WebViewClient(){

			// 网页加载开始时调用，显示加载提示旋转进度条
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				progressBar.setVisibility(View.VISIBLE);
			}

			// 网页加载完成时调用，隐藏加载提示旋转进度条
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				progressBar.setVisibility(View.GONE);
			}

			// 网页加载失败时调用，隐藏加载提示旋转进度条
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
