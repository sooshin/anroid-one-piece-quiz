package com.example.android.onepiecequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the start button
        Button startButton = findViewById(R.id.start_button);

        // Set a click listener on that button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent quizIntent = new Intent(MainActivity.this, QuizActivity.class);
                // Start the new activity
                startActivity(quizIntent);
            }
        });

    }

}
