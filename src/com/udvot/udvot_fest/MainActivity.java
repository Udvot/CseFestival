package com.udvot.udvot_fest;

import android.app.Activity;
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
<<<<<<< HEAD
		
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
			break;
		case R.id.signbutton:
			//sign up
			break;
			
		}
=======
		setContentView(R.layout.activity_main);
		
>>>>>>> 196a9773223ab681ce80ce6dc8caf60d343239b4
	}

}
