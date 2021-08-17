package com.example.dev;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentNext extends Fragment {
    private TextView textViewTitle;
    private TextView textViewText;
    private Button button;

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_next, container, false);
        textViewTitle = v.findViewById(R.id.text_view_title_next);
        textViewText = v.findViewById(R.id.text_view_text_next);
        button = v.findViewById(R.id.button_next);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = "Here comes the text for next";
                CharSequence title = "Here comes the title for next";
                textViewText.setText(title);
                textViewTitle.setText(text);
            }
        });
        return v;
    }
}
