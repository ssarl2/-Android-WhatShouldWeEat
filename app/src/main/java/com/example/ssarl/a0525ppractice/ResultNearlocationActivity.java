package com.example.ssarl.a0525ppractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ResultNearlocationActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_nearlocation);

        String foodQuery;
        String locationQuery;
        locationQuery = "주례동";
        foodQuery = "짜장면";
        webView = (WebView) findViewById(R.id.WebViewNearlocation);
        webView.getSettings().setJavaScriptEnabled(true); // 자바 스크립트 사용 허용
        // 새 창에서 말고 현재창에서 뜨게끔 하는 메소드
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("https://m.map.naver.com/search2/search.nhn?query="+locationQuery+"%20"+foodQuery+"&sm=hty#/map/1");
        //webView.loadUrl("https://m.map.naver.com/search2/search.nhn?query=주례동%20치킨&sm=hty#/map/1");
    }
}