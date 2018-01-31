package com.example.elnapoli.petoperation.fragments;

import com.example.elnapoli.petoperation.adapters.PetAdapter;
import com.example.elnapoli.petoperation.models.Pets;

import java.util.ArrayList;

/**
 * Created by elnapoli on 29-01-18.
 */

public interface IRecyclerViewFragmentView {
    public void generateLinearLayoutVertical();
    public PetAdapter createPetAdapter(ArrayList<Pets> pets);
    public void initAdapterRV(PetAdapter adapter);
}
