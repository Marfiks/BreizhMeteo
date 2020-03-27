package com.marfiks.breizhmeteo.ui.propos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.marfiks.breizhmeteo.R;

public class ProposFragment extends Fragment {

    private ProposViewModel proposViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        proposViewModel =
                ViewModelProviders.of(this).get(ProposViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propos, container, false);
        final TextView textView = root.findViewById(R.id.text_propos);
        proposViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        return root;


    }
}