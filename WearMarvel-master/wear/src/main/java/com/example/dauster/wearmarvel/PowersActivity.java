package com.example.dauster.wearmarvel;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.wear.widget.WearableRecyclerView;
import android.support.wear.widget.drawer.WearableActionDrawerView;
import android.support.wearable.activity.WearableActivity;
import android.view.MenuItem;

import com.example.dauster.wearmarvel.Adapters.WearableRecyclerViewPowersAdapter;
import com.example.dauster.wearmarvel.Model.Hero;

public class PowersActivity extends WearableActivity implements MenuItem.OnMenuItemClickListener {


    private WearableRecyclerView mWearableRecyclerView;
    private WearableActionDrawerView mWearableActionDrawer;
    private WearableRecyclerViewPowersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powers);

        Hero hero = getIntent().getExtras().getParcelable(MainActivity.TAG_HERO);

        mWearableRecyclerView = findViewById(R.id.powers_recycleview);

        mAdapter = new WearableRecyclerViewPowersAdapter(hero,this);

        mWearableRecyclerView.setAdapter(mAdapter);

        mWearableRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Bottom Action Drawer
        mWearableActionDrawer = findViewById(R.id.bottom_action_drawer_powers);
        // Peeks action drawer on the bottom.
        mWearableActionDrawer.getController().peekDrawer();
        mWearableActionDrawer.setOnMenuItemClickListener(this);


    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        finish();
        return true;
    }
}
