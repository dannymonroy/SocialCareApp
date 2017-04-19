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

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * LoginActivity is a simple log in activity. In future versions it will be connected to a database.
 *
 * @author  Danny Monroy
 * @version 1.0
 * @since   2017-02-20
 */

public class LoginActivity extends AppCompatActivity {

    EditText userEdit, passEdit;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logIn = (Button) findViewById(R.id.btn_log_in);
        userEdit = (EditText)findViewById(R.id.text_carer_id);
        passEdit = (EditText)findViewById(R.id.text_password);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String carer_id = userEdit.getText().toString();
                final String password = passEdit.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            Boolean success = jsonResponse.getBoolean("success");

                            if (success){
                                //String name = jsonResponse.getString("name");
                                //int age = jsonResponse.getInt("age");

                                Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                                //intent.putExtra("name", name);
                                //intent.putExtra("age", age);
                                intent.putExtra("carer_id", carer_id);
                                LoginActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                LoginRequest loginRequest = new LoginRequest(carer_id, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
                //Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                //LoginActivity.this.startActivity(intent);
            }
        });
    }

}
