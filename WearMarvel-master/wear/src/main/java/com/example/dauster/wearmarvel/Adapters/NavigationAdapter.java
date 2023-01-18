package com.example.dauster.wearmarvel.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.wear.widget.drawer.WearableNavigationDrawerView;

import com.example.dauster.wearmarvel.Model.Hero;

import java.util.ArrayList;

/**
 * Created by dauster on 13/10/17.
 */

public class NavigationAdapter extends WearableNavigationDrawerView.WearableNavigationDrawerAdapter {

    private final Context mContext;
    private ArrayList<Hero> mHeroArrayList;

    public NavigationAdapter(Context context, ArrayList<Hero> heroArrayList) {
        mContext = context;
        mHeroArrayList = heroArrayList;

    }

    @Override
    public int getCount() {
        return mHeroArrayList.size();
    }

    @Override
    public String getItemText(int pos) {
        return mHeroArrayList.get(pos).getHeroName();
    }

    @Override
    public Drawable getItemDrawable(int pos) {
        String navigationIcon = mHeroArrayList.get(pos).getImage();

        int drawableNavigationIconId =
                mContext.getResources().getIdentifier("thumb_"+navigationIcon, "drawable", mContext.getPackageName());


        return mContext.getDrawable(drawableNavigationIconId);
    }
}

