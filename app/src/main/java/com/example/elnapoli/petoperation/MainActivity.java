package com.example.elnapoli.petoperation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.elnapoli.petoperation.adapters.PetAdapter;
import com.example.elnapoli.petoperation.models.Pets;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    ArrayList<Pets> myPets;
    private RecyclerView rvPet;
    PetAdapter miAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPet = (RecyclerView) findViewById(R.id.rvPet);
        initPets();
        miAdapter = new PetAdapter(this,myPets);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvPet.setLayoutManager(llm);
        rvPet.setAdapter(miAdapter);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FavouritePet.class);
                Bundle bundle = new Bundle();
                ArrayList<Pets> requestPet = new ArrayList<Pets>();
                int count = 0;
                Iterator<Pets> it = myPets.iterator();
                for(int i = 0; i < myPets.size(); i++){
                    if(count > 4){
                        break;
                    }
                    if(myPets.get(i).getIsLike()){

                        requestPet.add(myPets.get(i));
                    }
                    count++;

                }
                bundle.putSerializable("myPets",requestPet);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
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
