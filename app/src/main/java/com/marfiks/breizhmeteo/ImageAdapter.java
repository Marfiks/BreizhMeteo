package com.marfiks.breizhmeteo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private ArrayList<String> liens;
    private Context context;

    ImageAdapter(Context context, ArrayList<String> liens) {
        this.context = context;
        this.liens = liens;
    }


    @Override
    public int getItemCount() {
        return liens.size();
    }

    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image, parent, false);
        return new ImageAdapter.ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        String lien = liens.get(position);

        Picasso.get().load(lien).into(holder.image);
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {


        private ImageView image;


        public ImageViewHolder(final View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

        }
    }



}