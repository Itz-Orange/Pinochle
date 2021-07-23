package com.apps.pinochle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class WinnerA_activity extends AppCompatActivity {
    TextView tvTeamA, tvWinner, scoreA, scoreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_aactivity);



        tvTeamA = findViewById(R.id.textView8);
        tvWinner = findViewById(R.id.textView9);
        scoreA = findViewById(R.id.textView10);
        scoreB = findViewById(R.id.textView11);
        // putting the inputs into the bundle

        Bundle bundle2 = getIntent().getExtras();
        String text2 = bundle2.getString("Team A");
        String text3 = getIntent().getStringExtra("ScoreA");
        String text4 = getIntent().getStringExtra("ScoreB");


        tvTeamA.setText(text2);
        scoreA.setText(text3);
        scoreB.setText(text4);

        }
    public void startAllOver(View view) {

        Intent intent = new Intent(WinnerA_activity.this, MainActivity.class);
        startActivity(intent);
    }
}