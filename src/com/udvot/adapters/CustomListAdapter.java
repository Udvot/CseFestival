package com.udvot.adapters;

//import android.R;
import org.apache.http.Header;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.udvot.client.ApiClient;
import com.udvot.udvot_fest.R;

public class CustomListAdapter extends ArrayAdapter<String>{
	
	
	private final Activity context;
	String[] name,thumbUrl, price;
	
	public CustomListAdapter(Activity context,String[] name, String[] thumburl, String price[]) {		
		super(context, R.layout.product_list_item, name);
		this.context = context;
		this.name = name;
		this.thumbUrl = thumburl;
		this.price = price;
		// TODO Auto-generated constructor stub
	}

	
	public class Holder
    {
        TextView product_name;
        TextView price;
        ImageView thumb_img;
    }
	@Override
	public View getView(int position, View view, ViewGroup parent) {
	
		LayoutInflater inflater = context.getLayoutInflater();
		Holder holder=new Holder();
		View rowView= inflater.inflate(R.layout.product_list_item, null,true);
		holder.product_name = (TextView) rowView.findViewById(R.id.name_textView);
		holder.price = (TextView) rowView.findViewById(R.id.tvPrice);
//		holder.atv=(TextView) rowView.findViewById(R.id.textView2);
		holder.thumb_img = (ImageView) rowView.findViewById(R.id.listimageView);
		holder.product_name.setText(name[position]);
		holder.price.setText("Price : "+ price[position]);
		ApiClient.setImageFromURL(thumbUrl[position], holder.thumb_img);
//		holder.atv.setText(address[position]);
		//holder.thumb_img.setImageResource();
		return rowView;
	}
	
	

}
