package com.example.dauster.wearmarvel.Controller;

import android.content.Context;

import com.example.dauster.wearmarvel.Model.Hero;
import com.example.dauster.wearmarvel.R;

import java.util.ArrayList;

/**
 * Created by dauster on 13/10/17.
 */

public class ApiHero {


    public static ArrayList<Hero> initializeHeros(Context context) {
        ArrayList<Hero> heroList = new ArrayList<Hero>();
        String[] heroArrayNames = context.getResources().getStringArray(R.array.hero_array_names);

        for (int i = 0; i < heroArrayNames.length; i++) {
            String hero = heroArrayNames[i];
            int planetResourceId =
                    context.getResources().getIdentifier(hero, "array", context.getPackageName());
            String[] heroInformation = context.getResources().getStringArray(planetResourceId);

            heroList.add(new Hero(
                    heroInformation[0],   // HeroName
                    heroInformation[1],   // RealName
                    heroInformation[2],   // powers
                    heroInformation[3],   // abilities
                    heroInformation[4])); // Image
        }

        return heroList;
    }

}
