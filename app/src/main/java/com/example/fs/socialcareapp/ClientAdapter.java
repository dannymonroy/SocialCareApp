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

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * ClientAdapter this is where we inflate the views and we bind the view holder.
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
    private static final String EXTRA_AREA = "EXTRA_AREA";
    private static final String EXTRA_TIME = "EXTRA_TIME";

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
        holder.fullName.setText(visitItem.getFullName());
        holder.area.setText(visitItem.getArea());
        holder.startTime.setText(visitItem.getStartTime());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context.getApplicationContext(), ClientActivity.class);

                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle extras = new Bundle();
                extras.putString(EXTRA_TITLE, visitItem.getTitle());
                extras.putString(EXTRA_NAME, visitItem.getFullName());
                extras.putString(EXTRA_AREA, visitItem.getArea());
                extras.putString(EXTRA_TIME, visitItem.getStartTime());

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

        //private ImageView icon;
        private TextView title;
        private TextView fullName;
        private TextView area;
        private TextView startTime;

        private View container;

        public ClientHolder(View itemView) {
            super(itemView);

            //icon = (ImageView)itemView.findViewById(R.id.ic_client);
            title = (TextView)itemView.findViewById(R.id.text_title);
            fullName = (TextView)itemView.findViewById(R.id.text_full_name);
            area = (TextView)itemView.findViewById(R.id.text_area);
            startTime = (TextView)itemView.findViewById(R.id.text_time_start);
            container =  itemView.findViewById(R.id.item_client);

        }

    }
}
