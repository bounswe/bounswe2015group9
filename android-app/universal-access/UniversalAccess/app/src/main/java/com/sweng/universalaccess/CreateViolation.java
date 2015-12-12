package com.sweng.universalaccess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CreateViolation extends AppCompatActivity {

    @Bind(R.id.violation_title)
    AppCompatEditText title;

    @Bind(R.id.violation_description)
    AppCompatEditText description;

    @Bind(R.id.violation_location)
    AppCompatEditText location;

    @Bind(R.id.violation_button_create)
    AppCompatButton createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation);

        ButterKnife.bind(this);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonObject violation = new JsonObject();
                violation.addProperty("title", title.getText().toString());
                violation.addProperty("description", description.getText().toString());
                violation.addProperty("location", location.getText().toString());
                violation.addProperty("closed",false);

                Ion.with(CreateViolation.this)
                        .load(getString(R.string.createViolationURL))
                        .addHeader("Authorization", "Bearer " + getIntent().getExtras().getString("Bearer"))
                        .setJsonObjectBody(violation)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                if (e == null) {
                                    Log.d("CreateViolationResult", result.toString());
                                } else {
                                    Log.d("CreateViolationError", e.toString());
                                }
                            }
                        });

            }
        });

    }
}
