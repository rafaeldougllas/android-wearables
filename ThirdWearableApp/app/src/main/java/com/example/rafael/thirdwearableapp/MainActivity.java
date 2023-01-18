package com.example.rafael.thirdwearableapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by rafael on 23/09/17.
 */

public class MainActivity extends WearableActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);


        final Button button = findViewById(R.id.btnNewScreen);
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, NewFrame.class);
                startActivity(it);
            }
        });




        setAmbientEnabled();
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);

        Button btn = (Button) findViewById(R.id.btnNewScreen);
        btn.setBackgroundColor(getResources().getColor(R.color.green));
    }

    @Override
    public void onExitAmbient() {
        super.onExitAmbient();

        Button btn = (Button) findViewById(R.id.btnNewScreen);
        btn.setBackgroundColor(getResources().getColor(R.color.red));
    }
}
