package com.example.tpandroid;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TextEntryFragment extends Fragment {
    public TextEntryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_entry_fragment, container, false);
        EditText editText = (EditText)  view.findViewById(R.id.editTextText);
        Button button = (Button) view.findViewById(R.id.buttonColor);
        Button buttonF = (Button) view.findViewById(R.id.buttonFont);
        button.setOnClickListener(v -> {
            Spannable wordtoSpan = new SpannableString(editText.getText());
            wordtoSpan.setSpan(new ForegroundColorSpan(Color.BLUE), 0, wordtoSpan.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            editText.setText(wordtoSpan);
        });
        buttonF.setOnClickListener(v -> {
            editText.setTypeface(Typeface.create("Arial", 1));
        });
        return view;
    }
}
