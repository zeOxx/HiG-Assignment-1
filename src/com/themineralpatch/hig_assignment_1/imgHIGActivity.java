package com.themineralpatch.hig_assignment_1;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

public class imgHIGActivity extends Activity {

	ImageView imageView;
	String imgURL = "http://themineralpatch.net/img/avatar_sc2.jpg";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imghig);

		ConnectivityManager connMGR = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMGR.getActiveNetworkInfo();

		if (networkInfo != null && networkInfo.isConnected()) {
			imageView = (ImageView) findViewById(R.id.imgHIGimage);
			new DownloadImage().execute(imgURL);
		}
	}

	private class DownloadImage extends AsyncTask<String, Void, Bitmap> {
		protected Bitmap doInBackground(String... url) {
			return loadImage(url[0]);
		}

		protected void onPostExecute(Bitmap result) {
			imageView.setImageBitmap(result);
		}
	}

	public Bitmap loadImage(final String s) {
		Bitmap bm = null;
		try{
			URL url = new URL(s);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			InputStream is = conn.getInputStream();
			bm = BitmapFactory.decodeStream(is);
		} catch (Exception e) {
			System.out.println("Couldn't reach image: " + e);
			e.printStackTrace();
		}
		return bm;
	}
}
