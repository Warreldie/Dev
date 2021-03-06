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

public class DetailActivity extends AppCompatActivity implements FragmentPrevious.FragmentPreviousListener, FragmentNext.FragmentNextListener {
    //Fragments Come together here
    private FragmentPrevious fragmentPrevious;
    private FragmentNext fragmentNext;

    Button bt;

    @Override
    public void onInputNextSent(CharSequence input) {
        fragmentPrevious.updateEditText(input);
    }

    @Override
    public void onInputPreviousSent(CharSequence input) {
        fragmentNext.updateEditText(input);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        fragmentPrevious = new FragmentPrevious();
        fragmentNext = new FragmentNext();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_previous, fragmentPrevious)
                .replace(R.id.container_next, fragmentNext)
                .commit();



        Intent intent = getIntent();

        final String title = intent.getStringExtra(EXTRA_TITLE);
        final String text = intent.getStringExtra(EXTRA_TEXT);


        TextView textViewTitle = findViewById(R.id.text_view_title);
        TextView textViewText = findViewById(R.id.text_view_text);

        textViewTitle.setText(title);
        textViewText.setText(text);

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