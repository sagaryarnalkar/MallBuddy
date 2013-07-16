package com.sagar.mallbuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;



public class ActivitySplashScreen extends Activity{

	private static final String TAG = ActivitySplashScreen.class
		    .getSimpleName();
	
	private static final int DELAY = 2000;		    

    private DelayLoader mLoader = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

	super.onCreate(savedInstanceState);
	
	setContentView(R.layout.activity_splash);

	mLoader = new DelayLoader();

	mLoader.execute((String) null);
		
    }
    
    private void gotoHomeScreen()
    {
    	Intent intent = new Intent(this,ActivityMallHomeScreen.class);

		startActivity(intent);

		finish();
    }
    
    private class DelayLoader extends AsyncTask<String, Void, Boolean> {
		
		private String mUserName;
		
		@Override
		protected Boolean doInBackground(String... data) {

		    boolean result = false;

		    try {
		    	
		    	Thread.sleep(DELAY);
		    }
		    catch(Exception e)
		    {
		    	if (BuildConfig.DEBUG) {

					Log.d(TAG,"exception",e);
				    }
		    }

		    return result;
		}

		@Override
		protected void onPostExecute(Boolean result) {

		    if (BuildConfig.DEBUG) {

			System.out.println("onPostExecute");
		    }

			gotoHomeScreen();

		}

	    }

	
}
