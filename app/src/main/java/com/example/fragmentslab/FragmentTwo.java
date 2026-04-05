package com.example.fragmentslab;

import android.media.Rating;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    private TextView rating;
    private SeekBar seek;
    private int progress = 0;
    private static final String KEY_PROGRESS = "progress";

    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rating = view.findViewById(R.id.Rating);
        seek = view.findViewById(R.id.seekBar);

        // Restaurer l’état si rotation
        if (savedInstanceState != null) {
            progress = savedInstanceState.getInt(KEY_PROGRESS, 0);
            seek.setProgress(progress);
            rating.setText("Rating : " + progress);
        }

        // Suivre les changements de la barre
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar s, int p, boolean fromUser) {
                progress = p;
                rating.setText("Rating : " + p);
            }
            @Override public void onStartTrackingTouch(SeekBar s) {}
            @Override public void onStopTrackingTouch(SeekBar s) {}
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_PROGRESS, progress);
    }
}