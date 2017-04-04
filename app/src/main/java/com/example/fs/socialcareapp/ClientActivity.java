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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * ClientActivity this activity will display the specific client with more detail.
 *
 * @author  Danny Monroy
 * @version 1.0
 * @since   2017-02-20
 */

public class ClientActivity extends AppCompatActivity {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_TITLE = "EXTRA_TITLE";
    private static final String EXTRA_NAME = "EXTRA_NAME";
    private static final String EXTRA_AREA = "EXTRA_AREA";
    private static final String EXTRA_TIME = "EXTRA_TIME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);

        TextView clientTitle = (TextView)findViewById(R.id.text_client_title);
        clientTitle.setText(extras.getString(EXTRA_TITLE));

        TextView clientName = (TextView)findViewById(R.id.text_client_name);
        clientName.setText(extras.getString(EXTRA_NAME));

        TextView clientArea = (TextView)findViewById(R.id.text_client_area);
        clientArea.setText(extras.getString(EXTRA_AREA));

        TextView clientTime = (TextView)findViewById(R.id.text_client_time);
        clientTime.setText(extras.getString(EXTRA_TIME));

    }
}
