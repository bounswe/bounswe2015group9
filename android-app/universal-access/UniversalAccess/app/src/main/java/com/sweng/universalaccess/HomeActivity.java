package com.sweng.universalaccess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    private String bearer;

    @Bind(R.id.violation_list) ListView violationList;
    MyAdapter adapter;

    @Bind(R.id.advance_search_button) AppCompatButton advancedSearchButton;

    ArrayList<Violation> violations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        bearer = getIntent().getExtras().getString("Bearer");
        violations = new ArrayList<>();

        advancedSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

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
                            JsonArray violation_ar = result.getAsJsonArray("violations");

                            Log.d("violationObject", violation_ar.get(0).getAsJsonObject().toString());
                            for (int i = 0; i < violation_ar.size(); ++i) {
                                Violation violation = new Violation();

                                JsonObject violation_obj = violation_ar.get(i).getAsJsonObject();
                                violation.setTitle(violation_obj.get("title").getAsString());
                                violation.setDescription(violation_obj.get("description").getAsString());
//                                violation.setSeverityRate(violation_obj.get("rating").getAsInt());
                                violation.setCity(violation_obj.get("city").getAsJsonObject().get("name").getAsString());
                                violation.setDistrict(violation_obj.get("district").getAsJsonObject().get("name").getAsString());
                                violation.setNeighborhood(violation_obj.get("neighborhood").getAsJsonObject().get("name").getAsString());
//                                violation.setImage_url(violation_obj.get("image_url").getAsString());
                                violations.add(violation);
                            }
                            Log.d("AllViolations", violations.size() + "");
                            adapter = new MyAdapter();

                            violationList.setAdapter(adapter);

                        } else {
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

                view.setTag(holder);
            } else
                holder = (ViewHolder) view.getTag();
            holder.title.setText(violations.get(i).getTitle());
            holder.description.setText(violations.get(i).getDescription());
            holder.city.setText(violations.get(i).getCity());
            holder.district.setText(violations.get(i).getDistrict());
            holder.neighborhood.setText(violations.get(i).getNeighborhood());
//            Picasso.with(HomeActivity.this).load(violations.get(i).getPicture()).into(holder.picture);

            return view;
        }


    }

    public static class ViewHolder {
        ImageView picture;
        TextView description,title,severity_rate,city,district,neighborhood,type;
        AppCompatButton downloadButton;
    }

}
