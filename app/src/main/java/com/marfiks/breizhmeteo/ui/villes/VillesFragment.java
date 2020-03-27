package com.marfiks.breizhmeteo.ui.villes;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marfiks.breizhmeteo.R;

import java.util.ArrayList;

public class VillesFragment extends Fragment {

    private ArrayList<ville> listeVille;
    private VillesAdapter mAdapter;

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
        listeVille.add(new ville("Auray",3036059));
        listeVille.add(new ville("Bouguenais", 3031268));
        listeVille.add(new ville("Bruz", 3029713));
        listeVille.add(new ville("Carquefou", 3028535));
        listeVille.add(new ville("Cesson-Sévigné", 3027767));
        listeVille.add(new ville("Châteaubriant", 3026303));
        listeVille.add(new ville("Concarneau", 3024035));
        listeVille.add(new ville("Couëron", 3023324));
        listeVille.add(new ville("Dinan", 3021356));
        listeVille.add(new ville("Douarnenez", 3020996));
        listeVille.add(new ville("Fougères", 3017609));
        listeVille.add(new ville("Guérande", 3014392));
        listeVille.add(new ville("Guidel", 2997576));
        listeVille.add(new ville("Guipavas", 3014213));
        listeVille.add(new ville("Hennebont", 3013521));
        listeVille.add(new ville("La Baule-Escoublac", 3019766));
        listeVille.add(new ville("La Chapelle-sur-Erdre", 3010237));
        listeVille.add(new ville("Lamballe", 3008225));
        listeVille.add(new ville("Landerneau", 3007874));
        listeVille.add(new ville("Lanester", 3007794));
        listeVille.add(new ville("Lannion", 3007609));
        listeVille.add(new ville("Le Relecq-Kerhuon", 3002373));
        listeVille.add(new ville("Lorient", 6437298));
        listeVille.add(new ville("Morlaix", 2991772));
        listeVille.add(new ville("Nantes", 2990969));
        listeVille.add(new ville("Orvault", 2989170));
        listeVille.add(new ville("Pacé", 6432777));
        listeVille.add(new ville("Plérin", 2986795));
        listeVille.add(new ville("Ploemeur", 2986732));
        listeVille.add(new ville("Ploufragan", 2986678));
        listeVille.add(new ville("Plougastel-Daoulas", 2986674));
        listeVille.add(new ville("Plouzané", 6453934));
        listeVille.add(new ville("Pontivy", 2986160));
        listeVille.add(new ville("Pornic", 6434496));
        listeVille.add(new ville("Quimper", 2984701));
        listeVille.add(new ville("Quimperlé", 2984699));
        listeVille.add(new ville("Rennes", 2983990));
        listeVille.add(new ville("Rezé", 2983770));
        listeVille.add(new ville("Saint-Brevin-les-Pins", 6613997));
        listeVille.add(new ville("Saint-Brieuc", 2981280));
        listeVille.add(new ville("Sainte-Luce-sur-Loire", 2980488));
        listeVille.add(new ville("Saint-Herblain", 2979590));
        listeVille.add(new ville("Saint-Jacques-de-la-Lande", 2979415));
        listeVille.add(new ville("Saint-Malo", 2978640));
        listeVille.add(new ville("Saint-Nazaire", 2977926));
        listeVille.add(new ville("Saint-Sébastien-sur-Loire", 2976984));
        listeVille.add(new ville("Vannes", 2970777));
        listeVille.add(new ville("Vertou", 2969612));
        listeVille.add(new ville("Vitré", 2967879));
    }

    private void filter(String text){
        ArrayList<ville> filteredList = new ArrayList<>();
        for (ville ville : listeVille) {
            if (ville.getNom().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(ville);
            }
        }
        mAdapter.filterList(filteredList);
    }

    private void buildRecyclerView(View root) {
        RecyclerView rv =  root.findViewById(R.id.liste_ville);
        rv.setHasFixedSize(true);
        mAdapter = new VillesAdapter(listeVille);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(mAdapter);
    }

}