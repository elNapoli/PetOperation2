package com.example.elnapoli.petoperation.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.elnapoli.petoperation.R;
import com.example.elnapoli.petoperation.adapters.PetAdapter;
import com.example.elnapoli.petoperation.models.Pets;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetFragment extends Fragment {

    ArrayList<Pets> myPets;
    private RecyclerView rvPet;
    PetAdapter miAdapter;
    public PetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pet, container, false);

        rvPet = (RecyclerView) view.findViewById(R.id.rvPet);
        initPets();
        miAdapter = new PetAdapter(view.getContext(),myPets);

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPet.setLayoutManager(llm);
        rvPet.setAdapter(miAdapter);
        return view;
    }

    public void initPets(){
        myPets = new ArrayList<Pets>();
        myPets.add(new Pets("Burbuja",R.drawable.elefante));
        myPets.add(new Pets("Perry",R.drawable.jirafa));
        myPets.add(new Pets("Osoman",R.drawable.leon));
        myPets.add(new Pets("Mano Larga",R.drawable.mono));
        myPets.add(new Pets("Diego",R.drawable.tigre));
        myPets.add(new Pets("Lobo",R.drawable.dray3115_edit_3_200x200));

    }

}
