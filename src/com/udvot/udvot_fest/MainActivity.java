package com.udvot.udvot_fest;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.udvot.client.ApiClient;
import com.udvot.client.Resource;

public class MainActivity extends Activity implements OnClickListener {
	EditText etUsername, etPassword;
	Button bLogin, bSignup, bViewProduct;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.login);
		etUsername = (EditText) findViewById(R.id.usernameeditText);

		etPassword = (EditText) findViewById(R.id.passwordeditText);

		bLogin = (Button) findViewById(R.id.loginbutton);
		bLogin.setOnClickListener(this);
		bSignup = (Button) findViewById(R.id.signbutton);
		bSignup.setOnClickListener(this);
		bViewProduct = (Button) findViewById(R.id.bViewProduct);
		bViewProduct.setOnClickListener(this);

	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id=item.getItemId();
		switch(id)
		{
		case R.id.view_cart:
			break;
		case R.id.logout_menu:
			
			break;
		}
		
		
		return super.onOptionsItemSelected(item);
		
		
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.loginbutton:
			// check login
			boolean isOk = true;
			String userName = etUsername.getText().toString();
			String password = etPassword.getText().toString();
			if (userName.equals("")) {
				Toast.makeText(getApplicationContext(), "Invalid user name",
						Toast.LENGTH_SHORT).show();
				isOk = false;
			}
			if (password.equals("")) {
				Toast.makeText(getApplicationContext(), "Invalid user name",
						Toast.LENGTH_SHORT).show();
				isOk = false;
			}
			if (isOk) {
				Toast.makeText(getApplicationContext(), "Trying",
						Toast.LENGTH_SHORT).show();
				ApiClient.addHeaderValue(Resource.APP_ID_KEY,
						Resource.APP_ID_VALUE);
				ApiClient.addHeaderValue(Resource.CONTENT_TYPE_KEY,
						Resource.CONTENT_TYPE_VALUE);
				ApiClient.addHeaderValue(Resource.REST_API_KEY,
						Resource.REST_API_VALUE);

				String url = "/login?username=" + userName + "&password="
						+ password;
				ApiClient.get(url, null, new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(int statusCode, Header[] headers,
							JSONObject response) {
						try {
							String sessionToken = response.getString("sessionToken");
							String userName = response.getString("username");
							Toast.makeText(getApplicationContext(), "Welcome "+userName, Toast.LENGTH_SHORT).show();
							Resource.SESSOIN_TOKEN_VALUE = sessionToken;
							Toast.makeText(getApplicationContext(), "Session Id "+Resource.SESSOIN_TOKEN_VALUE, Toast.LENGTH_SHORT).show();
							
							Intent i1 = new Intent(MainActivity.this, Show_Product_Activity.class);
							startActivity(i1);
							finish();
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				});
			}else
			{
				Toast.makeText(getApplicationContext(), "Invalid Login", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.signbutton:
			// sign up
			Intent i = new Intent(MainActivity.this, SignUp.class);
			startActivity(i);
			finish();
			break;
		case R.id.bViewProduct:
			Intent i2 = new Intent(this, Show_Product_Activity.class);
			startActivity(i2);
			finish();
			break;

		}
	}

}
