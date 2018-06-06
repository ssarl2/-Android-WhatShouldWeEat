package com.example.ssarl.a0525ppractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    Button resultRecipeBtn;
    Button resultNearlocationBtn;
    Button resultResearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultRecipeBtn = (Button) findViewById(R.id.ResultRecipeBtn);
        resultNearlocationBtn = (Button)findViewById(R.id.ResultNearlocationBtn);
        resultResearchBtn = (Button)findViewById(R.id.ResultResearchBtn);

        resultRecipeBtn.setOnClickListener(this);
        //resultNearlocationBtn.setOnClickListener(this);
        resultResearchBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ResultRecipeBtn: {
                Intent intent = new Intent(ResultActivity.this, ResultRecipeActivity.class);
                intent.putExtra("DATA_RESULT_ACTIVITY", "데이터베이스에서 가져올 음식 이름");
                startActivity(intent);
                break;
            }
            case R.id.ResultNearlocationBtn:

                break;
            case R.id.ResultResearchBtn: {
                PlayActivity R_playActivity = (PlayActivity) PlayActivity.playActivity;
                R_playActivity.finish();
                Intent intent = new Intent(ResultActivity.this,PlayActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }

    }

}
