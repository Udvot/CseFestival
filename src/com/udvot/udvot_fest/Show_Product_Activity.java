package com.udvot.udvot_fest;

import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.udvot.adapters.CustomListAdapter;

public class Show_Product_Activity extends Activity{
	ListView list;
	String[] productName, thumbImage, price; //= new String[100];
//	String [] thumbImage = new String[100];
	Vector<String> p = new Vector<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_list);
		list=(ListView)findViewById(R.id.product_list);
		initialize();
		CustomListAdapter adapter= new CustomListAdapter(this, productName, thumbImage, price);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(listListener);
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		productName = new String[5];
		thumbImage = new String[5];
		price = new String[5];
		for(int i=0;i<5;i++){
			productName[i] = "A";
			thumbImage[i] = "http://online-kenakata.com/uploads/products_compressed/"
					+ "products_1898_01378483961_212x159.jpg";
			price[i] = "100";
		}
		
	}

	public OnItemClickListener listListener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			// TODO Auto-generated method stub
			Log.i("Udvot", "ListItem Clicked");
		}
	};

}
