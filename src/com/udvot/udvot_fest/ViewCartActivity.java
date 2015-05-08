package com.udvot.udvot_fest;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.udvot.adapters.CustomListAdapter;
import com.udvot.client.ApiClient;
import com.udvot.client.Resource;
import com.udvot.utils.Product;

public class ViewCartActivity extends Activity {
	ListView list;
	String[] productName, thumbImage, price, quantity; // = new String[100];
	ArrayList<Product> products = new ArrayList<Product>();
	ImageButton searchButton ; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_cart);
		list = (ListView) findViewById(R.id.product_list);
		// initialize();
		fetchProducts();
		searchButton = (ImageButton) findViewById(R.id.imgBtSearch);
		searchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void enumarateArrays() {
		if (products.size() == 0) {
			Toast.makeText(getApplicationContext(), "This is what I expected",
					Toast.LENGTH_SHORT).show();
		} else {
			int length = products.size();
			productName = new String[length];
			thumbImage = new String[length];
			price = new String[length];
			for(int i = 0 ; i < length ; i++)
			{
				Product p = products.get(i);
				productName[i] = p.getProductName();
				thumbImage[i] = p.getThumbImage();
				price[i] = p.getPrice();
			}
			

		}
	}

	private void fetchProducts() {
		Toast.makeText(getApplicationContext(), "Fetching...",
				Toast.LENGTH_SHORT).show();
		ApiClient.addHeaderValue(Resource.APP_ID_KEY, Resource.APP_ID_VALUE);
		ApiClient.addHeaderValue(Resource.CONTENT_TYPE_KEY,
				Resource.CONTENT_TYPE_VALUE);
		ApiClient
				.addHeaderValue(Resource.REST_API_KEY, Resource.REST_API_VALUE);

		String url = "/classes/Product?skip=0&limit=20";
		ApiClient.get(url, null, new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				try {
					JSONArray results = response.getJSONArray("results");
					for (int i = 0; i < results.length(); i++) {
						JSONObject temp = results.getJSONObject(i);
						String pName = temp.getString("name");
						String price = temp.getString("price");
						String thumbURL = temp.getString("thumbURL");
						String imageURL = temp.getString("imageURL");
						String description = temp.getString("description");
						Product p = new Product(pName, thumbURL, price,imageURL,description);
						products.add(p);
					}
					enumarateArrays();
					CustomListAdapter adapter = new CustomListAdapter(ViewCartActivity.this, productName,thumbImage, price);
					list.setAdapter(adapter);
					list.setOnItemClickListener(listListener);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		// TODO Auto-generated method stub
		productName = new String[5];
		thumbImage = new String[5];
		price = new String[5];
		for (int i = 0; i < 5; i++) {
			productName[i] = "A";
			thumbImage[i] = "http://online-kenakata.com/uploads/products_compressed/"
					+ "products_1898_01378483961_212x159.jpg";
			price[i] = "100";
		}

	}

	public OnItemClickListener listListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			Long i=arg3;
			Product p=products.get(i.intValue());
			String des=p.getDescription();
			String pricce=p.getPrice();
			String name=p.getProductName();
			String imgaUrl=p.getImageURL();
			Intent intent=new Intent(ViewCartActivity.this,ProductDetailsActivity.class);
			intent.putExtra("Name",name);
			intent.putExtra("Price",pricce);
			intent.putExtra("ImageUrl",imgaUrl);
			intent.putExtra("Description", des);
			startActivity(intent);
			Log.i("Udvot", "ListItem Clicked");
		}
	};

}
