package com.example.minggu_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import  android.view.View;
import android.view.ViewGroup;
import  android.widget.Button;
import android.widget.Toast;
import android.app.Fragment;
import androidx.annotation.Nullable;


public class SecondFragment extends Fragment {
    View view;
    Button secondButton;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);
        secondButton = view.findViewById(R.id.secondButton);
        secondButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "second fragment", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
