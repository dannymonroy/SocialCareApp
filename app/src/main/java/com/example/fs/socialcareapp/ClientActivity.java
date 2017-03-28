package com.example.fs.socialcareapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

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
