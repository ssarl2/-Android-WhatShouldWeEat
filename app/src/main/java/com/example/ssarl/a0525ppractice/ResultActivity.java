package com.example.ssarl.a0525ppractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    Button resultRecipeBtn;
    Button resultNearlocationBtn;
    Button resultResearchBtn;
    TextView resultTxt;
    String resultFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultRecipeBtn = (Button) findViewById(R.id.ResultRecipeBtn);
        resultNearlocationBtn = (Button)findViewById(R.id.ResultNearlocationBtn);
        resultResearchBtn = (Button)findViewById(R.id.ResultResearchBtn);
        resultTxt = (TextView) findViewById(R.id.ResultTxt);

        resultRecipeBtn.setOnClickListener(this);
        resultNearlocationBtn.setOnClickListener(this);
        resultResearchBtn.setOnClickListener(this);


        Intent intent = getIntent();

        resultFood = intent.getExtras().getString("DATA_PLAY_ACTIVITY");

        resultTxt.setText(resultFood + "(을)를 추천드립니다!");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ResultRecipeBtn: {
                Intent intent = new Intent(ResultActivity.this, ResultRecipeActivity.class);
                intent.putExtra("DATA_RESULT_ACTIVITY", resultFood);
                startActivity(intent);
                break;
            }
            case R.id.ResultNearlocationBtn: {
                Intent intent = new Intent(ResultActivity.this, ResultNearlocationActivity.class);
                intent.putExtra("DATA_RESULT_ACTIVITY", resultFood);
                startActivity(intent);
                break;
            }
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
