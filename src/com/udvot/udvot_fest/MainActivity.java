package com.udvot.udvot_fest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{
	EditText username,password;
	Button login,signup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.login);
		username=(EditText)findViewById(R.id.usernameeditText);
		
		password=(EditText)findViewById(R.id.passwordeditText);
		
		login=(Button)findViewById(R.id.loginbutton);
		login.setOnClickListener(this);
		signup=(Button)findViewById(R.id.signbutton);
		signup.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		switch(id)
		{
		case R.id.loginbutton:
			//check login
			Intent i1 = new Intent(this, Show_Product_Activity.class);
			startActivity(i1);
			break;
		case R.id.signbutton:
			//sign up
			Intent i = new Intent(MainActivity.this, SignUp.class);
			startActivity(i);
			break;
			
		}
	}

}
