package com.example.dev;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentNext extends Fragment {
    private FragmentNext.FragmentNextListener listener;
    private EditText editText;

    public interface FragmentNextListener{
        void onInputNextSent(CharSequence input);
    }


    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_next, container, false);
        editText = v.findViewById(R.id.edit_text_comment);
        return v;
    }
    public void updateEditText(CharSequence newText){
        editText.setText(newText);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentNext.FragmentNextListener){
            listener = (FragmentNext.FragmentNextListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement FragmentNextListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
