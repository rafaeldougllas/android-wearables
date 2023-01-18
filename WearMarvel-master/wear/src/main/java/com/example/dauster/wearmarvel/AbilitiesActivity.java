package com.example.dauster.wearmarvel;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.wear.widget.WearableRecyclerView;
import android.support.wear.widget.drawer.WearableActionDrawerView;
import android.support.wearable.activity.WearableActivity;
import android.view.MenuItem;

import com.example.dauster.wearmarvel.Adapters.WearableRecyclerViewAbilitiesAdapter;
import com.example.dauster.wearmarvel.Model.Hero;

public class AbilitiesActivity extends WearableActivity implements MenuItem.OnMenuItemClickListener {


    private WearableRecyclerView mWearableRecyclerView;
    private WearableActionDrawerView mWearableActionDrawer;
    private WearableRecyclerViewAbilitiesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abilities);

        Hero hero = getIntent().getExtras().getParcelable(MainActivity.TAG_HERO);

        mWearableRecyclerView = findViewById(R.id.abilities_recycleview);

        mAdapter = new WearableRecyclerViewAbilitiesAdapter(hero,this);

        mWearableRecyclerView.setAdapter(mAdapter);

        mWearableRecyclerView.setEdgeItemsCenteringEnabled(true);

        mWearableRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Bottom Action Drawer
        mWearableActionDrawer = findViewById(R.id.bottom_action_drawer_abilities);
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

