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
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * ClientAdapter this is where we inflate the views and we bind the view holder.
 *
 * @author  Danny Monroy
 * @version 1.0
 * @since   2017-02-20
 */

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientHolder> {

    private List<VisitItem> visitItem;
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback{
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback){
        this.itemClickCallback = itemClickCallback;
    }

    public ClientAdapter(List<VisitItem> visitItem, Context c){
        this.inflater = LayoutInflater.from(c);
        this.visitItem = visitItem;
    }

    @Override
    public ClientHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ClientHolder(view);
    }

    @Override
    public void onBindViewHolder(ClientHolder holder, int position) {
        VisitItem item = visitItem.get(position);
        //holder.icon.setImageResource(item.getImageResId());
        holder.title.setText(item.getTitle());
        holder.name.setText(item.getFullName());
        holder.area.setText(item.getArea());
        holder.time.setText(item.getStartTime());
    }

    @Override
    public int getItemCount() {
        return visitItem.size();
    }

    class ClientHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //private ImageView icon;
        private TextView title;
        private TextView name;
        private TextView area;
        private TextView time;

        private View container;

        public ClientHolder(View itemView) {
            super(itemView);

            //icon = (ImageView)itemView.findViewById(R.id.ic_client);
            title = (TextView)itemView.findViewById(R.id.text_title);
            name = (TextView)itemView.findViewById(R.id.text_full_name);
            area = (TextView)itemView.findViewById(R.id.text_area);
            time = (TextView)itemView.findViewById(R.id.text_time_start);
            container = itemView.findViewById(R.id.item_client);
//          container.setOnClickListener(this);

        }

        @Override
        public void onClick(View v){
            if (v.getId() == R.id.item_client){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }

    }
}
