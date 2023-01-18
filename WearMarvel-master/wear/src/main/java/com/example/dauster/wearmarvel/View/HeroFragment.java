package com.example.dauster.wearmarvel.View;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dauster.wearmarvel.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeroFragment extends Fragment {

    public static final String HERO_IMAGE_ID = "hero_image_id";

    private ImageView mImageView;

    public HeroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_hero, container, false);

        mImageView = rootView.findViewById(R.id.image);

        int imageIdToLoad = getArguments().getInt(HERO_IMAGE_ID);
        mImageView.setImageResource(imageIdToLoad);

        return rootView;
    }

    public void updateHero(int imageId) {
        mImageView.setImageResource(imageId);
    }


}
