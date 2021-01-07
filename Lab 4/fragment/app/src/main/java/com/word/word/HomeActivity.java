package com.word.word;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.word.word.NavigtionActivity;
import com.word.word.R;

public class HomeActivity extends Fragment {

    private TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        textView = view.findViewById(R.id.text_home);

        view.findViewById(R.id.btnTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() instanceof NavigtionActivity) {
                    ((NavigtionActivity) getActivity()).setTitleVal("Receive Message");
                }
            }
        });
        return view;
    }

    public void onTypeClick(String message) {
        textView.setText(message);
    }
}
