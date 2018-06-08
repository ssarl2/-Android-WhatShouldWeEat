package com.example.ssarl.a0525ppractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ResultRecipeActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_recipe);

        String foodQuery;
        foodQuery = "볶음밥";
        webView = (WebView)findViewById(R.id.WebViewRecipe);
        // 새 창에서 말고 현재창에서 뜨게끔 하는 메소드
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("https://terms.naver.com/search.nhn?query="+foodQuery+"+%EB%A7%8C%EB%93%9C%EB%8A%94+%EB%B2%95&searchType=&dicType=&subject=");
    }

}
