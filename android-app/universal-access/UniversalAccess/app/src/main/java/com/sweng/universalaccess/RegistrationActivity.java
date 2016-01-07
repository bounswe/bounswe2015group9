package com.sweng.universalaccess;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity {

    @Bind(R.id.emailEditText)
    AppCompatEditText emailEditText;

    @Bind(R.id.passwordEditText)
    AppCompatEditText passwordEditText;

    @Bind(R.id.nameEditText)
    AppCompatEditText nameEditText;

    @Bind(R.id.surnameEditText)
    AppCompatEditText surnameEditText;

    @Bind(R.id.createButton)
    AppCompatButton createUserButton;

    @Bind(R.id.age_editText)
    AppCompatEditText age;

    @Bind(R.id.gender_Spinner)
    AppCompatSpinner gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.gender));

        gender.setAdapter(adapter);


        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("email",emailEditText.getText().toString());
                jsonObject.addProperty("password",passwordEditText.getText().toString());
                jsonObject.addProperty("first_name",nameEditText.getText().toString());
                jsonObject.addProperty("last_name",surnameEditText.getText().toString());
                jsonObject.addProperty("age",age.getText().toString());
                jsonObject.addProperty("gender",gender.getSelectedItem().toString());



                createUser(jsonObject);
            }
        });

    }

    private void createUser(JsonObject user) {
        Log.d("createUser","enter");
        Ion.with(RegistrationActivity.this)
                .load(getString(R.string.createUser))
                .addHeader("Content-Type","application/json")
                .setJsonObjectBody(user)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
//                        Log.d("CreateResult",e.toString());
                        if(e == null) {
                            Log.d("UserCreated", result.toString());
                        }
                        else
                        {
                            Log.d("UserCreationError",e.toString());
                        }
                    }
                });

    }

}
