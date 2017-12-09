package com.example.elnapoli.petoperation.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.elnapoli.petoperation.R;
import com.example.elnapoli.petoperation.adapters.PetAdapter;
import com.example.elnapoli.petoperation.adapters.PhotosProfileAdapter;
import com.example.elnapoli.petoperation.models.Pets;
import com.example.elnapoli.petoperation.models.Photos;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPetFragment extends Fragment {

    Pets myPet;
    private RecyclerView rvFavouritePetPersonal;
    PhotosProfileAdapter miAdapter;
    public MyPetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_pet, container, false);
        TextView tvNameProfile = (TextView) view.findViewById(R.id.tvNameProfile);
        CircularImageView civProfile = (CircularImageView) view.findViewById(R.id.civProfile) ;
        initPet();

        tvNameProfile.setText(myPet.getName());
        civProfile.setImageResource(myPet.getPhoto());
        rvFavouritePetPersonal = (RecyclerView) view.findViewById(R.id.rvFavouritePetPersonal);
        miAdapter = new PhotosProfileAdapter(view.getContext(),myPet.getMyPhotos());

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        GridLayoutManager grid = new GridLayoutManager(view.getContext(),3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavouritePetPersonal.setLayoutManager(grid);
        rvFavouritePetPersonal.setAdapter(miAdapter);
        return view;
    }

    public void initPet(){
        myPet = new Pets("Perry",R.drawable.jirafa);
        ArrayList<Photos> myAlbum = new ArrayList<Photos>();
        myAlbum.add(new Photos(5,R.drawable.leon));
        myAlbum.add(new Photos(4,R.drawable.leon));
        myAlbum.add(new Photos(5,R.drawable.leon));
        myAlbum.add(new Photos(1,R.drawable.leon));
        myPet.setMyPhotos(myAlbum);

    }

}
