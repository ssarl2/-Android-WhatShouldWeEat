package com.example.ssarl.a0525ppractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultRecipeActivity extends AppCompatActivity implements View.OnTouchListener{

    WebView webView;
    TextView textView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_recipe);

        Intent intent = getIntent();
        String foodQuery = intent.getExtras().getString("DATA_RESULT_ACTIVITY");;

        webView = (WebView)findViewById(R.id.WebViewRecipe);
        textView = (TextView)findViewById(R.id.ResultRecipeTxt);
        linearLayout = (LinearLayout)findViewById(R.id.ResultRecipeTopLayout);

        // 새 창에서 말고 현재창에서 뜨게끔 하는 메소드
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("https://terms.naver.com/search.nhn?query="+foodQuery+"+%EB%A7%8C%EB%93%9C%EB%8A%94+%EB%B2%95&searchType=&dicType=&subject=");

        textView.setEnabled(false);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
