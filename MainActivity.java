package com.example.viikon10tehtavat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    boolean isActive;
    Library library;
    WebView web;

    EditText searchField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isActive = false;
        library = Library.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

        searchField = (EditText)findViewById(R.id.searchText);
    }

    public void goBack(View v){
        library.goBack();
        setView();
    }

    public void goNext(View v){
        library.goNext();
        setView();
    }

    public void search(View v){
        String newUrl = (String) searchField.getText().toString();
        newUrl = ("http://"+newUrl);
        System.out.println(newUrl);
        library.addNewUrl(newUrl);
        setView();
    }

    public void refresh(View v){
        setView();
    }

    private void setView(){
        web.loadUrl(library.getCurrentUrl());
    }

    // tämä requires api juttu tuli kun painoin alt+enter
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void shoutOutButtonF(View v){
        if (library.getCurrentUrl().equals("file:///android_asset/index.html")){
            System.out.println("TESTITESTI");
            web.evaluateJavascript("javascript:shoutOut()", null);
        }
    }

    // sama homma tässä
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void initializeButtonF(View v){
        if (library.getCurrentUrl().equals("file:///android_asset/index.html")){
            System.out.println("TESTITESTI2222");
            web.evaluateJavascript("javascript:initialize()", null);
        }
    }

}