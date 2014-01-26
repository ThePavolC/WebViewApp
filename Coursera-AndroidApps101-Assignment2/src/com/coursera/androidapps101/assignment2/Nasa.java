package com.coursera.androidapps101.assignment2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class Nasa extends Activity {

	
	WebView w;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		
		w = (WebView) findViewById(R.id.webView1);
		
		w.getSettings().setBuiltInZoomControls(true);
		w.getSettings().setJavaScriptEnabled(true);
		
		w.loadUrl("file:///android_asset/uofi-at-nasa.html");
	}

	public void onPause(){
		super.onPause();
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nasa, menu);
		return true;
	}

}
