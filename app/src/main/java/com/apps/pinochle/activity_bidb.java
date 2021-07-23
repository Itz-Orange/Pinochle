package com.apps.pinochle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_bidb extends AppCompatActivity {
    TextView tvTeamA, tvTeamB, mentionA, mentionB;
    EditText bidB, tricksA, tricksB;

    int mentionteamA = 0;
    int mentionteamB = 0;
    int scoreB2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidb);

        // assigning the outputs of the user to the object
        tvTeamA = findViewById(R.id.textView8);
        tvTeamB = findViewById(R.id.textView9);

        // fetching the data from the bundle
        Bundle bundle = getIntent().getExtras();
        String text1 = bundle.getString("Team A");
        String text2 = bundle.getString("Team B");

        // setting the fetched data to the corresponding text views
        tvTeamA.setText(text1);
        tvTeamB.setText(text2);


        mentionA = (TextView) findViewById(R.id.tvmentiona);
        mentionB = (TextView) findViewById(R.id.tvmentionB);

        bidB = findViewById(R.id.editTextNumberA);
        tricksA = findViewById(R.id.editTextNumber2);
        tricksB = findViewById(R.id.editTextNumberB);

    }

    public void teamnines(View view) {
        mentionteamA = mentionteamA + 1;
        displayForTeamA(mentionteamA);
    }
    public void teamjacks(View view) {
        mentionteamA = mentionteamA + 4;
        displayForTeamA(mentionteamA);
    }
    public void teamqueens(View view) {
        mentionteamA = mentionteamA + 6;
        displayForTeamA(mentionteamA);
    }
    public void teamkings(View view) {
        mentionteamA = mentionteamA + 8;
        displayForTeamA(mentionteamA);
    }
    public void teampinochle(View view) {
        mentionteamA = mentionteamA + 4;
        displayForTeamA(mentionteamA);
    }
    public void pinochle3(View view) {
        mentionteamA = mentionteamA + 30;
        displayForTeamA(mentionteamA);
    }
    public void teammarriage(View view) {
        mentionteamA = mentionteamA + 2;
        displayForTeamA(mentionteamA);
    }
    public void teammarriagetrump(View view) {
        mentionteamA = mentionteamA + 4;
        displayForTeamA(mentionteamA);
    }
    public void teamrun(View v) {
        mentionteamA = mentionteamA + 15;
        displayForTeamA(mentionteamA);
    }
    public void teamaces(View view) {
        mentionteamA = mentionteamA + 10;
        displayForTeamA(mentionteamA);
    }
    private void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.tvmentiona);
        scoreView.setText(String.valueOf(score));
    }

    public void nines(View view) {
        mentionteamB = mentionteamB + 1;
        displayForTeamB(mentionteamB);
    }
    public void jacks(View view) {
        mentionteamB = mentionteamB + 4;
        displayForTeamB(mentionteamB);
    }
    public void queens(View view) {
        mentionteamB = mentionteamB + 6;
        displayForTeamB(mentionteamB);
    }
    public void kings(View view) {
        mentionteamB = mentionteamB + 8;
        displayForTeamB(mentionteamB);
    }
    public void pinochle(View view) {
        mentionteamB = mentionteamB + 4;
        displayForTeamB(mentionteamB);
    }
    public void pinochle2(View view) {
        mentionteamB = mentionteamB + 30;
        displayForTeamB(mentionteamB);
    }
    public void marriage(View view) {
        mentionteamB = mentionteamB + 2;
        displayForTeamB(mentionteamB);
    }
    public void marriagetrump(View view) {
        mentionteamB = mentionteamB + 4;
        displayForTeamB(mentionteamB);
    }
    public void run(View view) {
        mentionteamB = mentionteamB + 15;
        displayForTeamB(mentionteamB);
    }
    public void run2(View view) {
        mentionteamB = mentionteamB + 150;
        displayForTeamB(mentionteamB);
    }
    public void aces(View view) {
        mentionteamB = mentionteamB + 10;
        displayForTeamB(mentionteamB);
    }
    public void aces2(View view) {
        mentionteamB = mentionteamB + 100;
        displayForTeamB(mentionteamB);
    }
    private void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.tvmentionB);
        scoreView.setText(String.valueOf(score));
    }
    public void reset(View view) {
        mentionteamB = 0;
        mentionteamA = 0;
        displayForTeamA(0);
        displayForTeamB(0);
    }
    public void scoreTotal(View view) {
        Bundle bundle = getIntent().getExtras();

        String scoreBoxA = bundle.getString("ScoreA2");
        String scoreBoxB = bundle.getString("ScoreB2");
        int A2 = Integer.parseInt(scoreBoxA);
        int B2 = Integer.parseInt(scoreBoxB);

        String nameA = tvTeamA.getText().toString();
        String nameB = tvTeamB.getText().toString();

        int bidb = Integer.parseInt(bidB.getText().toString());
        int tricksTotalB = Integer.parseInt(tricksB.getText().toString());

        int totalA = 25 - tricksTotalB;
        int totalScoreBB = mentionteamB + tricksTotalB;
        int totalScoreBA = mentionteamA + totalA;


        if (totalA == 0 && totalScoreBB < bidb) {
            scoreB2 = (bidb * -1);
            B2 += scoreB2;

            String scoreBoardA = String.valueOf(A2);
            String scoreBoardB = String.valueOf(B2);
            Intent i = new Intent(activity_bidb.this, score_activity.class);
            i.putExtra("Team A", nameA);
            i.putExtra("Team B", nameB);
            i.putExtra("ScoreA", scoreBoardA);
            i.putExtra("ScoreB", scoreBoardB);
            // starting the activity
            startActivity(i);
        } else if (totalScoreBB < bidb) {
            scoreB2 = (bidb * -1);
            B2 += scoreB2;
            A2 += totalScoreBA;

            String scoreBoardA = String.valueOf(A2);
            String scoreBoardB = String.valueOf(B2);
            Intent i = new Intent(activity_bidb.this, score_activity.class);
            i.putExtra("Team A", nameA);
            i.putExtra("Team B", nameB);
            i.putExtra("ScoreA", scoreBoardA);
            i.putExtra("ScoreB", scoreBoardB);
            // starting the activity
            startActivity(i);
        }
        if (totalScoreBB >= bidb && totalA == 0) {

            B2 += totalScoreBB;

            String scoreBoardA = String.valueOf(A2);
            String scoreBoardB = String.valueOf(B2);
            Intent i = new Intent(activity_bidb.this, score_activity.class);
            i.putExtra("Team A", nameA);
            i.putExtra("Team B", nameB);
            i.putExtra("ScoreA", scoreBoardA);
            i.putExtra("ScoreB", scoreBoardB);
            // starting the activity
            startActivity(i);
        }else if(totalScoreBB >= bidb){

            A2 += totalScoreBA;
            B2 += totalScoreBB;

            String scoreBoardA = String.valueOf(A2);
            String scoreBoardB = String.valueOf(B2);
            Intent i = new Intent(activity_bidb.this, score_activity.class);
            i.putExtra("Team A", nameA);
            i.putExtra("Team B", nameB);
            i.putExtra("ScoreA", scoreBoardA);
            i.putExtra("ScoreB", scoreBoardB);
            // starting the activity
            startActivity(i);
        }
            if (B2 >= 150) {


                String scoreBoardA = String.valueOf(A2);
                String scoreBoardB = String.valueOf(B2);
                Intent intent = new Intent(activity_bidb.this, WinnerB_activity.class);
                intent.putExtra("ScoreB", scoreBoardB);
                intent.putExtra("ScoreA", scoreBoardA);
                intent.putExtra("Team B", nameB);
                startActivity(intent);
            }
                else if (A2 >= 150) {

                String scoreBoardA = String.valueOf(A2);
                String scoreBoardB = String.valueOf(B2);
                Intent intent = new Intent(activity_bidb.this, WinnerA_activity.class);
                intent.putExtra("ScoreB", scoreBoardB);
                intent.putExtra("ScoreA", scoreBoardA);
                intent.putExtra("Team A", nameA);
                startActivity(intent);
            }
        }
}






