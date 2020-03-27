package com.marfiks.breizhmeteo.ui.villes;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;


import com.marfiks.breizhmeteo.R;
import com.marfiks.breizhmeteo.WeatherDailyActivity;

import java.util.ArrayList;



public class VillesAdapter extends RecyclerView.Adapter<VillesAdapter.VillesViewHolder> {


    private ArrayList<ville> listeVille;

    VillesAdapter(ArrayList<ville> characters) {
        this.listeVille = characters;
    }


    @Override
    public int getItemCount() {
        return listeVille.size();
    }

    @Override
    public VillesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ville, parent, false);
        return new VillesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VillesViewHolder holder, int position) {
        ville ville = listeVille.get(position);
        holder.display(ville);
    }



    public class VillesViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        private ville currentVille;


        public VillesViewHolder(final View itemView) {
            super(itemView);

            name = ( itemView.findViewById(R.id.name));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), WeatherDailyActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("id_ville", currentVille.getIdVIlle());
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                }
            });
        }
        public void display(ville ville) {
            currentVille = ville;
            name.setText(ville.getNom());
        }
    }


    public void filterList(ArrayList<ville> filteredList) {
        listeVille = filteredList;
        notifyDataSetChanged();
    }
}





