package com.example.dauster.wearmarvel.Adapters;

import android.content.Context;
import android.support.wear.widget.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dauster.wearmarvel.Model.Hero;
import com.example.dauster.wearmarvel.R;

/**
 * Created by dauster on 14/10/17.
 */

public class WearableRecyclerViewPowersAdapter extends WearableRecyclerView.Adapter<PowersViewHolder> {

    private Hero mHero;
    private Context mContext;

    public WearableRecyclerViewPowersAdapter(Hero hero, Context context) {
        mHero = hero;
        mContext = context;
    }

    @Override
    public PowersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.powers,parent,false);

        PowersViewHolder viewHolder = new PowersViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PowersViewHolder holder, int position) {

        int drawableIconId =
                mContext.getResources().getIdentifier("thumb_"+mHero.getImage(), "drawable", mContext.getPackageName());

        holder.mHeroName.setText(mHero.getHeroName());
        holder.mPowers.setText(mHero.getPowers());
        holder.mImage.setImageResource(drawableIconId);

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
