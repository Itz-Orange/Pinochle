package com.apps.pinochle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WinnerB_activity extends AppCompatActivity {
    TextView tvTeamB, tvWinner, scoreA, scoreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_bactivity);


        tvTeamB = findViewById(R.id.textView8);
        tvWinner = findViewById(R.id.textView9);
        scoreA = findViewById(R.id.textView13);
        scoreB = findViewById(R.id.textView12);
        // putting the inputs into the bundle

        Bundle bundle2 = getIntent().getExtras();
        String text2 = bundle2.getString("Team B");
        String text3 = getIntent().getStringExtra("ScoreA");
        String text4 = getIntent().getStringExtra("ScoreB");


        tvTeamB.setText(text2);
        scoreA.setText(text3);
        scoreB.setText(text4);
    }
    public void startAllOver(View view) {

        Intent intent = new Intent(WinnerB_activity.this, MainActivity.class);
        startActivity(intent);
    }

}