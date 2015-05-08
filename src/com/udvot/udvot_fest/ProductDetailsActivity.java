package com.udvot.udvot_fest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends Activity {
	
	TextView productName, productDecription, productPrice;
	ImageView productImage;
	EditText productQuantity;
	Button addToCart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.productdescription);
		initialize();
		
	}

	private void initialize() {
		// TODO Auto-generated method stub
		productName = (TextView)findViewById(R.id.tvName);
		productDecription = (TextView)findViewById(R.id.tvDesc);
		productPrice  = (TextView)findViewById(R.id.tvPrice);
		productImage = (ImageView)findViewById(R.id.imgProduct);
		productQuantity = (EditText) findViewById(R.id.etQuantity);
		addToCart = (Button) findViewById(R.id.bAddToCart);
		addToCart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent i = new Intent(ProductDetailsActivity.this, V)
			}
		});
	}
	

}
