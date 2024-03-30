package com.example.pr_5;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    TextView second_fragment_text_view;
    public SecondFragment() {
        super(R.layout.fragment_second);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        second_fragment_text_view = view.findViewById(R.id.fragment_second_text_view2);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ArrayList<String> Fio = bundle.getStringArrayList("fio&group");
            if (Fio != null && Fio.size() >= 1) {
                String fio = Fio.get(0);
                String group = Fio.get(1);

                String result = fio + " группы " + group;

                second_fragment_text_view.setText(result);
            }
        }
    }
}