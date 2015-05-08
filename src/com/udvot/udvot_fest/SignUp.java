package com.udvot.udvot_fest;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.udvot.client.ApiClient;
import com.udvot.client.Resource;

public class SignUp extends Activity implements OnClickListener {
	private Button bSignUp;
	private EditText etUserName, etEmail, etPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_signup);
		initialize();
	}

	private void initialize() {
		bSignUp = (Button) findViewById(R.id.bSignUp);
		etUserName = (EditText) findViewById(R.id.etUserNameSignUp);
		etEmail = (EditText) findViewById(R.id.etEmailSignUp);
		etPassword = (EditText) findViewById(R.id.etPasswordSignUp);
		bSignUp.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.bSignUp) {
			boolean shouldProceed = true;
			String userName = etUserName.getText().toString();
			String eMail = etEmail.getText().toString();
			String password = etPassword.getText().toString();
			if (userName.equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please enter a user name", Toast.LENGTH_SHORT).show();
				shouldProceed = false;
			}
			if (eMail.equals("")) {
				Toast.makeText(getApplicationContext(), "Please enter a email",
						Toast.LENGTH_SHORT).show();
				shouldProceed = false;
			}
			if (password.equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please enter a passworrd", Toast.LENGTH_SHORT).show();
				shouldProceed = false;
			}
			if (shouldProceed) {
				Toast.makeText(getApplicationContext(), "Trying",
						Toast.LENGTH_SHORT).show();
				ApiClient.addHeaderValue(Resource.APP_ID_KEY,
						Resource.APP_ID_VALUE);
				ApiClient.addHeaderValue(Resource.CONTENT_TYPE_KEY,
						Resource.CONTENT_TYPE_VALUE);
				ApiClient.addHeaderValue(Resource.REST_API_KEY,
						Resource.REST_API_VALUE);

				// RequestParams params = new RequestParams();
				// params.add("email", eMail);
				// params.add("password", password);
				// params.add("username", userName);
				try {
					JSONObject params = new JSONObject();
					params.put("email", eMail);
					params.put("password", password);
					params.put("username", userName);
					StringEntity entity;
					entity = new StringEntity(params.toString());
					ApiClient.post(getApplicationContext(), "/users", entity,
							new JsonHttpResponseHandler() {
								@Override
								public void onFailure(int statusCode,
										Throwable e, JSONObject errorResponse) {
									Toast.makeText(
											getApplicationContext(),
											"Failed "
													+ errorResponse.toString(),
											Toast.LENGTH_SHORT).show();
									Log.d("udvot", errorResponse.toString());
								};

								@Override
								public void onSuccess(int statusCode,
										Header[] headers, JSONObject response) {
									try {
										String userName = response
												.getString("username");
										String sessionToken = response
												.getString("sessionToken");
										Toast.makeText(
												getApplicationContext(),
												"User Name "
														+ userName
														+ " created sucessfully",
												Toast.LENGTH_SHORT).show();
										Resource.SESSOIN_TOKEN_VALUE = sessionToken;
										Toast.makeText(
												getApplicationContext(),
												"Session "
														+ Resource.SESSOIN_TOKEN_VALUE,
												Toast.LENGTH_SHORT).show();
										Intent intent=new Intent(SignUp.this,Show_Product_Activity.class);
										startActivity(intent);
										finish();
									} catch (JSONException e1) {
										e1.printStackTrace();
										try {
											String code = response
													.getString("code");
											Toast.makeText(
													getApplicationContext(),
													"Error code" + code,
													Toast.LENGTH_SHORT).show();
										} catch (JSONException e) {
											e.printStackTrace();
											Toast.makeText(
													getApplicationContext(),
													"Big error",
													Toast.LENGTH_SHORT).show();
										}
									}
								};
							});
				} catch (UnsupportedEncodingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (JSONException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}
	}
}
