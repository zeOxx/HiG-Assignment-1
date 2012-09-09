package com.themineralpatch.hig_assignment_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button infoButton = (Button) findViewById(R.id.infoBtn);
        
        Button sDataButton = (Button) findViewById(R.id.sData);
        sDataButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.themineralpatch.hig_assignment_1.action.SDATA"));
			}
		});
        
        Button rDataButton = (Button) findViewById(R.id.rData);
        rDataButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.themineralpatch.hig_assignment_1.action.RDATA"));
			}
		});
        
        Button imgHIGButton = (Button) findViewById(R.id.imgHIG);
        imgHIGButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.themineralpatch.hig_assignment_1.action.IMGHIG"));
			}
		});
    }
    
    
}
