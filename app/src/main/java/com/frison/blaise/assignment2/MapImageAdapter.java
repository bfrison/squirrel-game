package com.frison.blaise.assignment2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Blaise on 29/oct./2017.
 */

public class MapImageAdapter extends BaseAdapter {
    private Context mContext;
    private final static int MAP_SIZE = 100;
    private final Forest forest;
    private List<Integer> mThumbIds;

    public MapImageAdapter(Context mContext, Forest forest) {
        this.mContext = mContext;
        this.forest = forest;
        mThumbIds = forest.getThisList();
    }

    public void update() {
        this.mThumbIds = this.forest.getThisList();
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int i) {
        return mThumbIds.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i / 10;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) view;
        }
        imageView.setImageResource(mThumbIds.get(i));
        return imageView;
    }

    public ImageView getSquirrelView() {
        for (int i = 0; i < MAP_SIZE;i++) {
            if (mThumbIds.get(i) == R.drawable.squirrel_sprite) {
                return (ImageView) getView(i,null,null);
            }
        }
        return null;
    }
}
