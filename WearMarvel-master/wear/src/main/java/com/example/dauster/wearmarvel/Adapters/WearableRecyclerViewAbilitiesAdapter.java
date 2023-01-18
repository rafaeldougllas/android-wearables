package com.example.dauster.wearmarvel.Adapters;

import android.content.Context;
import android.support.wear.widget.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dauster.wearmarvel.Model.Hero;
import com.example.dauster.wearmarvel.R;

/**
 * Created by dauster on 15/10/17.
 */

public class WearableRecyclerViewAbilitiesAdapter extends WearableRecyclerView.Adapter<AbilitiesViewHolder> {

    private Hero mHero;
    private Context mContext;

    public WearableRecyclerViewAbilitiesAdapter(Hero hero, Context context) {
        mHero = hero;
        mContext = context;
    }

    @Override
    public AbilitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.abilities,parent,false);

        AbilitiesViewHolder viewHolder = new AbilitiesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AbilitiesViewHolder holder, int position) {

        if (position == 0){
            int drawableIconId =
                    mContext.getResources().getIdentifier("thumb_"+mHero.getImage(), "drawable", mContext.getPackageName());

            holder.mHeroName.setText(mHero.getHeroName());
            holder.mAbilities.setText(mHero.getAbilities());
            holder.mImage.setImageResource(drawableIconId);

        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

