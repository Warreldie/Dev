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

public class FragmentPrevious extends Fragment {
    private TextView textViewTitle;
    private TextView textViewText;
    private Button button;


    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_previous, container, false);
        textViewTitle = v.findViewById(R.id.text_view_title_previous);
        textViewText = v.findViewById(R.id.text_view_text_previous);
        button = v.findViewById(R.id.button_previous);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = "Here comes the text for previous";
                CharSequence title = "Here comes the title for previous";
                textViewText.setText(title);
                textViewTitle.setText(text);
            }
        });
        return v;
    }

}
