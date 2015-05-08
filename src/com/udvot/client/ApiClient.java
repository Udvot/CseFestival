package com.udvot.client;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ApiClient {
	static AsyncHttpClient client = new AsyncHttpClient();
	private static String BASE_URL = "https://api.parse.com/1";

	public static void get(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), params, responseHandler);
	}

	public static void post(String url, RequestParams params,
			AsyncHttpResponseHandler responseHandler) {
		Log.e("udvot", "posting url + " +getAbsoluteUrl(url));
		client.post(getAbsoluteUrl(url), params, responseHandler);
	}
	public static void post(Context context,String url,StringEntity entity,AsyncHttpResponseHandler responseHandler) {
		
		client.post(context, getAbsoluteUrl(url), entity, "application/json", responseHandler);
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
	public static void addHeaderValue(String key, String value) {
		client.addHeader(key,value);
	}
	public static void removeHeaderValue(String key) {
		client.removeHeader(key);
	}
}
