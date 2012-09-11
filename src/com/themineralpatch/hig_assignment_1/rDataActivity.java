package com.themineralpatch.hig_assignment_1;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;

public class rDataActivity extends Activity{
	
	String audioUrl = "http://www.themineralpatch.net/files/Terran_ScannerSweep.m4a";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rdata);
		
		// Setting up the text retrieval button and creating a listener that spawns a dialog.
		
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
