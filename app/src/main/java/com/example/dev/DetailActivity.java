package com.example.dev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static android.content.Intent.EXTRA_TITLE;
import static com.example.dev.MainActivity.EXTRA_TEXT;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String title = intent.getStringExtra(EXTRA_TITLE);
        String text = intent.getStringExtra(EXTRA_TEXT);

        TextView textViewTitle = findViewById(R.id.text_view_detail_title);
        TextView textViewText = findViewById(R.id.text_view_text);

        textViewTitle.setText(title);
        textViewText.setText(text);

    }
}