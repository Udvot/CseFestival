package com.udvot.udvot_fest;

import com.udvot.client.ApiClient;
import com.udvot.client.Resource;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity{
	private Button bSignUp;
	private EditText etUserName,etEmail,etPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_signup);
		initialize();
	}
	private void initialize() {
		bSignUp = (Button)findViewById(R.id.bSignUp);
		etUserName = (EditText)findViewById(R.id.etUserNameSignUp);
		etEmail = (EditText)findViewById(R.id.etEmailSignUp);
		etPassword = (EditText)findViewById(R.id.etPasswordSignUp);
		bSignUp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v.getId()==R.id.bSignUp)
				{
					boolean shouldProceed = true;
					String userName = etUserName.getText().toString();
					String eMail = etEmail.getText().toString();
					String password = etPassword.getText().toString();
					if(userName.equals(""))
					{
						Toast.makeText(getApplicationContext(), "Please enter a user name", Toast.LENGTH_SHORT).show();
						shouldProceed = false;
					}
					if(eMail.equals(""))
					{
						Toast.makeText(getApplicationContext(), "Please enter a email", Toast.LENGTH_SHORT).show();
						shouldProceed = false;
					}
					if(password.equals(""))
					{
						Toast.makeText(getApplicationContext(), "Please enter a passworrd", Toast.LENGTH_SHORT).show();
						shouldProceed = false;
					}
					if(shouldProceed)
					{
						ApiClient.addHeaderValue(Resource.APP_ID_KEY, Resource.APP_ID_VALUE);
						ApiClient.addHeaderValue(Resource.CONTENT_TYPE_KEY, Resource.CONTENT_TYPE_VALUE);
						ApiClient.addHeaderValue(Resource.REST_API_KEY, Resource.REST_API_VALUE);
						
						
					}
				}
			}
		});
	}
}
