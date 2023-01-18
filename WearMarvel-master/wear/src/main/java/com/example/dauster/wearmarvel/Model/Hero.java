package com.example.dauster.wearmarvel.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dauster on 13/10/17.
 */

public class Hero implements Parcelable {

    private String heroName;
    private String realName;
    private String powers;
    private String abilities;
    private String image;

    public Hero(
            String heroName,
            String realName,
            String powers,
            String abilities,
            String image
            ) {

        this.heroName = heroName;
        this.realName = realName;
        this.powers = powers;
        this.abilities = abilities;
        this.image = image;
    }

    protected Hero(Parcel in) {
        heroName = in.readString();
        realName = in.readString();
        powers = in.readString();
        abilities = in.readString();
        image = in.readString();
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getPowers() {
        return powers;
    }

    public String getAbilities() {
        return abilities;
    }

    public String getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(heroName);
        parcel.writeString(realName);
        parcel.writeString(powers);
        parcel.writeString(abilities);
        parcel.writeString(image);
    }
}