package com.example.ssarl.a0525ppractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReSearchActivity extends AppCompatActivity implements View.OnClickListener {

    Button resultResearchBtn;
    TextView resultTxt;
    String resultFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_search);

        resultResearchBtn = (Button)findViewById(R.id.ResultResearchBtn2);
        resultTxt = (TextView) findViewById(R.id.ResultTxt2);

        resultResearchBtn.setOnClickListener(this);


        Intent intent = getIntent();

        resultFood = intent.getExtras().getString("DATA_PLAY_ACTIVITY");

        resultTxt.setText(resultFood + "(을)를\n추천드립니다!");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ResultResearchBtn2: {
                PlayActivity R_playActivity = (PlayActivity) PlayActivity.playActivity;
                R_playActivity.finish();
                Intent intent = new Intent(ReSearchActivity.this,PlayActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }

    }

}
