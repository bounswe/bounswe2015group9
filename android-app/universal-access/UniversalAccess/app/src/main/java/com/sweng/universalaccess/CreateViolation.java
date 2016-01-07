package com.sweng.universalaccess;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;
import com.sweng.universalaccess.objects.City;
import com.sweng.universalaccess.objects.Districts;
import com.sweng.universalaccess.objects.Neighbourhoods;
import com.sweng.universalaccess.objects.ViolationTypes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CreateViolation extends AppCompatActivity {

    @Bind(R.id.violation_title)
    AppCompatEditText title;

    @Bind(R.id.violation_description)
    AppCompatEditText description;

    @Bind(R.id.violation_button_create)
    AppCompatButton createButton;

    @Bind(R.id.violation_location)
    AppCompatSpinner city_spinner;
    @Bind(R.id.district_spinner)
    AppCompatSpinner district_spinner;
    @Bind(R.id.neighbourhood_spinner)
    AppCompatSpinner neighbourhood_spinner;
    @Bind(R.id.type_spinner)
    AppCompatSpinner type_spinner;
    @Bind(R.id.address_edittext)
    AppCompatEditText address;

    @Bind(R.id.type_description)
    AppCompatTextView type_description;

    @Bind(R.id.take_picture_button)
    AppCompatButton takePictureWithCamera;


    ArrayList<ViolationTypes> types;
    ArrayList<Districts> district_array;
    ArrayList<Neighbourhoods> neighbourhood_array;
    ArrayList<City> city_array;

    private String bearer;
    private String imageURL;

    private ArrayList<String> cities, type_names, districts, neighbourhoods;
    ArrayAdapter<String> city_adapter, type_adapter, district_adapter, neighbourhood_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_violation);

        ButterKnife.bind(this);

        cities = new ArrayList<>();
        types = new ArrayList<>();
        type_names = new ArrayList<>();
        bearer = getIntent().getExtras().getString("Bearer");

        takePictureWithCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, 0);
            }
        });

        imageURL = "";

        getCities();
        getTypes();

        type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                type_description.setText(types.get(i).getDescription());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getDistricts(city_array.get(i).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        district_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getNeighbourhoods(district_array.get(i).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        ArrayAdapter<String> city_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,cities);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonObject violation = new JsonObject();
                violation.addProperty("title", title.getText().toString());
                violation.addProperty("description", description.getText().toString());
                violation.addProperty("address", address.getText().toString());
                violation.addProperty("type_id", types.get(type_spinner.getSelectedItemPosition()).getId());
                violation.addProperty("city_id", city_array.get(city_spinner.getSelectedItemPosition()).getId());
                violation.addProperty("district_id", district_array.get(district_spinner.getSelectedItemPosition()).getId());
                violation.addProperty("neighborhood_id", neighbourhood_array.get(neighbourhood_spinner.getSelectedItemPosition()).getId());
                violation.addProperty("closed", false);
                violation.addProperty("image_url",imageURL);

                Ion.with(CreateViolation.this)
                        .load(getString(R.string.createViolationURL))
                        .addHeader("Authorization", "Bearer " + getIntent().getExtras().getString("Bearer"))
                        .addHeader("Content-Type", "application/json")
                        .setJsonObjectBody(violation)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                if (e == null) {
                                    finish();
//                                    Log.d("CreateViolationResult", result.toString());
                                } else {
//                                    Log.d("CreateViolationError", e.toString());
                                }
                            }
                        });

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case 0:

                if (resultCode == RESULT_OK) {
                    Bitmap photo = (Bitmap) imageReturnedIntent.getExtras().get("data");
                    File file = new File(Environment.getExternalStorageDirectory(), "myImage.jpg"); // the File to save to

                    FileOutputStream out = null;
                    try {
                        out = new FileOutputStream(file);
                        photo.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
                        // PNG is a lossless format, the compression factor (100) is ignored
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (out != null) {
                                out.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
//                    mImageUri = imageReturnedIntent.getData();
//                    Log.d("IntentDate", imageReturnedIntent.getExtras().get("data").toString());
//                    Log.d("URI", mImageUri.toString());

                    Log.d("FilePath",file.getAbsolutePath());

                    Ion.with(CreateViolation.this)
                            .load(getString(R.string.uploadURL))
                            .uploadProgressHandler(new ProgressCallback() {
                                @Override
                                public void onProgress(long uploaded, long total) {
                                    // Displays the progress bar for the first time.
                                }
                            })
                            .addHeader("Authorization","bearer "+bearer)
                            .setTimeout(60 * 60 * 1000)
                            .setMultipartFile("upload", "image/jpeg", file)
                            .asJsonObject()
                                    // run a callback on completion
                            .setCallback(new FutureCallback<JsonObject>() {
                                @Override
                                public void onCompleted(Exception e, JsonObject result) {
                                    // When the loop is finished, updates the notification
                                    if (e != null) {
                                        Log.d("ImageUpload",result.toString());
                                        Toast.makeText(CreateViolation.this, "Error uploading file", Toast.LENGTH_LONG).show();
                                        return;
                                    }
//                                    Log.d("ImageUpload",result.toString());

                                    imageURL =result.get("files").getAsJsonArray().get(0).getAsJsonObject().get("url").getAsString();

                                    Toast.makeText(CreateViolation.this, "File upload complete", Toast.LENGTH_LONG).show();
                                }
                            });
                }

                break;
            case 1:
                break;
        }
    }

    private void getCities() {
        city_array = new ArrayList<>();
        Ion.with(this)
                .load(getString(R.string.getCityUrl))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + bearer)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
//                        Log.d("CityResults", result.toString());
                        if (e == null) {
                            JsonArray city_ar = result.getAsJsonArray("cities");
                            Log.d("CitySize", city_ar.size() + "");
                            for (int i = 0; i < city_ar.size(); ++i) {
                                City city = new City();
                                city.setId(city_ar.get(i).getAsJsonObject().get("id").getAsInt());
                                city.setName(city_ar.get(i).getAsJsonObject().get("name").getAsString());
                                cities.add(city_ar.get(i).getAsJsonObject().get("name").getAsString());
                                city_array.add(city);
                            }
                            city_adapter = new ArrayAdapter<String>(CreateViolation.this, android.R.layout.simple_spinner_item, cities);
                            city_spinner.setAdapter(city_adapter);
                            city_spinner.setSelection(0);
                        }
                    }
                });
    }

    private void getTypes() {
        Ion.with(this)
                .load(getString(R.string.getTypesURL))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + bearer)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        Log.d("Type", result.toString());
                        if (e == null) {
                            JsonArray type_ar = result.getAsJsonArray("types");
                            Log.d("Type", type_ar.size() + "");
                            for (int i = 0; i < type_ar.size(); ++i) {
                                ViolationTypes type = new ViolationTypes();
                                type.setName(type_ar.get(i).getAsJsonObject().get("name").getAsString());
                                type.setId(type_ar.get(i).getAsJsonObject().get("id").getAsInt());
                                type.setDescription(type_ar.get(i).getAsJsonObject().get("description").getAsString());
                                type_names.add(type.getName());
                                types.add(type);
                            }
                            type_adapter = new ArrayAdapter<>(CreateViolation.this, android.R.layout.simple_spinner_item, type_names);
                            type_spinner.setAdapter(type_adapter);
                        }
                    }
                });
    }

    private void getDistricts(int id) {
        district_array = new ArrayList<>();
        districts = new ArrayList<>();
        Ion.with(this)
                .load(getString(R.string.getDisctrictURL) + "?id=" + id)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + bearer)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        Log.d("DistrictError", result.toString());
                        if (e == null) {
                            JsonArray district_ar = result.getAsJsonArray("districts");
//                            Log.d("CitySize",city_ar.size()+"");
                            for (int i = 0; i < district_ar.size(); ++i) {
                                Districts district = new Districts();
                                Log.d("myerror", district_ar.get(i).getAsJsonObject().toString());
                                districts.add(district_ar.get(i).getAsJsonObject().get("name").getAsString());
                                district.setName(districts.get(i));
                                district.setId(district_ar.get(i).getAsJsonObject().get("id").getAsInt());
                                district_array.add(district);
                            }
                            district_adapter = new ArrayAdapter<String>(CreateViolation.this, android.R.layout.simple_spinner_item, districts);
                            district_spinner.setAdapter(district_adapter);
                            district_spinner.setSelection(0);
                        }
                    }
                });
    }

    private void getNeighbourhoods(int id) {
        neighbourhoods = new ArrayList<>();
        neighbourhood_array = new ArrayList<>();
        Ion.with(this)
                .load(getString(R.string.getNeighbourhoodURL) + "?id=" + id)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + bearer)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        Log.d("CityResults", result.toString());
                        if (e == null) {
                            JsonArray city_ar = result.getAsJsonArray("neighborhoods");
                            Log.d("CitySize", city_ar.size() + "");
                            for (int i = 0; i < city_ar.size(); ++i) {
                                Neighbourhoods neighbourhood = new Neighbourhoods();
                                neighbourhood.setName(city_ar.get(i).getAsJsonObject().get("name").getAsString());
                                neighbourhood.setId(city_ar.get(i).getAsJsonObject().get("id").getAsInt());
                                neighbourhoods.add(city_ar.get(i).getAsJsonObject().get("name").getAsString());
                                neighbourhood_array.add(neighbourhood);
                            }
                            neighbourhood_adapter = new ArrayAdapter<String>(CreateViolation.this, android.R.layout.simple_spinner_item, neighbourhoods);
                            neighbourhood_spinner.setAdapter(neighbourhood_adapter);
                            neighbourhood_spinner.setSelection(0);
                        }
                    }
                });
    }


}
