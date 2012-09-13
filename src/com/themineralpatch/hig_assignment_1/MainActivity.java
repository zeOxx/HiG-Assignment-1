package com.themineralpatch.hig_assignment_1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	final Context context = this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button infoButton = (Button) findViewById(R.id.infoBtn);
		infoButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {

				// Sets up the custom dialog
				final Dialog infoDialog = new Dialog(context);
				infoDialog.setContentView(R.layout.info_dialog);
				infoDialog.setTitle("Info!");

				// Set the custom dialog components
				TextView infoText = (TextView) infoDialog
						.findViewById(R.id.infoDialogText);
				infoText.setText(R.string.infoDialogText);

				Button infoDialogButton = (Button) infoDialog
						.findViewById(R.id.infoDialogButton);

				// Exits the dialog if button is clicked
				infoDialogButton.setOnClickListener(new View.OnClickListener() {

					public void onClick(View v) {
						infoDialog.dismiss();
					}
				});

				infoDialog.show();
			}

		});

		Button sDataButton = (Button) findViewById(R.id.sData);
		sDataButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(
						"com.themineralpatch.hig_assignment_1.action.SDATA"));
			}
		});

		Button rDataButton = (Button) findViewById(R.id.rData);
		rDataButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(
						"com.themineralpatch.hig_assignment_1.action.RDATA"));
			}
		});

		Button imgHIGButton = (Button) findViewById(R.id.imgHIG);
		imgHIGButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(
						"com.themineralpatch.hig_assignment_1.action.IMGHIG"));
			}
		});
	}

}
