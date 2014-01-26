package com.coursera.androidapps101.assignment2;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class Jabberwocky extends Activity {

	MediaPlayer myPlayer;
	WebView w;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		
		w = (WebView) findViewById(R.id.webView2);
		
		w.getSettings().setBuiltInZoomControls(true);
		w.getSettings().setJavaScriptEnabled(true);
		
		w.loadUrl("file:///android_asset/jabberwocky.html");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabberwocky, menu);
		return true;
	}

	@Override 
	protected void onResume() {  
	  myPlayer = MediaPlayer.create(this, R.raw.jabberwocky); 
	  myPlayer.start(); 
	  super.onResume(); 
	} 
	@Override 
	protected void onPause() {  
	 	myPlayer.stop(); 
	 	myPlayer.release(); 
		
		super.onPause();
		finish();
	}
	
	public void openWiki(View v) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://en.wikipedia.org/wiki/Jabberwocky"));
		startActivity(browserIntent);
	}
	
	public void displayPic(View v) {
		w.loadUrl("file:///android_asset/img.html");
	}
}
