package com.example.android.onepiecequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Displays the score and the result of the problem you solved.
 */

public class ScoreActivity extends AppCompatActivity {

    private String[] quizResult;

    private TextView qOneTextView;
    private TextView qTwoTextView;
    private TextView qThreeTextView;
    private TextView qFourTextView;
    private TextView qFiveTextView;
    private TextView qSixTextView;
    private TextView qSevenTextView;
    private TextView qEightTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Find the text view that shows the score
        TextView scoreTextView = (TextView) findViewById(R.id.score_circle_text);

        // Get intent from QuizActivity
        Intent quizIntent = getIntent();

        // The number of right answers
        int count = quizIntent.getIntExtra("count", 0);

        // Final score
        int score = count *10;

        // Convert int score to String value and display on the textView
        scoreTextView.setText(String.valueOf(score));

        // Find the button that goes back to the Main Activity
        Button backToStartButton = (Button) findViewById(R.id.back_to_start_button);
        backToStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });

        // Get the value of the String array
        quizResult = quizIntent.getStringArrayExtra("result");

        // display the result of each question
        displayResult();
    }

    /**
     * Displays the result of each question
     */
    private void displayResult() {

        // Find the textView that displays the result
        qOneTextView = (TextView) findViewById(R.id.q_one);
        qTwoTextView = (TextView) findViewById(R.id.q_two);
        qThreeTextView = (TextView) findViewById(R.id.q_three);
        qFourTextView = (TextView) findViewById(R.id.q_four);
        qFiveTextView = (TextView) findViewById(R.id.q_five);
        qSixTextView = (TextView) findViewById(R.id.q_six);
        qSevenTextView = (TextView) findViewById(R.id.q_seven);
        qEightTextView = (TextView)findViewById(R.id.q_eight);

        // Change null to String "X"
        for (int i = 0 ; i <quizResult.length; i++) {
            if (quizResult[i] == null) {
                quizResult[i] = "X";
            }
        }

        String resultOne = "Q1 :" + " " + quizResult[0];
        String resultTwo = "Q2 :" + " " + quizResult[1];
        String resultThree = "Q3 :" + " " + quizResult[2];
        String resultFour = "Q4 :" + " " + quizResult[3];
        String resultFive = "Q5 :" + " " + quizResult[4];
        String resultSix = "Q6 :" + " " + quizResult[5];
        String resultSeven = "Q7 :" + " " + quizResult[6];
        String resultEight = "Q8 :" + " " + quizResult[7];

        // Displays whether each question is correct.
        qOneTextView.setText(resultOne);
        qTwoTextView.setText(resultTwo);
        qThreeTextView.setText(resultThree);
        qFourTextView.setText(resultFour);
        qFiveTextView.setText(resultFive);
        qSixTextView.setText(resultSix);
        qSevenTextView.setText(resultSeven);
        qEightTextView.setText(resultEight);
    }
}
