package com.marfiks.breizhmeteo.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.marfiks.breizhmeteo.GalleryActivity;
import com.marfiks.breizhmeteo.R;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private List<String> listeVille;

    GalleryAdapter(List<String> listeVille) {
        this.listeVille = listeVille;
    }


    @Override
    public int getItemCount() {
        return listeVille.size();
    }

    @Override
    public GalleryAdapter.GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ville, parent, false);
        return new GalleryAdapter.GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryAdapter.GalleryViewHolder holder, int position) {
        String ville = listeVille.get(position);
        holder.display(ville);
    }


    public int getPosition(String ville){
        int result = 0;
        for (int i =0; i < listeVille.size(); i++){
            if (listeVille.get(i) == ville){
                result = i;
            }
        }
        return result;
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        private String currentVille;


        public GalleryViewHolder(final View itemView) {
            super(itemView);

            name = ( itemView.findViewById(R.id.name));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), GalleryActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("id_ville", GalleryAdapter.this.getPosition(currentVille));
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                }
            });
        }
        public void display(String ville) {
            currentVille = ville;
            name.setText(ville);
        }
    }


    public void filterList(List<String> filteredList) {
        listeVille = filteredList;
        notifyDataSetChanged();
    }
}
