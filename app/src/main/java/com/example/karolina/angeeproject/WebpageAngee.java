package com.example.karolina.angeeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebpageAngee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpage_angee);
        WebView webViewAngee=(WebView)findViewById(R.id.webViewAngee);
        webViewAngee.loadUrl("http://ami-2016.github.io/Angee");
    }



}
