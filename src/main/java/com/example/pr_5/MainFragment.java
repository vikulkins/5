package com.example.pr_5;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    Button main_fragment_button;
    EditText main_fragment_edit_text;
    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        main_fragment_button = (Button) getActivity().findViewById(R.id.fragment_main_button);
        main_fragment_edit_text = (EditText) getActivity().findViewById(R.id.fragment_main_edit_text);

        main_fragment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = main_fragment_edit_text.getText().toString();
                NavController navController = Navigation.findNavController(view);

                if (!date.isEmpty()) {
                    ArrayList<String> Data =  new ArrayList<String>();
                    Data.add(date);

                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("fio",  Data);
                    navController.navigate(R.id.action_mainFragment_to_firstFragment, bundle);
                } else {
                    main_fragment_edit_text.setText("");
                    main_fragment_edit_text.setHint(getResources().getString(R.string.fio_2));
                }
            }
        });
    }
    public static boolean isNumber(String string_num) {
        try {
            Integer.parseInt(string_num);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}