package com.example.ssarl.a0525ppractice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class PlayActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressBar progressBar;
    Button playYesBtn;
    Button playNoBtn;
    TextView playQuery;
    public static Activity playActivity;
    private FoodRecomendor foodRecomendor;

    private String question;

    private int allFoodCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        playActivity = PlayActivity.this;

        progressBar = (ProgressBar)findViewById(R.id.Progress);
        playQuery = (TextView) findViewById(R.id.PlayQuery);
        playYesBtn = findViewById(R.id.PlayYesBtn);
        playNoBtn = findViewById(R.id.PlayNoBtn);

        playYesBtn.setOnClickListener(this);
        playNoBtn.setOnClickListener(this);

        foodRecomendor = new FoodRecomendor(MainActivity.db);
        progressBar.setMax(foodRecomendor.getSize());
        progressBar.setProgress(0);
        allFoodCount = foodRecomendor.getSize();
        setRandomQuestion();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.PlayYesBtn:{
                foodRecomendor.filt(question, true);

                break;
            }
            case R.id.PlayNoBtn:{
                foodRecomendor.filt(question, false);
                break;
            }
        }
// 와 객체지향의 끝을 달리네
        switch (foodRecomendor.getSize())
        {
            case 0:
                // 원하는 음식 못찾음
                Intent intent = new Intent(PlayActivity.this,ReSearchActivity.class);
                intent.putExtra("DATA_PLAY_ACTIVITY", "먹지 않는 것");
                startActivity(intent);
                break;
            case 1:
                // 원하는 음식 찾음
                startResultActivity(foodRecomendor.getFoods().get(0).getName());
                break;
            default:
                setRandomQuestion();
                progressBar.setProgress((allFoodCount - foodRecomendor.getSize()));
        }

    }//별론가?

    private void startResultActivity(String txt) {
        Intent intent = new Intent(PlayActivity.this, ResultActivity.class);
        intent.putExtra("DATA_PLAY_ACTIVITY", txt);
        startActivity(intent);
    }

    private void setRandomQuestion() {
        question = foodRecomendor.getRandomDescribe();
        playQuery.setText(String.format("%s 어때요?", question));
    }


}