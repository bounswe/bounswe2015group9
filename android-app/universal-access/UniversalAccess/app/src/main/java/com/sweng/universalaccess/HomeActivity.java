package com.sweng.universalaccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonArray;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(HomeActivity.this, CreateViolation.class);
                intent.putExtra("Bearer", getIntent().getExtras().getString("Bearer"));
                startActivity(intent);

            }
        });

        Ion.with(this)
                .load(getString(R.string.getAllViolationsURL))
                .addHeader("Authorization", "Bearer " + getIntent().getExtras().getString("Bearer"))
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        if (e == null) {
                            Log.d("GetAllViolations", result.toString());
                        } else {
                            Log.d("GetAllViolationsError", e.toString());
                        }
                    }
                });
    }

}
