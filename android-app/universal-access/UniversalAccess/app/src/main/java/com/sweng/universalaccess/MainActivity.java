package com.sweng.universalaccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.input_username)
    AppCompatEditText userName;

    @Bind(R.id.input_password)
    AppCompatEditText passwword;

    @Bind(R.id.btn_login)
    AppCompatButton loginButton;

    @Bind(R.id.btn_signup)
    AppCompatButton signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObject object = new JsonObject();

                Ion
                        .with(MainActivity.this)
                        .load(getString(R.string.getUserTokenUrl))
                        .setBodyParameter("grant_type","password")
                        .setBodyParameter("email",userName.getText().toString())
                        .setBodyParameter("password",passwword.getText().toString())
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                if (e == null && result.get("access_token") != null) {
                                    getUser(result.get("access_token").getAsString());
                                    Log.d("FirstResult", result.toString());
                                } else {
                                    Toast.makeText(MainActivity.this, "Bad Credentials", Toast.LENGTH_SHORT).show();

                                    if (e != null)
                                        Log.d("AppTokenError", e.toString());
                                    else
                                        Log.d("AppTokenError", result.toString());
                                }
                            }
                        });
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });


    }

    public void getUser(final String access_token) {
        Ion
                .with(this)
                .load(getString(R.string.getUserURL))
                .addHeader("Authorization", "Bearer " + access_token)
                .setJsonObjectBody(new JsonObject())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (e == null) {
                            Log.d("LoginResult", result.toString());
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            intent.putExtra("Bearer", access_token);
                            JsonObject user = result.getAsJsonObject("user");
                            intent.putExtra("email", user.get("email").getAsString());
                            intent.putExtra("firstName", user.get("first_name").getAsString());
                            intent.putExtra("lastName", user.get("last_name").getAsString());
                            intent.putExtra("age",user.get("age").getAsString());
                            intent.putExtra("gender",user.get("gender").getAsString());
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                        Log.d("MyUser", result.toString());
                    }
                });
    }


}
