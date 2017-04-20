/*
 * Copyright (C) 2017 Danny Monroy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.fs.socialcareapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * ListActivity in this class we displays the view from the RecyclerView and also get our data from the JSON object
 * created by the PHP script.
 *
 * @author  Danny Monroy
 * @version 1.0
 * @since   2017-02-20
 */

public class ListActivity extends AppCompatActivity  {



    //final String URL = "https://socialcareapp.000webhostapp.com/index1.php";




    private RecyclerView recView;
    private ClientAdapter adapter;

    private List<VisitItem> visitItems;

    public String returnURL (){
        Intent intent = getIntent();
        String username = intent.getStringExtra("carer_id");
        final String URL_DATA = "https://socialcareapp.000webhostapp.com/index1.php?id="+username;
        return URL_DATA;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        recView = (RecyclerView)findViewById(R.id.rec_list);

        recView.setLayoutManager(new LinearLayoutManager(this));

        visitItems =  new ArrayList<>();

        loadRecyclerViewData();

    }

    private void loadRecyclerViewData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, returnURL(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("visits");

                            for(int i = 0; i<array.length(); i++){
                                JSONObject jsonObj = array.getJSONObject(i);

                                VisitItem item = new VisitItem(jsonObj.getString("title"),jsonObj.getString("name"),jsonObj.getString("middle_name"),jsonObj.getString("surname"),jsonObj.getString("area"),jsonObj.getString("start_time"),
                                jsonObj.getString("end_time"),jsonObj.getString("address"),jsonObj.getString("postcode"),jsonObj.getString("general_information"),jsonObj.getString("keycode"),jsonObj.getString("level_vulnerability"));

                                visitItems.add(item);
                            }

                            adapter = new ClientAdapter(visitItems, getApplicationContext());
                            recView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String volleyError = "There seems like there is no internet";
                        Toast.makeText(getApplicationContext(), volleyError, Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
