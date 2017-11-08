package com.example.android.onepiecequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Displays the score of the problem you solved.
 */

public class ScoreActivity extends AppCompatActivity {

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

    }
}
