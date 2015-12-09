package com.mike.instagramauthdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.mike.appfragments.WebFragment;

public class LaunchActivity extends ActionBarActivity {

	private ImageView mCloseImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.landing_layout);
		
		mCloseImageView = (ImageView) findViewById(R.id.closeImageView);
		mCloseImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
				
			}
		});
		
		if(savedInstanceState==null){

            Fragment mMapFragment = new WebFragment();

            FragmentManager mFragmentManager = getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager
                    .beginTransaction();
            mFragmentTransaction.replace(R.id.fragmentContainer, mMapFragment);
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();

        }
		
	}

}
