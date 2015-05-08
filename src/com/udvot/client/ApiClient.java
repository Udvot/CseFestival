package com.udvot.client;

import org.apache.http.Header;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ApiClient {
	static AsyncHttpClient client = new AsyncHttpClient();
	private static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

	public static void get(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), params, responseHandler);
	}

	public static void post(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		client.post(url, params, responseHandler);
	}

	public static void put() {
		
	}
	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}

	public static boolean setImageFromURL(String imageUrl, final ImageView iv) {
		client.get(imageUrl, new AsyncHttpResponseHandler() {
			@Override
		    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
		        // called when response HTTP status is "200 OK"
				Bitmap bitmap = BitmapFactory.decodeByteArray(response, 0, response.length);
				iv.setImageBitmap(bitmap);
				iv.refreshDrawableState();
		    }
			
		});
		return false;
	}
}
