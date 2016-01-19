package com.vtcapp.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class HttpUtil{
	/**
	 * POST�����ύHTTP���󣬷�������Ľ��
	 * 
	 * @param url
	 * @param params
	 * @return ������
	 * @throws IOException
	 */
	public static String sendPost(String url, String params) throws IOException {
		StringBuffer result = new StringBuffer();

		// ����URL����
		URL _url = new URL(url);
		// ����HTTP����
		/**
		 * ʹ��.openConnection()����ʵ����һ��URLConnection����
		 * */
		HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
		
		// ���������������ӵ���ز���
		/* ʹ��POST�����������󴫵�ʱ�����붨��setDoInput��setDoOutput���� */
		// �����������
		conn.setDoInput(true);
		// �����������
		conn.setDoOutput(true);

		// ���ò�ʹ�û���
		conn.setUseCaches(false);
		// �������ӳ�ʱ��ʱ�� - 5s
		conn.setConnectTimeout(5000);
		// ���ö�ȡ��ʱ��ʱ�� - 5s
		conn.setReadTimeout(5000);
		// ����HTTP����ķ��� - POST
		conn.setRequestMethod("POST");
		// ����HTTP�������� - ���ӷ�ʽ������
		conn.setRequestProperty("Connection", "Keep-Alive");
		// ����HTTP�������� - �ַ�����UTF-8
		conn.setRequestProperty("Charset", "UTF-8");
		// ����HTTP�������� - �������ݵ����� - �򵥱�
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		// ����HTTP�������� - �������ݵĳ���
		conn.setRequestProperty("Content-Length",
				String.valueOf(params.length()));
		// ����HTTP�������� - �û�����
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.3; WOW64; rv:27.0) Gecko/20100101 Firefox/27.0");
		// ���Ͳ��� �������ַ�����������
		PrintWriter pw = new PrintWriter(conn.getOutputStream());
		pw.write(params);
		pw.flush();
		pw.close();
		// ��ȡ���صĽ��
		if (200 == conn.getResponseCode()) {// �ж�״̬��
			// ��ȡ���������ص� ��� - �ַ���
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			// ÿ�ζ�ȡһ��
			String line;
			while((line = br.readLine()) != null){
				result.append(line);
			}
		}
		// �ر�HTTP����
		conn.disconnect();
		return result.toString();
	}

	/**
	 * GET�����ύHTTP���󣬷�������Ľ��
	 * @param url
	 * @return ����Ľ��
	 * @throws IOException
	 */
	public static String sendGet(String url) throws IOException {

		StringBuffer result = new StringBuffer();
		// ����URL����
		URL _url = new URL(url);
		// ����HTTP����
		HttpURLConnection conn = (HttpURLConnection) _url.openConnection();
		// �����������ӵ���ز���
		// �����������
		conn.setDoInput(true);
		// �����������
		conn.setDoOutput(true);
		// ���ò�ʹ�û���
		conn.setUseCaches(false);
		// �������ӳ�ʱ��ʱ�� - 5s
		conn.setConnectTimeout(5000);
		// ���ö�ȡ��ʱ��ʱ�� - 5s
		conn.setReadTimeout(5000);
		// ����HTTP����ķ��� - GET
		conn.setRequestMethod("GET");
		// ����HTTP�������� - ���ӷ�ʽ������
		conn.setRequestProperty("Connection", "Keep-Alive");
		// ����HTTP�������� - �ַ�����UTF-8
		conn.setRequestProperty("Charset", "UTF-8");
		// ����HTTP�������� - �û�����
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.3; WOW64; rv:27.0) Gecko/20100101 Firefox/27.0");
		// ��ȡ���صĽ��
		if (200 == conn.getResponseCode()) {// �ж�״̬��
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			// ÿ�ζ�ȡһ��
			String line;
			while((line = br.readLine()) != null){
				result.append(line);
			}
		}
		// �ر�HTTP����
		conn.disconnect();
		return result.toString();
	}
}
