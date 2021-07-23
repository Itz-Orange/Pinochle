package com.apps.pinochle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class score_activity extends AppCompatActivity {
    // creating an object of the text view
    TextView scoreA;
    TextView scoreB;
    TextView tvA;
    TextView tvB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        // assigning the outputs of the user to the object
        scoreA = (TextView) findViewById(R.id.scoreA);
        scoreB = (TextView) findViewById(R.id.scoreB);
        tvA = (TextView) findViewById(R.id.nameA);
        tvB = (TextView) findViewById(R.id.nameB);

        Bundle bundle = getIntent().getExtras();
        String text1 = bundle.getString("Team A");
        String text2 = bundle.getString("Team B");

        int totalScoreA2 = Integer.parseInt(scoreA.getText().toString());
        int totalScoreB2 = Integer.parseInt(scoreB.getText().toString());


        try {

            String text3 = getIntent().getStringExtra("ScoreA");
            String text4 = getIntent().getStringExtra("ScoreB");

            tvA.setText(text1);
            tvB.setText(text2);
            scoreA.setText(text3);
            scoreB.setText(text4);

        } finally {

        }

    }
    public void bidA(View view) {
        String nameA = tvA.getText().toString();
        String nameB = tvB.getText().toString();
        String ScoreA1 = scoreA.getText().toString();
        String ScoreB1 = scoreB.getText().toString();
        Intent intent = new Intent(score_activity.this, bid_activity.class);
        // creating an object of bundle
        Bundle bundle = new Bundle();
        // putting the inputs into the bundle
        bundle.putString("Team A", nameA);
        bundle.putString("Team B", nameB);
        bundle.putString("ScoreA1", ScoreA1);
        bundle.putString("ScoreB1", ScoreB1);
        intent.putExtras(bundle);
        // starting the activity
        startActivity(intent);
    }

    public void bidB(View view) {
        String nameA = tvA.getText().toString();
        String nameB = tvB.getText().toString();
        String ScoreA2 = scoreA.getText().toString();
        String ScoreB2 = scoreB.getText().toString();

        Intent myIntent = new Intent(score_activity.this, activity_bidb.class);
        // creating an object of bundle
        Bundle bundle = new Bundle();
        // putting the inputs into the bundle
        bundle.putString("Team A", nameA);
        bundle.putString("Team B", nameB);
        bundle.putString("ScoreA2", ScoreA2);
        bundle.putString("ScoreB2", ScoreB2);

        myIntent.putExtras(bundle);
        // starting the activity
        startActivity(myIntent);
    }

    public void startAllOver(View view) {
        scoreA.setText("00");
        scoreB.setText("00");
    }


}

