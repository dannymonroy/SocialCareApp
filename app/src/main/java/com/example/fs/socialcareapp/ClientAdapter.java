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
 * Created by Danny Monroy on 20/02/2017.
 */

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientHolder> {

    //CHANGED
    private List<TestItem> testItem;
    //
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback{
        void onItemClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback){
        this.itemClickCallback = itemClickCallback;
    }

    public ClientAdapter(List<TestItem> testItem, Context c){
        this.inflater = LayoutInflater.from(c);
        this.testItem = testItem;
    }

    @Override
    public ClientHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ClientHolder(view);
    }

    @Override
    public void onBindViewHolder(ClientHolder holder, int position) {
        TestItem item = testItem.get(position);

        holder.title.setText(item.getHead());
        holder.name.setText(item.getDesc());
        holder.area.setText(item.getImageUrl());

        /*
        holder.icon.setImageResource(item.getImageResId());
        holder.title.setText(item.getTitle());
        holder.name.setText(item.getName());
        holder.area.setText(item.getArea());
        holder.time.setText(item.getTime());
        */
    }

    @Override
    public int getItemCount() {
        return testItem.size();
    }

    class ClientHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView icon;
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

//            time = (TextView)itemView.findViewById(R.id.text_time_start);
//            container = itemView.findViewById(R.id.item_client);
//            container.setOnClickListener(this);

        }

        @Override
        public void onClick(View v){
            if (v.getId() == R.id.item_client){
                itemClickCallback.onItemClick(getAdapterPosition());
            }
        }
    }
}
