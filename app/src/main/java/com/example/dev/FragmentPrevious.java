package com.example.dev;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPrevious extends Fragment {
    private FragmentPreviousListener listener;
    private EditText editText;
    private Button button;

    public interface FragmentPreviousListener{
        void onInputPreviousSent(CharSequence input);
    }


    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_previous, container, false);
        editText = v.findViewById(R.id.edit_text_comment);
        button = v.findViewById(R.id.button_comment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputPreviousSent(input);
            }
        });
        return v;
    }
    public void updateEditText(CharSequence newText){
            editText.setText(newText);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentPreviousListener){
            listener = (FragmentPreviousListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement FragmentPreviousListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
