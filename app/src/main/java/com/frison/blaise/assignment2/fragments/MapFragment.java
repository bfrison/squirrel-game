package com.frison.blaise.assignment2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.frison.blaise.assignment2.Forest;
import com.frison.blaise.assignment2.Game;
import com.frison.blaise.assignment2.MapImageAdapter;
import com.frison.blaise.assignment2.R;

/**
 * Created by Blaise on 28/oct./2017.
 */

public class MapFragment extends Fragment {
    private Forest forest;
    private ImageView squirrelView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            this.forest = ((Game)getActivity()).getForest();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       GridView gridView = getView().findViewById(R.id.grid_map);
        MapImageAdapter mia = new MapImageAdapter(this.getContext(), this.forest);
        gridView.setAdapter(mia);
        this.squirrelView = mia.getSquirrelView();
    }

    public ImageView getSquirrelView() {
        return squirrelView;
    }
}
