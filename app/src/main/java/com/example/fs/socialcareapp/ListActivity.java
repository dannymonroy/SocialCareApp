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

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements ClientAdapter.ItemClickCallback {

    private static final String URL_DATA = "https://socialcareapp.000webhostapp.com/index000.php";

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_TITLE = "EXTRA_TITLE";
    private static final String EXTRA_NAME = "EXTRA_NAME";
    private static final String EXTRA_AREA = "EXTRA_AREA";
    private static final String EXTRA_TIME = "EXTRA_TIME";


    private RecyclerView recView;
    private ClientAdapter adapter;

    private List<VisitItem> visitItems;

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

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //IN THIS METHOD WE GET THE JSON
                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("test");

                            for(int i = 0; i<array.length(); i++){
                                JSONObject jsonObj = array.getJSONObject(i);
                                VisitItem item = new VisitItem(jsonObj.getString("title"),jsonObj.getString("full_name"),jsonObj.getString("area"),jsonObj.getString("start_date"));
                                //VisitItem item = new VisitItem(o.getString("title"),o.getString("full_name"),o.getString("area"),o.getString("start_time"));

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
                        String volleyError = "Problems...";
                        Toast.makeText(getApplicationContext(), volleyError, Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(int p) {
        /*VisitItem item = (VisitItem) listData.get(p);

        Intent i = new Intent(this, ClientActivity.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_TITLE, item.getTitle());
        extras.putString(EXTRA_NAME, item.getName());
        extras.putString(EXTRA_AREA, item.getArea());
        extras.putString(EXTRA_TIME, item.getTime());

        i.putExtra(BUNDLE_EXTRAS, extras);

        startActivity(i);*/
    }
}
