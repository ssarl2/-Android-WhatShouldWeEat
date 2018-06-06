package com.example.ssarl.a0525ppractice;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressBar progressBar;
    Button playYesBtn;
    Button playNoBtn;
    public static Activity playActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        playActivity = PlayActivity.this;

        progressBar = (ProgressBar)findViewById(R.id.Progress);
        playYesBtn = findViewById(R.id.PlayYesBtn);
        playNoBtn = findViewById(R.id.PlayNoBtn);

        playYesBtn.setOnClickListener(this);
        playNoBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.PlayYesBtn:{
                int i = progressBar.getProgress();
                progressBar.setProgress(i+20);
                break;
            }
            case R.id.PlayNoBtn:{
                int i = progressBar.getProgress();
                progressBar.setProgress(i-20);
                break;
            }

        }
        if(progressBar.getProgress()>=100){
            Intent intent = new Intent(PlayActivity.this,ResultActivity.class);
            startActivity(intent);
        }

    }
}
