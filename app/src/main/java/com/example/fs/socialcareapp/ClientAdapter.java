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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * ClientAdapter is the class of binding views with the data and is an essential step for creating a RecyclerView.
 *
 * @author  Danny Monroy
 * @version 1.0
 * @since   2017-02-20
 */

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientHolder> {

    private List<VisitItem> visitItems;
    private Context context;


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

    public ClientAdapter(List<VisitItem> visitItems, Context context){
        this.visitItems = visitItems;
        this.context = context;
    }

    @Override
    public ClientHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false);

        return new ClientHolder(v);

    }

    @Override
    public void onBindViewHolder(ClientHolder holder, final int position) {
        final VisitItem visitItem = visitItems.get(position);

        holder.title.setText(visitItem.getTitle());
        holder.name.setText(visitItem.getName());
        holder.surname.setText(visitItem.getSurname());
        holder.area.setText(visitItem.getArea());
        holder.start_time.setText(visitItem.getStartTime());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context.getApplicationContext(), ClientActivity.class);

                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle extras = new Bundle();
                extras.putString(EXTRA_TITLE, visitItem.getTitle());
                extras.putString(EXTRA_NAME, visitItem.getName());
                extras.putString(EXTRA_MIDDLE_NAME, visitItem.getMiddleName());
                extras.putString(EXTRA_SURNAME, visitItem.getSurname());
                extras.putString(EXTRA_AREA, visitItem.getArea());
                extras.putString(EXTRA_START_TIME, visitItem.getStartTime());
                extras.putString(EXTRA_END_TIME, visitItem.getEndTime());
                extras.putString(EXTRA_ADDRESS, visitItem.getAddress());
                extras.putString(EXTRA_POSTCODE, visitItem.getPostcode());
                extras.putString(EXTRA_GENERAL_INFORMATION, visitItem.getGeneralInformation());
                extras.putString(EXTRA_KEYCODE, visitItem.getKeycode());
                extras.putString(EXTRA_LEVEL_VULNERABILITY, visitItem.getLevelVulnerability());

                i.putExtra(BUNDLE_EXTRAS, extras);

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return visitItems.size();
    }

    class ClientHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView name;
        private TextView surname;
        private TextView area;
        private TextView start_time;


        private View container;

        public ClientHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.text_title);
            name = (TextView)itemView.findViewById(R.id.text_name);
            surname = (TextView)itemView.findViewById(R.id.text_surname);
            area = (TextView)itemView.findViewById(R.id.text_area);
            start_time = (TextView)itemView.findViewById(R.id.text_time_start);
            container =  itemView.findViewById(R.id.item_client);

        }

    }
}
