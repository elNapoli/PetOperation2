package com.example.elnapoli.petoperation.presentador;

import android.content.Context;

import com.example.elnapoli.petoperation.dataBase.BuilderPets;
import com.example.elnapoli.petoperation.fragments.IRecyclerViewFragmentView;
import com.example.elnapoli.petoperation.models.Pets;

import java.util.ArrayList;

/**
 * Created by elnapoli on 29-01-18.
 */

public class RecyclerViewFragmentsPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private  Context context;
    private BuilderPets builderPets;
    private ArrayList<Pets> pets1;


   public RecyclerViewFragmentsPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        getPetsDB();
   }

    @Override
    public void getPetsDB() {
        builderPets = new BuilderPets(context);
        pets1 = builderPets.getPets();
        showPetsRV();
    }

    @Override
    public void showPetsRV() {
        iRecyclerViewFragmentView.initAdapterRV(iRecyclerViewFragmentView.createPetAdapter(pets1));
        iRecyclerViewFragmentView.generateLinearLayoutVertical();

    }
}
