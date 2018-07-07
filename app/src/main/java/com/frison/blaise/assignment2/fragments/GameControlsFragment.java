package com.frison.blaise.assignment2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frison.blaise.assignment2.Forest;
import com.frison.blaise.assignment2.Game;
import com.frison.blaise.assignment2.R;

/**
 * Created by Blaise on 29/oct./2017.
 */

public class GameControlsFragment extends Fragment {
    Forest forest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.forest = ((Game) getActivity()).getForest();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_controls_fragment, container, false);
    }
}
