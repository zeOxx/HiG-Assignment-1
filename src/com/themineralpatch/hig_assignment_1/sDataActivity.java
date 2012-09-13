package com.themineralpatch.hig_assignment_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.widget.Toast;

public class sDataActivity extends Activity {

	String username;
	EditText editMessage;
	Button sDataButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sdata);

		// Makes the edittext object
		editMessage = (EditText) findViewById(R.id.sDataTextMessage);
		// Defining the username string
		username = "Inge";
		// Makes the button object
		sDataButton = (Button) findViewById(R.id.sDataButton);

	}

	public void send(View v) {
		// Get the message from the message text box
		String textMessage = editMessage.getText().toString();

		// Make sure the fields are not empty
		if (textMessage.length() > 0) {
	          HttpClient client = new DefaultHttpClient();
	          String getURL = "http://gtl.hig.no/mobile/logging.php?user=" + username + "&data=" + textMessage;
	          HttpGet get = new HttpGet(getURL);
	          try {
				HttpResponse res = client.execute(get);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			
			// Display message if textbox is empty
			Toast.makeText(getApplicationContext(), "Field cannot be empty", Toast.LENGTH_SHORT).show();
		}
	}
}
