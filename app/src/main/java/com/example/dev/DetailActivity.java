package com.example.dev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.content.ContentValues.TAG;
import static com.example.dev.MainActivity.EXTRA_TITLE;
import static com.example.dev.MainActivity.EXTRA_TEXT;
//Binds the values in the Detailscreen with use of an Intent
public class DetailActivity extends AppCompatActivity {
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        final String title = intent.getStringExtra(EXTRA_TITLE);
        final String text = intent.getStringExtra(EXTRA_TEXT);


        TextView textViewTitle = findViewById(R.id.text_view_title);
        TextView textViewText = findViewById(R.id.text_view_text);

        textViewTitle.setText(title);
        textViewText.setText(text);
        //Logica for the share button
        bt=(Button) findViewById(R.id.button_share);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = text;
                String shareSub = title;
                //String shareUrl = "http://warrel.net/Dev";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                //myIntent.putExtra(Intent.EXTRA_TEXT, shareUrl);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });

    }
}