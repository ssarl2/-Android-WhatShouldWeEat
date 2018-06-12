package com.example.ssarl.a0525ppractice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


public class ResultNearlocationActivity extends AppCompatActivity {

    //private static final String TAG = MainActivityTest.class.getSimpleName();
    private static final int MY_PERMISSION_REQUEST_LOCATION = 0;


    TextView textView;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_nearlocation);

        textView = (TextView) findViewById(R.id.ResultNearlocationTxt);
        webView = (WebView) findViewById(R.id.WebViewNearlocation);

        permissionCheck();

    }


    private void initWebView() {

        Intent intent = getIntent();
        String foodQuery = intent.getExtras().getString("DATA_RESULT_ACTIVITY");
        String locationQuery = "주례동";

        webView.getSettings().setJavaScriptEnabled(true);
        // 자바스크립트 사용을 허용한다.
        webView.setWebViewClient(new WebViewClient());
        // 새 창에서 말고 현재창에서 뜨게끔 하는 메소드
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                super.onGeolocationPermissionsShowPrompt(origin, callback);
                callback.invoke(origin, true, false);
            }
        });
        webView.loadUrl("https://m.map.naver.com/search2/search.nhn?query=" + locationQuery + "%20" + foodQuery + "&sm=hty#/map/1");
    }


    private void permissionCheck() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //Manifest.permission.ACCESS_FINE_LOCATION 접근 승낙 상태 일때
            initWebView();
        } else {
            //Manifest.permission.ACCESS_FINE_LOCATION 접근 거절 상태 일때
            //사용자에게 접근권한 설정을 요구하는 다이얼로그를 띄운다.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_REQUEST_LOCATION);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSION_REQUEST_LOCATION) {
            initWebView();
        }
    }


}