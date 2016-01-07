package com.sweng.universalaccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private String bearer;

    ArrayList<Violation> violations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bearer = getIntent().getExtras().getString("Bearer");
        violations = new ArrayList<>();

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

        getAllViolations();

    }

    private void getAllViolations() {
        Ion.with(this)
                .load(getString(R.string.createViolationURL))
                .addHeader("Authorization", "Bearer " + getIntent().getExtras().getString("Bearer"))
                .addHeader("Content-Type", "application/json")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (e == null) {
                            JsonArray violations = result.getAsJsonArray("violations");

                            Log.d("AllViolations", result.toString());
                        } else {
                        }
                    }
                });

    }

}
