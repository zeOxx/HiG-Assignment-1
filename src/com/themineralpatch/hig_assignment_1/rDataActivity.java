package com.themineralpatch.hig_assignment_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class rDataActivity extends Activity {

	// Setting URL strings
	String audioUrl = "http://www.themineralpatch.net/files/Terran_ScannerSweep.m4a";
	String textUrl = "http://www.themineralpatch.net/test/ass1.txt";

	// Defining the TextView object that displays the downloaded text
	TextView textview;

	// Initializes the mediaplayer
	MediaPlayer mediaPlayer = new MediaPlayer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rdata);

		Button dataButton = (Button) findViewById(R.id.rDataButton);
		dataButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				new DownloadWebpageText().execute(textUrl);
			}
		});

		// Setting up the audio playback button and creating a listener.
		Button audioButton = (Button) findViewById(R.id.rAudioButton);

		audioButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

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

	/* Used with permission by Harry Nystad */
	private class DownloadWebpageText extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {

			// params comes from the execute() call: params[0] is the url.
			try {
				return downloadUrl(urls[0]);
			} catch (IOException e) {
				return "Unable to retrieve web page. URL may be invalid.";
			}
		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			textview = (TextView) findViewById(R.id.rDataTextDisplay);
			textview.setText(result);
		}
	}

	private String downloadUrl(String myurl) throws IOException {
		InputStream is = null;
		// Only display the first 500 characters of the retrieved
		// web page content.
		int len = 500;

		try {
			URL url = new URL(myurl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(10000);// milliseconds
			conn.setConnectTimeout(15000);// milliseconds
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			// Starts the query
			conn.connect();
			// int response = conn.getResponseCode();
			// Log.d(DEBUG_TAG, "The response is: " + response);
			is = conn.getInputStream();

			// Convert the InputStream into a string
			String contentAsString = readIt(is, len);
			return contentAsString;

			// Makes sure that the InputStream is closed after the app is
			// finished using it.
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	// Reads an InputStream and converts it to a String.
	public String readIt(InputStream stream, int len) throws IOException,
			UnsupportedEncodingException {
		Reader reader = null;
		reader = new InputStreamReader(stream, "UTF-8");
		char[] buffer = new char[len];
		reader.read(buffer);
		return new String(buffer);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mediaPlayer.stop();
		finish();
	}
}
