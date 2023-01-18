package com.example.rafael.wearmarvel.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rafael.wearmarvel.R;

/**
 * Created by rafael on 15/10/17.
 */

class AbilitiesViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mHeroName;
    TextView mAbilities;


    public AbilitiesViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.abilities_image);
        mHeroName = itemView.findViewById(R.id.abilities_text_hero_name);
        mAbilities = itemView.findViewById(R.id.abilities_text);
    }


}