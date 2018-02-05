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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Find the text view that shows the score
        TextView scoreTextView = findViewById(R.id.score_circle_text);

        // Get intent from QuizActivity
        Intent quizIntent = getIntent();

        // The number of right answers
        int count = quizIntent.getIntExtra("count", 0);

        // Final score
        int score = count *10;

        // Convert int score to String value and display on the textView
        scoreTextView.setText(String.valueOf(score));

        // Find the button that goes back to the Main Activity
        Button backToStartButton = findViewById(R.id.back_to_start_button);
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
        TextView qOneTextView = findViewById(R.id.q_one);
        TextView qTwoTextView = findViewById(R.id.q_two);
        TextView qThreeTextView = findViewById(R.id.q_three);
        TextView qFourTextView = findViewById(R.id.q_four);
        TextView qFiveTextView = findViewById(R.id.q_five);
        TextView qSixTextView = findViewById(R.id.q_six);
        TextView qSevenTextView = findViewById(R.id.q_seven);
        TextView qEightTextView = findViewById(R.id.q_eight);

        // Change null to String "X"
        for (int i = 0 ; i <quizResult.length; i++) {
            if (quizResult[i] == null) {
                quizResult[i] = getString(R.string.x);
            }
        }

        String resultOne = getString(R.string.q1) + " " + quizResult[0];
        String resultTwo = getString(R.string.q2) + " " + quizResult[1];
        String resultThree = getString(R.string.q3) + " " + quizResult[2];
        String resultFour = getString(R.string.q4) + " " + quizResult[3];
        String resultFive = getString(R.string.q5) + " " + quizResult[4];
        String resultSix = getString(R.string.q6) + " " + quizResult[5];
        String resultSeven = getString(R.string.q7) + " " + quizResult[6];
        String resultEight = getString(R.string.q8) + " " + quizResult[7];

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
