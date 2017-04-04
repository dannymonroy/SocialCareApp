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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * LoginActivity is a simple log in activity. In future versions it will be connected to a database.
 *
 * @author  Danny Monroy
 * @version 1.0
 * @since   2017-02-20
 */

public class LoginActivity extends AppCompatActivity {

    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logIn = (Button) findViewById(R.id.btn_log_in);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }

}
