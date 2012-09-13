package com.themineralpatch.hig_assignment_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class rDataActivity extends Activity{
	
	String audioUrl = "http://www.themineralpatch.net/files/Terran_ScannerSweep.m4a";
	String textUrl = "http://www.themineralpatch.net/test/ass1.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rdata);
		
		// Setting up the text retrieval button and creating a listener that spawns a dialog.
		Button dataButton = (Button)findViewById(R.id.rDataButton);
		
		/*dataButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				TextView textView = (TextView) findViewById(R.id.rDataTextDisplay);
				DefaultHttpClient httpclient = new DefaultHttpClient();
				
				HttpGet httppost = new HttpGet(textUrl);
				HttpResponse response = httpclient.execute(httppost);
		        HttpEntity ht = response.getEntity();

		        BufferedHttpEntity buf = new BufferedHttpEntity(ht);

		        InputStream is = buf.getContent();


		        BufferedReader r = new BufferedReader(new InputStreamReader(is));

		        StringBuilder total = new StringBuilder();
		        String line;
		        while ((line = r.readLine()) != null) {
		            total.append(line + "\n");
		        }

		        textView.setText(total);
			}
		});*/
		
		// Setting up the audio playback button and creating a listener.
		Button audioButton = (Button)findViewById(R.id.rAudioButton);
		
		audioButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				MediaPlayer mediaPlayer = new MediaPlayer();
				mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
				
				// Protection since the file might not exist
				try {
					mediaPlayer.setDataSource(audioUrl);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					mediaPlayer.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				mediaPlayer.start();
				
			}
		});
	}
}
