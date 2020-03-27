package com.marfiks.breizhmeteo.ui.gallery;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marfiks.breizhmeteo.R;
import com.marfiks.breizhmeteo.ui.villes.VillesAdapter;
import com.marfiks.breizhmeteo.ui.villes.ville;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {



    private List<String> listeVille;
    private GalleryAdapter mAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_villes, container, false);
        createList();



        buildRecyclerView(root);


        EditText editText = root.findViewById(R.id.search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
        return root;


    }

    private void createList(){
        listeVille = new ArrayList<>();
        listeVille.add("Auray");
        listeVille.add("Bouguenais");
        listeVille.add("Bruz");
        listeVille.add("Carquefou");
        listeVille.add("Cesson-Sévigné");
        listeVille.add("Châteaubriant");
        listeVille.add("Concarneau");
        listeVille.add("Couëron");
        listeVille.add("Dinan");
        listeVille.add("Douarnenez");
        listeVille.add("Fougères");
        listeVille.add("Guérande");
        listeVille.add("Guidel");
        listeVille.add("Guipavas");
        listeVille.add("Hennebont");
        listeVille.add("La Baule-Escoublac");
        listeVille.add("La Chapelle-sur-Erdre");
        listeVille.add("Lamballe");
        listeVille.add("Landerneau");
        listeVille.add("Lanester");
        listeVille.add("Lannion");
        listeVille.add("Le Relecq-Kerhuon");
        listeVille.add("Lorient");
        listeVille.add("Morlaix");
        listeVille.add("Nantes");
        listeVille.add("Orvault");
        listeVille.add("Pacé");
        listeVille.add("Plérin");
        listeVille.add("Ploemeur");
        listeVille.add("Ploufragan");
        listeVille.add("Plougastel-Daoulas");
        listeVille.add("Plouzané");
        listeVille.add("Pontivy");
        listeVille.add("Pornic");
        listeVille.add("Quimper");
        listeVille.add("Quimperlé");
        listeVille.add("Rennes");
        listeVille.add("Rezé");
        listeVille.add("Saint-Brevin-les-Pins");
        listeVille.add("Saint-Brieuc");
        listeVille.add("Sainte-Luce-sur-Loire");
        listeVille.add("Saint-Herblain");
        listeVille.add("Saint-Jacques-de-la-Lande");
        listeVille.add("Saint-Malo");
        listeVille.add("Saint-Nazaire");
        listeVille.add("Saint-Sébastien-sur-Loire");
        listeVille.add("Vannes");
        listeVille.add("Vertou");
        listeVille.add("Vitré");
    }

    private void filter(String text){
        List<String> filteredList = new ArrayList<>();
        for (String ville : listeVille) {
            if (ville.toLowerCase().contains(text.toLowerCase())){
                filteredList.add(ville);
            }
        }
        mAdapter.filterList(filteredList);
    }

    private void buildRecyclerView(View root) {
        RecyclerView rv =  root.findViewById(R.id.liste_ville);
        rv.setHasFixedSize(true);
        mAdapter = new GalleryAdapter(listeVille);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(mAdapter);
    }
}