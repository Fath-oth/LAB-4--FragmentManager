package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentOne extends Fragment {

    private TextView tv;
    private Button Hellobutton;

    public FragmentOne() {
        super(R.layout.fragment_one); // définit directement le layout
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tv = view.findViewById(R.id.Firsttext);
        Hellobutton = view.findViewById(R.id.Hellobutton);

        // Action du bouton
        Hellobutton.setOnClickListener(v -> tv.setText("Hello from the first Fragment !"));
    }

    @Override
    public void onResume() {
        super.onResume();
        android.util.Log.d("FragmentOne", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        android.util.Log.d("FragmentOne", "onPause()");
    }
}


