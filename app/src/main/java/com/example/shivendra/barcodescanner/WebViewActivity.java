package com.example.shivendra.barcodescanner;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getSupportActionBar().hide();

        setContentView(R.layout.activity_webview);

        webview = (WebView) findViewById(R.id.webView);

        Bundle data = getIntent().getExtras();




            final String FNAME = (String) data.getString("fName");
            final String LNAME = (String) data.getString("lName");
            final String ADDRESS = (String) data.getString("address");


            webview.setWebViewClient(new WebViewClient());
            webview.getSettings().setJavaScriptEnabled(true);
            webview.getSettings().setDomStorageEnabled(true);
            webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
            webview.loadUrl("http://192.168.1.4:3000");

            webview.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView view, String url) {

                    webview.loadUrl("javascript: (function() {document.getElementById('fName').value= '" + FNAME + " ' ;}) ();");
                    webview.loadUrl("javascript: (function() {document.getElementById('lName').value= '" + LNAME + "';}) ();");
                    webview.loadUrl("javascript: (function() {document.getElementById('age').value= '" + ADDRESS + "';}) ();");

                    //webview.loadUrl("javascript: (function() {document.getElementById('button').clicked==true;}) ();");

                    }


            });





    }




}