package com.frison.blaise.assignment2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.frison.blaise.assignment2.Game;
import com.frison.blaise.assignment2.Inventory;
import com.frison.blaise.assignment2.R;

/**
 * Created by Blaise on 29/oct./2017.
 */

public class InventoryFragment extends Fragment {
    Inventory inventory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inventory = ((Game)getActivity()).getInventory();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.inventory_fragment, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView[] imageViews = new ImageView[5];
        imageViews[0] = getView().findViewById(R.id.inventory_image_1);
        imageViews[1] = getView().findViewById(R.id.inventory_image_2);
        imageViews[2] = getView().findViewById(R.id.inventory_image_3);
        imageViews[3] = getView().findViewById(R.id.inventory_image_4);
        imageViews[4] = getView().findViewById(R.id.inventory_image_5);
        for (int i = 0; i < 5;i++) {
            if (this.inventory.get(i + 1)) {
                imageViews[i].setImageResource(R.drawable.acorn_icon);
            }
        }
    }
}
