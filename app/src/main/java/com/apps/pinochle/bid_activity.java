package com.apps.pinochle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


    public class bid_activity extends AppCompatActivity {
        // creating an object of the text view
        TextView tvTeamA, tvTeamB, mentionA, mentionB;
        EditText bidA, tricksA, tricksB;

        int mentionteamA;
        int mentionteamB;
        int scoreA2 = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_bid);

            // assigning the outputs of the user to the object
            tvTeamA = findViewById(R.id.textView8);
            tvTeamB = findViewById(R.id.textView9);

            Bundle bundle = getIntent().getExtras();
            String text1 = bundle.getString("Team A");
            String text2 = bundle.getString("Team B");

            tvTeamA.setText(text1);
            tvTeamB.setText(text2);


            mentionA = (TextView) findViewById(R.id.tvmentiona);
            mentionB = (TextView) findViewById(R.id.tvmentionB);

            bidA = findViewById(R.id.editTextNumberA);
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
        public void run2(View view) {
            mentionteamA = mentionteamA + 150;
            displayForTeamA(mentionteamA);
        }
        public void teamaces(View view) {
            mentionteamA = mentionteamA + 10;
            displayForTeamA(mentionteamA);
        }
        public void aces2(View view) {
            mentionteamA = mentionteamA + 100;
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
        public void aces(View view) {
            mentionteamB = mentionteamB + 10;
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

            String scoreBoxA = bundle.getString("ScoreA1");
            String scoreBoxB = bundle.getString("ScoreB1");
            int A1 = Integer.parseInt(scoreBoxA);
            int B1 = Integer.parseInt(scoreBoxB);

            String nameA = tvTeamA.getText().toString();
            String nameB = tvTeamB.getText().toString();

            int bida = Integer.parseInt(bidA.getText().toString());
            int tricksTotalA = Integer.parseInt(tricksA.getText().toString());

            int totalB = 25 - tricksTotalA;
            int totalScoreBA = mentionteamA + tricksTotalA;
            int totalScoreBB = mentionteamB + totalB;


            if (totalB == 0 && totalScoreBA < bida){
                    scoreA2 = (bida * -1);
                    A1 += scoreA2;

                    String scoreBoardA = String.valueOf(A1);
                    String scoreBoardB = String.valueOf(B1);
                    Intent i = new Intent(bid_activity.this, score_activity.class);
                    i.putExtra("Team A", nameA);
                    i.putExtra("Team B", nameB);
                    i.putExtra("ScoreA", scoreBoardA);
                    i.putExtra("ScoreB", scoreBoardB);
                    // starting the activity
                    startActivity(i);
                } else if(totalScoreBA < bida){
                scoreA2 = (bida * -1);
                A1 += scoreA2;
                B1 += totalScoreBB;

                String scoreBoardA = String.valueOf(A1);
                String scoreBoardB = String.valueOf(B1);
                Intent i = new Intent(bid_activity.this, score_activity.class);
                i.putExtra("Team A", nameA);
                i.putExtra("Team B", nameB);
                i.putExtra("ScoreA", scoreBoardA);
                i.putExtra("ScoreB", scoreBoardB);
                // starting the activity
                startActivity(i);
            }

             if(totalB == 0 && totalScoreBA >= bida){

                A1 += totalScoreBA;

                String scoreBoardA = String.valueOf(A1);
                String scoreBoardB = String.valueOf(B1);
                Intent i = new Intent(bid_activity.this, score_activity.class);
                i.putExtra("Team A", nameA);
                i.putExtra("Team B", nameB);
                i.putExtra("ScoreA", scoreBoardA);
                i.putExtra("ScoreB", scoreBoardB);
                // starting the activity
                startActivity(i);
            }else if (totalScoreBA >= bida){

                 A1 += totalScoreBA;
                 B1 += totalScoreBB;

                     String scoreBoardA = String.valueOf(A1);
                     String scoreBoardB = String.valueOf(B1);
                     Intent i = new Intent(bid_activity.this, score_activity.class);
                     i.putExtra("Team A", nameA);
                     i.putExtra("Team B", nameB);
                     i.putExtra("ScoreA", scoreBoardA);
                     i.putExtra("ScoreB", scoreBoardB);
                        startActivity(i);
             }

                if (A1 >= 150) {

                    String scoreBoardA = String.valueOf(A1);
                    String scoreBoardB = String.valueOf(B1);
                    Intent intent = new Intent(bid_activity.this, WinnerA_activity.class);
                    intent.putExtra("ScoreB", scoreBoardB);
                    intent.putExtra("ScoreA", scoreBoardA);
                    intent.putExtra("Team A", nameA);
                    startActivity(intent);
                }
                    else if (B1 >= 150) {

                    String scoreBoardA = String.valueOf(A1);
                    String scoreBoardB = String.valueOf(B1);
                        Intent intent = new Intent(bid_activity.this, WinnerB_activity.class);
                        intent.putExtra("ScoreB", scoreBoardB);
                        intent.putExtra("ScoreA", scoreBoardA);
                        intent.putExtra("Team B", nameB);
                        startActivity(intent);
                    }

            }
        }

