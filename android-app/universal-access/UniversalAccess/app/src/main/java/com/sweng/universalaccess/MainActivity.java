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

                String unamepass = "&username=" + userName.getText().toString() + "&password=" + passwword.getText().toString();

                Ion
                        .with(MainActivity.this)
                        .load(getString(R.string.getUserTokenUrl) + unamepass)
                        .addHeader("Authorization", getString(R.string.appToken))
                        .addHeader("Content-Type", "application/json")
                        .setJsonObjectBody(new JsonObject())
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
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (e == null) {
                            Log.d("LoginResult", result.toString());
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            intent.putExtra("Bearer", access_token);
                            intent.putExtra("email", result.get("email").getAsString());
                            intent.putExtra("firstName", result.get("firstName").getAsString());
                            intent.putExtra("lastName", result.get("lastName").getAsString());
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                        }
                        Log.d("MyUser", result.toString());
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
