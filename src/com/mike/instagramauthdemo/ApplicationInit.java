package com.mike.instagramauthdemo;

import com.mike.utils.AppConstants;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ApplicationInit extends ActionBarActivity {

	private TextView mHeaderTextView;
	private ProgressBar mLoadingProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();

	}

	private void init() {

		mHeaderTextView = (TextView) findViewById(R.id.initTextView);
		mLoadingProgressBar = (ProgressBar) findViewById(R.id.initProgressBar);

	}

	private void launchAuthActivity(Context context, Class<?> cls) {

		Intent launchAuthDialog = new Intent(context, cls);
		startActivity(launchAuthDialog);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		init();

		SharedPreferences mPreferences = getSharedPreferences(
				AppConstants.SHARED_PREF_CONSTANT, 0);

		if (mPreferences
				.getBoolean(AppConstants.SHARED_PREF_BOOLEAN_KEY, false) == true) {

			Toast.makeText(
					this,
					"User is authenticated with Request Token : "
							+ mPreferences.getString(
									AppConstants.SHARED_PREF_REQUEST_TOKEN_KEY,
									""), Toast.LENGTH_SHORT).show();

			mHeaderTextView.setText(mPreferences.getString(
					AppConstants.SHARED_PREF_REQUEST_TOKEN_KEY, ""));
			mLoadingProgressBar.setVisibility(View.GONE);

		} else {

			mHeaderTextView.setText("Waiting for authorization");
			mLoadingProgressBar.setVisibility(View.VISIBLE);
			launchAuthActivity(this, LaunchActivity.class);

		}

	}

}
