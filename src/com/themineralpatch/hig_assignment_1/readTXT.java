package com.themineralpatch.hig_assignment_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class readTXT extends Activity {
	
	String file = "ass1.txt";
	String text = null;
	
	TextView textview = (TextView) findViewById(R.id.readTXTdisplayFile);
	FileInputStream fis;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.readtxt);
		
		try {
			fis = openFileInput(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer("");
		
		byte[] buffer = new byte[1024];
		
		int length;
		try {
			while((length = fis.read(buffer)) != -1) {
				sb.append(new String(buffer));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		text = sb.toString();
		textview.setText(text);
		Toast.makeText(getApplicationContext(), "Text loaded from file",Toast.LENGTH_LONG).show();
		
	}

		
}
