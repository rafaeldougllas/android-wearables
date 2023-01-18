package com.example.dauster.wearmarvel;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.wear.widget.drawer.WearableActionDrawerView;
import android.support.wear.widget.drawer.WearableNavigationDrawerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dauster.wearmarvel.Adapters.NavigationAdapter;
import com.example.dauster.wearmarvel.Controller.ApiHero;
import com.example.dauster.wearmarvel.Model.Hero;
import com.example.dauster.wearmarvel.View.HeroFragment;

import java.util.ArrayList;

public class MainActivity extends Activity implements
        MenuItem.OnMenuItemClickListener, WearableNavigationDrawerView.OnItemSelectedListener {

    public static final String TAG_HERO = "hero";

    private WearableNavigationDrawerView mWearableNavigationDrawer;
    private WearableActionDrawerView mWearableActionDrawer;

    private ArrayList<Hero> mHeroList;
    private int mSelectedHero;

    private HeroFragment mHeroFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeroList = ApiHero.initializeHeros(this);
        mSelectedHero = 0;

        // Initialize content to first planet.
        mHeroFragment = new HeroFragment();
        Bundle args = new Bundle();

        int imageId = getResources().getIdentifier(mHeroList.get(mSelectedHero).getImage(),
                "drawable", getPackageName());


        args.putInt(HeroFragment.HERO_IMAGE_ID, imageId);
        mHeroFragment.setArguments(args);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, mHeroFragment).commit();


        // Top Navigation Drawer
        mWearableNavigationDrawer =
                (WearableNavigationDrawerView) findViewById(R.id.top_navigation_drawer);
        mWearableNavigationDrawer.setAdapter(new NavigationAdapter(this,mHeroList));
        // Peeks navigation drawer on the top.
        mWearableNavigationDrawer.getController().peekDrawer();
        mWearableNavigationDrawer.addOnItemSelectedListener(this);

        // Bottom Action Drawer
        mWearableActionDrawer =
                (WearableActionDrawerView) findViewById(R.id.bottom_action_drawer);
        // Peeks action drawer on the bottom.
        mWearableActionDrawer.getController().peekDrawer();
        mWearableActionDrawer.setOnMenuItemClickListener(this);

    }


    @Override
    public void onItemSelected(int pos) {
        mSelectedHero = pos;

        String selectedHeroImage = mHeroList.get(mSelectedHero).getImage();
        int drawableId =
                getResources().getIdentifier(selectedHeroImage, "drawable", getPackageName());
        mHeroFragment.updateHero(drawableId);

    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        final int itemId = menuItem.getItemId();
        Intent intent = null;
        Bundle params = null;

        String toastMessage = "";

        switch (itemId) {
            case R.id.menu_hero_heroname:
                toastMessage = mHeroList.get(mSelectedHero).getHeroName();
                break;
            case R.id.menu_hero_realname:
                toastMessage = mHeroList.get(mSelectedHero).getRealName();
                break;
            case R.id.menu_hero_powers:
                intent = new Intent(this, PowersActivity.class);

                params = new Bundle();
                params.putParcelable(TAG_HERO, mHeroList.get(mSelectedHero));
                intent.putExtras(params);

                startActivity(intent);

                break;
            case R.id.menu_hero_abilities:
                intent = new Intent(this, AbilitiesActivity.class);

                params = new Bundle();
                params.putParcelable(TAG_HERO, mHeroList.get(mSelectedHero));
                intent.putExtras(params);

                startActivity(intent);

                break;
        }

        mWearableActionDrawer.getController().closeDrawer();

        if (toastMessage.length() > 0) {
            Toast toast = Toast.makeText(
                    getApplicationContext(),
                    toastMessage,
                    Toast.LENGTH_SHORT);
            toast.show();
            return true;
        } else {
            return false;
        }
    }
}
