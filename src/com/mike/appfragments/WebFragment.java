package com.mike.appfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.mike.instagramauthdemo.R;
import com.mike.listeners.GenericFinishListener;
import com.mike.utils.AppConstants;
import com.mike.utils.CustomWebviewClient;

public class WebFragment extends Fragment implements GenericFinishListener{

	private WebView mWebView;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.web_view, container,false);
		
		CustomWebviewClient.addFinishListener(this);
		
		mWebView = (WebView)v.findViewById(R.id.insta_webView);
        mWebView.setWebViewClient(new CustomWebviewClient(getActivity()));
        mWebView.loadUrl(AppConstants.setAuthURL(getActivity().getApplicationContext().getResources().getString(R.string.client_id)));// If loading url
        
        return v;
	}

	@Override
	public void onFinishCallback() {
		
		getActivity().finish();
		
	}
	
}
