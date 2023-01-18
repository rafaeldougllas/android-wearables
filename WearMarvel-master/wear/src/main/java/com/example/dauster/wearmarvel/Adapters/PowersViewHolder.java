package com.example.rafael.wearmarvel.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rafael.wearmarvel.R;

/**
 * Created by rafael on 14/10/17.
 */

public class PowersViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mHeroName;
    TextView mPowers;


    public PowersViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.powers_image);
        mHeroName = itemView.findViewById(R.id.powers_text_hero_name);
        mPowers = itemView.findViewById(R.id.powers_text);
    }
}
