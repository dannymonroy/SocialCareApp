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
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * ClientActivity this activity will display the specific client with more detail. It display the bundles created in ListActivity. It also includes intents towards GoogleMaps and an Email application.
 *
 * @author  Danny Monroy
 * @version 1.0
 * @since   2017-02-20
 */

public class ClientActivity extends AppCompatActivity {


    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_TITLE = "EXTRA_TITLE";
    private static final String EXTRA_NAME = "EXTRA_NAME";
    private static final String EXTRA_MIDDLE_NAME = "EXTRA_MIDDLE_NAME";
    private static final String EXTRA_SURNAME = "EXTRA_SURNAME";
    private static final String EXTRA_AREA = "EXTRA_AREA";
    private static final String EXTRA_START_TIME = "EXTRA_START_TIME";
    private static final String EXTRA_END_TIME = "EXTRA_END_TIME";
    private static final String EXTRA_ADDRESS = "EXTRA_ADDRESS";
    private static final String EXTRA_POSTCODE = "EXTRA_POSTCODE";
    private static final String EXTRA_GENERAL_INFORMATION = "EXTRA_GENERAL_INFORMATION";
    private static final String EXTRA_KEYCODE = "EXTRA_KEYCODE";
    private static final String EXTRA_LEVEL_VULNERABILITY = "EXTRA_LEVEL_VULNERABILITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);

        TextView clientTitle = (TextView)findViewById(R.id.text_client_title);
        clientTitle.setText(extras.getString(EXTRA_TITLE));

        TextView clientName = (TextView)findViewById(R.id.text_client_name);
        clientName.setText(extras.getString(EXTRA_NAME));

        TextView clientMiddleName = (TextView)findViewById(R.id.text_client_middle_name);

        if(extras.getString(EXTRA_MIDDLE_NAME).equalsIgnoreCase("")){
            clientMiddleName.setVisibility(View.GONE);
        } else {
            clientMiddleName.setText(extras.getString(EXTRA_MIDDLE_NAME));
        }

        TextView clientSurname = (TextView)findViewById(R.id.text_client_surname);
        clientSurname.setText(extras.getString(EXTRA_SURNAME));

        TextView clientArea = (TextView)findViewById(R.id.text_client_area);
        clientArea.setText(extras.getString(EXTRA_AREA));



        TextView clientStartTime = (TextView)findViewById(R.id.text_client_start_time);
        clientStartTime.setText(extras.getString(EXTRA_START_TIME));

        TextView clientEndTime = (TextView)findViewById(R.id.text_client_end_time);
        clientEndTime.setText(extras.getString(EXTRA_END_TIME));

        TextView clientAddress = (TextView)findViewById(R.id.text_client_address);
        clientAddress.setText(extras.getString(EXTRA_ADDRESS));

        TextView clientPostcode = (TextView)findViewById(R.id.text_client_postcode);
        clientPostcode.setText(extras.getString(EXTRA_POSTCODE));

        TextView clientGeneralInformation = (TextView)findViewById(R.id.text_client_general_information);
        clientGeneralInformation.setText(extras.getString(EXTRA_GENERAL_INFORMATION));

        TextView clientKeycode = (TextView)findViewById(R.id.text_client_keycode);
        clientKeycode.setText(extras.getString(EXTRA_KEYCODE));

        TextView clientLevelVulnerability = (TextView)findViewById(R.id.text_client_level_vulnerability);
        clientLevelVulnerability.setText(extras.getString(EXTRA_LEVEL_VULNERABILITY));

        Button maps = (Button) findViewById(R.id.btn_maps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView post = (TextView) findViewById(R.id.text_client_postcode);
                String postcode = post.getText().toString();
                postcode = postcode.replaceAll(" ", "+");

            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.google.co.uk/maps/place/"+postcode));
            startActivity(intent);

            }
        });

        Button email = (Button) findViewById(R.id.btn_report);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView clientName = (TextView) findViewById(R.id.text_client_name);
                String name = clientName.getText().toString();

                 TextView clientSurname = (TextView) findViewById(R.id.text_client_surname);
                String surname = clientSurname.getText().toString();

                String subject = name+" "+surname+": Issue here";

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","help@careagency.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Write as much as you know about the issue");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });






    }
}
