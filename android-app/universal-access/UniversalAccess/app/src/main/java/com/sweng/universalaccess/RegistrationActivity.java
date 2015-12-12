package com.sweng.universalaccess;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

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

    private String appBearerToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ButterKnife.bind(this);


        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("email",emailEditText.getText().toString());
                jsonObject.addProperty("password",passwordEditText.getText().toString());
                jsonObject.addProperty("firstName",nameEditText.getText().toString());
                jsonObject.addProperty("lastName",surnameEditText.getText().toString());

                Ion.with(RegistrationActivity.this)
                        .load(getString(R.string.getAppTokenUrl))
                        .addHeader("Authorization",getString(R.string.appToken))
                        .setJsonObjectBody(new JsonObject())
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                Log.d("Access_Token",result.toString());
                                appBearerToken = result.get("access_token").getAsString();
                                createUser(jsonObject);
                            }
                        });

            }
        });

    }

    private void createUser(JsonObject user){
        Ion.with(RegistrationActivity.this)
                .load(getString(R.string.createUser))
                .addHeader("Authorization","Bearer "+appBearerToken)
//                .addHeader("Content-Type","application/json")
                .setJsonObjectBody(user)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
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
