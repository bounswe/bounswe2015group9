package com.sweng.universalaccess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;
import com.sweng.universalaccess.objects.City;
import com.sweng.universalaccess.objects.Districts;
import com.sweng.universalaccess.objects.Neighbourhoods;
import com.sweng.universalaccess.objects.Tags;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AdvanceSearchActivity extends AppCompatActivity {

    @Bind(R.id.advance_city_spinner)
    AppCompatSpinner city_spinner;
    @Bind(R.id.advance_district_spinner)
    AppCompatSpinner district_spinner;
    @Bind(R.id.advance_neighborhood_spinner)
    AppCompatSpinner neighbourhood_spinner;
    @Bind(R.id.advance_tags_spinner)
    AppCompatSpinner tags_spinner;
    @Bind(R.id.advance_selected_tags)
    AppCompatTextView selected_tags;
    @Bind(R.id.search_advance_button)
    AppCompatButton search_button;
    @Bind(R.id.advance_search_results)
    ListView violationList;


    MyAdapter adapter;
    ArrayList<Violation> violations;
    ArrayList<City> city_array;
    ArrayList<Districts> district_array;
    ArrayList<Neighbourhoods> neighbourhood_array;
    ArrayList<Tags> tags_array;
    ArrayList<String> cities, districts, neighbourhoods, tags;
    ArrayAdapter<String> city_adapter, district_adapter, neighbourhood_adapter, tags_adapter;

    String bearer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_search);

        ButterKnife.bind(this);

        bearer = getIntent().getExtras().getString("bearer");
        getCities();
        getTags();

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = getString(R.string.createViolationURL)+"?";
                boolean p = false;
                if (city_spinner.getSelectedItemPosition() > 0) {
                    url += "q[city_id_eq]=" + city_array.get(city_spinner.getSelectedItemPosition()).getId();
                    p = true;
                }
                if (neighbourhood_spinner.getSelectedItemPosition() > 0) {
                    if (p == true)
                        url += "&";
                    url += "q[neighborhood_id_eq]=" + neighbourhood_array.get(neighbourhood_spinner.getSelectedItemPosition()).getId();
                    p = true;
                }
                if (district_spinner.getSelectedItemPosition() > 0) {
                    if (p == true)
                        url += "&";
                    url += "q[district_id_eq]=" + district_array.get(district_spinner.getSelectedItemPosition()).getId();
                    p = true;
                }
                if (selected_tags.getText() != null && selected_tags.getText().toString().length() > 0) {
                    if (p == true)
                        url += "&";
                    url += "tag_list=" + selected_tags.getText().toString();
                }
                Log.d("mySearchURL:", url);
                Ion.with(AdvanceSearchActivity.this)
                        .load(url)
                        .addHeader("Content-Type","application/json")
                        .addHeader("Authorization","Bearer "+bearer)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {
                                if(e==null)
                                {
                                    Log.d("AdvanceSearchResult",result.toString());

                                    JsonArray violation_ar = result.getAsJsonArray("violations");

                                    violations = new ArrayList<Violation>();
                                    for (int i = 0; i < violation_ar.size(); ++i) {
                                        Violation violation = new Violation();
                                        Log.d("violationObject", violation_ar.get(i).getAsJsonObject().toString());

                                        JsonObject violation_obj = violation_ar.get(i).getAsJsonObject();
                                        violation.setTitle(violation_obj.get("title").getAsString());
                                        violation.setDescription(violation_obj.get("description").getAsString());
                                        if(violation_obj.get("rating") != null)
                                            violation.setSeverityRate(violation_obj.get("rating").getAsInt());
                                        else
                                            violation.setSeverityRate(0);
                                        violation.setCity(violation_obj.get("city").getAsJsonObject().get("name").getAsString());
                                        violation.setDistrict(violation_obj.get("district").getAsJsonObject().get("name").getAsString());
                                        violation.setNeighborhood(violation_obj.get("neighborhood").getAsJsonObject().get("name").getAsString());
                                        if(violation_obj.get("image_url")!=null)
                                            violation.setImage_url(violation_obj.get("image_url").getAsString());
                                        else
                                            violation.setImage_url("");
                                        violation.setType(violation_obj.get("type").getAsJsonObject().get("name").getAsString());
                                        violations.add(violation);
                                    }
                                    Log.d("AllViolations", violations.size() + "");
                                    adapter = new MyAdapter();

                                    violationList.setAdapter(adapter);

                                }
                            }
                        });

            }
        });

        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    getDistricts(city_array.get(i).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tags_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (selected_tags.getText().toString().equals(""))
                    selected_tags.setText(selected_tags.getText().toString() + tags_spinner.getSelectedItem().toString());
                else
                    selected_tags.setText(selected_tags.getText().toString() + "," + tags_spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        district_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0)
                getNeighbourhoods(district_array.get(i).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void getCities() {
        city_array = new ArrayList<>();
        cities = new ArrayList<>();
        city_array.add(new City());
        cities.add("");
        Ion.with(this)
                .load(getString(R.string.getCityUrl))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + bearer)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        Log.d("CityResults", result.toString());
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
                            city_adapter = new ArrayAdapter<String>(AdvanceSearchActivity.this, android.R.layout.simple_spinner_item, cities);
                            city_spinner.setAdapter(city_adapter);
                            city_spinner.setSelection(0);
                        }
                    }
                });
    }

    private void getDistricts(int id) {
        district_array = new ArrayList<>();
        districts = new ArrayList<>();
        district_array.add(new Districts());
        districts.add("");
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
                            district_adapter = new ArrayAdapter<String>(AdvanceSearchActivity.this, android.R.layout.simple_spinner_item, districts);
                            district_spinner.setAdapter(district_adapter);
                            district_spinner.setSelection(0);
                        }
                    }
                });
    }

    private void getNeighbourhoods(int id) {
        neighbourhoods = new ArrayList<>();
        neighbourhoods.add("");
        neighbourhood_array = new ArrayList<>();
        neighbourhood_array.add(new Neighbourhoods());
        Ion.with(this)
                .load(getString(R.string.getNeighbourhoodURL) + "?id=" + id)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + bearer)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
//                        Log.d("CityResults",e.toString());
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
                            neighbourhood_adapter = new ArrayAdapter<String>(AdvanceSearchActivity.this, android.R.layout.simple_spinner_item, neighbourhoods);
                            neighbourhood_spinner.setAdapter(neighbourhood_adapter);
                            neighbourhood_spinner.setSelection(0);
                        }
                    }
                });
    }

    private void getTags() {
        tags = new ArrayList<>();
        tags.add("");
        tags_array = new ArrayList<>();
        tags_array.add(new Tags());
        Ion.with(this)
                .load(getString(R.string.getTagURL))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + bearer)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
//                        Log.d("CityResults", e.toString());
                        if (e == null) {
                            JsonArray tag_ar = result.getAsJsonArray("tags");
                            Log.d("CitySize", tag_ar.size() + "");
                            for (int i = 0; i < tag_ar.size(); ++i) {
                                Tags tag = new Tags();
                                tag.setName(tag_ar.get(i).getAsJsonObject().get("name").getAsString());
                                tag.setId(tag_ar.get(i).getAsJsonObject().get("id").getAsInt());
                                tag.setTaggings_count(tag_ar.get(i).getAsJsonObject().get("taggings_count").getAsInt());
                                tags.add(tag_ar.get(i).getAsJsonObject().get("name").getAsString());
                                tags_array.add(tag);
                            }
                            tags_adapter = new ArrayAdapter<String>(AdvanceSearchActivity.this, android.R.layout.simple_spinner_item, tags);
                            tags_spinner.setAdapter(tags_adapter);
                        }
                    }
                });

    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return violations.size();
        }

        @Override
        public Object getItem(int i) {
            return violations.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            final ViewHolder holder;

            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.violation_item, null);
                holder = new ViewHolder();
                holder.title = (TextView) view.findViewById(R.id.descriptionText);
                holder.description = (TextView)view.findViewById(R.id.single_violation_description);
                holder.picture = (ImageView) view.findViewById(R.id.image);
                holder.city =  (TextView)view.findViewById(R.id.single_violation_city_name);
                holder.district = (TextView)view.findViewById(R.id.single_violation_district_name);
                holder.neighborhood = (TextView)view.findViewById(R.id.single_violation_neighborhood_name);
                holder.type = (TextView)view.findViewById(R.id.single_violation_type);
                holder.severity_rate= (TextView)view.findViewById(R.id.single_severity_rate);
                view.setTag(holder);
            } else
                holder = (ViewHolder) view.getTag();
            holder.title.setText(violations.get(i).getTitle());
            holder.description.setText(violations.get(i).getDescription());
            holder.city.setText(violations.get(i).getCity());
            holder.district.setText(violations.get(i).getDistrict());
            holder.neighborhood.setText(violations.get(i).getNeighborhood());
            holder.severity_rate.setText(violations.get(i).getSeverityRate()+"");
            holder.type.setText(violations.get(i).getType());
            if(violations.get(i).getImage_url().equals("")==false)
                Picasso.with(AdvanceSearchActivity.this).load(violations.get(i).getImage_url()).into(holder.picture);

            return view;
        }


    }

    public static class ViewHolder {
        ImageView picture;
        TextView description,title,severity_rate,city,district,neighborhood,type;
    }


}
